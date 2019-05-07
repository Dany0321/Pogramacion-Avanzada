
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 

public class Controlador implements ActionListener {
    private Vista miVista;

    Controlador(Vista aThis) {
        miVista = aThis;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource().equals(miVista.getBtnSalir())) {            
             miVista.getMiModelo().salir();
        }
    }
    
}
