//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Empregador empregador = new Empregador();
        empregador.pagarColaboradores(empregador, 3500);
        empregador.imprimirEmpregador("José");

        Empregado empregado1 = new Empregado();
        empregador.pagarColaboradores(empregado1, 2500);
        empregado1.imprimirEmpregado("Manuel");

        Empregado empregado2 = new Empregado();
        empregador.pagarColaboradores(empregado2, 2500);
        empregado2.imprimirEmpregado("Antonio");

        Empresa[] colaborador = new Empresa[3];

        colaborador[0] = empregador;
        colaborador[1] = empregado1;
        colaborador[2] = empregado2;

        for (int i = 0; i < colaborador.length; i++){
            Empresa.quantidadeDeColaboradores ++;
        }

        System.out.println("\nColaborador: " + empregador.nome);
        System.out.println("Colaborador: " + empregado1.nome);
        System.out.println("Colaborador: " + empregado2.nome);
        System.out.println("\nQuantidade de Colaboradores: " + Empresa.quantidadeDeColaboradores);
    }
}