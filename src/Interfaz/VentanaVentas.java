package Interfaz;

import Datos.OperacionesBaseDeDatos;
import javax.swing.JFrame;
import Operaciones.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class VentanaVentas extends javax.swing.JFrame {

    //Usados para llamar a los metodos de dichas clases
    OperacionesBaseDeDatos opBdd = new OperacionesBaseDeDatos();
    OperacionesInterfaz opInterfaz = new OperacionesInterfaz();
    Logica log = new Logica();
    
    //Variable usada para abrir la ventana
    private static VentanaVentas ventana=null;
    //Variable que guarda el nombre de usuario
    private String nombreUsuario;

    public VentanaVentas() {
        initComponents();
        //Evita que se cierre el programa cuando se cierra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public VentanaVentas(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        initComponents();
        //Evita que se cierre el programa cuando se cierra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //Metodo usado para abrir la ventana. Evita que se abran multiples ventanas del mismo tipo
    public static VentanaVentas obtenerVentanaVentas(String nombreUsuario){
        if (ventana==null) {
            ventana = new VentanaVentas(nombreUsuario);
        }
        return ventana;
    }
    
    //Verifica si la cantidad ingresada es un numero
    public void validarCantidad(){
        Pattern patron = Pattern.compile("^\\d*$");
        Matcher m = patron.matcher(txtCantidad.getText());
        
        if (m.find()==false || txtCantidad.getText().isEmpty()) {
            txtCantidad.setText("");
            nombreUsuario="";
        }
    }
    
    //Vacia la tabla de venta
    public void vaciar(){
        DefaultTableModel tm = (DefaultTableModel) tablaCarrito.getModel();
        txtPrecioTotal.setText("0");
        tm.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentas = new javax.swing.JPanel();
        labelDNICliente = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        btnBuscarProducto = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        comboBuscarProducto = new javax.swing.JComboBox<>();
        btnAgregarProducto = new javax.swing.JButton();
        labelCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBuscarProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        btnGenerarVenta = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        labelPrecioTotal = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();
        txtDNICliente = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        labelVerificacion = new javax.swing.JLabel();
        labelAlertaStock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nueva venta");
        setResizable(false);

        labelDNICliente.setText("DNI Cliente");

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaCarrito);

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        comboBuscarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre" }));

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        labelCantidad.setText("Cantidad");

        tablaBuscarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Nombre", "Categoría", "Descripción", "Talle", "Precio", "Stock", "Stock minimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaBuscarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBuscarProductosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaBuscarProductos);

        btnGenerarVenta.setText("Generar venta");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        labelPrecioTotal.setText("Total    $");

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setText("0");

        btnVerificar.setText("Verificar existencia");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                        .addComponent(btnEliminarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVentasLayout.createSequentialGroup()
                                .addComponent(comboBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarProducto))
                            .addGroup(panelVentasLayout.createSequentialGroup()
                                .addComponent(labelDNICliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btnVerificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevoCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelVerificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 152, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerarVenta))
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addComponent(labelCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAlertaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVentasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVerificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDNICliente)
                        .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVerificar)
                        .addComponent(btnNuevoCliente)))
                .addGap(18, 18, 18)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(comboBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarProducto)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCantidad))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAlertaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPrecioTotal)
                        .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta)
                .addContainerGap())
            .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVentasLayout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );

        txtPrecioTotal.setHorizontalAlignment(JTextField.RIGHT);
        labelAlertaStock.setHorizontalAlignment(JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Abre la ventana ABM Clientes
    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        VentanaABMClientes.obtenerVentanaClientes().setVisible(true);
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    //Verifica si el cliente existe y muestra un mensaje
    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        if (opBdd.verificarExistenciaDNI(txtDNICliente.getText())) {
            labelVerificacion.setText("Cliente encontrado");
        }
        else{
            labelVerificacion.setText("El cliente no existe o esta deshabilitado");
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    //Elimina un producto de la tabla de venta
    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (tablaCarrito.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No se selecciono ningún producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            opInterfaz.eliminarProductoPedidos(tablaCarrito, txtPrecioTotal);
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    //Confirma la compra. Guarda el registro de venta, todos los productos vendidos, actualiza el stock
    //y genera la factura.
    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        if (opBdd.verificarExistenciaDNI(txtDNICliente.getText())) {
            if (tablaCarrito.getRowCount()==0) {
                JOptionPane.showMessageDialog(null, "La tabla esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int eleccion = JOptionPane.showConfirmDialog(null, "¿Generar venta?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (eleccion == JOptionPane.YES_OPTION) {
                    opBdd.guardarRegistroVenta(log.obtenerFecha(), nombreUsuario, txtPrecioTotal.getText(), txtDNICliente.getText());
                    opBdd.guardarRegistroProductosVendidos(log.hashMapVenta(tablaCarrito));
                    if (opBdd.actualizarStockVenta(log.hashMapStock(tablaCarrito))) {
                        JOptionPane.showMessageDialog(null, "Venta completada");
                    }
                    log.imprimir(tablaCarrito, txtPrecioTotal.getText(), opBdd.obtenerUltimoID());
                    vaciar();  
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El cliente no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    //Agrega el producto seleccionado de la tabla de productos y la cantidad a la tabla de venta
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if (tablaBuscarProductos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No se selecciono ningún producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            validarCantidad();
            if (txtCantidad.getText().equals("") || txtCantidad.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Error al ingresar la cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if (opInterfaz.agregarATablaVenta(tablaBuscarProductos, tablaCarrito, Integer.parseInt(txtCantidad.getText()),
                        opInterfaz.verificarExistenciaCodigoTabla(tablaBuscarProductos, tablaCarrito))) {
                    opInterfaz.obtenerPrecioTotal(tablaBuscarProductos, tablaCarrito, txtPrecioTotal, txtCantidad);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    //Boton que busca los productos en la base de datos que cumplan con los terminos
    //de busqueda y los agrega a la tabla de productos
    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        opInterfaz.llenarTabla(opBdd.buscarProductoVentas(txtBuscarProducto.getText(),
            comboBuscarProducto.getSelectedItem().toString().toLowerCase()), tablaBuscarProductos);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    //Muestra un mensaje con el estado del stock del producto seleccionado en la tabla
    private void tablaBuscarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBuscarProductosMouseClicked
        log.alertaStock(tablaBuscarProductos, labelAlertaStock);
    }//GEN-LAST:event_tablaBuscarProductosMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> comboBuscarProducto;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelAlertaStock;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelDNICliente;
    private javax.swing.JLabel labelPrecioTotal;
    private javax.swing.JLabel labelVerificacion;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTable tablaBuscarProductos;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
