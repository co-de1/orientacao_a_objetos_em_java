package Empresa;

import Clientes.*;
import Terceirizados.*;

public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin(10000, 100);

        admin.sacar(200);
        admin.depositar(500);
        admin.imprimir();

        Vendedor vendedor = new Vendedor();

        vendedor.vender(20, 1.5);
        admin.contabilizar();
        admin.imprimir();

        Cliente cliente = new Cliente();
        cliente.avaliar("Que produto bom...");

        Terceirizado terceirizado = new Terceirizado();
        terceirizado.vender(50);
        admin.contabilizar();

        admin.imprimir();

    }
}