/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import Implementaciones.ProveedoresImpl;
import Modelo.ModeloProveedores;
import interfaces.InterfaceProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class Panel_NuevoProveedor extends javax.swing.JPanel {
    
boolean isEdition = false;
ModeloProveedores userEdition;
 
    /**
     * Creates new form Panel_NuevoProveedor
     */
    public Panel_NuevoProveedor() {
        initComponents();
        GuardarProveedor();
    }
    
        public Panel_NuevoProveedor(ModeloProveedores proveedor){
        initComponents();
        GuardarProveedor();
        isEdition = true;
        userEdition = proveedor;
        InitStyles();
    
    }//Fin del 2 constructor
        
        
        
        private void InitStyles() {
        
        if (isEdition) {
            LabelTitulo.setText("Editar Proveedor");
            BotonRegistrar.setText("Guardar");

            if (userEdition != null) {
                txtNombre.setText(userEdition.getNombre());        
                txtDireccion.setText(userEdition.getDireccion());
                txtTelefono.setText(userEdition.getTelefono());
            }
        }
    }//Fin del metodo estilos
    
     private void GuardarProveedor(){
      
        BotonRegistrar.addActionListener(new ActionListener() {  
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = txtNombre.getText();
                String Telefono = txtTelefono.getText();
                String Direccion= txtDireccion.getText();
             
             
             if(Nombre.isEmpty() && Telefono.isEmpty() && Direccion.isEmpty() ){
                 JOptionPane.showMessageDialog(null, "Ingrese todos los datos","Error-Ingresar Cliente",0);
                 
                 
             }else{
                ModeloProveedores proveedor1 = isEdition ? userEdition : new ModeloProveedores(); 
                proveedor1.setNombre(Nombre);
                proveedor1.setDireccion(Direccion);
                 proveedor1.setTelefono(Telefono);
                try{
                 InterfaceProveedores dao = new ProveedoresImpl();
                if(!isEdition){
                     dao.Registrar(proveedor1);   
                }else{  
                    dao.Modificar(proveedor1);
                }
                if(!isEdition){
                     Limpiar();
                }
            
                    }catch(Exception a){
                        System.out.println(a);
                }//Fin del catch
               
             }
              
            }
        });
        
        BotonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.ShowJPanel(new Panel_Proveedores());
            }
        });
    
    }//Fin del metodo registrar cliente
    
    
        
    private void Limpiar(){
                 txtNombre.setText("");
                 txtTelefono.setText("");
                 txtDireccion.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        BotonRegresar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        LabelTitulo.setBackground(new java.awt.Color(255, 0, 0));
        LabelTitulo.setFont(new java.awt.Font("Bahnschrift", 0, 26)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setText("Registrar Proveedor");

        BotonRegistrar.setBackground(new java.awt.Color(102, 0, 102));
        BotonRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrar.setText("Registrar");
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(35, 35, 35));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        txtNombre.setMaximumSize(new java.awt.Dimension(200, 60));
        txtNombre.setMinimumSize(new java.awt.Dimension(200, 55));
        txtNombre.setPreferredSize(new java.awt.Dimension(200, 55));
        txtNombre.setVerifyInputWhenFocusTarget(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDireccion.setBackground(new java.awt.Color(35, 35, 35));
        txtDireccion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIRECCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        txtDireccion.setMaximumSize(new java.awt.Dimension(200, 60));
        txtDireccion.setMinimumSize(new java.awt.Dimension(200, 55));
        txtDireccion.setPreferredSize(new java.awt.Dimension(200, 55));
        txtDireccion.setVerifyInputWhenFocusTarget(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelefono.setBackground(new java.awt.Color(35, 35, 35));
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TELEFONO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        txtTelefono.setMaximumSize(new java.awt.Dimension(200, 60));
        txtTelefono.setMinimumSize(new java.awt.Dimension(200, 55));
        txtTelefono.setPreferredSize(new java.awt.Dimension(200, 55));
        txtTelefono.setVerifyInputWhenFocusTarget(false);

        BotonRegresar.setBackground(new java.awt.Color(35, 35, 35));
        BotonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        BotonRegresar.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BotonRegresar)
                .addGap(10, 10, 10)
                .addComponent(LabelTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(330, 330, 330))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonRegresar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(LabelTitulo)))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(263, 263, 263))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed

    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
