package Empresa;

public class Admin {
    private static double saldo = 0;
    static double precoDeCusto = 10;
    protected static double precoDeVenda = 12;
    protected static double caixa = 0;
    protected static int estoque = 0;
    public static String avaliacoes = " " ;

    Admin(double saldo, int estoque){
        Admin.saldo = saldo;
        Admin.estoque = estoque;
    }

    protected Admin(){

    }

    void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Estoque: " + estoque);
        System.out.println("Avaliacoes: " + avaliacoes);
        System.out.println("\n-----------------\n");
    }
    void sacar(double valor){
        Admin.saldo -= valor;
    }
    void depositar(double valor){
        Admin.saldo += valor;
    }

    void contabilizar(){
        Admin.saldo = Admin.saldo + Admin.caixa;
        Admin.caixa = 0;
    }
}
