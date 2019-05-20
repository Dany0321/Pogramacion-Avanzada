package Presentacion;

import Logica.Meme;
import Logica.MemeCrush;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.applet.AudioClip;
import javax.swing.JOptionPane;

public class Modelo implements Runnable {

    private Vista miVista;
    private MemeCrush miJuego;
    private Thread hilo;
    private AudioClip sonido;

    public void reproducirSonidoMeme() {       
        this.sonido.play();
         try {        
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escogerSonido() throws IOException {
        if (getMiJuego().contarSoluciones(getMiVista().getMatrizDePrueba()) >= 5) {
            this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/Chingawhat.wav"));
            
        }
        if (getMiJuego().contarSoluciones(getMiVista().getMatrizDePrueba()) == 3) {
            this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/Increible.wav"));
            
        }
        if (getMiJuego().contarSoluciones(getMiVista().getMatrizDePrueba()) == 4) {
            this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/Uy no lo puedo creer.wav"));
            
        }
        if (getMiJuego().contarSoluciones(getMiVista().getMatrizDePrueba()) == 0) {
            this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/Nope.wav"));
            
        }
    }

    public MemeCrush getMiJuego() {
        if (miJuego == null) {
            miJuego = new MemeCrush();
        }
        return miJuego;
    }

    public Vista getMiVista() throws IOException {
        if (miVista == null) {
            miVista = new Vista(this);
            miVista.setMinutos(2);
            miVista.setSegundos(0);
        }
        return miVista;
    }

    public void iniciar() {
        try {
            hilo = new Thread(this);
            getMiVista().setVisible(true);
            getMiJuego().llenarAleatorio();
            getMiJuego().corregirErrores();
            getMiJuego().asignarMemes();
            getMiVista().getLblTiempoMinutos().setText("5");
            getMiVista().getLblTiempoSegundos().setText("0");
            getMiVista().getTiempo().start();
            inicializarMemes();
            System.out.println("La matriz original es:");
            getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para indicar el Vista qué icono poner
     */
    public void inicializarMemes() throws IOException {
        Meme[][] a = getMiJuego().getMemeCrushImg();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                getMiVista().imprimirMemes(44 * j, 44 * i, a[i][j].getImgn());
            }
        }
    }

    /**
     * Metodo para ver si las coordenadas de click del mouse son correctas para
     * hacer cambios Las coordenadas estan en terminos de x, y (no de i,j)
     */
    public boolean comprobarPosibleMovimiento(int[] coordernadas1, int[] coordernadas2) {
        //ESQUINA SUPERIOR IZQUIERDA
        if (coordernadas1[0] == 0 && coordernadas1[1] == 0) {
            if ((coordernadas2[0] == 1 && coordernadas2[1] == 0) || (coordernadas2[0] == 0 && coordernadas2[1] == 1)) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //ESQUINA INFERIOR IZQUIERDA
        if (coordernadas1[0] == 0 && coordernadas1[1] == 8) {
            if ((coordernadas2[0] == 0 && coordernadas2[1] == 7) || (coordernadas2[0] == 1 && coordernadas2[1] == 8)) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //ESQUINA SUPERIOR DERECHA
        if (coordernadas1[0] == 8 && coordernadas1[1] == 0) {
            if ((coordernadas2[0] == 7 && coordernadas2[1] == 0) || (coordernadas2[0] == 8 && coordernadas2[1] == 1)) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //ESQUINA INFERIOR DERECHA
        if (coordernadas1[0] == 8 && coordernadas1[1] == 8) {
            if ((coordernadas2[0] == 7 && coordernadas2[1] == 8) || (coordernadas2[0] == 8 && coordernadas2[1] == 7)) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //BORDE SUPERIOR
        if ((coordernadas1[0] > 0 && coordernadas1[0] < 8) && coordernadas1[1] == 0) {
            if ((coordernadas2[0] == coordernadas1[0] + 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[0] == coordernadas1[0] - 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[1] == coordernadas1[1] + 1 && coordernadas2[0] == coordernadas1[0])) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //BORDE INFERIOR
        if ((coordernadas1[0] > 0 && coordernadas1[0] < 8) && coordernadas1[1] == 8) {
            if ((coordernadas2[0] == coordernadas1[0] + 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[0] == coordernadas1[0] - 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[1] == coordernadas1[1] - 1 && coordernadas2[0] == coordernadas1[0])) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //BORDE IZQUIERDO
        if ((coordernadas1[1] > 0 && coordernadas1[1] < 8) && coordernadas1[0] == 0) {
            if ((coordernadas2[0] == coordernadas1[0] + 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[1] == coordernadas1[1] - 1 && coordernadas2[0] == coordernadas1[0]) || (coordernadas2[1] == coordernadas1[1] + 1 && coordernadas2[0] == coordernadas1[0])) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //BORDE DERECHO
        if ((coordernadas1[1] > 0 && coordernadas1[1] < 8) && coordernadas1[0] == 8) {
            if ((coordernadas2[0] == coordernadas1[0] - 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[1] == coordernadas1[1] - 1 && coordernadas2[0] == coordernadas1[0]) || (coordernadas2[1] == coordernadas1[1] + 1 && coordernadas2[0] == coordernadas1[0])) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }
        //GENERALIZACION
        if ((coordernadas1[0] > 0 && coordernadas1[0] < 8) && (coordernadas1[1] > 0 && coordernadas1[1] < 8)) {
            if ((coordernadas2[0] == coordernadas1[0] + 1 && coordernadas2[1] == coordernadas1[1]) || (coordernadas2[0] == coordernadas1[0] - 1 && coordernadas2[1] == coordernadas1[1])
                    || (coordernadas2[1] == coordernadas1[1] + 1 && coordernadas2[0] == coordernadas1[0]) || (coordernadas2[1] == coordernadas1[1] - 1 && coordernadas2[0] == coordernadas1[0])) {
                System.out.println("Si mames, ccomo lo hizo, que poder");
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /**
     * Metodo para intercambiar el numero de los click que da el usuario
     */
    public void intercambiarNumero(int x1, int x2, int y1, int y2) {
        try {
            int numeroGuardado = 0;
            numeroGuardado = getMiVista().getMatrizDePrueba()[y2][x2];
            getMiVista().setMatrizDePrueba(y2, x2, getMiVista().getMatrizDePrueba()[y1][x1]);
            getMiVista().setMatrizDePrueba(y1, x1, numeroGuardado);
            getMiJuego().setMemeCrush(getMiVista().getMatrizDePrueba());
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void controlTiempo(){
        try {
            getMiVista().setSegundos(getMiVista().getSegundos() - 1);   
            if (getMiVista().getSegundos() < 0){
                getMiVista().setSegundos(59);
                getMiVista().setMinutos(getMiVista().getMinutos() - 1);
            } 
            if(getMiVista().getSegundos() == 0 && getMiVista().getMinutos() == 0){
                this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonido/Bueno nos vamos.wav"));
                reproducirSonidoMeme();
                JOptionPane.showMessageDialog(null, "Se ha quedado sin tiempo");
                getMiVista().getTiempo().stop();
                salir();
            }else{
            getMiVista().getLblTiempoMinutos().setText(String.valueOf(getMiVista().getMinutos()));
            getMiVista().getLblTiempoSegundos().setText(String.valueOf(getMiVista().getSegundos()));
            }
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarCanvas() {
        try {
            getMiVista().borrarCanvas();
            getMiJuego().asignarMemes();
            inicializarMemes();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void administrarPuntos(int contador){
        try {
            int puntuacionActual = Integer.parseInt(getMiVista().getLblPuntuacionNumero().getText());
            int puntos = contador * 100;
            getMiVista().getLblPuntuacionNumero().setText(String.valueOf(puntos + puntuacionActual));
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo de interaccion de usuario
     */
    public void interaccionDeUsuario() {
        try {
            int[] coordernadas1 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse1()[0], getMiVista().getPosMouse1()[1]);
            int[] coordernadas2 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse2()[0], getMiVista().getPosMouse2()[1]);
            if (comprobarPosibleMovimiento(coordernadas1, coordernadas2)) {
                this.intercambiarNumero(coordernadas1[0], coordernadas2[0], coordernadas1[1], coordernadas2[1]);
                if (getMiJuego().ComprobarExistenciaSolucion(getMiVista().getMatrizDePrueba())) {
                    System.out.println("\nme movi: \n\n");
                    getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                    while (getMiJuego().ComprobarExistenciaSolucion(getMiVista().getMatrizDePrueba())) {
                        System.out.println("\n Borre las soluciones: \n\n");
                        getMiVista().setMatrizDePrueba(getMiJuego().BorrarSoluciones(getMiVista().getMatrizDePrueba()));
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                        System.out.println("Aqui subi los ceros\n\n");
                        getMiJuego().subirCeros(getMiVista().getMatrizDePrueba());
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                        System.out.println("Ya estoy lleno :v\n\n");
                        getMiJuego().llenarAleatorio(getMiVista().getMatrizDePrueba());
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                    }
                    System.out.println("quede asi :O (cuanto poder)");
                    getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                    getMiVista().borrarCanvas();
                    
                } else {
                    this.intercambiarNumero(coordernadas2[0], coordernadas1[0], coordernadas2[1], coordernadas1[1]);
                    
                    System.out.println("quede asi :O (cuanto poder)");
                    getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que pone las coordenadas del click del mouse en un arreglo
     *
     * @param x coordenada horizontal del mouse
     * @param y coordenada vertical del mouse
     */
    public void conseguirCoordenadas(int x, int y) {
        try {
            if (getMiVista().getnClicks() == 0) {
                getMiVista().getPosMouse1()[0] = x;
                getMiVista().getPosMouse1()[1] = y;
                getMiVista().setnClicks(getMiVista().getnClicks() + 1);
                //System.out.println("Entre,  x es: " +x+ " y y es: "+y);
                System.out.println("Dio el primer click");
            } else {
                getMiVista().getPosMouse2()[0] = x;
                getMiVista().getPosMouse2()[1] = y;
                System.out.println("Dio el segundo click");
                getMiVista().setnClicks(0);
                hilo.run();
            }
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salir() {
        System.exit(0);
    }

    @Override
    public void run() {
        try {
            System.out.println("ayuda");
            int[] coordernadas1 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse1()[0], getMiVista().getPosMouse1()[1]);
            int[] coordernadas2 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse2()[0], getMiVista().getPosMouse2()[1]);
            if (comprobarPosibleMovimiento(coordernadas1, coordernadas2)) {
                this.intercambiarNumero(coordernadas1[0], coordernadas2[0], coordernadas1[1], coordernadas2[1]);
                Thread.sleep(50);
                actualizarCanvas();
                getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                if (getMiJuego().ComprobarExistenciaSolucion(getMiVista().getMatrizDePrueba())) {
                    while (getMiJuego().ComprobarExistenciaSolucion(getMiVista().getMatrizDePrueba())) {
                        getMiVista().setMatrizDePrueba(getMiJuego().BorrarSoluciones(getMiVista().getMatrizDePrueba()));
                        escogerSonido();
                        reproducirSonidoMeme();
                        administrarPuntos(getMiJuego().contarSoluciones(getMiVista().getMatrizDePrueba()));
                        Thread.sleep(50);
                        actualizarCanvas();
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                        getMiJuego().subirCeros(getMiVista().getMatrizDePrueba());
                        Thread.sleep(50);
                        actualizarCanvas();
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                        getMiJuego().llenarAleatorio(getMiVista().getMatrizDePrueba());
                        Thread.sleep(50);
                        actualizarCanvas();
                        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                    }
                } else {
                    escogerSonido();
                    reproducirSonidoMeme();
                    this.intercambiarNumero(coordernadas2[0], coordernadas1[0], coordernadas2[1], coordernadas1[1]);
                    Thread.sleep(50);
                    actualizarCanvas();
                    getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
                }
            }
            System.out.println("termine");
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
