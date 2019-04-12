package presentacion;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaMenu extends javax.swing.JFrame {
//ATRIBUTOS

    private Modelo modeloUno;
    private controladorMenu controladorUno;

//CONSTRUCTORES
    public VistaMenu(Modelo m) {
        modeloUno = m;
        initComponents();
        capturareventos();
    }
//MÉTODOS 

    public void capturareventos() {
        getBtnInicio().addActionListener(getControladorUno());
        getBtnSalir().addActionListener(getControladorUno());
        getComboDificultad().addItemListener(getControladorUno());
    }

    public JComboBox<String> getComboDificultad() {
        return comboDificultad;
    }

    public Modelo getModeloUno() {
        return modeloUno;
    }

    public controladorMenu getControladorUno() {
        if (controladorUno == null) {
            controladorUno = new controladorMenu(this);
        }
        return controladorUno;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
    
    

    public JButton getBtnInicio() {
        return btnInicio;
    }

//LA VENTANA CREADA CON JFRAME
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        btnInicio = new javax.swing.JButton();
        comboDificultad = new javax.swing.JComboBox<>();
        lblBienvenida = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnInicio.setText("Iniciar");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        comboDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal" }));

        lblBienvenida.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblBienvenida.setText("¡¡Bienvenido a Sudoku!!");

        lblSeleccion.setText("por favor seleccione una dificultad");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInicio)
                            .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSalir))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lblBienvenida)
                .addGap(18, 18, 18)
                .addComponent(lblSeleccion)
                .addGap(44, 44, 44)
                .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSalir))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        
    }//GEN-LAST:event_btnInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblSeleccion;
    // End of variables declaration//GEN-END:variables
}
