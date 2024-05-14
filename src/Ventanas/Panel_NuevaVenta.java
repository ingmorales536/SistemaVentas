
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;
//----------------------------------------------------------------------------------//

public class Panel_NuevaVenta extends javax.swing.JPanel {
  
private DefaultTableModel tablaModelo; 
public  int C;
public  int TotalC;

    public Panel_NuevaVenta() {

        initComponents();
           DiseñoTabla();
           tablaModelo = new DefaultTableModel();
           tablaModelo.addColumn("Cantidad");
           tablaModelo.addColumn("Código");
           tablaModelo.addColumn("Descripción");
           tablaModelo.addColumn("Precio Compra");
           tablaModelo.addColumn("Precio Venta");
           tablaModelo.addColumn("Eliminar");
           // Asignar el modelo de datos al TablaNuevaVenta
           TablaNuevaVenta.setModel(tablaModelo);
           TablaNuevaVenta.setEnabled(false);
           ComboBoxSugerencia.setEditable(false);
 
            MostrarSugerencias();
            InsertarProductoTabla();
            SumaTotal();
            LogicaBotones();
            //AgregarSugerenciaLabel();

    }//Fin del constructor
    
        
    private void DiseñoTabla(){
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
    BotonFinalizar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null, "Venta realizada");
          tablaModelo.setRowCount(0);
        }
    });
    BotonCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              tablaModelo.setRowCount(0);
        }
    });
    Boton_registroVentas.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           MenuPrincipal.ShowJPanel(new Panel_RegistroVentas());
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
                        System.out.println(ex);
                    }
                    ComboBoxSugerencia.removeAllItems();
                    ComboBoxSugerencia.setPopupVisible(false);
                }   
            }
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
                    ComboBoxSugerencia.removeAllItems();
                    ComboBoxSugerencia.setPopupVisible(false);
                }   
            }
        }
    });
    
}//Fin del método InsertarProductoEnLaTabla


private void SumaTotal(){
      
    tablaModelo.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
        actualizarTotal(); // Actualizar el total cuando se produzca un cambio en el modelo de datos
        actualizarSubTotal();
        }
    });
        
}//Fin del metodo SumaTotal

    

 
   private List<String> ObtenerSugerenciaBD(String keyword) throws SQLException {
        Conexion con = new Conexion();
        con.Conectar();
        List<String> sugerencias = new ArrayList<>();
        
        try {
            Connection connection =  con.Conectar();
            PreparedStatement stmt = connection.prepareStatement("SELECT descripcion FROM productos WHERE descripcion LIKE ?");
            stmt.setString(1, "%" + keyword + "%");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                sugerencias.add(resultSet.getString("descripcion"));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener sugerencias desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sugerencias;
        
    }//Fin del metodo ObtenerSugerenciaBD
   

private void InsertarSugerenciaTabla(String selectedItem) throws SQLException {
    Conexion con = new Conexion();
    con.Conectar();
      
    try {
        Connection connection =  con.Conectar();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM productos WHERE descripcion = ?");
        statement.setString(1, selectedItem);
        ResultSet resultSet = statement.executeQuery();
            
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String codigo = resultSet.getString("codigo");
            String descripcion = resultSet.getString("descripcion");
            double precioCompra = resultSet.getDouble("preciounitario");
            double precioVenta = resultSet.getDouble("precioventa");
            int items = resultSet.getInt("cantidad");
            C = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad"));
            tablaModelo.addRow(new Object[]{C, codigo, descripcion, precioCompra, precioVenta,items});
            
        }
        resultSet.close();
        statement.close();
    } catch (SQLException e) {  
        
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Error al obtener datos desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//Fin del catch
    
}//Fin del metodo InsertarSugerenciaTabla


private void actualizarTotal() {
         double total = 0.0;
        for (int fila = 0; fila < TablaNuevaVenta.getRowCount(); fila++) {
            int cantidad = Integer.parseInt(TablaNuevaVenta.getValueAt(fila, 0).toString());
            double precioVenta = Double.parseDouble(TablaNuevaVenta.getValueAt(fila, 4).toString());
            double subtotal = cantidad * precioVenta;
            total += subtotal;
        }
        LabelTotal.setText("Total: " + total); // Actualizar el texto del JLabel con el total calculado
    }//Fin del metodo ActualizarTotal


private void actualizarSubTotal() {
        double subtotal = 0.0;
        DefaultTableModel modelo = (DefaultTableModel) TablaNuevaVenta.getModel();
        int cantidadFilas = modelo.getRowCount();
        for (int i = 0; i < cantidadFilas; i++) {
            subtotal += (double) modelo.getValueAt(i, 3); // Sumar valores de la columna "Precio compra"
        }
        LabelSubTotal.setText("SubTotal:  " + subtotal); // Actualizar el texto del JLabel con el total
    }//Fin del metodo actualizarSubTotal

    













    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboBoxSugerencia = new javax.swing.JComboBox<>();
        Boton_registroVentas = new javax.swing.JButton();
        txtBuscarArticulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNuevaVenta = new javax.swing.JTable();
        BotonFinalizar = new javax.swing.JButton();
        BotonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelSubTotal = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        Panel_Background.setBackground(new java.awt.Color(35, 35, 35));
        Panel_Background.setMinimumSize(new java.awt.Dimension(750, 430));
        Panel_Background.setPreferredSize(new java.awt.Dimension(750, 430));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,4));

        ComboBoxSugerencia.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ComboBoxSugerencia.setMaximumRowCount(22);
        ComboBoxSugerencia.setToolTipText("Sugerencias");
        ComboBoxSugerencia.setBorder(null);
        ComboBoxSugerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSugerenciaActionPerformed(evt);
            }
        });

        Boton_registroVentas.setBackground(new java.awt.Color(35, 35, 35));
        Boton_registroVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/RegistroVentas.png"))); // NOI18N
        Boton_registroVentas.setBorder(null);

        txtBuscarArticulo.setBackground(new java.awt.Color(35, 35, 35));
        txtBuscarArticulo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtBuscarArticulo.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarArticulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarArticulo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Articulo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ComboBoxSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(Boton_registroVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ComboBoxSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Boton_registroVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TablaNuevaVenta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PRECIOUNI", "PRECIOVENTA", "ITEMS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        BotonFinalizar.setBackground(new java.awt.Color(0, 153, 51));
        BotonFinalizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        BotonFinalizar.setText("Finalizar");

        BotonCancelar.setBackground(new java.awt.Color(204, 0, 0));
        BotonCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BotonCancelar.setText("Cancelar");

        jPanel2.setBackground(new java.awt.Color(38, 38, 38));

        LabelSubTotal.setBackground(new java.awt.Color(0, 0, 0));
        LabelSubTotal.setFont(new java.awt.Font("Arial Black", 1, 26)); // NOI18N
        LabelSubTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelSubTotal.setText("SubTotal: 0.0");

        LabelTotal.setFont(new java.awt.Font("Arial Black", 1, 26)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Total :  0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(LabelSubTotal)
                .addGap(3, 3, 3)
                .addComponent(LabelTotal))
        );

        jSeparator1.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator1.setForeground(new java.awt.Color(35, 35, 35));

        jSeparator2.setBackground(new java.awt.Color(35, 35, 35));
        jSeparator2.setForeground(new java.awt.Color(35, 35, 35));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator1))
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(jSeparator2)
                                .addGap(112, 112, 112)
                                .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(BotonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(43, 43, 43))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(26, 26, 26))
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
    private javax.swing.JButton BotonFinalizar;
    private javax.swing.JButton Boton_registroVentas;
    private javax.swing.JComboBox<String> ComboBoxSugerencia;
    private javax.swing.JLabel LabelSubTotal;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JPanel Panel_Background;
    public javax.swing.JTable TablaNuevaVenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtBuscarArticulo;
    // End of variables declaration//GEN-END:variables
}
