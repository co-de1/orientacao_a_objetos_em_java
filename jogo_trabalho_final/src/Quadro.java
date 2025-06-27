import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quadro extends JFrame implements ActionListener, KeyListener {

    int larguraTela = 650;
    int alturaTela = 650;

    // IMAGEM
    Image imagemPersonagem;
    Image novaImagemPersonagem;

    Image imagemVilao;
    Image novaImagemVilao;

    // JOGADOR
    JLabel Personagem;
    int x0Personagem = 325;
    int y0Personagem = 488;
    int larguraPersonagem = 30;
    int alturaPersonagem = 30;
    int velocidadePersonagem = 1;
    char direcaoPersonagem = ' ';
    Timer timerPersonagem;

    // VILAO
    JLabel Vilao;
    int x0Vilao = 325;
    int y0Vilao = 80;
    int larguraVilao = 40;
    int alturaVilao = 40;
    int velocidadeVilao = 1;
    int trocaDirecao = KeyEvent.VK_RIGHT;
    Timer timerVilao;

    // FUSIL
    JLabel Fusil;
    int x0Fusil = x0Personagem + larguraPersonagem/2;
    int y0Fusil = y0Personagem + larguraPersonagem/2;
    int larguraFusil = 7;
    int alturaFusil = 7;
    int velocidadeFusil = 10;
    Timer timerFusil;

    // BALA
    JLabel Bala;
    int larguraBala = 7;
    int alturaBala = 7;
    int x0Bala = 325;
    int y0Bala = 200;
    int velocidadeBala = 15;
    Timer timerBala;
    Timer timerDisparoVilao;

    // EXPLOSAO
    ImageIcon novoIconeExplosao;
    Image novaImagemExplosao;

    // MENSAGEM
    JLabel mensagem;

    boolean jogoEncerrado = false;

    public Quadro() {

        // JOGADOR
        Personagem = new JLabel();
        Personagem.setBounds(x0Personagem, y0Personagem, larguraPersonagem, alturaPersonagem);
        ImageIcon personagem = new ImageIcon("personagem.png");

        Personagem.setIcon(personagem);
        imagemPersonagem = personagem.getImage();
        novaImagemPersonagem = imagemPersonagem.getScaledInstance(larguraPersonagem, alturaPersonagem, Image.SCALE_SMOOTH);
        ImageIcon novoIcone = new ImageIcon(novaImagemPersonagem);
        Personagem.setIcon(novoIcone);

        timerPersonagem = new Timer(10, this);
        timerPersonagem.start();

        // VILAO
        Vilao = new JLabel();
        Vilao.setBounds(x0Vilao, y0Vilao, larguraVilao, alturaVilao);
        ImageIcon vilao = new ImageIcon("vilao.png");

        Vilao.setIcon(vilao);
        imagemVilao = vilao.getImage();
        novaImagemVilao = imagemVilao.getScaledInstance(larguraVilao, alturaVilao, Image.SCALE_SMOOTH);
        ImageIcon novoVilao = new ImageIcon(novaImagemVilao);
        Vilao.setIcon(novoVilao);

        timerVilao = new Timer(8, this);
        timerVilao.start();

        // EXPLOSÃO
        ImageIcon explosao = new ImageIcon("explosao.png");
        Image imagemExplosao = explosao.getImage();
        novaImagemExplosao = imagemExplosao.getScaledInstance(2*larguraPersonagem, 2*alturaPersonagem, Image.SCALE_SMOOTH);

        // FUSIL
        Fusil = new JLabel();
        Fusil.setBounds(x0Fusil, y0Fusil, larguraFusil, alturaFusil);
        Fusil.setBackground(Color.orange);
        Fusil.setOpaque(true);

        timerDisparoVilao = new Timer(850, this); // dispara a cada 1.5 segundos
        timerDisparoVilao.start();

        // BALA
        Bala = new JLabel();
        Bala.setBounds(x0Bala, y0Bala, larguraBala, alturaBala);
        Bala.setBackground(Color.orange);
        Bala.setOpaque(true);

        timerBala = new Timer(10, this);
        timerBala.start();

        // MENSAGEM
        mensagem = new JLabel();
        mensagem.setForeground(new Color(0x124AD7));
        mensagem.setBounds(375, 200, 375, 375);
        mensagem.setText("VOCÊ PERDEU!");

        mensagem.setVisible(false);

        // INFORMAÇÕES SOBRE A TELA
        this.add(mensagem);
        this.add(Personagem);
        this.add(Vilao);
        this.add(Bala);
        this.addKeyListener(this);

        this.setSize(larguraTela, alturaTela);
        this.getContentPane().setBackground(Color.gray);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (jogoEncerrado) return;

        if(event.getSource()==timerFusil){
            int novaY = Fusil.getY() - velocidadeFusil;
            if (novaY >= 0){
                Fusil.setLocation(Fusil.getX(), novaY);
            } else {
                timerFusil.stop();
                this.remove(Fusil);
                this.repaint();
            }

            if ((Math.abs((Fusil.getX() + larguraFusil / 2) - (Vilao.getX() + larguraVilao / 2))
                    <= larguraVilao / 2) && Math.abs((Fusil.getY() + alturaFusil / 2) -
                    (Vilao.getY() + alturaVilao / 2)) <= alturaVilao / 2){

                mensagem.setForeground(new Color(0x2AC114));
                mensagem.setText("VOCÊ GANHOU!!");
                mensagem.setVisible(true);

                novoIconeExplosao = new ImageIcon(novaImagemExplosao);
                Vilao.setIcon(novoIconeExplosao);
                jogoEncerrado = true;

                timerPersonagem.stop();
                timerVilao.stop();
                if (timerBala != null) {
                    timerBala.stop();
                }
                timerDisparoVilao.stop();
            }
        }

        // PERSONAGEM
        if(event.getSource()==timerPersonagem){
            int novaX;

            switch (direcaoPersonagem) {
                case ' ', KeyEvent.VK_LEFT:
                    novaX = Personagem.getX() - velocidadePersonagem;
                    if (novaX >= 0) {
                        Personagem.setLocation(novaX, Personagem.getY());
                    } else
                        direcaoPersonagem = KeyEvent.VK_RIGHT;
                    break;
                case KeyEvent.VK_RIGHT:
                    novaX = Personagem.getX() + velocidadePersonagem;
                    if (novaX + larguraPersonagem <= this.getContentPane().getWidth()) {
                        Personagem.setLocation(novaX, Personagem.getY());
                    } else
                        direcaoPersonagem = KeyEvent.VK_LEFT;
                    break;
            }
        }

        // VILAO
        if(event.getSource()==timerVilao){

            int novaX;
            if (Math.random() <= 0.05){
                velocidadeVilao = velocidadeVilao*(-1);
            }

            switch (trocaDirecao) {
                case ' ', KeyEvent.VK_LEFT:
                    novaX = Vilao.getX() - velocidadeVilao;
                    if (novaX >= 0) {
                        Vilao.setLocation(novaX, Vilao.getY());
                    } else
                        trocaDirecao = KeyEvent.VK_RIGHT;
                    break;

                case KeyEvent.VK_RIGHT:
                    novaX = Vilao.getX() + velocidadeVilao;
                    if (novaX + larguraVilao <= this.getContentPane().getWidth()) {
                        Vilao.setLocation(novaX, Vilao.getY());
                    } else
                        trocaDirecao = KeyEvent.VK_LEFT;
                    break;
            }
        }

        if(event.getSource() == timerDisparoVilao){
            x0Bala = Vilao.getX() + larguraVilao / 2 - larguraBala / 2;
            y0Bala = Vilao.getY() + alturaVilao;

            Bala.setBounds(x0Bala, y0Bala, larguraBala, alturaBala);
            this.add(Bala);
            timerBala.start();
        }

        if(event.getSource()==timerBala){

            int novaY = Bala.getY() + velocidadeBala;
            if (novaY <= alturaTela){
                Bala.setLocation(Bala.getX(), novaY);
            } else {
                this.remove(Bala);
                this.repaint();
            }

            if ((Math.abs((Bala.getX() + larguraBala/2) - (Personagem.getX() + larguraPersonagem/2))
                    <= larguraPersonagem / 2) && Math.abs((Bala.getY() + alturaBala/2) - (Personagem.getY()
                    + alturaPersonagem/2)) <= alturaPersonagem / 2){

                mensagem.setVisible(true);
                novoIconeExplosao = new ImageIcon(novaImagemExplosao);
                Personagem.setBounds(Personagem.getX(), Personagem.getY(), 2*larguraPersonagem, 2*alturaPersonagem);
                Personagem.setIcon(novoIconeExplosao);
                jogoEncerrado = true;

                timerPersonagem.stop();
                timerVilao.stop();
                if (timerFusil != null) {
                    timerFusil.stop();
                }
                timerBala.stop();
                timerDisparoVilao.stop();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {

            // Cria o tiro na posição atual do personagem

            x0Fusil = Personagem.getX() + larguraPersonagem / 2 - larguraFusil / 2;
            y0Fusil = Personagem.getY() - alturaFusil;

            Fusil.setBounds(x0Fusil, y0Fusil, larguraFusil, alturaFusil);
            this.add(Fusil);
            this.repaint();

            // timerFusil criado aqui

            timerFusil = new Timer(20, this);
            timerFusil.start();
        }

        //  MUDANÇA DE DIREÇÃO PERSONAGEM

        if(event.getKeyCode() == KeyEvent.VK_LEFT){
            direcaoPersonagem = KeyEvent.VK_LEFT;
        }
        if(event.getKeyCode() == KeyEvent.VK_RIGHT){
            direcaoPersonagem = KeyEvent.VK_RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}