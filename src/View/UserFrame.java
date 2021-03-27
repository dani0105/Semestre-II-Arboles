/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Class.Singleton;
import Enums.Licenses;
import HashTable.User;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielR
 */
public class UserFrame extends javax.swing.JDialog {

    private Singleton singleton = Singleton.getInstance();
    private DefaultListModel listModel = new DefaultListModel();

    public UserFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboLicenses();
        print();
    }

    /**
     * Refresh table with all users inserted.
     */
    private void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) this.tableUsers.getModel();
        model.setRowCount(0);
        this.singleton.getUsers().getModel(  model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ComboAddLicense = new javax.swing.JComboBox<>();
        IDSPIN = new javax.swing.JSpinner();
        nameTXT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboDeleteUser = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboModUser = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboModLicenses = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel1.setText("Ingrese su nombre:");

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel2.setText("Ingrese su cedula:");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel3.setText("Seleccione el tipo de licencia:");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IDSPIN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTXT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboAddLicense, javax.swing.GroupLayout.Alignment.TRAILING, 0, 182, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(216, 216, 216))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboAddLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDSPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Agregar usuario", jPanel1);

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel4.setText("Seleccione al usuario:");

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUser(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(comboDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(comboDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar usuario", jPanel2);

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel5.setText("Seleccione al usuario:");

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel6.setText("Seleccione la licencia:");

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyUser(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboModUser, 0, 311, Short.MAX_VALUE)
                            .addComponent(comboModLicenses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboModUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboModLicenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton3)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar usuario", jPanel3);

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Licencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableUsers);
        if (tableUsers.getColumnModel().getColumnCount() > 0) {
            tableUsers.getColumnModel().getColumn(0).setResizable(false);
            tableUsers.getColumnModel().getColumn(1).setResizable(false);
            tableUsers.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Ver usuarios", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (nameTXT.getText().isEmpty() || (Integer) IDSPIN.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "no ha ingreado el nombre, el id solo puede ser mayor a 0");
        } else {
            User user = null;
            switch (ComboAddLicense.getSelectedItem().toString()) {
                case ("B1"):
                    user = new User((Integer) IDSPIN.getValue(), nameTXT.getText(), Licenses.B1);
                    if (singleton.getUsers().put(user)) {
                        print();
                        JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este id ya se encuentra en el sistema");
                    }
                    break;
                case ("B2"):
                    user = new User((Integer) IDSPIN.getValue(), nameTXT.getText(), Licenses.B2);
                    if (singleton.getUsers().put(user)) {
                        print();
                        JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este id ya se encuentra en el sistema");
                    }
                    break;
                case ("B4"):
                    user = new User((Integer) IDSPIN.getValue(), nameTXT.getText(), Licenses.B3);
                    if (singleton.getUsers().put(user)) {
                        print();
                        JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este id ya se encuentra en el sistema");
                    }
                    break;
                default:
                    user = new User((Integer) IDSPIN.getValue(), nameTXT.getText(), Licenses.B4);
                    if (singleton.getUsers().put(user)) {
                        print();
                        JOptionPane.showMessageDialog(null, "Usuario ingresado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este id ya se encuentra en el sistema");
                    }
                    break;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeUser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUser
      
        String[] array = comboDeleteUser.getSelectedItem().toString().split(" ");
        String name = array[8];
        name = name.replace(",", "");
        if(this.singleton.getUsers().remove(Integer.parseInt(name))){
            JOptionPane.showMessageDialog(this, "Eliminado");
            this.dispose();
        }else
            JOptionPane.showMessageDialog(this, "Error");
    }//GEN-LAST:event_removeUser

    private void modifyUser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyUser
        String[] array = comboModUser.getSelectedItem().toString().split(" ");
        String name = array[8];
        name = name.replace(",", "");
        User user =  this.singleton.getUsers().get(Integer.parseInt(name));
        System.out.println(user.getName());
        switch(comboModLicenses.getSelectedItem().toString()){
            case "B1":
                user.setLicense(Licenses.B1);
                break;
             case "B2":
                user.setLicense(Licenses.B2);
                break;
             case "B3":
                 user.setLicense(Licenses.B3);
                break;
             case "B4":
                user.setLicense(Licenses.B4);
                break;
             default:
                 System.out.println("No match");
        } 
        JOptionPane.showMessageDialog(this, "Guardado");
        this.dispose();
       
    }//GEN-LAST:event_modifyUser

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAddLicense;
    private javax.swing.JSpinner IDSPIN;
    private javax.swing.JComboBox<String> comboDeleteUser;
    private javax.swing.JComboBox<String> comboModLicenses;
    private javax.swing.JComboBox<String> comboModUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JTable tableUsers;
    // End of variables declaration//GEN-END:variables
    private void loadComboLicenses() {
        ComboAddLicense.removeAllItems();
        comboModLicenses.removeAllItems();
        comboDeleteUser.removeAllItems();
        comboModUser.removeAllItems();
        singleton.getUsers().addComboLicenses(ComboAddLicense);
        singleton.getUsers().addComboLicenses(comboModLicenses);
        singleton.getUsers().loadComboBox(comboModUser);
        singleton.getUsers().loadComboBox(comboDeleteUser);
    }
    private void print() {
        /*
        listModel.clear();
        singleton.getUsers().print(listModel);
        jList1.setModel(listModel);
                */
         singleton.getUsers().getModel((DefaultTableModel) tableUsers.getModel());
       
    }
}
