package Presentacion;

import Logica.Meme;
import Logica.MemeCrush;

public class Modelo {

    private Vista miVista;
    private MemeCrush miJuego;

    public MemeCrush getMiJuego() {
        if (miJuego == null) {
            miJuego = new MemeCrush();
        }
        return miJuego;
    }

    public Vista getMiVista() {
        if (miVista == null) {
            miVista = new Vista(this);
        }
        return miVista;
    }

    public void iniciar() {
        getMiVista().setVisible(true);
        getMiJuego().llenarAleatorio();
        getMiJuego().corregirErrores();
        getMiJuego().asignarMemes();
        getMiJuego().imprimir(getMiVista().getMatrizDePrueba());
        inicializarMemes();

    }

    /**
     * Metodo para indicar el Vista qué icono poner
     */
    public void inicializarMemes() {
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
    public boolean comprobarPosibleMovimiento() {
        int[] coordernadas1 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse1()[0], getMiVista().getPosMouse1()[1]);
        int[] coordernadas2 = getMiVista().reconocerCoordenada(getMiVista().getPosMouse2()[0], getMiVista().getPosMouse2()[1]);
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
     * Metodo que pone las coordenadas del click del mouse en un arreglo
     *
     * @param x coordenada horizontal del mouse
     * @param y coordenada vertical del mouse
     */
    public void conseguirCoordenadas(int x, int y) {
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
            System.out.println(comprobarPosibleMovimiento());
            getMiVista().setnClicks(0);

        }
    }

    public void salir() {
        System.exit(0);
    }

}
