/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

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
    private BufferedImage Fondo;
    private Timer tiempo = new Timer(1000, getmiControl());
    int minutos , segundos;
    

    Vista(Modelo m) throws IOException {
        this.Fondo = ImageIO.read(getClass().getResource("/Imagenes/Borrador.png"));
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
    
    public void borrarCanvas(){
        canvas1.getGraphics().drawImage(this.Fondo, 0, 0,null);
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

    public void setMatrizDePrueba(int[][] matrizDePrueba) {
        this.matrizDePrueba = matrizDePrueba;
    }

    public Timer getTiempo() {
        return tiempo;
    }

    public JLabel getLblTiempoSegundos() {
        return lblTiempoSegundos;
    }

    public void setLblTiempoSegundos(JLabel lblTiempoSegundos) {
        this.lblTiempoMinutos = lblTiempoSegundos;
    }

    public JLabel getLblTiempoMinutos() {
        return lblTiempoMinutos;
    }

    public void setLblTiempoMinutos(JLabel lblTiempoMinutos) {
        this.lblTiempoMinutos = lblTiempoMinutos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    
    

    public void setMatrizDePrueba(int x, int y, int numeroACambiar) {
        matrizDePrueba[x][y] = numeroACambiar;
    }

    public JLabel getLblPuntuacionNumero() {
        return lblPuntuacionNumero;
    }
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        lblPuntuacionNumero = new javax.swing.JLabel();
        lblTiempoMinutos = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        lblTiempoSegundos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        lblPuntuacionNumero.setText("0");

        jLabel1.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPuntuacionNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblPuntuacion))
                .addGap(60, 60, 60)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTiempoMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTiempoSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblPuntuacion)
                        .addGap(13, 13, 13)
                        .addComponent(lblPuntuacionNumero))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTiempo)
                            .addComponent(lblTiempoMinutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(lblTiempoSegundos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblPuntuacionNumero;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoMinutos;
    private javax.swing.JLabel lblTiempoSegundos;
    // End of variables declaration//GEN-END:variables

   
}
