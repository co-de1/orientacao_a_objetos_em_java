public class Empregado extends Empresa{
    public String nome;
    double saldoDoEmpregado = 0;

    Empregado(){

    }
    void imprimirInfo(String nome){
        System.out.println("Nome: " + nome);
        System.out.println("Saldo do Empregado: " + saldoDoEmpregado + " R$");
    }
}
