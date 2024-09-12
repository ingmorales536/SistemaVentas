
package Ventanas;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ConexionDB.Conexion;
import Implementaciones.ProveedoresImpl;
import interfaces.InterfaceProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;
//----------------------------------------------------------------------------------//

public class Panel_NuevaVenta extends javax.swing.JPanel {
    
//Variables para hacer la conexion y obtener datos
Conexion con = new Conexion();
Connection conexion = con.ConectarBDcloud();
PreparedStatement stmt;
ResultSet resultSet;
//-------------------------
public String descuento;
double Descuento ;
//------------------------
private DefaultTableModel tablaModelo; 
public  int C;
public  int TotalC;

//Obtener total
public static double TotalVenta = 0.0;

    public Panel_NuevaVenta() throws SQLException {
        
        initComponents();  
        DiseñoTabla();
        MostrarSugerencias();
        InsertarProductoTabla();
        SumaTotal();
        LogicaBotones();
        EliminarArticulo();
        DescuentoTotal();
        ObtenerClientes();
    }//Fin del constructor
    


    private void ObtenerClientes() throws SQLException{     
        stmt = conexion.prepareStatement("SELECT nombre,apellidopaterno FROM clientes");
        ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getNString("nombre");
                String apellido = resultSet.getNString("apellidopaterno");
                ComboBoxClientes.addItem(nombre);
            }
            resultSet.close();
            stmt.close();

    }//fin del metodo ObtenerClientes
    
    private void InsertarProductoTabla(){

    ComboBoxSugerencia.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Object selectedItem = ComboBoxSugerencia.getSelectedItem();
                if (selectedItem != null) {
                    try {
                       InsertarSugerenciaTabla(selectedItem.toString());

                    } catch (SQLException ex) {
                        System.out.println("Error al insertar el producto a la tabla: " + ex);
                    }
                   
                }   
            }
            txtBuscarArticulo.setText("");
        }
    });
    
   txtBuscarArticulo.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Object selectedItem = ComboBoxSugerencia.getSelectedItem();
                if (selectedItem != null) {
                    try {
                       InsertarSugerenciaTabla(selectedItem.toString());
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }          
                    txtBuscarArticulo.setText("");
                }   
            }
        }
    });
    
}//Fin del método InsertarProductoEnLaTabla

    private void EliminarArticulo(){
        
        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                if(TablaNuevaVenta.getSelectedRow() > -1){ 
                
                   DefaultTableModel model = (DefaultTableModel) TablaNuevaVenta.getModel();
                   InterfaceProveedores dao = new ProveedoresImpl();
               for(int x : TablaNuevaVenta.getSelectedRows()){
                   
                   try{
                     int option = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

                                 if (option == JOptionPane.YES_OPTION) {
                                    dao.Eliminar((int) TablaNuevaVenta.getValueAt(x, 0));
                                    model.removeRow(x);
                                 }
                                 
                   }catch(Exception error){
                       System.out.println(error);
                   }
                   
               }
            }else{
                    JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:red;'>Seleccione un Articulo</h3>",
                "Error-Eliminar",
                JOptionPane.ERROR_MESSAGE);
                
                }
            }
        });
        
    }

  
        
    public void DiseñoTabla(){
           tablaModelo = new DefaultTableModel();
           tablaModelo.addColumn("Cantidad");
           tablaModelo.addColumn("Código");
           tablaModelo.addColumn("DESCRIPCION");
           tablaModelo.addColumn("PRECIO COMPRA");
           tablaModelo.addColumn("PRECIO VENTA");
           tablaModelo.addColumn("PRECIO + DESCUENTO");
           tablaModelo.addColumn("ITEMS DISPONIBLES");
           // Asignar el modelo de datos al TablaNuevaVenta
           TablaNuevaVenta.setModel(tablaModelo);
           ComboBoxSugerencia.setEditable(false);
    // Configurar el renderizador para los encabezados
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.black); // Color de fondo
        headerRenderer.setForeground(java.awt.Color.white); // Color de fuente
        
        // Aplicar el renderizador a los encabezados de la tabla
        for (int i = 0; i < TablaNuevaVenta.getColumnCount(); i++) {
            TablaNuevaVenta.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        

    }//Fin del Metodo DiseñoTabla
    

    
    private void LogicaBotones(){
    BotonCobrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                FinalizarVenta   finalizarventa = new FinalizarVenta();
                finalizarventa.setVisible(true);
            } catch (SQLException ex) {
                System.out.println("Error en Ventana FinalizarVenta: "+ ex);
                JOptionPane.showMessageDialog(null, "Error al finaliza Venta","Error en venta",1);
            }
          //tablaModelo.setRowCount(0);    
        }
    });
    BotonCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              tablaModelo.setRowCount(0);
        }
    });
  
    
    }//fin metodo logicabotones
    
    
   private void MostrarSugerencias(){
       
    ((JTextComponent) txtBuscarArticulo).getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
                
                ObtenerSugerencias();
            } catch (SQLException ex) {
                System.out.println(ex);
               
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                ObtenerSugerencias();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            try {
                
                ObtenerSugerencias();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    
    });
    
    
}//Fin del método Mostrar sugerencias


private void ObtenerSugerencias() throws SQLException {
    
    String keyword = ((JTextComponent) txtBuscarArticulo).getText().trim();
    List<String> sugerencias = ObtenerSugerenciaBD(keyword);
    
    ComboBoxSugerencia.removeAllItems();
    for (String sugerencia : sugerencias) {
        ComboBoxSugerencia.addItem(sugerencia);
    }
    ComboBoxSugerencia.setPopupVisible(!sugerencias.isEmpty());
    
}//Fin del método ObtenerSugerencia

 
   private List<String> ObtenerSugerenciaBD(String keyword) throws SQLException {
        List<String> sugerencias = new ArrayList<>();
        try {
    
            stmt = conexion.prepareStatement("SELECT descripcion,codigo FROM productos WHERE codigo LIKE ?");
            stmt.setString(1, "%" + keyword + "%");
             resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                
                sugerencias.add(resultSet.getString("descripcion")); 
            }
            resultSet.close();
            stmt.close();
           
            
        } catch (SQLException e) {
            System.out.println("metodo(ObtenerSugerenciaBD): "+  e);
            JOptionPane.showMessageDialog(null, "Error al obtener sugerencias desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sugerencias;
        
    }//Fin del metodo ObtenerSugerenciaBD
   

private void InsertarSugerenciaTabla(String selectedItem) throws SQLException {
    double PrecioVenta = 0.0;
    double precioFinal = 0.0;
    double operacion = 0.0;
    
    try {
        // Preparar la consulta para obtener los datos del producto seleccionado
        stmt = conexion.prepareStatement("SELECT * FROM productos WHERE descripcion = ?");
        stmt.setString(1, selectedItem);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String codigo = resultSet.getString("codigo");
            String descripcion = resultSet.getString("descripcion");
            double precioCompra = resultSet.getDouble("preciounitario");
            double precioVenta = resultSet.getDouble("precioventa");
            int itemsDisponibles = resultSet.getInt("cantidad");

            // Obtener la cantidad deseada por el usuario
            int cantidadDeseada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad"));
            System.out.println(cantidadDeseada);
               
            // Validar la cantidad ingresada
            if (cantidadDeseada > 0 && cantidadDeseada <= itemsDisponibles) {
                // Calcular el precioFinal para la primera vez
                PrecioVenta = precioVenta; 
                operacion = (PrecioVenta * Descuento) / 100;
                precioFinal = PrecioVenta - operacion;
                System.out.println("-----Precio final: " + precioFinal);
                
                // Agregar el artículo a la tabla
                DefaultTableModel modelo = (DefaultTableModel) TablaNuevaVenta.getModel();
                modelo.addRow(new Object[]{cantidadDeseada, codigo, descripcion, precioCompra, precioVenta, precioFinal, itemsDisponibles});
             
            } else if (cantidadDeseada > itemsDisponibles) {
                JOptionPane.showMessageDialog(null, "Items insuficientes", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Agregue un Articulo", "Error", JOptionPane.ERROR_MESSAGE);      
            }
        }//fin del while
        
        resultSet.close();
        stmt.close();
        
    } catch (SQLException e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Error al obtener datos desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
    }
}






private void SumaTotal(){
      
    tablaModelo.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
        actualizarTotal(); // Actualizar el total cuando se produzca un cambio en el modelo de datos
        actualizarTotalArtuculos();
        Ganancias();    
        }
    });
        
}//Fin del metodo SumaTotal


public void actualizarTotal() {
        double total = 0.0;
        
        System.out.println("Total de venta: " + TotalVenta);
        for (int fila = 0; fila < TablaNuevaVenta.getRowCount(); fila++) {
            int cantidad = Integer.parseInt(TablaNuevaVenta.getValueAt(fila, 0).toString());
            double precioVenta = Double.parseDouble(TablaNuevaVenta.getValueAt(fila, 5).toString());
            double subtotal = cantidad * precioVenta;
            total+= subtotal;  
        }
        TotalVenta = total;
        LabelTotal.setText("Total: " + total);
    
    }//Fin del metodo ActualizarTotal


private void actualizarTotalArtuculos() {
        int Articulos = 0;
        DefaultTableModel modelo = (DefaultTableModel) TablaNuevaVenta.getModel();
        int cantidadFilas = modelo.getRowCount();
        for (int x = 0; x < cantidadFilas; x++) {
            Articulos += (int) modelo.getValueAt(x, 0); // Sumar valores de la columna "Precio compra"
        }
        LabelArticulos.setText("Articulos:  " + Articulos); // Actualizar el texto del JLabel con el total
    }//Fin del metodo actualizarSubTotal

    
private void Ganancias(){
    double compra = 0.0;
    double venta = 0.0;
    int items = 0;
    double operacion = 0.0;
    double totalGanancias = 0.0;
    DefaultTableModel modelo = (DefaultTableModel) TablaNuevaVenta.getModel();
    int cantidadFilas = modelo.getRowCount();
    
    for(int x = 0; x < cantidadFilas; x++){
        compra = (double) modelo.getValueAt(x, 3);
        venta = (double) modelo.getValueAt(x, 5);
        items = (int) modelo.getValueAt(x, 0);
        
        // Realiza la operación para cada fila
        operacion = (venta - compra) * items;
        
        // Suma el resultado a totalGanancias
        totalGanancias += operacion;
    }
    
    LabelGanancias.setText("Ganancias: " + totalGanancias);
    System.out.println("Ganancias: " + totalGanancias);
    System.out.println("operacion: " + operacion);
}//fin del metodo ganancias


public void ObtenerDescuento() throws SQLException{ 
    String cliente = (String) ComboBoxClientes.getSelectedItem();
    stmt = conexion.prepareStatement("SELECT descuento FROM clientes WHERE nombre = ?");
    stmt.setString(1,cliente);
    
    resultSet = stmt.executeQuery();
    while(resultSet.next()){
        descuento = resultSet.getString("descuento");
        Descuento = Double.parseDouble(descuento);
        LabelDescuento.setText("Descuento: "+descuento +"%");
    }
}//fin del metodo descuento


private void DescuentoTotal(){
ComboBoxClientes.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            ObtenerDescuento();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el descuento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});



}









    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboBoxSugerencia = new javax.swing.JComboBox<>();
        txtBuscarArticulo = new javax.swing.JTextField();
        ComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNuevaVenta = new javax.swing.JTable();
        BotonCobrar = new javax.swing.JButton();
        BotonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelArticulos = new javax.swing.JLabel();
        LabelGanancias = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        LabelDescuento = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BotonEliminar = new javax.swing.JButton();

        Panel_Background.setBackground(new java.awt.Color(35, 35, 35));
        Panel_Background.setMinimumSize(new java.awt.Dimension(750, 430));
        Panel_Background.setPreferredSize(new java.awt.Dimension(750, 430));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBoxSugerencia.setBackground(new java.awt.Color(35, 35, 35));
        ComboBoxSugerencia.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ComboBoxSugerencia.setForeground(new java.awt.Color(255, 255, 255));
        ComboBoxSugerencia.setMaximumRowCount(22);
        ComboBoxSugerencia.setToolTipText("Articulos");
        ComboBoxSugerencia.setBorder(null);
        ComboBoxSugerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSugerenciaActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxSugerencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 50));

        txtBuscarArticulo.setBackground(new java.awt.Color(35, 35, 35));
        txtBuscarArticulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBuscarArticulo.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarArticulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarArticulo.setToolTipText("Buscar Articulos");
        txtBuscarArticulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Articulo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(txtBuscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 300, 60));

        ComboBoxClientes.setBackground(new java.awt.Color(0, 0, 0));
        ComboBoxClientes.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ComboBoxClientes.setForeground(new java.awt.Color(255, 255, 255));
        ComboBoxClientes.setBorder(null);
        jPanel1.add(ComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 228, 50));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Articulos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        TablaNuevaVenta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PRECIOUNI", "PRECIOVENTA", "PRECIO + DESCUENTO", "ITEMS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaNuevaVenta.setMaximumSize(new java.awt.Dimension(450, 80));
        TablaNuevaVenta.setMinimumSize(new java.awt.Dimension(300, 80));
        TablaNuevaVenta.setRowHeight(22);
        TablaNuevaVenta.setRowMargin(4);
        jScrollPane1.setViewportView(TablaNuevaVenta);

        BotonCobrar.setBackground(new java.awt.Color(0, 153, 51));
        BotonCobrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonCobrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonCobrar.setText("Cobrar");

        BotonCancelar.setBackground(new java.awt.Color(204, 0, 0));
        BotonCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BotonCancelar.setText("Cancelar");

        jPanel2.setBackground(new java.awt.Color(38, 38, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelArticulos.setBackground(new java.awt.Color(0, 0, 0));
        LabelArticulos.setFont(new java.awt.Font("Arial Black", 1, 26)); // NOI18N
        LabelArticulos.setForeground(new java.awt.Color(255, 255, 255));
        LabelArticulos.setText("Articulos: 0");
        jPanel2.add(LabelArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, -1));

        LabelGanancias.setFont(new java.awt.Font("Arial Black", 1, 26)); // NOI18N
        LabelGanancias.setForeground(new java.awt.Color(255, 255, 255));
        LabelGanancias.setText("Ganancias :  0.00");
        jPanel2.add(LabelGanancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 320, -1));

        LabelTotal.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Venta Total:  0.00");
        jPanel2.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 320, -1));

        LabelDescuento.setFont(new java.awt.Font("Arial Black", 0, 26)); // NOI18N
        LabelDescuento.setForeground(new java.awt.Color(255, 255, 255));
        LabelDescuento.setText("Descuento: 0%");
        jPanel2.add(LabelDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 35));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        BotonEliminar.setBackground(new java.awt.Color(35, 35, 35));
        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar2.png"))); // NOI18N
        BotonEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Articulo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(43, 43, 43))
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(BotonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2)
                        .addContainerGap())))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jSeparator2)))
                .addGap(25, 25, 25))
        );

        BotonCancelar.getAccessibleContext().setAccessibleDescription("Cnacelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxSugerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSugerenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSugerenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonCobrar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JComboBox<String> ComboBoxClientes;
    private javax.swing.JComboBox<String> ComboBoxSugerencia;
    private javax.swing.JLabel LabelArticulos;
    private javax.swing.JLabel LabelDescuento;
    private javax.swing.JLabel LabelGanancias;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JPanel Panel_Background;
    public javax.swing.JTable TablaNuevaVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtBuscarArticulo;
    // End of variables declaration//GEN-END:variables
}
