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
            ventanaJuego.setMinutos(getJuego().getSudokuUno().getDificultad());
            ventanaJuego.setSegundos(0);
            this.colorearCuadro();
            ventanaJuego.getLblTiempoCambiante().setText(String.valueOf(ventanaJuego.getMinutos()));
            ventanaJuego.getLblTiempoCambianteS().setText(String.valueOf(ventanaJuego.getSegundos()));
        }
        return ventanaJuego;
    }
    
    public void ControlTiempo(){
            ventanaJuego.setSegundos(ventanaJuego.getSegundos() - 1);   
            if (ventanaJuego.getSegundos() < 0){
                ventanaJuego.setSegundos(59);
                ventanaJuego.setMinutos(ventanaJuego.getMinutos() - 1);
            } 
            if(ventanaJuego.getSegundos() == 0 && ventanaJuego.getMinutos() == 0){
                JOptionPane.showMessageDialog(null, "Se ha quedado sin tiempo");
                ventanaJuego.getTiempo().stop();
                this.btnVolver();
            }else{
            ventanaJuego.getLblTiempoCambiante().setText(String.valueOf(ventanaJuego.getMinutos()));
            ventanaJuego.getLblTiempoCambianteS().setText(String.valueOf(ventanaJuego.getSegundos()));
            }
    }

    public void salir() {
        System.exit(0);
    }

    public void btnVolver() {
        ventanaJuego.getTiempo().stop();
        ventanaJuego.setMinutos(0);
        ventanaJuego.setSegundos(0);
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
