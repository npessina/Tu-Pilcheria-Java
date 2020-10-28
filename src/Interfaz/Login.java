package Interfaz;

import Datos.OperacionesBaseDeDatos;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    OperacionesBaseDeDatos opBdd = new OperacionesBaseDeDatos();
    
    public Login() {
        initComponents();
        //Crea un administrador si no existe
        opBdd.crearAdminPorDefecto();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        labelContrasenia = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        labelUsuario.setText("Usuario");

        labelContrasenia.setText("Contraseña");

        btnIngresar.setText("Ingresar");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelContrasenia, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContrasenia)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnIngresar)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Verifica si el usuario y la contraseña son validos y dependiendo de
    //si el usuario es de tipo Administrador o de tipo Usuario se abriran
    //distintas ventanas de inicio
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingreso el nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String tipoUsuario = opBdd.buscarUsuarioIngresado(txtUsuario.getText(), txtContrasenia.getText());
            if (tipoUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Error de login", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if (tipoUsuario.equals("Administrador")) {
                    this.dispose();
                    InicioAdmin inicioAdmin = new InicioAdmin(txtUsuario.getText());
                    inicioAdmin.setVisible(true);
                }
                else if (tipoUsuario.equals("Usuario")) {
                    this.dispose();
                    Inicio inicioUsuario = new Inicio(txtUsuario.getText());
                    inicioUsuario.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelContrasenia;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}