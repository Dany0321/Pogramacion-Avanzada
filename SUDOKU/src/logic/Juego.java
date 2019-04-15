package logic;

public interface Juego {
    //Metodos abstractos
    
    public abstract void generar();

    public abstract boolean comprobarSolucion(int[][] a);
}
