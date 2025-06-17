//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Janela janela = new Janela(1000, 2000, 1);

        janela.redimensionarLargura(600);
        //janela.redimensionarAltura(200);

        janela.imprimirInfo();
    }
}