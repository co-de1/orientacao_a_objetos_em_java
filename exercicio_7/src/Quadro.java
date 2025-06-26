import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Quadro extends JFrame implements ActionListener, KeyListener {

    int largura = 500;
    int altura = 500;

    JLabel jogador;
    int x0jogador = 250;
    int y0jogador = 400;
    int larguraJogador = 20;
    int alturaJogador = 20;
    int velocidadeBala = 3;
    int velocidadeTimer = 10;
    int movimentoJogador = 1;
    char direcaoJogador = ' ';
    Timer timerJogador;

    JLabel bala;
    int x0bala = x0jogador + larguraJogador/2;
    int y0bala = 400;
    int larguraBala = 4;
    int alturaBala = 4;
    Timer timerBala;

    Image imagem;
    Image novaImagem;

    public Quadro() {

        // JOGADOR
        jogador = new JLabel();
        jogador.setBounds(x0jogador, y0jogador, larguraJogador, alturaJogador);
        //jogador.setBackground(Color.blue);
        //jogador.setOpaque(true);
        timerJogador = new Timer(velocidadeBala, this);
        timerJogador.start();

        // BALA
        bala = new JLabel();
        bala.setBounds(x0bala, y0bala, larguraBala, alturaBala);
        bala.setBackground(Color.yellow);
        bala.setOpaque(true);

        ImageIcon icone = new ImageIcon("personagem.png");
        jogador.setIcon(icone);
        imagem = icone.getImage();
        novaImagem = imagem.getScaledInstance(larguraJogador, alturaJogador, Image.SCALE_SMOOTH);
        ImageIcon novoIcone = new ImageIcon(novaImagem);
        jogador.setIcon(novoIcone);

        //TIMER
        timerBala = new Timer(velocidadeTimer, this);

        this.add(jogador);
        this.addKeyListener(this);

        this.setSize(largura, altura);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent event){
        if(event.getSource()==timerBala){
            bala.setLocation(bala.getX(), bala.getY() - velocidadeBala);
            int novaY = bala.getY() - velocidadeBala;
            if (novaY >= 0){
                bala.setLocation(bala.getX(), novaY);
            } else {
                timerBala.stop();
                this.remove(bala);
                this.repaint();
            }
        }

        if(event.getSource()==timerJogador){
            int novaX;

            switch (direcaoJogador) {
                case ' ':
                    jogador.setLocation(jogador.getX(), jogador.getY());
                case KeyEvent.VK_LEFT:
                    novaX = jogador.getX() - movimentoJogador;
                    if (novaX >= 0) {
                        jogador.setLocation(novaX, jogador.getY());
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    novaX = jogador.getX() + movimentoJogador;
                    if (novaX + larguraJogador <= this.getContentPane().getWidth()) {
                        jogador.setLocation(novaX, jogador.getY());
                    }
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent event){
        if(event.getKeyChar() == ' '){
            bala.setLocation(jogador.getX() + larguraJogador/2, jogador.getY());
            this.add(bala);
            timerBala.start();
        }
    }

    @Override
    public void keyPressed(KeyEvent event){
        if (event.getKeyCode() == KeyEvent.VK_SPACE){
                bala.setLocation(jogador.getX() + larguraJogador/2, jogador.getY());
                this.add(bala);
                timerBala.start();
            }

        if(event.getKeyCode() == KeyEvent.VK_LEFT){
            direcaoJogador = KeyEvent.VK_LEFT;
        }
        if(event.getKeyCode() == KeyEvent.VK_RIGHT){
            direcaoJogador = KeyEvent.VK_RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent event){

    }
}