//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Carro celta = new Carro("Fiat", 5, 0); // Metodo construtor


        /*
        celta.montadora = "Fiat";
        celta.quantidadeDePortas = 5;
        celta.velocidade = 0;
        */

        celta.acelerar(20);

        System.out.println("Montadora: " + celta.montadora );
        System.out.println("Velocidade: " + celta.velocidade);
        System.out.println("Quantidade de Portas: " + celta.quantidadeDePortas);
    }
}