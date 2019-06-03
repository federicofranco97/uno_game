package GUI;

import Models.Carta;
import Models.Jugador;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VistaJugador extends javax.swing.JFrame {

    /**
     * Creates new form VistaJugador
     */
    public VistaJugador() {
        initComponents();
        juntarCartas();
        cambiarImagen();
        setLocationRelativeTo(null);
    }
    
    public VistaJugador(Jugador j) {
        initComponents();
        juntarCartas();
        cambiarImagen();
        setLocationRelativeTo(null);
    }

    public ArrayList<JLabel>listaCartas=new ArrayList<>();
    
    public void convertirCarta(Carta c){
        
    }
    
    public void cambiarImagen(){
        String carta="+2azul";
        for (JLabel label : listaCartas) {
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+carta+".png")));
        }
    }

    public ArrayList<JLabel> getListaCartas() {
        return listaCartas; 
    }

    public void setListaCartas(ArrayList<JLabel> listaCartas) {
        this.listaCartas = listaCartas;
    }
    
    
    
    public void juntarCartas(){
        listaCartas.add(carta1);
        listaCartas.add(carta2);
        listaCartas.add(carta3);
        listaCartas.add(carta4);
        listaCartas.add(carta5);
        listaCartas.add(carta6);
        listaCartas.add(carta7);
        listaCartas.add(carta8);
        listaCartas.add(carta9);
        listaCartas.add(carta10);
        listaCartas.add(carta11);
        listaCartas.add(carta12);
        listaCartas.add(carta13);
        listaCartas.add(carta14);
        listaCartas.add(carta15);
        listaCartas.add(carta16);
        listaCartas.add(carta17);
        listaCartas.add(carta18);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta2 = new javax.swing.JLabel();
        carta1 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        carta6 = new javax.swing.JLabel();
        carta7 = new javax.swing.JLabel();
        carta8 = new javax.swing.JLabel();
        carta9 = new javax.swing.JLabel();
        carta10 = new javax.swing.JLabel();
        carta11 = new javax.swing.JLabel();
        carta12 = new javax.swing.JLabel();
        carta13 = new javax.swing.JLabel();
        carta14 = new javax.swing.JLabel();
        carta15 = new javax.swing.JLabel();
        carta16 = new javax.swing.JLabel();
        carta17 = new javax.swing.JLabel();
        carta18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPasar = new javax.swing.JButton();
        btnLevantar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1340, 1024));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 1024));

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N
        carta1.setName("Pepe");

        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        carta18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/color.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Carta del Pozo");

        btnPasar.setText("Pasar Turno");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnLevantar.setText("Levantar Carta");
        btnLevantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLevantarActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar y Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Jugador X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carta13)
                        .addGap(18, 18, 18)
                        .addComponent(carta14)
                        .addGap(18, 18, 18)
                        .addComponent(carta15)
                        .addGap(18, 18, 18)
                        .addComponent(carta16)
                        .addGap(18, 18, 18)
                        .addComponent(carta17)
                        .addGap(18, 18, 18)
                        .addComponent(carta18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carta7)
                        .addGap(18, 18, 18)
                        .addComponent(carta8)
                        .addGap(18, 18, 18)
                        .addComponent(carta9)
                        .addGap(18, 18, 18)
                        .addComponent(carta10)
                        .addGap(18, 18, 18)
                        .addComponent(carta11)
                        .addGap(18, 18, 18)
                        .addComponent(carta12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carta1)
                        .addGap(18, 18, 18)
                        .addComponent(carta2)
                        .addGap(18, 18, 18)
                        .addComponent(carta3)
                        .addGap(18, 18, 18)
                        .addComponent(carta4)
                        .addGap(18, 18, 18)
                        .addComponent(carta5)
                        .addGap(18, 18, 18)
                        .addComponent(carta6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnPasar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1)))
                            .addGap(70, 70, 70))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLevantar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carta7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carta13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta16, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta17, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta18, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLevantar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLevantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevantarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLevantarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPasarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLevantar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta10;
    private javax.swing.JLabel carta11;
    private javax.swing.JLabel carta12;
    private javax.swing.JLabel carta13;
    private javax.swing.JLabel carta14;
    private javax.swing.JLabel carta15;
    private javax.swing.JLabel carta16;
    private javax.swing.JLabel carta17;
    private javax.swing.JLabel carta18;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JLabel carta6;
    private javax.swing.JLabel carta7;
    private javax.swing.JLabel carta8;
    private javax.swing.JLabel carta9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
