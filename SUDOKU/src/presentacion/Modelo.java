package presentacion;

import javax.swing.JOptionPane;
import logic.App;

public class Modelo {

    //ATRIBUTOS
    
    private VistaMenu ventanaDeInicio;
    private VistaJuego ventanaJuego;
    private App juego;

    //MÉTODOS
    
    /**
     * Metodo que iniciliza la vista del menu
     */
    public void iniciarVentana() {
        getVentanaDeInicio().setTitle("SUDOKU");
        getVentanaDeInicio().setResizable(false);
        getVentanaDeInicio().setLocationRelativeTo(null);
        getVentanaDeInicio().setVisible(true);
    }

    /**
     * Metodo que incializa la ventana del juego 
     */
    public void iniciarPartida() {
        getVentanaDeInicio().setVisible(false);
        getVentanaJuego().setTitle("SUDOKU");
        getVentanaJuego().setResizable(false);
        getVentanaJuego().setLocationRelativeTo(null);
        getVentanaJuego().setVisible(true);
    }
   
    /** 
     * Metodo getter que instancia todas las propiedades de la ventana de juego
     * @return 
     */
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
    
    /**
     * Metodo para controlar el tiempo limite del usuario para solucionar el sudoku
     */
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

    /**
     * Metodo para salir del programa
     */
    public void salir() {
        System.exit(0);
    }

    /**
     * Metodo que reacciona al boton volver del usuario
     */
    public void btnVolver() {
        ventanaJuego.getTiempo().stop();
        ventanaJuego.setMinutos(0);
        ventanaJuego.setSegundos(0);
        ventanaJuego.dispose();
        ventanaDeInicio.setVisible(true);
        ventanaJuego=null;
    }
    
    /**
     * Metodo que reacciona al boton de comprobar solucion del usuario
     */
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
    
    /**
     * Metodo que colorea los cuadrantes del sudoku mostrado al usuario
     */
    public void colorearCuadro(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cuadrante = getJuego().getSudokuUno().conocerCuadrante(i, j);
                getVentanaJuego().colorearSudoku(cuadrante, i, j);
            }
        }
    }
            
    /**
     * Metodo getter que instancia todas las propiedades de la ventana de menu
     * @return 
     */
    public VistaMenu getVentanaDeInicio() {
        if (ventanaDeInicio == null) {

            ventanaDeInicio = new VistaMenu(this);
        }
        return ventanaDeInicio;
    }
    
    /**
     * Metodo que reacciona al boton reiniciar del usuario
     */
    public void btnReiniciar(){
        ventanaJuego.reiniciarCampos();
    }

    /**
     * Metodo getter que instancia todas las propiedades de la clase abstracta App
     * @return juego
     */
    public App getJuego() {
        if (juego == null) {
            juego = new App();
        }
        return juego;
    }   
    
    /**
     * Metodo para colocar la dificultad del juego
     * @param valorDificuldad 
     */
    public void seleccionarDificultad(int valorDificuldad) {
        getJuego().getSudokuUno().setDificultad(valorDificuldad);
    }
}
