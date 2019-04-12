/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
public class VistaJuego extends javax.swing.JFrame {

    private JTextField[][] matrizInterfaz;
    private int[][] sudoku;
    private Modelo MiModelo;
    private ControladorJuego miControl;
    private int[][] solucionUsuario = new int[9][9];

    ;
    
    

    public VistaJuego(Modelo m) {
        MiModelo = m;
        initComponents();
        capturareventos();
        generarCampos();
        imprmirCampos();
    }

    public void capturareventos() {
        getBtnVolver().addActionListener(getMiControl());
        getBtnReiniciar().addActionListener(getMiControl());
        getBtnComprobar().addActionListener(getMiControl());
    }

    public Modelo getMiModelo() {
        return MiModelo;
    }

    public ControladorJuego getMiControl() {
        if (miControl == null) {
            miControl = new ControladorJuego(this);
        }
        return miControl;
    }

    public void generarCampos() {
        Font negrita = new Font("Arial", Font.BOLD, 14);
        matrizInterfaz = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrizInterfaz[i][j] = new JTextField();
                matrizInterfaz[i][j].setSize(35, 35);
                matrizInterfaz[i][j].setFont(negrita);
                matrizInterfaz[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }
    }

    public void llenarCampos() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrizInterfaz[i][j].setText(String.valueOf(sudoku[i][j]));
                if (sudoku[i][j] != 0) {
                    matrizInterfaz[i][j].setDisabledTextColor(Color.blue);
                    matrizInterfaz[i][j].setEnabled(false);
                } else {
                    matrizInterfaz[i][j].setText("");
                }
            }
        }
    }

    public void recogerSolucion() {
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                     solucionUsuario[i][j] = Integer.parseInt(matrizInterfaz[i][j].getText());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cometio un error en el llenado del sudoku, verifique su respuesta");
        }

    }
    
    public void reiniciarCampos() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizInterfaz[i][j].isEnabled()) {
                    matrizInterfaz[i][j].setText("");

                }
            }
        }

    }

    public JButton getBtnComprobar() {
        return btnComprobar;
    }

    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public int[][] getSolucionUsuario() {
        return solucionUsuario;
    }

    public JTextField[][] getMatrizInterfaz() {
        return matrizInterfaz;
    }

    public void setMatrizInterfaz(JTextField[][] matrizInterfaz) {
        this.matrizInterfaz = matrizInterfaz;
    }

    public void imprmirCampos() {
        int y, x;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                x = (50 + j * (35 + 1));
                y = (50 + i * (35 + 1));
                this.matrizInterfaz[i][j].setLocation(x, y);
                this.getContentPane().add(this.matrizInterfaz[i][j]);
            }
        }
    }
    public void colorearSudoku(int cuadrante, int i, int j){
                switch(cuadrante){
                    case 1:
                        matrizInterfaz[i][j].setBackground(Color.lightGray);
                        break;
                    case 2:
                        matrizInterfaz[i][j].setBackground(Color.orange);
                        break;
                    case 3:
                        matrizInterfaz[i][j].setBackground(Color.lightGray);
                        break;
                    case 4:
                        matrizInterfaz[i][j].setBackground(Color.orange);
                        break;
                    case 5:
                        matrizInterfaz[i][j].setBackground(Color.lightGray);
                        break;
                    case 6:
                        matrizInterfaz[i][j].setBackground(Color.orange);
                        break;
                    case 7:
                        matrizInterfaz[i][j].setBackground(Color.lightGray);
                        break;
                    case 8:
                        matrizInterfaz[i][j].setBackground(Color.orange);
                        break;
                    case 9:
                        matrizInterfaz[i][j].setBackground(Color.lightGray);
                        break;
                }
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        btnComprobar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        lblTiempoCambiante = new javax.swing.JLabel();
        lblMensajeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 450));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblTiempo.setText("Tiempo:");

        btnComprobar.setText("Comprobar");

        btnReiniciar.setText("Reiniciar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTiempo)
                        .addGap(18, 18, 18)
                        .addComponent(lblTiempoCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnReiniciar)
                        .addGap(62, 62, 62)
                        .addComponent(btnComprobar)
                        .addContainerGap(146, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensajeError)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiempoCambiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVolver)
                        .addComponent(lblTiempo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                .addComponent(lblMensajeError)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReiniciar)
                    .addComponent(btnComprobar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblMensajeError;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoCambiante;
    // End of variables declaration//GEN-END:variables
}
