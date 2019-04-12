package presentacion;

import javax.swing.JOptionPane;
import logic.App;

public class Modelo {

    //ATRIBUTOS
    private VistaMenu ventanaDeInicio;
    private VistaJuego ventanaJuego;
    private App juego;

    //MÉTODOS
    public void iniciarVentana() {
        getVentanaDeInicio().setTitle("SUDOKU");
        getVentanaDeInicio().setResizable(false);
        getVentanaDeInicio().setLocationRelativeTo(null);
        getVentanaDeInicio().setVisible(true);
    }

    public void iniciarPartida() {
        getVentanaDeInicio().setVisible(false);
        getVentanaJuego().setTitle("SUDOKU");
        getVentanaJuego().setResizable(false);
        getVentanaJuego().setLocationRelativeTo(null);
        getVentanaJuego().setVisible(true);
    }
    public VistaJuego getVentanaJuego() {
        if (ventanaJuego == null) {
            ventanaJuego = new VistaJuego(this);            
            getJuego().getSudokuUno().generar();
            ventanaJuego.setSudoku(getJuego().getSudokuUno().getSudoku());
            ventanaJuego.llenarCampos();
            this.colorearCuadro();
        }
        return ventanaJuego;
    }

    public void salir() {
        System.exit(0);
    }

    public void btnVolver() {
        ventanaJuego.dispose();
        ventanaDeInicio.setVisible(true);
        ventanaJuego=null;
    }
    
    public void btnComprobarSolucion(){
        ventanaJuego.recogerSolucion();
        if(juego.getSudokuUno().comprobarSolucion(ventanaJuego.getSolucionUsuario())){
            JOptionPane.showMessageDialog(null,"Felicitaciones, es usted un genio");
            this.btnVolver();
        }
        else {
            JOptionPane.showMessageDialog(null,"Esta mal, por favor confirme su solucion");
        }
    }
    public void colorearCuadro(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cuadrante = getJuego().getSudokuUno().conocerCuadrante(i, j);
                getVentanaJuego().colorearSudoku(cuadrante, i, j);
            }
        }
    }
            
    public VistaMenu getVentanaDeInicio() {
        if (ventanaDeInicio == null) {

            ventanaDeInicio = new VistaMenu(this);
        }
        return ventanaDeInicio;
    }
    
    public void btnReiniciar(){
        ventanaJuego.reiniciarCampos();
    }

    public App getJuego() {
        if (juego == null) {
            juego = new App();
        }
        return juego;
    }

    public void seleccionarDificultad(int valorDificuldad) {
        getJuego().getSudokuUno().setDificultad(valorDificuldad);
    }
}
