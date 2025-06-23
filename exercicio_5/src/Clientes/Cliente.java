package Clientes;

import Empresa.*;

public class Cliente {
    public void avaliar(String avaliacao){
        Admin.avaliacoes = Admin.avaliacoes + avaliacao;
    }
}
