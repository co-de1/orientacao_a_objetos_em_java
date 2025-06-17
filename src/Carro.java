public class Carro {
    int quantidadeDePortas;
    String montadora;
    double velocidade;

    Carro(String M, int Q, double V){
        montadora = M;
        quantidadeDePortas = Q;
        velocidade = V;
    }

    void acelerar(double dv){
        velocidade = velocidade + dv;
    }
}