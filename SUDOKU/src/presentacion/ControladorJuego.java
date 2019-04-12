package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorJuego implements ActionListener  {
//ATRIBUTOS

    private VistaJuego ventana;
//CONSTRUCTOR

    ControladorJuego(VistaJuego aThis) {
        ventana = aThis;
    }
//MÉTODOS

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventana.getBtnVolver())) {
            ventana.getMiModelo().btnVolver();
        }
        if (e.getSource().equals(ventana.getBtnReiniciar())) {
            ventana.getMiModelo().btnReiniciar();
        }
        if(e.getSource().equals(ventana.getBtnComprobar())){
            ventana.getMiModelo().btnComprobarSolucion();
        }
    }

}
