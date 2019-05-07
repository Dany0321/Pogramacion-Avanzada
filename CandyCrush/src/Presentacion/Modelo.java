
package Presentacion;


public class Modelo {
   
    private Vista miVista;

    public Vista getMiVista() {
        if(miVista == null){
            miVista = new Vista(this);
        }
        return miVista;
    }

    public void iniciar() {
        getMiVista().setVisible(true);        
        
    }

    public void salir() {
        System.exit(0);
    }
    
}
