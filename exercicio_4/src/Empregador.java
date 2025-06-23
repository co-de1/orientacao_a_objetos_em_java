public class Empregador extends Empresa{
    String nome;
    double saldoDoEmpregador = 0;

    Empregador(){

    }

    void pagarColaboradores(Empregado empregado, double valorPagamento){
        empregado.saldoDoEmpregado += valorPagamento;
        Empresa.saldoDaEmpresa -= valorPagamento;
    }

    void pagarColaboradores(Empregador empregador, double valorPagamento){
        saldoDoEmpregador += valorPagamento;
        Empresa.saldoDaEmpresa -= valorPagamento;
    }

    void imprimirInfo(String nome){
        this.nome = nome;
        System.out.println("Nome: " + nome);
        System.out.println("Saldo do Empregador: " + saldoDoEmpregador + " R$");
    }
}
