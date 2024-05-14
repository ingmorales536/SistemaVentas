
package Ventanas;

import Implementaciones.ProductosImpl;
import interfaces.InterfaceProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Panel_Productos extends javax.swing.JPanel {

 
    public Panel_Productos() {
        initComponents();
        DiseñoTabla();
        LogicaBotones();
        CargarProductos();
    }

    
     private void CargarProductos(){
         
        try{
            InterfaceProductos dao = new ProductosImpl();
            DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
            dao.listar("").forEach(u -> model.addRow(new Object[]{u.getId(),u.getCodigo(),u.getDescripcion(),u.getPrecioUnitario(),u.getPrecioVenta(),u.getCantidad()}));
            
        }catch(Exception e){
    
        }
    }//Fin del metodo CargarProductos
    
    
    
    
    
   private void DiseñoTabla(){
    // Configurar el renderizador para los encabezados
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.black); // Color de fondo
        headerRenderer.setForeground(java.awt.Color.white); // Color de fuente
        
        // Aplicar el renderizador a los encabezados de la tabla
        for (int i = 0; i < TablaProductos.getColumnCount(); i++) {
            TablaProductos.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }//Fin del metodo diseñoTabla
   
   
   private void LogicaBotones(){
   
       BotonAgregar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                MenuPrincipal.ShowJPanel(new Panel_NuevoProducto());           
           }
       });
       
       BotonEditar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               if(TablaProductos.getSelectedRow() > -1){
                   int userId = (int) TablaProductos.getValueAt(TablaProductos.getSelectedRow(),0);
                   InterfaceProductos dao = new ProductosImpl();
                    try {        
                        MenuPrincipal.ShowJPanel(new Panel_NuevoProducto(dao.getUserById(userId)));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                   
                }else{
                        JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Producto</h3>",
                "Error-Editar",
                JOptionPane.ERROR_MESSAGE);
                }
           }
       });//Fin del botonEditar
       
       BotonEliminar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
                if(TablaProductos.getSelectedRow() > -1){ 
                    
                   DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
                   InterfaceProductos dao = new ProductosImpl();
                                  
                     for(int x : TablaProductos.getSelectedRows()){     
                        try{
                                int option = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);

                                 if (option == JOptionPane.YES_OPTION) {
                                    dao.Eliminar((int) TablaProductos.getValueAt(x, 0));
                                     model.removeRow(x);
                                 }

                            }catch(Exception error){
                                System.out.println("");
                            }//Fin del catch   
                        
                    }//Fin del for
                             
                            
                }else{
                         JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Producto</h3>",
                "Error-Eliminar",
                JOptionPane.ERROR_MESSAGE); 
                    } 

           }//Fin del ActioPerfomed
           
       });//Fin del botonEliminar
   
   
   }//Fin del metodo LogicaBotones
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BotonAgregar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(35, 35, 35));

        Panel_Background.setBackground(new java.awt.Color(35, 35, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");

        TablaProductos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PRECIO UNI.", "PRECIO VENTA", "ITEMS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProductos.setRowHeight(30);
        jScrollPane1.setViewportView(TablaProductos);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(35, 35, 35));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar-Clientes.png"))); // NOI18N
        jButton1.setBorder(null);

        BotonAgregar.setBackground(new java.awt.Color(35, 35, 35));
        BotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BotonAgregar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        BotonEliminar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        BotonEditar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar.png"))); // NOI18N
        BotonEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonAgregar)
                .addGap(20, 20, 20)
                .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addGap(67, 67, 67))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JPanel Panel_Background;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
