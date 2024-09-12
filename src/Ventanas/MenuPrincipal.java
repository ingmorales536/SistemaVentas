package Ventanas;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 




public class MenuPrincipal extends javax.swing.JFrame {


    
    public MenuPrincipal() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        InicializarBienvenida();
        Fecha();
        AccionBotonesMenu();
        BotonSoporte.setBorderPainted(false); // Ocultar el borde del botón
        BotonSoporte.setFocusPainted(false); // Evitar que se pinte el borde al tener el foco
        BotonSoporte.setContentAreaFilled(false);
        ObtenerUsuario();
    }//fin del constructor
    
    private void ObtenerUsuario(){
        Login user = new Login();
        String Usuario = user.usuario;
        LabelUser.setText("Sesion de  "+Usuario);
    }
    
    @Override
    public Image getIconImage(){
    Toolkit miPantalla = Toolkit.getDefaultToolkit();
    Image miIcono = miPantalla.getImage("src/Img/icon.jpg");
    setIconImage(miIcono);
    return miIcono ;
    }
    

    public static void ShowJPanel(JPanel p) {
        p.setSize(750, 430);
        p.setLocation(0,0);
        
        Panel_Ventanas.removeAll();
        Panel_Ventanas.add(p, BorderLayout.CENTER);
        Panel_Ventanas.revalidate();
        Panel_Ventanas.repaint();
    }//Fin del metodo PanelClientes - "Boton Nuevo Cliente - NuevoUsuario"
    
    
    
    //Metodo de accion de botones
    private void AccionBotonesMenu(){
        
        
        BotonNuevaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Panel_NuevaVenta Ventana1;
                try {
                    Ventana1 = new Panel_NuevaVenta();
                    Ventana1.setSize(963, 580);
                    Ventana1.setLocation(0, 0);

                    Panel_Ventanas.removeAll();
                    Panel_Ventanas.add(Ventana1,BorderLayout.CENTER);
                    Panel_Ventanas.revalidate();
                    Panel_Ventanas.repaint();
                } catch (SQLException ex) {    
                    System.out.println("Error en mostrar nueva venta: " + ex);
                }
               
                
             }
        });  //Fin Accion boton Nueva Venta
        
        BotonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_Clientes Ventana2 = new Panel_Clientes();
                Ventana2.setSize(963, 580);
                Ventana2.setLocation(0, 0);

                Panel_Ventanas.removeAll();
                Panel_Ventanas.add(Ventana2,BorderLayout.CENTER);
                Panel_Ventanas.revalidate();
                Panel_Ventanas.repaint();
            }
        });//Fin Accion boton cliente
        
        
        BotonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Panel_Proveedores Ventana3 = new Panel_Proveedores();
                Ventana3.setSize(963, 580);
                Ventana3.setLocation(0, 0);

                Panel_Ventanas.removeAll();
                Panel_Ventanas.add(Ventana3,BorderLayout.CENTER);
                Panel_Ventanas.revalidate();
                Panel_Ventanas.repaint();
            }
        });//Fin Accion Boton Proveedores
        
        
        BotonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_Productos Ventana4 = new Panel_Productos();
                Ventana4.setSize(1062, 813);
                Ventana4.setLocation(0, 0);

                Panel_Ventanas.removeAll();
                Panel_Ventanas.add(Ventana4,BorderLayout.CENTER);
                Panel_Ventanas.revalidate();
                Panel_Ventanas.repaint();
            }
        });//Fin del boton Productos
        BotonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_Usuarios Ventana2 = new Panel_Usuarios();
                Ventana2.setSize(963, 580);
                Ventana2.setLocation(0, 0);

                Panel_Ventanas.removeAll();
                Panel_Ventanas.add(Ventana2,BorderLayout.CENTER);
                Panel_Ventanas.revalidate();
                Panel_Ventanas.repaint();
            }
        });
        
        BotonCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_Compras Ventana2;
                try {
                    Ventana2 = new Panel_Compras();
                    Ventana2.setSize(963, 580);
                    Ventana2.setLocation(0, 0);

                    Panel_Ventanas.removeAll();
                    Panel_Ventanas.add(Ventana2,BorderLayout.CENTER);
                    Panel_Ventanas.revalidate();
                    Panel_Ventanas.repaint();
                    
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
             
            }
        });
 
        BotonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               Login  inicio = new Login();
               inicio.setVisible(true);
            }
        });//Fin Accion Boton CerrarSesion
        
        
        BotonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });//Fin Accion boton Salir
             
        BotonSoporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chatbot bot = new Chatbot();
                bot.setVisible(true);
            }
        });
        
        Boton_registroVentas.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           MenuPrincipal.ShowJPanel(new Panel_VentasDelDia());
            }
        });
        
    }//Fin del metodo Accion de botones
    
    //Metodo mostrar un panel dentro de otro panel
    private void InicializarBienvenida(){
        Bienvenida Ventana5 = new Bienvenida();
        Ventana5.setSize(963, 580);
        Ventana5.setLocation(0, 0);
        
        Panel_Ventanas.removeAll();
        Panel_Ventanas.add(Ventana5,BorderLayout.CENTER);
        Panel_Ventanas.revalidate();
        Panel_Ventanas.repaint();
    }//Fin del metodo InicializarNuevaVentana
    
    //Metodo obtener fecha
    private void Fecha(){
        LocalDate now = LocalDate.now();   
        int dia = now.getDayOfMonth();
        int year = now.getYear();
        int month = now.getMonthValue();
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        Label_Fecha.setText(dia+" / " + meses[month - 1]+"/"+ year);
    }//Fin del metodo Fecha
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        Panel_Menu = new javax.swing.JPanel();
        BotonNuevaVenta = new javax.swing.JButton();
        BotonClientes = new javax.swing.JButton();
        BotonProveedores = new javax.swing.JButton();
        BotonCompras = new javax.swing.JButton();
        BotonProductos = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        BotonCerrarSesion = new javax.swing.JButton();
        BotonUsuarios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        Panel_Fecha = new javax.swing.JPanel();
        Boton_registroVentas = new javax.swing.JButton();
        LabelUser = new javax.swing.JLabel();
        Label_Fecha = new javax.swing.JLabel();
        BotonSoporte = new javax.swing.JButton();
        Panel_Ventanas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1213, 821));

        Panel_Background.setBackground(new java.awt.Color(35, 35, 35));
        Panel_Background.setMinimumSize(new java.awt.Dimension(1213, 820));

        Panel_Menu.setBackground(new java.awt.Color(27, 27, 27));

        BotonNuevaVenta.setBackground(new java.awt.Color(27, 27, 27));
        BotonNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        BotonNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/NuevaVenta.png"))); // NOI18N
        BotonNuevaVenta.setText("  Nueva Venta");
        BotonNuevaVenta.setBorder(null);
        BotonNuevaVenta.setMaximumSize(new java.awt.Dimension(133, 40));

        BotonClientes.setBackground(new java.awt.Color(27, 27, 27));
        BotonClientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonClientes.setForeground(new java.awt.Color(255, 255, 255));
        BotonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        BotonClientes.setText("       Clientes");
        BotonClientes.setBorder(null);
        BotonClientes.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonClientes.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonClientes.setPreferredSize(new java.awt.Dimension(133, 38));

        BotonProveedores.setBackground(new java.awt.Color(27, 27, 27));
        BotonProveedores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonProveedores.setForeground(new java.awt.Color(255, 255, 255));
        BotonProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Proveedores.png"))); // NOI18N
        BotonProveedores.setText("   Proveedores");
        BotonProveedores.setBorder(null);
        BotonProveedores.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonProveedores.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonProveedores.setPreferredSize(new java.awt.Dimension(133, 38));

        BotonCompras.setBackground(new java.awt.Color(27, 27, 27));
        BotonCompras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonCompras.setForeground(new java.awt.Color(255, 255, 255));
        BotonCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Compra.png"))); // NOI18N
        BotonCompras.setText("      Compras");
        BotonCompras.setBorder(null);
        BotonCompras.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonCompras.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonCompras.setPreferredSize(new java.awt.Dimension(133, 38));
        BotonCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonComprasActionPerformed(evt);
            }
        });

        BotonProductos.setBackground(new java.awt.Color(27, 27, 27));
        BotonProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonProductos.setForeground(new java.awt.Color(255, 255, 255));
        BotonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Productos.png"))); // NOI18N
        BotonProductos.setText("        Productos");
        BotonProductos.setBorder(null);
        BotonProductos.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonProductos.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonProductos.setPreferredSize(new java.awt.Dimension(133, 38));

        BotonSalir.setBackground(new java.awt.Color(27, 27, 27));
        BotonSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        BotonSalir.setText("    Salir");
        BotonSalir.setBorder(null);
        BotonSalir.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonSalir.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonSalir.setPreferredSize(new java.awt.Dimension(133, 38));

        BotonCerrarSesion.setBackground(new java.awt.Color(27, 27, 27));
        BotonCerrarSesion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        BotonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CerrarSesion.png"))); // NOI18N
        BotonCerrarSesion.setText("    Cerrar sesion ");
        BotonCerrarSesion.setBorder(null);
        BotonCerrarSesion.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonCerrarSesion.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonCerrarSesion.setPreferredSize(new java.awt.Dimension(133, 38));

        BotonUsuarios.setBackground(new java.awt.Color(27, 27, 27));
        BotonUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        BotonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Usuarios.png"))); // NOI18N
        BotonUsuarios.setText("     Usuarios");
        BotonUsuarios.setBorder(null);
        BotonUsuarios.setMaximumSize(new java.awt.Dimension(133, 40));
        BotonUsuarios.setMinimumSize(new java.awt.Dimension(133, 38));
        BotonUsuarios.setPreferredSize(new java.awt.Dimension(133, 38));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tokyo System");

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema Gestor de ventas");

        javax.swing.GroupLayout Panel_MenuLayout = new javax.swing.GroupLayout(Panel_Menu);
        Panel_Menu.setLayout(Panel_MenuLayout);
        Panel_MenuLayout.setHorizontalGroup(
            Panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonCompras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonNuevaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_MenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_MenuLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        Panel_MenuLayout.setVerticalGroup(
            Panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BotonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BotonProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(BotonProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BotonCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(BotonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(BotonCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(BotonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(106, 106, 106))
        );

        Panel_Fecha.setBackground(new java.awt.Color(27, 27, 27));

        Boton_registroVentas.setBackground(new java.awt.Color(27, 27, 27));
        Boton_registroVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/RegistroVentas.png"))); // NOI18N
        Boton_registroVentas.setBorder(null);

        LabelUser.setFont(new java.awt.Font("UD Digi Kyokasho NK-R", 0, 16)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 255, 255));
        LabelUser.setText("Sesion de {user}");

        Label_Fecha.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Label_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        Label_Fecha.setText("{dayname}  {day} de {month} de {year}");

        BotonSoporte.setBackground(new java.awt.Color(27, 27, 27));
        BotonSoporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Soporte.png"))); // NOI18N
        BotonSoporte.setBorder(null);
        BotonSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout Panel_FechaLayout = new javax.swing.GroupLayout(Panel_Fecha);
        Panel_Fecha.setLayout(Panel_FechaLayout);
        Panel_FechaLayout.setHorizontalGroup(
            Panel_FechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_FechaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Panel_FechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(LabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(216, 216, 216)
                .addComponent(Boton_registroVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        Panel_FechaLayout.setVerticalGroup(
            Panel_FechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_FechaLayout.createSequentialGroup()
                .addComponent(Label_Fecha)
                .addGap(0, 0, 0)
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Panel_FechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_FechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_FechaLayout.createSequentialGroup()
                        .addComponent(Boton_registroVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BotonSoporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel_Ventanas.setBackground(new java.awt.Color(35, 35, 35));
        Panel_Ventanas.setMinimumSize(new java.awt.Dimension(963, 580));
        Panel_Ventanas.setPreferredSize(new java.awt.Dimension(1062, 813));
        Panel_Ventanas.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addComponent(Panel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Ventanas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addComponent(Panel_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Panel_Ventanas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonComprasActionPerformed

    public static void main(String args[]) {
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new MenuPrincipal().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonCompras;
    private javax.swing.JButton BotonNuevaVenta;
    private javax.swing.JButton BotonProductos;
    private javax.swing.JButton BotonProveedores;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonSoporte;
    private javax.swing.JButton BotonUsuarios;
    private javax.swing.JButton Boton_registroVentas;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JLabel Label_Fecha;
    private javax.swing.JPanel Panel_Background;
    private javax.swing.JPanel Panel_Fecha;
    private javax.swing.JPanel Panel_Menu;
    private static javax.swing.JPanel Panel_Ventanas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

/**
 *
 * @author Armando
 */