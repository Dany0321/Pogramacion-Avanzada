/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

import javax.swing.JButton;

/**
 *
 * @author Estudiantes
 */
public class Vista extends javax.swing.JFrame{

    private Controlador miControl;
    private Modelo miModelo;
    private int[][] matrizDePrueba;
    private int nClicks = 0;
    private int[] posMouse1 = new int[2];
    private int[] posMouse2 = new int[2];
    

    Vista(Modelo m) {
        initComponents();
        this.setLocationRelativeTo(null);
        miModelo = m;
        matrizDePrueba = miModelo.getMiJuego().getMemeCrush();
        canvas1.addMouseListener(getmiControl());
        capturareventos();
    }

   /**
    * Metodo para dibujar los iconos en el canvas
    * @param x coordenada horizontal
    * @param y coordenada vertical
    * @param img icono
    * @param g lapiz que pertenece al canvas
    */
    public void imprimirMemes(int x, int y, Image img){
        canvas1.getGraphics().drawImage(img, x, y,null);
    }
    
    public Controlador getmiControl() {
        if (miControl == null) {
            miControl = new Controlador(this);
        }
        return miControl;
    }
    /**
     * Metodo para relacionar la coordenada en el canvas con la posicion en la matriz numerica
     */
    public int[] reconocerCoordenada(int x, int y){
        int pos1 = (int) Math.floor(x/44);
        int pos2 = (int) Math.floor(y/44);
        int[] coordenada = new int[2];
        coordenada[0] = pos1;
        coordenada[1] = pos2;
        return coordenada;
    }

    public void capturareventos() {
        getBtnSalir().addActionListener(getmiControl());

    }

    public Modelo getMiModelo() {
        return miModelo;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public Canvas getCanvas1() {
        return canvas1;
    }


    public int getnClicks() {
        return nClicks;
    }

    public void setnClicks(int nClicks) {
        this.nClicks = nClicks;
    }

    public int[] getPosMouse1() {
        return posMouse1;
    }

    public void setPosMouse1(int[] posMouse1) {
        this.posMouse1 = posMouse1;
    }

    public int[] getPosMouse2() {
        return posMouse2;
    }

    public void setPosMouse2(int[] posMouse2) {
        this.posMouse2 = posMouse2;
    }

    public int[][] getMatrizDePrueba() {
        return matrizDePrueba;
    }

    public void setMatrizDePrueba(int x, int y, int numeroACambiar) {
        matrizDePrueba[x][y] = numeroACambiar;
    }
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        lblPuntuacionNumero = new javax.swing.JLabel();
        lblTiempoSegundos = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblTiempo.setText("Tiempo: ");

        lblPuntuacion.setText("PUNTUACION:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuntuacion)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPuntuacionNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTiempo)
                        .addGap(9, 9, 9)
                        .addComponent(lblTiempoSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblPuntuacion)
                        .addGap(13, 13, 13)
                        .addComponent(lblPuntuacionNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiempo)
                            .addComponent(lblTiempoSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(360, 360, 360)
                        .addComponent(btnSalir)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblPuntuacionNumero;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoSegundos;
    // End of variables declaration//GEN-END:variables

   
}
