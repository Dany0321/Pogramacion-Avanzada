package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class controladorMenu implements ActionListener,ItemListener {
//ATRIBUTOS

    private VistaMenu ventana;
//CONSTRUCTOR

    controladorMenu(VistaMenu aThis) {
        ventana = aThis;
    }
//MÉTODOS

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventana.getBtnInicio())) {
            ventana.getModeloUno().iniciarPartida();
        }
        if (e.getSource().equals(ventana.getBtnSalir())) {
            ventana.getModeloUno().salir();
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(ventana.getComboDificultad())){
            switch(ventana.getComboDificultad().getSelectedItem().toString()){
                case "Facil":
                    ventana.getModeloUno().seleccionarDificultad(40);
                    break;
                case "Normal":
                    ventana.getModeloUno().seleccionarDificultad(25);
                    break; 
            }
        }
    }
}
