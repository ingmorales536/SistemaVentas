
package Ventanas;


import Implementaciones.ClientesImpl;
import Implementaciones.UsuariosImpl;
import interfaces.InterfaceClientes;
import interfaces.InterfaceUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Armando
 */
public class Panel_Usuarios extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Usuarios
     */
    public Panel_Usuarios() {
        initComponents();
        CargarUsuarios();
        DiseñoTabla();
        LogicaBotones();
    }
      private void DiseñoTabla(){
    // Configurar el renderizador para los encabezados
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.black); // Color de fondo
        headerRenderer.setForeground(java.awt.Color.white); // Color de fuente
        
        // Aplicar el renderizador a los encabezados de la tabla
        for (int i = 0; i < TablaUsuarios.getColumnCount(); i++) {
            TablaUsuarios.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    
    
    }
    private void CargarUsuarios(){
            
        try{
            InterfaceUsuarios dao = new UsuariosImpl();
            DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
            dao.listar("").forEach(u -> model.addRow(new Object[]{u.getId(),u.getNombre(),u.getUsuario(),u.getPassword(),u.getPermiso()}));   
        }catch(Exception e){
    
        }
    }
    
    
    private void LogicaBotones(){
        
        BotonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MenuPrincipal.ShowJPanel(new Panel_RegistrarUsuario());
            }
        });//Fin del botonNuevo
        
        BotonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TablaUsuarios.getSelectedRow() > -1){
                   int userId = (int) TablaUsuarios.getValueAt(TablaUsuarios.getSelectedRow(),0);
                   InterfaceUsuarios dao = new UsuariosImpl();
                    try {        
                        MenuPrincipal.ShowJPanel(new Panel_RegistrarUsuario(dao.getUserById(userId)));
                    } catch (Exception ex) {
                        
                    }
                   
                }else{
                        JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Usuario</h3>",
                "Error-Editar",
                JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });//Fin del boton Modificar
        
        BotonEliminar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                   if(TablaUsuarios.getSelectedRow() > -1){
                        DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
                       InterfaceUsuarios dao = new UsuariosImpl();
                   for(int x : TablaUsuarios.getSelectedRows()){

                       try{
                          dao.Eliminar((int) TablaUsuarios.getValueAt(x, 0));
                          model.removeRow(x);
                       }catch(Exception error){
                           System.out.println(error);
                       }
                   
                    }
               }else{
                   
                           JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Usuario</h3>",
                "Error-Eliminar",
                JOptionPane.ERROR_MESSAGE);
                   
                   }
            }
        });
    
        
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        LabelTitulo = new javax.swing.JLabel();
        BotonEliminar = new javax.swing.JButton();
        BotonNuevo = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        TablaUsuarios.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "USUARIO", "CONTRASEÑA", "PERMISO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuarios.setRowHeight(30);
        jScrollPane1.setViewportView(TablaUsuarios);

        LabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setText("Usuarios Registrados");

        BotonEliminar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonEliminar.setToolTipText("");
        BotonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        BotonNuevo.setBackground(new java.awt.Color(35, 35, 35));
        BotonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BotonNuevo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        BotonEditar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        BotonEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)
                        .addGap(124, 124, 124)
                        .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LabelTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)))
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LabelTitulo)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonNuevo;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
