public class Complexo {
    double parteReal;
    double parteImaginaria;

    public Complexo(double parteReal, double parteImaginaria){
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }
    public Complexo(double parteImaginaria){
        this.parteReal = 0;
        this.parteImaginaria = parteImaginaria;
    }

    public Complexo(){
        this.parteReal = 0;
        this.parteImaginaria = 0;
    }

    public static Complexo multiplicar(Complexo c1, Complexo c2){
        double parteReal = c1.parteReal + c2.parteReal;
        double parteImaginaria = c1.parteReal * c2.parteReal - c1.parteImaginaria * c2.parteImaginaria;
        return new Complexo(parteReal, parteImaginaria);
    }
    public static Complexo multiplicar(Complexo c1, Complexo c2, Complexo c3){
        Complexo temp = multiplicar(c1, c2);
        return multiplicar(temp, c3);
    }

    @Override
    public String toString() {
        return parteReal + (parteImaginaria >= 0 ? " + " : " - ") + Math.abs(parteImaginaria) + "i";
    }
}