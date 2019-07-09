package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador implements ActionListener, MouseListener {

    private Vista miVista;

    Controlador(Vista aThis) {
        miVista = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(miVista.getBtnSalir())) {
            miVista.getMiModelo().salir();
        }
        if (e.getSource().equals(miVista.getTiempo())) {
            miVista.getMiModelo().controlTiempo();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(miVista.getCanvas1())) {
            miVista.getMiModelo().conseguirCoordenadas(e.getX(), e.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
