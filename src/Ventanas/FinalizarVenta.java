
package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FinalizarVenta extends javax.swing.JFrame {
ImageIcon iconoFinalizado = new ImageIcon("src/Img/CompraFinalizada.png");//icono para JOptionPane
Panel_NuevaVenta total= new Panel_NuevaVenta();

    public FinalizarVenta() throws SQLException {
        initComponents();
        DiseñoVentana();
        LogicaBotones();
        ObtenerTotal();
        cambio();
    }
    
    private void ObtenerTotal() throws SQLException{
    
    double Total = total.TotalVenta;
    LabelTotal.setText("Total: "+Total);
        
    }

    private void DiseñoVentana() {
        
        setSize(374, 466);
        setResizable(false);
        setTitle("Finalizar venta");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
  
    
    
   private void  LogicaBotones() {
       
       BotonFinalizar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Venta Realizada", "Registro-Compra", HEIGHT, iconoFinalizado);
                String recibido = TxtRecibo.getText();
                double Total = total.TotalVenta;
      
        if(recibido != ""){
            double Recibi = Double.parseDouble(recibido);
            double operacion = Recibi-Total;
            LabelCambio.setText("Cambio: $"+ operacion);
           
        }else{
           System.out.println("textfile recibido vacio");
        }
           }
       });
   
   }//fin logicabotones
   
   
   
  private void cambio() throws SQLException{
      
      
      
  }//fin del metodo cambio
    
    
  
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtRecibo = new javax.swing.JTextField();
        LabelTotal = new javax.swing.JLabel();
        BotonFinalizar = new javax.swing.JButton();
        LabelCambio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtRecibo.setBackground(new java.awt.Color(35, 35, 35));
        TxtRecibo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TxtRecibo.setForeground(new java.awt.Color(255, 255, 255));
        TxtRecibo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtRecibo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recibo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(TxtRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 270, 60));

        LabelTotal.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Total: $0.00");
        jPanel1.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 250, -1));

        BotonFinalizar.setBackground(new java.awt.Color(0, 204, 51));
        BotonFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        BotonFinalizar.setText("Finalizar");
        jPanel1.add(BotonFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 140, 40));

        LabelCambio.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        LabelCambio.setForeground(new java.awt.Color(255, 255, 255));
        LabelCambio.setText("Cambio: $0.00");
        jPanel1.add(LabelCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FinalizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FinalizarVenta().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FinalizarVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonFinalizar;
    private javax.swing.JLabel LabelCambio;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JTextField TxtRecibo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
