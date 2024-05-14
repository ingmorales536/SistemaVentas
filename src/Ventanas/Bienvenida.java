/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package Ventanas;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Bienvenida extends javax.swing.JPanel {
int width1 =963;
int height1= 580;
    
    
    /** Creates new form Bienvenida */
    public Bienvenida() {
        initComponents();
        
         Panel_Background.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Tamaño(); // Llamada al método Tamaño() al detectar un cambio de tamaño
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();

        Panel_Background.setBackground(new java.awt.Color(35, 35, 35));

        label3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("nuestro punto de venta, encontrarás una amplia variedad de productos para satisfacer tus ");

        label1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("¡Bienvenido a nuestro Punto de Venta!");

        label2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Estamos encantados de recibirte y ofrecerte nuestros productos y servicios de calidad. En ");

        label8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 255, 255));
        label8.setText("¡Gracias por elegirnos y esperamos que disfrutes tu visita en nuestro Punto de Venta!  ");

        label4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("necesidades.");

        label5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Nuestro equipo está aquí para ayudarte en lo que necesites. No dudes en consultarnos sobre ");

        label6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("nuestros productos, precios especiales o cualquier otra información que requieras. Estamos ");

        label7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("comprometidos en brindarte una experiencia de compra agradable y satisfactoria.");

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1)
                    .addComponent(label2)
                    .addComponent(label3)
                    .addComponent(label4)
                    .addComponent(label5)
                    .addComponent(label6)
                    .addComponent(label7)
                    .addComponent(label8))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(label1)
                .addGap(23, 23, 23)
                .addComponent(label2)
                .addGap(13, 13, 13)
                .addComponent(label3)
                .addGap(13, 13, 13)
                .addComponent(label4)
                .addGap(33, 33, 33)
                .addComponent(label5)
                .addGap(13, 13, 13)
                .addComponent(label6)
                .addGap(13, 13, 13)
                .addComponent(label7)
                .addGap(13, 13, 13)
                .addComponent(label8)
                .addContainerGap(156, Short.MAX_VALUE))
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
    
    private void Tamaño(){
       int width = Panel_Background.getWidth();
       int height = Panel_Background.getHeight();
       
        if(width > 1400 ){
            Font arial = new Font("Arial", Font.PLAIN, 46);
            Font arial2 = new Font("Arial", Font.PLAIN, 30);
            label1.setFont(arial);
            label2.setFont(arial2);
            label3.setFont(arial2);
            label4.setFont(arial2);
            label5.setFont(arial2);
            label6.setFont(arial2);
            label7.setFont(arial2);
            label8.setFont(arial2);
            System.out.println("aumento");
        }else if(width < 1400){
            Font arial = new Font("Arial", Font.PLAIN, 28);
            Font arial2 = new Font("Arial", Font.PLAIN, 20);
            label1.setFont(arial);
            label2.setFont(arial2);
            label3.setFont(arial2);
            label4.setFont(arial2);
            label5.setFont(arial2);
            label6.setFont(arial2);
            label7.setFont(arial2);
            label8.setFont(arial2);
            System.out.println("siuu");
        }else{
            System.out.println("papa dio");
        }
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Background;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    // End of variables declaration//GEN-END:variables

}
