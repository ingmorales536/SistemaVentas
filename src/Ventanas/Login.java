package Ventanas;

//Importaciones
import VentanasEmpleados.MenuPrincipalEmpleado;
import Ventanas.MenuPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import ConexionDB.Conexion;



public class Login extends javax.swing.JFrame{
    
    

Conexion con = new Conexion();

//usuario y contraseña ingresadas
static String usuarioIngresado = "";
String contrasenaIngresada = "";
public int Cont = 0;
public static String user = "";
  
    public Login() {
        setUndecorated(true);
        initComponents();
        DiseñoVentana();
        CerrarVentana();
        IniciarLogin();
        BotonInicio();
    }//fin del constructor
    
    @Override
    public Image getIconImage(){
    Toolkit miPantalla = Toolkit.getDefaultToolkit();
    Image miIcono = miPantalla.getImage("src/Img/icon.jpg");
    setIconImage(miIcono);
    return miIcono ;
    }
    
    
    //Iniciar secion con el boton Enter
    public void IniciarLogin(){
    
        password_usuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
              
                // Verificar si se presionó la tecla "Enter" (código 10 para Enter)
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if(password_usuario == null || Text_usuario == null){
                         JOptionPane.showMessageDialog(null, "Ingresa todos los datos","Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                            BotonIniciar();
                        }//Fin del 2do if    
                        
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
    
        Text_usuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
           
               // Verificar si se presionó la tecla "Enter" (código 10 para Enter)
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if(password_usuario == null || Text_usuario == null){
                         JOptionPane.showMessageDialog(null, "Ingresa todos los datos","Error",JOptionPane.ERROR_MESSAGE);
                        }else{
                            BotonIniciar();
                        }//Fin del 2do if    
                        
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }//fin de catch
                    
                }//fin del primer if
                
            }//fin del metodo keypressed
        });
    
    }//Fin del metodo IniciarLogin
    
    private void DiseñoVentana(){
       
        //diseñar la ventana con sus caracteristicas
        setSize(842, 542);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        //poner la imagen de fondo
        ImageIcon Wallpaper = new ImageIcon("src/Img/wallpaperPrincipal.png");
        Icon icono = new ImageIcon(Wallpaper.getImage().getScaledInstance(Label_wallpaper.getWidth(),Label_wallpaper.getHeight(),Image.SCALE_DEFAULT));   
        Label_wallpaper.setIcon(icono);
        this.repaint();
        
        
        //agregar imagen al logo
        ImageIcon wallpaper_logo = new ImageIcon("src/Img/logo.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(label_logo.getWidth(), label_logo.getHeight(), Image.SCALE_DEFAULT));
        label_logo.setIcon(icono_logo);
        this.repaint();
        
         BotonCerrar.setBorderPainted(false); // Ocultar el borde del botón
         BotonCerrar.setFocusPainted(false); // Evitar que se pinte el borde al tener el foco
         BotonCerrar.setContentAreaFilled(false);
    }//Fin del metodo DiseñoVentana
    
    
    
    private void CerrarVentana(){
        BotonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
    
    }
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Text_usuario = new javax.swing.JTextField();
        password_usuario = new javax.swing.JPasswordField();
        Boton_Acceder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BotonCerrar = new javax.swing.JButton();
        Label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_logo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                label_logoPropertyChange(evt);
            }
        });
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 260, 240));

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Text_usuario.setBackground(new java.awt.Color(35, 35, 35));
        Text_usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Text_usuario.setForeground(new java.awt.Color(255, 255, 255));
        Text_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Text_usuario.setBorder(null);
        jPanel1.add(Text_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 190, 40));

        password_usuario.setBackground(new java.awt.Color(35, 35, 35));
        password_usuario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        password_usuario.setForeground(new java.awt.Color(255, 255, 255));
        password_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password_usuario.setBorder(null);
        jPanel1.add(password_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 190, 40));

        Boton_Acceder.setBackground(new java.awt.Color(127, 20, 154));
        Boton_Acceder.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Boton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        Boton_Acceder.setText("ACCEDER");
        Boton_Acceder.setBorder(null);
        Boton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AccederActionPerformed(evt);
            }
        });
        jPanel1.add(Boton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 130, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio de sesion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Contraseña-InicioSesion.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 50, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 190, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuario-InicioSesion.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 50, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 190, -1));

        BotonCerrar.setBackground(new java.awt.Color(35, 35, 35));
        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonCerrar.setBorder(null);
        jPanel1.add(BotonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 440, 550));
        getContentPane().add(Label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_logoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_label_logoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_label_logoPropertyChange



    
    private void Boton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AccederActionPerformed

        
    }//GEN-LAST:event_Boton_AccederActionPerformed

    
    
private void BotonInicio(){
    Boton_Acceder.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BotonIniciar();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    });

}    
    
public void BotonIniciar() throws SQLException{

        usuarioIngresado = Text_usuario.getText().trim();
        contrasenaIngresada = password_usuario.getText().trim();
        
         if(usuarioIngresado.isEmpty() || contrasenaIngresada.isEmpty() ){
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos","ERROR",0);
         }else{
          
          try{
             Connection conn = con.Conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT permiso FROM usuarios WHERE usuario = '"+usuarioIngresado+"' AND contrasena = '"+contrasenaIngresada+"'");
          
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String permiso1 = result.getString("permiso");
                
                if(permiso1.equalsIgnoreCase("Administrador")){             
                      abrirVentanaProgreso();
                      Cont=1;
                }else if(permiso1.equalsIgnoreCase("Empleado")){
                      abrirVentanaProgreso();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta","ERROR",0);
                }//Fin del else 
                
            }//Fin del while result
          stmt.close();
          con.CerrarConexion();
        } catch (SQLException err) {
            System.err.println("Error al verificar usuario: " + err.getMessage());
        
        }
          
         
         }

}//Fin del metodo BotonIniciar
    

    
     private void abrirVentanaProgreso() {
        VentanaProgreso ventanaProgreso = new VentanaProgreso();
        ventanaProgreso.setVisible(true);
        // Cerrar la ventana actual de inicio de sesión
        dispose();
    }//fin del metodo abrirVentanaProgreso
     
     //barra de carga
    class VentanaProgreso extends JFrame {   
    private JProgressBar progressBar;
    
    public VentanaProgreso() {
        super("Barra de Carga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 50);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        // Crear la barra de progreso
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true); // Mostrar el porcentaje de carga

        // Cambiar el color de la barra de progreso (en este caso, rojo)
        UIManager.put("ProgressBar.foreground", Color.RED);
        UIManager.put("ProgressBar.selectionForeground", Color.WHITE);
        UIManager.put("ProgressBar.selectionBackground", Color.RED);

        add(progressBar, BorderLayout.CENTER);

        // Crear un temporizador para simular la carga
        Timer timer = new Timer(15, new ActionListener() {
            int progreso = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progreso++;
                progressBar.setValue(progreso);

                if (progreso == 100) {
                    
                    if(Cont==1){
                     
                    abrirVentanaAdmin();
                    
                    dispose();
                    }else{
                    AbrirVentanaEmpleado();
                     dispose();
                    }
                   
                }//Fin del if progreso terminado
            }
        });//Fin de crear temporizador
        
        timer.start(); // Iniciar el temporizador
        setVisible(true);
    }
}//Fin de Ventana progreso

    
private void abrirVentanaAdmin() {
        new MenuPrincipal().setVisible(true);
    }//metodoAbrir VentanaPrincipal
    
private void AbrirVentanaEmpleado(){
    new MenuPrincipalEmpleado().setVisible(true);
}
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    public javax.swing.JButton Boton_Acceder;
    private javax.swing.JLabel Label_wallpaper;
    private javax.swing.JTextField Text_usuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_logo;
    private javax.swing.JPasswordField password_usuario;
    // End of variables declaration//GEN-END:variables
}
