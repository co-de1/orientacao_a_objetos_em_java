//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Multiplicacao de inteiros

        System.out.println("\nMultiplicacao de 2 inteiros: " + MultiplicarInteiros.multiplicar(6, 10));

        System.out.println("Multiplicacao de 3 inteiros: " + MultiplicarInteiros.multiplicar(6, 10, 5));

        // Multiplicacao de doubles


        System.out.println("\nMultiplicacao de 2 inteiros: " + MultiplicarDoubles.multiplicar(5, 2.3));

        System.out.println("Multiplicacao de 3 inteiros: " + MultiplicarDoubles.multiplicar(4.1, 2.5, 5));


        // Multiplicacao de complexos

        Complexo complexo1 = new Complexo(3, 2);
        Complexo complexo2 = new Complexo(3);
        Complexo complexo3 = new Complexo();

        System.out.println("\nMultiplicacao de 2 complexos: " + Complexo.multiplicar(complexo1, complexo2));

        System.out.println("Multiplicacao de 3 complexos: " + Complexo.multiplicar(complexo1, complexo2, complexo3));

    }
}