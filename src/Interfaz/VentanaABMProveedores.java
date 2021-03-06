package Interfaz;

import Datos.OperacionesBaseDeDatos;
import Entidades.Proveedor;
import Operaciones.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class VentanaABMProveedores extends javax.swing.JFrame {

    //Usados para llamar a los metodos de dichas clases
    OperacionesBaseDeDatos opBdd = new OperacionesBaseDeDatos();
    OperacionesInterfaz opInterfaz = new OperacionesInterfaz();
    OperacionesClases opClases = new OperacionesClases();
    ValidacionesClases validacionClase = new ValidacionesClases();
    
    //Variable usada para abrir la ventana
    private static VentanaABMProveedores ventana=null;
    
    public VentanaABMProveedores() {
        initComponents();
        //Evita que se cierre el programa cuando se cierra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Evita que se pueda ingresar o cambiar la id en el textfield
        txtID.setEnabled(false);
    }
    
    //Metodo usado para abrir la ventana. Evita que se abran multiples ventanas del mismo tipo
    public static VentanaABMProveedores obtenerVentanaProveedores(){
        if (ventana==null) {
            ventana = new VentanaABMProveedores();
        }
        return ventana;
    }
    
    //Vacia los textfield en la pestaña Modificar/Baja
    public void vaciarModificar(){
        txtID.setText("");
        txtModificarNombre.setText("");
        txtModificarDireccion.setText("");
        txtModificarEmail.setText("");
        txtModificarTelefono.setText("");
    }
    
    //Vacia los textfield en la pestaña Nuevo
    public void vaciarNuevo(){
        txtNuevoNombre.setText("");
        txtNuevaDireccion.setText("");
        txtNuevoEmail.setText("");
        txtNuevoTelefono.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuProveedores = new javax.swing.JTabbedPane();
        panelNuevoCliente = new javax.swing.JPanel();
        labelNuevoNombre = new javax.swing.JLabel();
        labelNuevaDireccion = new javax.swing.JLabel();
        labelNuevoTelefono = new javax.swing.JLabel();
        labelNuevoEmail = new javax.swing.JLabel();
        txtNuevoNombre = new javax.swing.JTextField();
        txtNuevaDireccion = new javax.swing.JTextField();
        txtNuevoTelefono = new javax.swing.JTextField();
        txtNuevoEmail = new javax.swing.JTextField();
        btnGuardarProveedorNuevo = new javax.swing.JButton();
        btnVaciarNuevo = new javax.swing.JButton();
        panelModificarCliente = new javax.swing.JPanel();
        btnBuscarProveedor = new javax.swing.JButton();
        txtModificarDireccion = new javax.swing.JTextField();
        btnModificarProveedor = new javax.swing.JButton();
        labelModificarNombre = new javax.swing.JLabel();
        txtModificarEmail = new javax.swing.JTextField();
        txtModificarTelefono = new javax.swing.JTextField();
        labelModificarDirecccion = new javax.swing.JLabel();
        btnGuardarProveedorModificado = new javax.swing.JButton();
        labelModificarTelefono = new javax.swing.JLabel();
        labelModificarEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBuscarProveedores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        txtModificarNombre = new javax.swing.JTextField();
        txtBuscarProveedor = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        labelModificarEstado = new javax.swing.JLabel();
        btnVaciarModificacion = new javax.swing.JButton();
        labelBuscarNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABM Proveedores");
        setResizable(false);

        labelNuevoNombre.setText("Nombre");

        labelNuevaDireccion.setText("Direccion");

        labelNuevoTelefono.setText("Telefono");

        labelNuevoEmail.setText("Email");

        btnGuardarProveedorNuevo.setText("Guardar");
        btnGuardarProveedorNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorNuevoActionPerformed(evt);
            }
        });

        btnVaciarNuevo.setText("Vaciar campos");
        btnVaciarNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNuevoClienteLayout = new javax.swing.GroupLayout(panelNuevoCliente);
        panelNuevoCliente.setLayout(panelNuevoClienteLayout);
        panelNuevoClienteLayout.setHorizontalGroup(
            panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevoClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNuevoNombre)
                    .addComponent(labelNuevaDireccion))
                .addGap(25, 25, 25)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNuevoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(txtNuevaDireccion))
                .addGap(71, 71, 71)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNuevoTelefono)
                    .addComponent(labelNuevoEmail))
                .addGap(18, 18, 18)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevoClienteLayout.createSequentialGroup()
                        .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNuevoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNuevoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNuevoClienteLayout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addComponent(btnVaciarNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarProveedorNuevo)
                        .addGap(39, 39, 39))))
        );
        panelNuevoClienteLayout.setVerticalGroup(
            panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevoClienteLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNuevoNombre)
                    .addComponent(txtNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuevoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNuevoTelefono))
                .addGap(26, 26, 26)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNuevoEmail)
                    .addComponent(txtNuevaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNuevaDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(panelNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVaciarNuevo)
                    .addComponent(btnGuardarProveedorNuevo))
                .addGap(34, 34, 34))
        );

        menuProveedores.addTab("Nuevo", panelNuevoCliente);

        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        labelModificarNombre.setText("Nombre");

        labelModificarDirecccion.setText("Direccion");

        btnGuardarProveedorModificado.setText("Guardar");
        btnGuardarProveedorModificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorModificadoActionPerformed(evt);
            }
        });

        labelModificarTelefono.setText("Telefono");

        labelModificarEmail.setText("Email");

        tablaBuscarProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Teléfono", "Email", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBuscarProveedores);
        if (tablaBuscarProveedores.getColumnModel().getColumnCount() > 0) {
            tablaBuscarProveedores.getColumnModel().getColumn(0).setMaxWidth(35);
            tablaBuscarProveedores.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        labelID.setText("ID");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitado", "Deshabilitado" }));

        labelModificarEstado.setText("Estado");

        btnVaciarModificacion.setText("Vaciar campos");
        btnVaciarModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarModificacionActionPerformed(evt);
            }
        });

        labelBuscarNombre.setText("Nombre");

        javax.swing.GroupLayout panelModificarClienteLayout = new javax.swing.GroupLayout(panelModificarCliente);
        panelModificarCliente.setLayout(panelModificarClienteLayout);
        panelModificarClienteLayout.setHorizontalGroup(
            panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelModificarEmail)
                            .addComponent(labelID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                        .addComponent(txtModificarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelModificarTelefono))
                                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                        .addComponent(txtModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelModificarDirecccion)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                        .addComponent(txtModificarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                        .addComponent(txtModificarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarProveedor)
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addComponent(labelBuscarNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarProveedor)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addComponent(labelModificarEstado)
                                .addGap(18, 18, 18)
                                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarClienteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVaciarModificacion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarProveedorModificado)
                        .addGap(48, 48, 48))))
        );
        panelModificarClienteLayout.setVerticalGroup(
            panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor)
                    .addComponent(labelBuscarNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarProveedor)
                .addGap(12, 12, 12)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModificarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelModificarDirecccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModificarTelefono)
                    .addComponent(txtModificarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelModificarEmail)
                    .addComponent(txtModificarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModificarEstado)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVaciarModificacion)
                    .addComponent(btnGuardarProveedorModificado))
                .addGap(53, 53, 53))
        );

        menuProveedores.addTab("Modificar / Baja", panelModificarCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuProveedores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Boton que busca los proveedores en la base de datos que cumplan con los terminos
    //de busqueda y los agrega a la tabla de proveedores
    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        opInterfaz.llenarTabla(opBdd.buscarProveedor(txtBuscarProveedor.getText()), tablaBuscarProveedores);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    //Boton que carga los campos textfield con los datos del proveedor seleccionado en la tabla
    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        if (tablaBuscarProveedores.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No se selecciono ningún proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            opInterfaz.llenarCamposProveedor(tablaBuscarProveedores, txtID, txtModificarNombre, txtModificarDireccion, txtModificarTelefono, txtModificarEmail, comboEstado);
        }
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    //Boton que guarda el proveedor modificado en la base de datos
    private void btnGuardarProveedorModificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorModificadoActionPerformed
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Proveedor proveedor = opClases.crearProveedor(txtModificarNombre.getText(), txtModificarDireccion.getText(), txtModificarTelefono.getText(), txtModificarEmail.getText());
            if (validacionClase.ValidarProveedor(proveedor)) {
                int eleccion = JOptionPane.showConfirmDialog(null, "¿Actualizar proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (eleccion == JOptionPane.YES_OPTION) {
                    if (opBdd.guardarProveedorModificado(proveedor, comboEstado.getSelectedItem().toString(), txtID.getText())) {
                        JOptionPane.showMessageDialog(null, "Este proveedor ya existe. Seleccione otro nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Datos actualizados");
                        vaciarModificar();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarProveedorModificadoActionPerformed

    //Boton que vacia los campos de los textfield en la pestaña Modificar/Baja
    private void btnVaciarModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarModificacionActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea vaciar los campos?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (eleccion == JOptionPane.YES_OPTION) {
            vaciarModificar();
        }
    }//GEN-LAST:event_btnVaciarModificacionActionPerformed

    //Boton que vacia los campos de los textfield en la pestaña Nuevo
    private void btnVaciarNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarNuevoActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea vaciar los campos?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (eleccion == JOptionPane.YES_OPTION) {
            vaciarNuevo();
        }
    }//GEN-LAST:event_btnVaciarNuevoActionPerformed

    //Boton que guarda el proveedor nuevo en la base de datos
    private void btnGuardarProveedorNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorNuevoActionPerformed
        if (txtNuevoNombre.getText().equals("") || txtNuevaDireccion.getText().equals("") || txtNuevoTelefono.getText().equals("") || txtNuevoEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Proveedor proveedor = opClases.crearProveedor(txtNuevoNombre.getText(), txtNuevaDireccion.getText(), txtNuevoTelefono.getText(), txtNuevoEmail.getText());
            if (validacionClase.ValidarProveedor(proveedor)) {
                int eleccion = JOptionPane.showConfirmDialog(null, "¿Guardar proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (eleccion == JOptionPane.YES_OPTION) {
                    if (opBdd.guardarProveedorNuevo(proveedor)) {
                        JOptionPane.showMessageDialog(null, "Este proveedor ya existe. Seleccione otro nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Datos guardados");
                        vaciarNuevo();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarProveedorNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaABMProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaABMProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaABMProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaABMProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaABMProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnGuardarProveedorModificado;
    private javax.swing.JButton btnGuardarProveedorNuevo;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnVaciarModificacion;
    private javax.swing.JButton btnVaciarNuevo;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscarNombre;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelModificarDirecccion;
    private javax.swing.JLabel labelModificarEmail;
    private javax.swing.JLabel labelModificarEstado;
    private javax.swing.JLabel labelModificarNombre;
    private javax.swing.JLabel labelModificarTelefono;
    private javax.swing.JLabel labelNuevaDireccion;
    private javax.swing.JLabel labelNuevoEmail;
    private javax.swing.JLabel labelNuevoNombre;
    private javax.swing.JLabel labelNuevoTelefono;
    private javax.swing.JTabbedPane menuProveedores;
    private javax.swing.JPanel panelModificarCliente;
    private javax.swing.JPanel panelNuevoCliente;
    private javax.swing.JTable tablaBuscarProveedores;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtModificarDireccion;
    private javax.swing.JTextField txtModificarEmail;
    private javax.swing.JTextField txtModificarNombre;
    private javax.swing.JTextField txtModificarTelefono;
    private javax.swing.JTextField txtNuevaDireccion;
    private javax.swing.JTextField txtNuevoEmail;
    private javax.swing.JTextField txtNuevoNombre;
    private javax.swing.JTextField txtNuevoTelefono;
    // End of variables declaration//GEN-END:variables
}
