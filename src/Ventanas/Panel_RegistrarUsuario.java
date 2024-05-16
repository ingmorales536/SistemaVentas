/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import Implementaciones.UsuariosImpl;
import Modelo.ModeloUsuarios;
import interfaces.InterfaceUsuarios;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class Panel_RegistrarUsuario extends javax.swing.JPanel {
boolean isEdition = false;
ModeloUsuarios userEdition;
   
    public Panel_RegistrarUsuario() {
        initComponents();
        setSize(963, 580);
        GuardarUsuario();
    }
    
    public Panel_RegistrarUsuario(ModeloUsuarios usuario){
        initComponents();
        GuardarUsuario();
        isEdition = true;
        userEdition = usuario;
        InitStyles();
    
    }//Fin del 2 constructor
    
    //Para modificar usuario
     private void InitStyles() {
        if (isEdition) {
            LabelTitulo.setText("Editar Usuario");
            BotonRegistrar.setText("Guardar");

            if (userEdition != null) {
                txtNombre.setText(userEdition.getNombre());
                txtUsuario.setText(userEdition.getUsuario());
                txtPassword.setText(userEdition.getPassword());  
                BoxPermiso.setSelectedItem(userEdition.getPermiso());
            }//Fin del 2 if
            
        }//Fin del 1 if
        
    }//Fin del metodo InitStyles
    

    
   private void GuardarUsuario(){
       
   BotonRegistrar.addActionListener(new ActionListener() {
       
       @Override
       public void actionPerformed(ActionEvent e) {
        String Nombre = txtNombre.getText().trim();
        String Usuario = txtUsuario.getText().trim();
        String Password1 = txtPassword.getText().trim();
        String permiso = (String) BoxPermiso.getSelectedItem();
        
         if(Nombre.isEmpty() && Usuario.isEmpty() && Password1.isEmpty() ){
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos","Error-Ingresar Cliente",0);
    
             }else{
                ModeloUsuarios usuario1 = isEdition ? userEdition : new ModeloUsuarios(); 
                usuario1.setNombre(Nombre);
                usuario1.setUsuario(Usuario);
                usuario1.setPassword(Password1);
                usuario1.setPermiso(permiso);
                try{
                 InterfaceUsuarios dao = new UsuariosImpl();
                if(!isEdition){
                     dao.Registrar(usuario1);  
                    JOptionPane.showMessageDialog(null, "<html><body><h3 style='color:green;'>Registro Exitoso</h3>" + "<p>El registro se ha completado exitosamente.</p></body></html>","Éxito",
                            JOptionPane.INFORMATION_MESSAGE);   
                    Limpiar();
                }else{  
                    dao.Modificar(usuario1);
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
            MenuPrincipal.ShowJPanel(new Panel_Usuarios());
       }
    });
   
   }
    
private void Limpiar(){
txtNombre.setText("");
txtUsuario.setText("");
txtPassword.setText("");
}
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        BoxPermiso = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        BotonRegistrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        BotonRegresar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        LabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setText("Registrar Usuario");

        txtPassword.setBackground(new java.awt.Color(35, 35, 35));
        txtPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRASEÑA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNombre.setBackground(new java.awt.Color(35, 35, 35));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtUsuario.setBackground(new java.awt.Color(35, 35, 35));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        BoxPermiso.setBackground(new java.awt.Color(35, 35, 35));
        BoxPermiso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BoxPermiso.setForeground(new java.awt.Color(255, 255, 255));
        BoxPermiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        BoxPermiso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jSeparator1.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        BotonRegistrar.setBackground(new java.awt.Color(102, 0, 102));
        BotonRegistrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrar.setText("Registrar");
        BotonRegistrar.setBorder(null);

        jSeparator2.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 35));

        BotonRegresar.setBackground(new java.awt.Color(35, 35, 35));
        BotonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        BotonRegresar.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(BotonRegresar)
                .addGap(14, 14, 14)
                .addComponent(LabelTitulo))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(txtPassword)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario)
                            .addComponent(BoxPermiso, 0, 257, Short.MAX_VALUE))))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(238, 238, 238))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonRegresar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(LabelTitulo)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(BoxPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JComboBox<String> BoxPermiso;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
