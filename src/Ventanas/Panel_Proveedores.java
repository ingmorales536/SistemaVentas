
package Ventanas;

import Implementaciones.ProveedoresImpl;
import interfaces.InterfaceProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Armando
 */
public class Panel_Proveedores extends javax.swing.JPanel {

   
    public Panel_Proveedores() {
        initComponents();
        DiseñoTabla();
        CargarClientes();
        LogicaBotones();
    }
    
    private void LogicaBotones(){
        BotonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.ShowJPanel(new Panel_NuevoProveedor());           
            }
        });//Fin del boton Nuevo
        
        
         BotonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TablaProveedores.getSelectedRow() > -1){
                   int userId = (int) TablaProveedores.getValueAt(TablaProveedores.getSelectedRow(),0);
                   InterfaceProveedores dao = new ProveedoresImpl();
                    try {        
                        MenuPrincipal.ShowJPanel(new Panel_NuevoProveedor(dao.getUserById(userId)));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                   
                }else{
                         JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un proveedor</h3>",
                "Error-Editar",
                JOptionPane.ERROR_MESSAGE);
                }
                 
            }
        });//Fin del boton Editar
         
         
        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TablaProveedores.getSelectedRow() > -1){ 
                
                   DefaultTableModel model = (DefaultTableModel) TablaProveedores.getModel();
                   InterfaceProveedores dao = new ProveedoresImpl();
               for(int x : TablaProveedores.getSelectedRows()){
                   
                   try{
                     int option = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION);

                                 if (option == JOptionPane.YES_OPTION) {
                                    dao.Eliminar((int) TablaProveedores.getValueAt(x, 0));
                                    model.removeRow(x);
                                 }
                                 
                   }catch(Exception error){
                       System.out.println(error);
                   }
                   
               }
            }else{
                    JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un proveedor</h3>",
                "Error-Eliminar",
                JOptionPane.ERROR_MESSAGE);
                
                }
            }
        });//Fin del boton Eliminar
        
    
    
    }
     private void DiseñoTabla(){
    // Configurar el renderizador para los encabezados
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.black); // Color de fondo
        headerRenderer.setForeground(java.awt.Color.white); // Color de fuente
        
        // Aplicar el renderizador a los encabezados de la tabla
        for (int i = 0; i < TablaProveedores.getColumnCount(); i++) {
            TablaProveedores.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    
    
    }
    
    
    private void CargarClientes(){
            
        try{
            InterfaceProveedores dao = new ProveedoresImpl();
            DefaultTableModel model = (DefaultTableModel) TablaProveedores.getModel();
            dao.listar("").forEach(u -> model.addRow(new Object[]{u.getId(),u.getNombre(),u.getTelefono(),u.getDireccion()}));
            
        }catch(Exception e){
    
        }
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBackground = new javax.swing.JPanel();
        BotonBuscar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BotonNuevo = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();

        PanelBackground.setBackground(new java.awt.Color(35, 35, 35));

        BotonBuscar.setBackground(new java.awt.Color(35, 35, 35));
        BotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar-Clientes.png"))); // NOI18N
        BotonBuscar.setBorder(null);
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 35));

        TablaProveedores.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaProveedores.setForeground(new java.awt.Color(0, 0, 0));
        TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "TELEFONO", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProveedores.setRowHeight(30);
        jScrollPane1.setViewportView(TablaProveedores);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proveedores Registrados");

        BotonNuevo.setBackground(new java.awt.Color(35, 35, 35));
        BotonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BotonNuevo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoActionPerformed(evt);
            }
        });

        BotonEliminar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BotonEditar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        BotonEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtBuscarCliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtBuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelBackgroundLayout = new javax.swing.GroupLayout(PanelBackground);
        PanelBackground.setLayout(PanelBackgroundLayout);
        PanelBackgroundLayout.setHorizontalGroup(
            PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBackgroundLayout.createSequentialGroup()
                .addGroup(PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonBuscar))
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)))
                .addGap(79, 79, 79))
        );
        PanelBackgroundLayout.setVerticalGroup(
            PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBackgroundLayout.createSequentialGroup()
                .addGroup(PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addGroup(PanelBackgroundLayout.createSequentialGroup()
                        .addGroup(PanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed

    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoActionPerformed

    }//GEN-LAST:event_BotonNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonNuevo;
    private javax.swing.JPanel PanelBackground;
    private javax.swing.JTable TablaProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
