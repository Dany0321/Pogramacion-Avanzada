
package Presentacion;

import Logica.Meme;
import Logica.MemeCrush;


public class Modelo {
   
    private Vista miVista;
    private MemeCrush miJuego;

    public MemeCrush getMiJuego() {
        if (miJuego==null){
            miJuego = new MemeCrush();
        }
        return miJuego;
    }
    

    
    public Vista getMiVista() {
        if(miVista == null){
            miVista = new Vista(this);
        }
        return miVista;
    }

    public void iniciar() {
        getMiVista().setVisible(true);  
        getMiJuego().llenarAleatorio();
        getMiJuego().corregirErrores();
        getMiJuego().asignarMemes();
        getMiJuego().imprimir();
        inicializarMemes();
        
    }
    /**
     * Metodo para indicar el Vista qué icono poner
     */
    public void inicializarMemes(){
        Meme[][] a =  getMiJuego().getMemeCrushImg();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("i es: "+i);
                System.out.println("j es : "+j);
                getMiVista().imprimirMemes(44*i,44*j,a[i][j].getImgn());
            }
        }
    }

    public void salir() {
        System.exit(0);
    }
    
}
