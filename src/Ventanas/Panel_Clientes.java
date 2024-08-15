
package Ventanas;

import Implementaciones.ClientesImpl;
import interfaces.InterfaceClientes;
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
public class Panel_Clientes extends javax.swing.JPanel {
    

    public Panel_Clientes() {
        initComponents();
        LogicaBotones();
        CargarClientes();
        DiseñoTabla();
    }


     private void DiseñoTabla(){
    // Configurar el renderizador para los encabezados
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.black); // Color de fondo
        headerRenderer.setForeground(java.awt.Color.white); // Color de fuente
        
        // Aplicar el renderizador a los encabezados de la tabla
        for (int i = 0; i < TablaClientes.getColumnCount(); i++) {
            TablaClientes.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    
    
    }
    
    //Obtetenido del metodo list-interface clientes
    private void CargarClientes(){
            
        try{
            InterfaceClientes dao = new ClientesImpl();
            DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
            dao.listar("").forEach(u -> model.addRow(new Object[]{u.getId(),u.getNombre(),u.getApellidoPaterno(),u.getApellidoMaterno(),u.getTelefono(),u.getDireccion(),u.getDescuento()}));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al cargar cliente","ERROR",0);
            System.out.println("Error en el panel clientes: " + e);
        }
    }//Fin de cargarclientes

    private void LogicaBotones(){
        BotonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.ShowJPanel(new Panel_NuevoCliente());           
            }
        });//Fin del boton Nuevo
        
        BotonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TablaClientes.getSelectedRow() > -1){
                   int userId = (int) TablaClientes.getValueAt(TablaClientes.getSelectedRow(),0);
                   InterfaceClientes dao = new ClientesImpl();
                    try {        
                        MenuPrincipal.ShowJPanel(new Panel_NuevoCliente(dao.getUserById(userId)));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                   
                }else{
                     JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Cliente</h3>",
                "Error",
                JOptionPane.ERROR_MESSAGE);
                }
                 
          
            }
        });//Fin del boton Editar
         
         
        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(TablaClientes.getSelectedRow() > -1){
                     
                    DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
                    InterfaceClientes dao = new ClientesImpl();
                    for(int x : TablaClientes.getSelectedRows()){

                        try{
                           int option = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);

                                 if (option == JOptionPane.YES_OPTION) {
                                    dao.Eliminar((int) TablaClientes.getValueAt(x, 0));
                                    model.removeRow(x);
                                 }
                        }catch(Exception error){
                            System.out.println("");
                        }

                    }
                }else{
                    JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Cliente</h3>",
                "Error",
                JOptionPane.ERROR_MESSAGE);
                 }
            }
        });//Fin del boton Eliminar
    
    }
   
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BotonNuevo = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();
        Boton_Buscar_Cliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        TablaClientes.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO PA.", "APELLIDO MA.", "TELEFONO", "DIRECCION", "DESCUENTO (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.setRowHeight(30);
        jScrollPane1.setViewportView(TablaClientes);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes ");

        BotonNuevo.setBackground(new java.awt.Color(35, 35, 35));
        BotonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BotonNuevo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoActionPerformed(evt);
            }
        });

        BotonEliminar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BotonEditar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        BotonEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        BotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtBuscarCliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtBuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Boton_Buscar_Cliente.setBackground(new java.awt.Color(35, 35, 35));
        Boton_Buscar_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar-Clientes.png"))); // NOI18N
        Boton_Buscar_Cliente.setBorder(null);
        Boton_Buscar_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Buscar_ClienteActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Buscar_Cliente))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton_Buscar_Cliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void BotonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoActionPerformed
       
        
    }//GEN-LAST:event_BotonNuevoActionPerformed

    private void Boton_Buscar_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Buscar_ClienteActionPerformed
        
    }//GEN-LAST:event_Boton_Buscar_ClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonNuevo;
    private javax.swing.JButton Boton_Buscar_Cliente;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
