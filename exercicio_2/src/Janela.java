
public class Janela {
    private double largura;
    private double altura;
    int manterProporcao;
    double taxaDeProporcao;

    Janela(double largura, double altura, int manterProporcao){
        this.largura = largura;
        this.altura = altura;
        this.manterProporcao = manterProporcao;
        if (altura != 0) {
            this.taxaDeProporcao = largura / altura;
        } else {
            this.taxaDeProporcao = 0;
        }
    }

    void redimensionarLargura(double novaLargura){
        this.largura = novaLargura;
        if (manterProporcao == 1 && taxaDeProporcao != 0) {
            this.altura = novaLargura / taxaDeProporcao;
        }
    }

    void redimensionarAltura(double novaAltura){
            this.altura = novaAltura;
            if (manterProporcao == 1 && taxaDeProporcao != 0){
                this.largura = novaAltura * taxaDeProporcao;
            }
    }

    void imprimirInfo(){
        System.out.println("Largura: " + largura);
        System.out.println("Altura: " + altura);
        System.out.println("Taxa de Proporcao: " + taxaDeProporcao);
    }
}
