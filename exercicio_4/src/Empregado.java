public class Empregado extends Empresa{
    public String nome;
    double saldoDoEmpregado = 0;

    void imprimirEmpregado(String nome){
        System.out.println("Nome: " + nome);
        System.out.println("Saldo do Empregado: " + saldoDoEmpregado + " R$");
    }
}
