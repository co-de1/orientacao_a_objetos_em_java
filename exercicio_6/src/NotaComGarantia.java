import java.util.Scanner;

public class NotaComGarantia implements CertificadoDeGarantia, ModeloDeNota {

    double valorDaNota;
    int mesesDeGarantia;

    public void gerarNota(){
        Scanner valor = new Scanner(System.in);

        System.out.println("Digite o valor da nota: ");
        valorDaNota = valor.nextDouble();
    }
    public void imprimirNota(){
        System.out.println("\nValor da nota: " + valorDaNota);
    }

    public void gerarCertificado(){

        Scanner meses = new Scanner(System.in);

        System.out.println("Digite os meses de garantia da nota: ");
        mesesDeGarantia = meses.nextInt();
    };

    public void imprimirCertificado(){
        System.out.println("Meses de garantia: " + mesesDeGarantia);
    }
}
