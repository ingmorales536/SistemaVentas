
package Ventanas;

import Implementaciones.ProductosImpl;
import Modelo.ModeloProductos;
import interfaces.InterfaceProductos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Panel_NuevoProducto extends javax.swing.JPanel {
boolean isEdition = false;
ModeloProductos userEdition;
 
   
    public Panel_NuevoProducto() {
        initComponents();
        GuardarProducto();
   
    }

 public Panel_NuevoProducto(ModeloProductos productos){
        initComponents();
        GuardarProducto();
        isEdition = true;
        userEdition = productos;
        InitStyles();
    
    }//Fin del 2 constructor
    
    private void InitStyles() {
        
        if (isEdition) {
            Label_Titulo.setText("Editar Producto");
            BotonRegistrar.setText("Guardar");

            if (userEdition != null) {
                txtCodigo.setText(userEdition.getCodigo());
                txtDescripcion.setText(userEdition.getDescripcion());
                
                String precioUnitarioStr = String.valueOf(userEdition.getPrecioUnitario());
                txtPrecioCompra.setText(precioUnitarioStr);
                
                String PrecioVenta1 = String.valueOf(userEdition.getPrecioVenta());
                txtPrecioVenta.setText(PrecioVenta1);
                
                String Items = String.valueOf(userEdition.getCantidad());
                txtCantidad.setText(Items);
                
            }//Fin del if userEdition
            
        }//Fin del if isEdition
        
    }//Fin del metodo estilos
    
    
    private void GuardarProducto(){
      
        BotonRegistrar.addActionListener(new ActionListener() {  
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String Codigo = txtCodigo.getText();
                String Descripcion = txtDescripcion.getText();
                String PrecioCompra = txtPrecioCompra.getText();
                double precioCompraDouble = Double.parseDouble(PrecioCompra);
                String PrecioVenta2 = txtPrecioVenta.getText();
                double PrecioVentaDouble = Double.parseDouble(PrecioVenta2);
                String Cantidad= txtCantidad.getText();
                int CantidadItems = Integer.parseInt(Cantidad);
             
             
             if(Codigo.isEmpty() && Descripcion.isEmpty() && PrecioCompra.isEmpty() && PrecioVenta2.isEmpty() && Cantidad.isEmpty() ){
                txtCodigo.setBackground(Color.red);
                 txtDescripcion.setBackground(Color.red);
                 txtPrecioCompra.setBackground(Color.red);
                 txtPrecioVenta.setBackground(Color.red);
                 txtCantidad.setBackground(Color.red);
                 JOptionPane.showMessageDialog(null, "Ingrese todos los datos","Error-Ingresar Cliente",0);
                 
                 
             }else{
                ModeloProductos Producto1 = isEdition ? userEdition : new ModeloProductos(); 
                Producto1.setCodigo(Codigo);
                Producto1.setDescripcion(Descripcion);
                Producto1.setPrecioUnitario(precioCompraDouble);
                Producto1.setPrecioVenta(PrecioVentaDouble);
                Producto1.setCantidad(CantidadItems);
                
                try{
                 InterfaceProductos dao = new ProductosImpl();
                if(!isEdition){
                     dao.Registrar(Producto1);   
                }else{  
                    dao.Modificar(Producto1);
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
    
    }//Fin del metodo registrar producto
    
    
    private void Limpiar(){
                 txtCantidad.setBackground(Color.white);
                 txtDescripcion.setBackground(Color.white);
                 txtPrecioCompra.setBackground(Color.white);
                 txtPrecioVenta.setBackground(Color.white);
                 txtCantidad.setBackground(Color.white);
                 
                 txtCantidad.setText("");
                 txtDescripcion.setText("");
                 txtPrecioCompra.setText("");
                 txtPrecioVenta.setText("");
                 txtCantidad.setText("");
    
    }//Fin del metodo Limpiar
    
    

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Label_Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        Label_ImagenProducto = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));

        Label_Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Label_Titulo.setFont(new java.awt.Font("Arial", 0, 34)); // NOI18N
        Label_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Label_Titulo.setText("Nuevo Producto");

        jSeparator1.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtDescripcion.setBackground(new java.awt.Color(35, 35, 35));
        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESCRIPCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtPrecioCompra.setBackground(new java.awt.Color(35, 35, 35));
        txtPrecioCompra.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecioCompra.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRECIO - COMPRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });

        txtCantidad.setBackground(new java.awt.Color(35, 35, 35));
        txtCantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ITEMS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtPrecioVenta.setBackground(new java.awt.Color(35, 35, 35));
        txtPrecioVenta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRECIO - VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        txtCodigo.setBackground(new java.awt.Color(35, 35, 35));
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CODIGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        BotonRegistrar.setBackground(new java.awt.Color(102, 0, 102));
        BotonRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistrar.setText("Registrar");
        BotonRegistrar.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtDescripcion)
                            .addComponent(txtPrecioCompra))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(txtPrecioVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_ImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator1)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Label_Titulo)
                        .addGap(49, 49, 49)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Label_ImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JLabel Label_ImagenProducto;
    private javax.swing.JLabel Label_Titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
