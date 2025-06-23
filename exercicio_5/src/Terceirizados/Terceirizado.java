package Terceirizados;

import Empresa.*;

public class Terceirizado extends Admin {
    public void vender(int quantidade){
        Admin.caixa = Admin.caixa + Admin.precoDeVenda*quantidade;
        Admin.estoque = Admin.estoque - quantidade;
    }
}
