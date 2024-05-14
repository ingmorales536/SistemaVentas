
package Ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.util.Random;

/**
 *
 * @author Armando
 */
public class Chatbot extends javax.swing.JFrame {
String user;
    /**
     * Creates new form Chatbot
     */
    
     
    public Chatbot() {
       initComponents();
       Diseño();   
       LogicaBot();
       
    }//Fin del constructor
    
    @Override
    public Image getIconImage(){
    Toolkit miPantalla = Toolkit.getDefaultToolkit();
    Image miIcono = miPantalla.getImage("src/Img/icon.jpg");
    setIconImage(miIcono);
    return miIcono ;
    }//Fin del icono
    
    private void Diseño(){
     //configuracion de la ventana 576, 642
        setSize(840, 690);
        setResizable(false);
        setTitle("Asistente Virtual");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Chat_Area.setEditable(false);
    
    }//Fin del metodo Diseño
    
    private void LogicaBot(){
    
      //Logica del chatbot
        Text_Ingresado.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent arg0) {
             String obtener_texto = Text_Ingresado.getText();
             Chat_Area.append(user+"->"+obtener_texto+"\n"+"\n");
             Text_Ingresado.setText("");
             
             
            
             
             if(obtener_texto.contains("No puedo ingresar a mi cuenta") || obtener_texto.contains("no puedo ingresar a mi cuenta") ||
                obtener_texto.contains("No puedo ingresar a una cuenta") || obtener_texto.contains("no puedo ingresar a una cuenta") ||
                obtener_texto.contains("no puedo ingresar a una cuenta registrada") || obtener_texto.contains("No puedo ingresar a mi cuenta registrada")){
                    bot("Si no puedes ingresar a una cuenta estas pueden ser algunas soluciones:"+"\n"+
                        "1-Verifica la Contraseña: Asegúrate de que el usuario esté ingresando la contraseña correcta."+"\n"+"Las contraseñas distinguen entre mayúsculas y minúsculas, así que es importante que coincidan exactamente."+"\n"+
                        "2-Restablece la Contraseña: Si el usuario ha olvidado la contraseña, considera ofrecer la opción de restablecerla."+"\n"+
                        "3-Verifica la Conexión a Internet: Asegúrate de que el usuario tenga una conexión a Internet estable."+"\n"+
                        "4-Comuniquese con un administrador para verificar que la cuenta no haya sido bloqueada"+"\n"+
                        "(Si la informacio fue util, ingresa el '1',sino fue util ingresa el '2')");
             }
             
             else if(obtener_texto.contains("hola") || obtener_texto.contains("Hola")){
                 Random random = new Random();
                 int numero_random = random.nextInt(5) + 1;
                 switch(numero_random){
                     case 1:bot("Hola "+user+" en que puedo ayudarte?");
                     break;
                     case 2:bot("Hola");
                     break;
                     case 3: bot("Que tal "+user);
                     break;
                     case 4: bot("En que puedo ayudarte?");
                     break;
                     case 5: bot("Puedo ayudarte en algo?");
                     break;
                     default:bot("zi");
                 
                 }   
             }
             
             else if(obtener_texto.contains("no puedo agregar un cliente") || obtener_texto.contains("NO PUEDO AGREGAR UN CLIENTE")){
                 bot("Si no puedes agregar otro cliente,intenta reiniciando el sistema,esto puede pasar "+"\n"+"por algun error en la conexion a la base de datos."+"\n"+
                         "Tambien puedes revisar que tu conexion wifi sea estable"+"\n"+
                         "(Si la informacio fue util, ingresa el '1',sino fue util ingresa el '2')");
             }
             else if(obtener_texto.contains("quiero hablar con un tecnico") || obtener_texto.contains("contactame con un tecnico")){
                 bot("Claro,estas son las direcciones para contactarte con el tecnico"+"\n"+"Correo: armando_morales10@hotmail.com"+"\n"+"Whatsapp: +523221323344");
             }
             else if(obtener_texto.contains("gracias") || obtener_texto.contains("Gracia") || obtener_texto.contains("grasias")){
                 bot("De nada,espero haberte ayudado :)");
             } 
             else if(obtener_texto.contains("1")){
                 bot("Genial!!,me alegro haberte ayudado con tu problema :)"+"\n"+"Si tienes algun otro problema puedes consultarmelo");
             }
             else if(obtener_texto.contains("2")){
                 bot("Lamento no ser de ayuda para resolver tu problema, te muestro los contactos del"+"\n" +"tecnico para que te ayude con tu problema"+"\n"
                         +"Correo: armando_morales10@hotmail.com"+"\n"+"Whatsapp: +523221323344");
             }
             else if(obtener_texto.contains("tengo un problema al intentar agregar un cliente") || obtener_texto.contains("tengo un problema al intentar agregar un nuevo cliente")|| 
                     obtener_texto.contains("no puedo registrar un cliente")|| obtener_texto.contains("no puedo registrar un nuevo cliente")){
                 bot("Si tienes problemas al agregar un cliente, hay algunas cosas que puedes hacer:"+"\n"+"1-Reiniciar el software"+"\n"+
                         "2-Verificar que todas las casillas tengan los datos"+"\n"+"3-Verificar que la conexion wifi sea estable"+"\n"+
                         "Si la informacio fue util, ingresa el '1',sino fue util ingresa el '2')");
             }
             else if(obtener_texto.contains("tengo un problema al intentar agregar un usuario") || obtener_texto.contains("tengo un problema al intentar agregar un nuevo usuario")){
                 bot("Si tienes problemas al agregar un usuario, hay algunas cosas que puedes hacer:"+"\n"+"1-Reiniciar el software"+"\n"+
                         "2-Verificar que todas las casillas tengan los datos"+"\n"+"3-Verificar que la conexion wifi sea estable"+"\n"+
                         "Si la informacio fue util, ingresa el '1',sino fue util ingresa el '2')");
             }
             
             else if(obtener_texto.contains("no puedo agregar un usuario") || obtener_texto.contains("no puedo agregar un nuevo usuario")|| 
                     obtener_texto.contains("no puedo registrar un usuario")|| obtener_texto.contains("no puedo registrar un nuevo usuario")){
               bot("Si tienes problemas al agregar un usuario, hay algunas cosas que puedes hacer:"+"\n"+"1-Reiniciar el software"+"\n"+
                         "2-Verificar que todas las casillas tengan los datos"+"\n"+"3-Verificar que la conexion wifi sea estable"+"\n"+
                         "(Si la informacio fue util, ingresa el '1',sino fue util ingresa el '2')");
             }
             
             
             //Condiciones en desarrollo
             else if(obtener_texto.contains(".") || obtener_texto.contains(".")){
                 bot("Hola" + user + ", en que puedo ayudarte?");
             }
             else if(obtener_texto.contains(".") || obtener_texto.contains(".")){
                 bot("Hola" + user + ", en que puedo ayudarte?");
             }
             else if(obtener_texto.contains(".") || obtener_texto.contains(".")){
                 bot("Hola" + user + ", en que puedo ayudarte?");
             }
             
             else{
                 bot("Lo siento, no puedo entenderte :("+"\n"+"Revisa que hayas escrito de manera correcta");
             }
                 
       

            }
     
        
        });
    
    
    }//Fin del metodo logicaBot
    
 private void bot(String respuesta){
        Chat_Area.append("BOT-> " + respuesta + "\n"+"\n");
 }//Fin del metodo bot
 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Backgroung = new javax.swing.JPanel();
        Label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat_Area = new javax.swing.JTextArea();
        Text_Ingresado = new javax.swing.JTextField();
        Label_foot = new javax.swing.JLabel();
        Label_titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Backgroung.setBackground(new java.awt.Color(27, 27, 27));
        Panel_Backgroung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_titulo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        Label_titulo.setText("Ingresar");
        Panel_Backgroung.add(Label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, -1));

        Chat_Area.setBackground(new java.awt.Color(35, 35, 35));
        Chat_Area.setColumns(20);
        Chat_Area.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        Chat_Area.setForeground(new java.awt.Color(255, 255, 255));
        Chat_Area.setRows(5);
        Chat_Area.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(Chat_Area);

        Panel_Backgroung.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 760, 500));

        Text_Ingresado.setBackground(new java.awt.Color(255, 255, 255));
        Text_Ingresado.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Text_Ingresado.setForeground(new java.awt.Color(0, 0, 0));
        Text_Ingresado.setToolTipText("Ingrese aqui su problema");
        Text_Ingresado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Text_Ingresado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_IngresadoActionPerformed(evt);
            }
        });
        Panel_Backgroung.add(Text_Ingresado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 610, 47));

        Label_foot.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_foot.setForeground(new java.awt.Color(255, 255, 255));
        Label_foot.setText("Asistente virtual.  version: 1.0");
        Panel_Backgroung.add(Label_foot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        Label_titulo1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Label_titulo1.setForeground(new java.awt.Color(255, 255, 255));
        Label_titulo1.setText("Asistente");
        Panel_Backgroung.add(Label_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        getContentPane().add(Panel_Backgroung, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_IngresadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_IngresadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_IngresadoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chatbot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Chat_Area;
    private javax.swing.JLabel Label_foot;
    private javax.swing.JLabel Label_titulo;
    private javax.swing.JLabel Label_titulo1;
    private javax.swing.JPanel Panel_Backgroung;
    private javax.swing.JTextField Text_Ingresado;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
