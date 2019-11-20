/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Class.CanvasController;
import Class.Singleton;
import Dialog.ArcDialog;
import Grafo.Vertex;
import Tree.Node;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author DanielR
 */
public class Main extends javax.swing.JFrame {

    private CanvasController canvas;
    
    private Singleton singleton;
    
    public Main() {
        initComponents();
        
        int height = this.canvasContainer.getHeight();
        int width = this.canvasContainer.getWidth();
        this.canvas = new CanvasController(width, height);
        this.singleton= Singleton.getInstance();
        this.canvas.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                canvas.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                canvas.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                canvas.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                canvas.mouseExited(e);
            }

        });
        this.canvasContainer.add(this.canvas);
        
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        btnAddCity = new javax.swing.JButton();
        btnAddPath = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        canvasContainer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddCity.setText("Agregar Ciudad");
        btnAddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVertex(evt);
            }
        });

        btnAddPath.setText("Agregar Camino");
        btnAddPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArc(evt);
            }
        });

        btnAddUser.setText("Usuarios");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnAddOrder.setText("Pedidos");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout canvasContainerLayout = new javax.swing.GroupLayout(canvasContainer);
        canvasContainer.setLayout(canvasContainerLayout);
        canvasContainerLayout.setHorizontalGroup(
            canvasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        canvasContainerLayout.setVerticalGroup(
            canvasContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jButton1.setText("Ajustes Rutas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendOrder(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddOrder)
                .addGap(12, 12, 12))
            .addComponent(canvasContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvasContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCity)
                    .addComponent(btnAddPath)
                    .addComponent(btnAddUser)
                    .addComponent(btnAddOrder)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addVertex(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVertex
        String name = JOptionPane.showInputDialog("Nombre de la ciudad");
        this.canvas.setTempName(name);
        
        
    }//GEN-LAST:event_addVertex

    private void addArc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArc
        ArcDialog dialog = new ArcDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_addArc

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        OrderFrame OF = new OrderFrame(null, true);
        OF.setVisible(true);
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SettingsGraph SG = new SettingsGraph();
        SG.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        UserFrame UF = new UserFrame(null, true);
        UF.setVisible(true);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void SendOrder(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendOrder
        Node aux = this.singleton.getTreeMethods().root;
        
        String prueba = "Santa Clara,Florencia,Ciudad Quesada,Aguas Zarcas";
        if(aux == null){
            JOptionPane.showMessageDialog(this, "No hay pedidos");
        }
            this.singleton.getGraphMethods().shortRouteByDistance(aux.getSender(), aux.getReceiver(), "",0.0f);
        System.out.println(this.singleton.getGraphMethods().routC);
            /*
        String ruta[] = prueba.split(",");
        
        for(int i = 0; i< ruta.length-1 ; ++i){
           Vertex current = this.singleton.getGraphMethods().search(ruta[i]);
            
           System.out.println("\nCurrent: "+current.getName());
           Vertex next = this.singleton.getGraphMethods().search(ruta[i+1]);
              System.out.println("Next: "+next.getName());
           /*
           if(current == null || next == null){
               continue;
           }
              
           this.canvas.drawOrder(current, next,1.3F);
        }
            */
    }//GEN-LAST:event_SendOrder

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCity;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnAddPath;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JPanel canvasContainer;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
