public class Estudante {
    String nome;
    String matricula;
    double nota1;
    double nota2;
    double nota3;
    double mediaFinal;


    Estudante(String N, String M, double N1, double N2, double N3){
        nome = N;
        matricula = M;
        nota1 = N1;
        nota2 = N2;
        nota3 = N3;
    }
    void calcularMedia(){
        mediaFinal = (nota1 + nota2 + nota3)/3;
    }

    void imprimirInfo(){
        System.out.println("Nome: "+ nome);
        System.out.println("Matricula: "+ matricula);
        System.out.println("Media: " + mediaFinal);
    }
}
