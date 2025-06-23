
public class Main {
    public static void main(String[] args) {

        Empregador empregador = new Empregador();
        empregador.pagarColaboradores(empregador, 3500);
        empregador.imprimirInfo("José");

        Empregado empregado1 = new Empregado();
        empregador.pagarColaboradores(empregado1, 2500);
        empregado1.imprimirInfo("Manuel");

        Empregado empregado2 = new Empregado();
        empregador.pagarColaboradores(empregado2, 2500);
        empregado2.imprimirInfo("Antonio");

        Empresa[] colaborador = new Empresa[3];

        colaborador[0] = empregador;
        colaborador[1] = empregado1;
        colaborador[2] = empregado2;

        for (Empresa empresa : colaborador) {
            empresa.imprimirInfo();
            Empresa.quantidadeDeColaboradores++;
        }
        System.out.println("\nQuantidade de Colaboradores: " + Empresa.quantidadeDeColaboradores);
    }
}