package GUI;

import Models.Carta;
import Models.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    
    public VistaJugador(Jugador j,Carta c) {
        initComponents();
        juntarCartas();
        cambiarImagen(j);
        asignarPozo(c);
        asignarNombre(j.getNombre());
        setLocationRelativeTo(null);
    }

    public ArrayList<JLabel>listaCartas=new ArrayList<>();
    public ArrayList<JLabel>cartasLibres=new ArrayList<>();
    public Carta pozo = new Carta();
    
    public void asignarNombre(String nombre){
        lblNombre.setText(nombre);
    }
    
    public void asignarPozo(Carta c){
        String carta=c.getValor()+c.getColor();
        pozo.setColor(c.getColor());
        pozo.setTipo(c.getTipo());
        pozo.setValor(c.getValor());
        cartaPozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+carta+".png")));
        cartaPozo.setName(pozo.getValor()+" "+pozo.getColor()+" "+pozo.getTipo());
    }
    
    public void cambiarImagen(){
        String carta="+2azul";
        for (JLabel label : listaCartas) {
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+carta+".png")));
        }
    }
    
    public boolean validarTiro(String carta){
        String [] cartaPartida=carta.split(" ");
        Carta cartaTirada = new Carta(cartaPartida[1],cartaPartida[2],cartaPartida[0]);
        if(pozo.validarCarta(cartaTirada)){
            JOptionPane.showMessageDialog(null, "Carta Valida!");
            pozo.setColor(cartaTirada.getColor());
            pozo.setValor(cartaTirada.getValor());
            pozo.setTipo(cartaTirada.getTipo());
            String carta2=pozo.getValor()+pozo.getColor();
            cartaPozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+carta2+".png")));
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Carta No Valida!");
            return false;
        }
    }
    
    public void cambiarImagen(Jugador j){
        for (int i = 0; i < j.getManoCartas().size(); i++) {
            String card=j.getManoCartas().get(i).getValor()+j.getManoCartas().get(i).getColor();
            listaCartas.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+card+".png")));
            listaCartas.get(i).setName(j.getManoCartas().get(i).getValor()+" "+j.getManoCartas().get(i).getColor()+" "+j.getManoCartas().get(i).getTipo());
        }    
         
        for (int i = j.getManoCartas().size(); i < listaCartas.size(); i++) {            
            listaCartas.get(i).setIcon(null);
            cartasLibres.add(listaCartas.get(i));
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
        cartaPozo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPasar = new javax.swing.JButton();
        btnLevantar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1340, 1024));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 1024));

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta2MouseClicked(evt);
            }
        });

        carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta1.setName("Pepe");
        carta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta1MouseClicked(evt);
            }
        });

        carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta3MouseClicked(evt);
            }
        });

        carta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta4MouseClicked(evt);
            }
        });

        carta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta5MouseClicked(evt);
            }
        });

        carta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta6MouseClicked(evt);
            }
        });

        carta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta7MouseClicked(evt);
            }
        });

        carta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta8MouseClicked(evt);
            }
        });

        carta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta9MouseClicked(evt);
            }
        });

        carta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta10MouseClicked(evt);
            }
        });

        carta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta11MouseClicked(evt);
            }
        });

        carta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta12MouseClicked(evt);
            }
        });

        carta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta13MouseClicked(evt);
            }
        });

        carta14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta14MouseClicked(evt);
            }
        });

        carta15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta15MouseClicked(evt);
            }
        });

        carta16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta16MouseClicked(evt);
            }
        });

        carta17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta17MouseClicked(evt);
            }
        });

        carta18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/+4joker.png"))); // NOI18N
        carta18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta18MouseClicked(evt);
            }
        });

        cartaPozo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/color.png"))); // NOI18N

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

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNombre.setText("Jugador X");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Jugador");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cartaPozo)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLevantar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartaPozo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLevantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevantarActionPerformed
        if(cartasLibres.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cupo Maximo de cartas en mano!");
            return;
        }
        //Asigna una carta al, primer slot libre que haya
        String carta="+2rojo";
        cartasLibres.get(0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Resources/recartas/"+carta+".png")));
        cartasLibres.get(0).setName("+2 rojo especial");
        cartasLibres.remove(0);
    }//GEN-LAST:event_btnLevantarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        JOptionPane.showMessageDialog(null, "Turno Cedido!");
    }//GEN-LAST:event_btnPasarActionPerformed

    private void carta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1MouseClicked
        if(validarTiro(carta1.getName())){
            carta1.setName("");
            carta1.setIcon(null);
            cartasLibres.add(carta1);
        }
    }//GEN-LAST:event_carta1MouseClicked

    private void carta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2MouseClicked
       if(validarTiro(carta2.getName())){
            carta2.setName("");
            carta2.setIcon(null);
            cartasLibres.add(carta2);
        }
    }//GEN-LAST:event_carta2MouseClicked

    private void carta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3MouseClicked
        if(validarTiro(carta3.getName())){
            carta3.setName("");
            carta3.setIcon(null);
            cartasLibres.add(carta3);
        }
    }//GEN-LAST:event_carta3MouseClicked

    private void carta4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta4MouseClicked
        if(validarTiro(carta4.getName())){
            carta4.setName("");
            carta4.setIcon(null);
            cartasLibres.add(carta4);
        }
    }//GEN-LAST:event_carta4MouseClicked

    private void carta5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta5MouseClicked
       if(validarTiro(carta5.getName())){
            carta5.setName("");
            carta5.setIcon(null);
            cartasLibres.add(carta5);
        }
    }//GEN-LAST:event_carta5MouseClicked

    private void carta6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta6MouseClicked
        if(validarTiro(carta6.getName())){
            carta6.setName("");
            carta6.setIcon(null);
            cartasLibres.add(carta6);
        }
    }//GEN-LAST:event_carta6MouseClicked

    private void carta7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta7MouseClicked
        if(validarTiro(carta7.getName())){
            carta7.setName("");
            carta7.setIcon(null);
            cartasLibres.add(carta7);
        }
    }//GEN-LAST:event_carta7MouseClicked

    private void carta8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta8MouseClicked
        if(validarTiro(carta8.getName())){
            carta8.setName("");
            carta8.setIcon(null);
            cartasLibres.add(carta8);
        }
    }//GEN-LAST:event_carta8MouseClicked

    private void carta9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta9MouseClicked
       if(validarTiro(carta9.getName())){
            carta9.setName("");
            carta9.setIcon(null);
            cartasLibres.add(carta9);
        }
    }//GEN-LAST:event_carta9MouseClicked

    private void carta10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta10MouseClicked
        if(validarTiro(carta10.getName())){
            carta10.setName("");
            carta10.setIcon(null);
            cartasLibres.add(carta10);
        }
    }//GEN-LAST:event_carta10MouseClicked

    private void carta11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta11MouseClicked
        if(validarTiro(carta11.getName())){
            carta11.setName("");
            carta11.setIcon(null);
            cartasLibres.add(carta11);
        }
    }//GEN-LAST:event_carta11MouseClicked

    private void carta12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta12MouseClicked
        if(validarTiro(carta12.getName())){
            carta12.setName("");
            carta12.setIcon(null);
            cartasLibres.add(carta12);
        }
    }//GEN-LAST:event_carta12MouseClicked

    private void carta13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta13MouseClicked
       if(validarTiro(carta13.getName())){
            carta13.setName("");
            carta13.setIcon(null);
            cartasLibres.add(carta13);
        }
    }//GEN-LAST:event_carta13MouseClicked

    private void carta14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta14MouseClicked
        if(validarTiro(carta14.getName())){
            carta14.setName("");
            carta14.setIcon(null);
            cartasLibres.add(carta14);
        }
    }//GEN-LAST:event_carta14MouseClicked

    private void carta15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta15MouseClicked
        if(validarTiro(carta15.getName())){
            carta15.setName("");
            carta15.setIcon(null);
            cartasLibres.add(carta15);
        }
    }//GEN-LAST:event_carta15MouseClicked

    private void carta16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta16MouseClicked
        if(validarTiro(carta16.getName())){
            carta16.setName("");
            carta16.setIcon(null);
            cartasLibres.add(carta16);
        }
    }//GEN-LAST:event_carta16MouseClicked

    private void carta17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta17MouseClicked
        if(validarTiro(carta17.getName())){
            carta17.setName("");
            carta17.setIcon(null);
            cartasLibres.add(carta17);
        }
    }//GEN-LAST:event_carta17MouseClicked

    private void carta18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta18MouseClicked
        if(validarTiro(carta18.getName())){
            carta18.setName("");
            carta18.setIcon(null);
            cartasLibres.add(carta18);
        }
    }//GEN-LAST:event_carta18MouseClicked

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
                Jugador jugador = new Jugador("Player 1");
                Carta carta = new Carta("rojo", "numero", "3");
                Carta carta2 = new Carta("azul", "numero", "9");
                Carta carta3 = new Carta("verde", "numero", "2");
                Carta carta4 = new Carta("verde", "especial", "+2");
                Carta carta5 = new Carta("joker", "especial", "+4");
                Carta carta6 = new Carta("rojo", "numero", "9");
                jugador.agregarCartas(Arrays.asList(carta,carta2,carta3,carta4,carta5));
                new VistaJugador(jugador,carta6).setVisible(true);
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
    private javax.swing.JLabel cartaPozo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
