package Empresa;

public class Vendedor {
    void vender(int quantidade, double percentual){
        Admin.caixa = Admin.caixa + quantidade*percentual*Admin.precoDeCusto;
        Admin.estoque = Admin.estoque - quantidade;
    }
}
