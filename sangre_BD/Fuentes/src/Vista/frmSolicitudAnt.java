/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Joshua ML
 */
public class frmSolicitudAnt extends javax.swing.JFrame {

    /**
     * Creates new form frmSolicitud
     */
    public frmSolicitudAnt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sangre = new javax.swing.ButtonGroup();
        Signo = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Panel_Solicitudes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Solicitudes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        Panel_Datos = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        text_Nombre = new javax.swing.JTextArea();
        Motivo = new javax.swing.JLabel();
        text_Motivo = new javax.swing.JTextArea();
        Tipo_de_Sangre = new javax.swing.JLabel();
        Sangre_A = new javax.swing.JRadioButton();
        Sangre_B = new javax.swing.JRadioButton();
        Sangre_AB = new javax.swing.JRadioButton();
        Sangre_O = new javax.swing.JRadioButton();
        Separador_Sangre = new javax.swing.JSeparator();
        Sangre_Pos = new javax.swing.JRadioButton();
        Sangre_Neg = new javax.swing.JRadioButton();
        Cantidad = new javax.swing.JLabel();
        text_Cantidad = new javax.swing.JTextField();
        Tipo_de_Sangre1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SABS");

        jPanel2.setBackground(new java.awt.Color(50, 225, 108));

        jPanel1.setBackground(new java.awt.Color(243, 95, 95));

        Panel_Solicitudes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Solicitudes"));
        Panel_Solicitudes.setToolTipText("");

        tbl_Solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Motivo", "Grupo Sanguíneo", "Rh", "Cantidad (L)", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tbl_Solicitudes);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_SolicitudesLayout = new javax.swing.GroupLayout(Panel_Solicitudes);
        Panel_Solicitudes.setLayout(Panel_SolicitudesLayout);
        Panel_SolicitudesLayout.setHorizontalGroup(
            Panel_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_SolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SolicitudesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        Panel_SolicitudesLayout.setVerticalGroup(
            Panel_SolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_SolicitudesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(7, 7, 7))
        );

        Panel_Datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del solicitante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Nombre.setText("Nombre:");

        text_Nombre.setColumns(20);
        text_Nombre.setLineWrap(true);
        text_Nombre.setRows(5);
        text_Nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        text_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_NombreKeyTyped(evt);
            }
        });

        Motivo.setText("Motivo:");

        text_Motivo.setColumns(20);
        text_Motivo.setLineWrap(true);
        text_Motivo.setRows(5);
        text_Motivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        Tipo_de_Sangre.setText("Grupo Sanguíneo");

        Sangre.add(Sangre_A);
        Sangre_A.setSelected(true);
        Sangre_A.setText("A");
        Sangre_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_AActionPerformed(evt);
            }
        });

        Sangre.add(Sangre_B);
        Sangre_B.setText("B");
        Sangre_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_BActionPerformed(evt);
            }
        });

        Sangre.add(Sangre_AB);
        Sangre_AB.setText("AB");
        Sangre_AB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_ABActionPerformed(evt);
            }
        });

        Sangre.add(Sangre_O);
        Sangre_O.setText("O");
        Sangre_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_OActionPerformed(evt);
            }
        });

        Separador_Sangre.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Signo.add(Sangre_Pos);
        Sangre_Pos.setSelected(true);
        Sangre_Pos.setText("+");
        Sangre_Pos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_PosActionPerformed(evt);
            }
        });

        Signo.add(Sangre_Neg);
        Sangre_Neg.setText("-");
        Sangre_Neg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sangre_NegActionPerformed(evt);
            }
        });

        Cantidad.setText("Cantidad:");

        text_Cantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        text_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_CantidadActionPerformed(evt);
            }
        });
        text_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_CantidadKeyTyped(evt);
            }
        });

        Tipo_de_Sangre1.setText("Rh");

        jLabel1.setText("L");

        javax.swing.GroupLayout Panel_DatosLayout = new javax.swing.GroupLayout(Panel_Datos);
        Panel_Datos.setLayout(Panel_DatosLayout);
        Panel_DatosLayout.setHorizontalGroup(
            Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_DatosLayout.createSequentialGroup()
                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(Motivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(Panel_DatosLayout.createSequentialGroup()
                                .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_DatosLayout.createSequentialGroup()
                                        .addComponent(Tipo_de_Sangre)
                                        .addGap(18, 18, 18)
                                        .addComponent(Tipo_de_Sangre1))
                                    .addGroup(Panel_DatosLayout.createSequentialGroup()
                                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Sangre_A)
                                            .addComponent(Sangre_B))
                                        .addGap(18, 18, 18)
                                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Sangre_AB)
                                            .addComponent(Sangre_O))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Separador_Sangre, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Sangre_Pos)
                                            .addComponent(Sangre_Neg))))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(Panel_DatosLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(Cantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_Cantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addContainerGap())
        );
        Panel_DatosLayout.setVerticalGroup(
            Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipo_de_Sangre)
                    .addComponent(Tipo_de_Sangre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_DatosLayout.createSequentialGroup()
                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sangre_A)
                                .addComponent(Sangre_AB))
                            .addComponent(Sangre_Pos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sangre_Neg)
                            .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sangre_O)
                                .addComponent(Sangre_B))))
                    .addComponent(Separador_Sangre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cantidad)
                    .addComponent(text_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34))
        );

        btnRegresar.setText("Cancelar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Panel_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(28, 28, 28)))
                .addComponent(Panel_Solicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Solicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Panel_Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar)
                            .addComponent(btnAgregar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("SOLICITUDES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_CantidadActionPerformed

    private void text_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_CantidadKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_text_CantidadKeyTyped

    private void Sangre_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_AActionPerformed

    private void Sangre_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_BActionPerformed

    private void Sangre_ABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_ABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_ABActionPerformed

    private void Sangre_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_OActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_OActionPerformed

    private void Sangre_PosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_PosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_PosActionPerformed

    private void Sangre_NegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sangre_NegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sangre_NegActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void text_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_NombreKeyTyped
        char c=evt.getKeyChar();
        if((c<'a'||c>'z')&&(c<'A'||c>'Z')) evt.consume();
    }//GEN-LAST:event_text_NombreKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudAnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSolicitudAnt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Motivo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JPanel Panel_Datos;
    private javax.swing.JPanel Panel_Solicitudes;
    public javax.swing.ButtonGroup Sangre;
    public javax.swing.JRadioButton Sangre_A;
    public javax.swing.JRadioButton Sangre_AB;
    public javax.swing.JRadioButton Sangre_B;
    public javax.swing.JRadioButton Sangre_Neg;
    public javax.swing.JRadioButton Sangre_O;
    public javax.swing.JRadioButton Sangre_Pos;
    private javax.swing.JSeparator Separador_Sangre;
    public javax.swing.ButtonGroup Signo;
    private javax.swing.JLabel Tipo_de_Sangre;
    private javax.swing.JLabel Tipo_de_Sangre1;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_Solicitudes;
    public javax.swing.JTextField text_Cantidad;
    public javax.swing.JTextArea text_Motivo;
    public javax.swing.JTextArea text_Nombre;
    // End of variables declaration//GEN-END:variables
}
