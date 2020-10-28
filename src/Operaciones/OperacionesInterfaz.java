package Operaciones;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author User
 */
public class OperacionesInterfaz {
    
    
    //Llena la JTable con la lista de elementos recibida
    public void llenarTabla(ArrayList lista, JTable tabla){
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel tm=(DefaultTableModel) tabla.getModel();
        tm.setRowCount(0);
        lista.forEach((elemento) -> {
            tm.addRow((String[]) elemento);
        });
    }
    
    //Agrega productos a la tabla de pedidos en base al producto seleccionado en la tabla y la cantidad ingresada
    public void llenarTablaPedidos(JTable tablaProductos, JTable tablaPedidos, int cantidad, int indiceExistencia){
        tablaPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int indice = tablaProductos.getSelectedRow();
        DefaultTableModel tmProducto = (DefaultTableModel) tablaProductos.getModel();
        DefaultTableModel tmPedido = (DefaultTableModel) tablaPedidos.getModel();
        int cantidadTablaPedido = 0;
        float subtotal = 0;
        
        if (indiceExistencia==-1) {
            subtotal = Float.parseFloat(tmProducto.getValueAt(indice, 6).toString()) * cantidad;
            String[] pedido = {tmProducto.getValueAt(indice, 1).toString(), tmProducto.getValueAt(indice, 2).toString(),
                Integer.toString(cantidad), tmProducto.getValueAt(indice, 6).toString(), Float.toString(subtotal)};
            tmPedido.addRow(pedido);
        }
        else{
            cantidadTablaPedido = Integer.parseInt(tmPedido.getValueAt(indiceExistencia, 2).toString());
            subtotal = (Float.parseFloat(tmProducto.getValueAt(indice, 6).toString()) * cantidad) + Float.parseFloat(tmPedido.getValueAt(indiceExistencia, 4).toString());
                tmPedido.setValueAt(cantidad+cantidadTablaPedido, indiceExistencia, 2);
                tmPedido.setValueAt(subtotal, indiceExistencia, 4);
        }
    }
    
    //Llena el comboBox con los nombres de los proveedores que estan en la lista recibida
    public void llenarComboProveedores(ArrayList listaProveedores, JComboBox comboProveedores){
        comboProveedores.removeAllItems();
        listaProveedores.forEach((proveedor) -> {
            comboProveedores.addItem(proveedor);
        });
    }
    
    //Llena los campos de los TextField recibidos con los datos cargados en la tabla de productos
    public void llenarCamposProducto(JTable tablaProductos, JTextField id, JTextField codigo, JTextField nombre, JComboBox comboCategoria,
            JTextField descripcion, JComboBox comboTalle, JTextField precio, JComboBox comboEstado, JComboBox comboProveedor, JTextField stockMinimo){
        DefaultTableModel tm=(DefaultTableModel) tablaProductos.getModel();
        int indice = tablaProductos.getSelectedRow();

        id.setText(tm.getValueAt(indice, 0).toString());
        codigo.setText(tm.getValueAt(indice, 1).toString());
        nombre.setText(tm.getValueAt(indice, 2).toString());
        comboCategoria.setSelectedItem(tm.getValueAt(indice, 3).toString());
        descripcion.setText(tm.getValueAt(indice, 4).toString());
        precio.setText(tm.getValueAt(indice, 6).toString());
        llenarComboTalle(comboTalle, tm.getValueAt(indice, 3).toString());
        comboTalle.setSelectedItem(tm.getValueAt(indice, 5).toString());
        comboEstado.setSelectedItem(tm.getValueAt(indice, 8).toString());
        comboProveedor.setSelectedItem(tm.getValueAt(indice, 9).toString());
        stockMinimo.setText(tm.getValueAt(indice, 10).toString());
    }
    
    //Llena los campos de los TextField recibidos con los datos cargados en la tabla de usuarios
    public void llenarCamposUsuario(JTable tablaUsuarios, JTextField id, JTextField nombre, JTextField apellido, JTextField usuario, JTextField contrasenia, JTextField email, JComboBox comboEstado){

        DefaultTableModel tm=(DefaultTableModel) tablaUsuarios.getModel();
        int indice = tablaUsuarios.getSelectedRow();

        id.setText(tm.getValueAt(indice, 0).toString());
        nombre.setText(tm.getValueAt(indice, 1).toString());
        apellido.setText(tm.getValueAt(indice, 2).toString());
        usuario.setText(tm.getValueAt(indice, 3).toString());
        contrasenia.setText(tm.getValueAt(indice, 4).toString());
        email.setText(tm.getValueAt(indice, 5).toString());
        comboEstado.setSelectedItem(tm.getValueAt(indice, 6).toString());
    }
    
    //Agrega items al comboBox talle dependiendo de la categoria de producto seleccionada
    public void llenarComboTalle(JComboBox comboTalle, String categoria){
        comboTalle.setEnabled(true);
        switch (categoria) {
            case "Ropa Parte Superior":
            case "Ropa Interior":
            comboTalle.removeAllItems();
            comboTalle.addItem("S");
            comboTalle.addItem("M");
            comboTalle.addItem("L");
            comboTalle.addItem("XL");
            break;
            case "Ropa Parte Inferior":
            comboTalle.removeAllItems();
            comboTalle.addItem("36");
            comboTalle.addItem("38");
            comboTalle.addItem("40");
            comboTalle.addItem("42");
            comboTalle.addItem("44");
            comboTalle.addItem("46");
            comboTalle.addItem("48");
            break;
            case "Calzado":
            comboTalle.removeAllItems();
            comboTalle.addItem("35");
            comboTalle.addItem("36");
            comboTalle.addItem("37");
            comboTalle.addItem("38");
            comboTalle.addItem("39");
            comboTalle.addItem("40");
            comboTalle.addItem("41");
            comboTalle.addItem("42");
            comboTalle.addItem("43");
            comboTalle.addItem("44");
            comboTalle.addItem("45");
            break;
            default:
            comboTalle.removeAllItems();
            comboTalle.setEnabled(false);
            break;
        }
    }   
    
    //Llena los campos de los TextField recibidos con los datos cargados en la tabla de clientes
    public void llenarCamposCliente(JTable tablaProductos, JTextField id, JTextField nombre, JTextField apellido,
            JTextField dni, JTextField direccion, JTextField telefono, JTextField email, JTextField fecha_nacimiento, JComboBox comboEstado){

        DefaultTableModel tm=(DefaultTableModel) tablaProductos.getModel();
        int indice = tablaProductos.getSelectedRow();

        id.setText(tm.getValueAt(indice, 0).toString());
        nombre.setText(tm.getValueAt(indice, 1).toString());
        apellido.setText(tm.getValueAt(indice, 2).toString());
        dni.setText(tm.getValueAt(indice, 3).toString());
        direccion.setText(tm.getValueAt(indice, 4).toString());
        telefono.setText(tm.getValueAt(indice, 5).toString());
        email.setText(tm.getValueAt(indice, 6).toString());
        fecha_nacimiento.setText(tm.getValueAt(indice, 7).toString());
        comboEstado.setSelectedItem(tm.getValueAt(indice, 8).toString());
    }
    
    //Llena los campos de los TextField recibidos con los datos cargados en la tabla de proveedores
    public void llenarCamposProveedor(JTable tablaProveedores, JTextField id, JTextField nombre, JTextField direccion, JTextField telefono, JTextField email, JComboBox comboEstado){

        DefaultTableModel tm=(DefaultTableModel) tablaProveedores.getModel();
        int indice = tablaProveedores.getSelectedRow();

        id.setText(tm.getValueAt(indice, 0).toString());
        nombre.setText(tm.getValueAt(indice, 1).toString());
        direccion.setText(tm.getValueAt(indice, 2).toString());
        telefono.setText(tm.getValueAt(indice, 3).toString());
        email.setText(tm.getValueAt(indice, 4).toString());
        comboEstado.setSelectedItem(tm.getValueAt(indice, 5).toString());
    }
    
    //Calcula el precio total del pedido o venta
    public void obtenerPrecioTotal(JTable tablaProductos, JTable tablaPedidos, JTextField precioTotal, JTextField cantidad){
        float total = 0;
        int indice = tablaProductos.getSelectedRow();
        int cant = Integer.parseInt(cantidad.getText());
        DefaultTableModel tmProducto=(DefaultTableModel) tablaProductos.getModel();
        DefaultTableModel tmPedido=(DefaultTableModel) tablaPedidos.getModel();
        total = Float.parseFloat(precioTotal.getText()) + (Float.parseFloat(tmProducto.getValueAt(indice, 6).toString()) * cant);
        precioTotal.setText(Float.toString(total));  
    }
    
    //Elimina un producto de la lista de pedidos
    public void eliminarProductoPedidos(JTable tablaPedidos, JTextField precioTotal){
        int indice = tablaPedidos.getSelectedRow();
        float total = 0;
        DefaultTableModel tm = (DefaultTableModel) tablaPedidos.getModel();
        total = Float.parseFloat(precioTotal.getText()) - Float.parseFloat(tm.getValueAt(indice, 4).toString());
        precioTotal.setText(Float.toString(total));
        tm.removeRow(indice); 
    }
    
    //Verifica si el codigo del producto seleccionado ya existe en la tabla de pedidos
    //y si lo encuentra devuelve el indice donde esta guardado, en caso de 
    //no encontrarlo devuelve -1
    public int verificarExistenciaCodigoTabla(JTable tablaProductos, JTable tablaDestino){
        int indiceExistencia = -1;
        int indice = tablaProductos.getSelectedRow();
        DefaultTableModel tmProducto = (DefaultTableModel) tablaProductos.getModel();
        DefaultTableModel tmPedido = (DefaultTableModel) tablaDestino.getModel();
        String codigoTablaProductos = tmProducto.getValueAt(indice, 1).toString();
        String codigoTablaPedidos = "";
        
        for (int i = 0; i < tmPedido.getRowCount(); i++) {
            codigoTablaPedidos = tmPedido.getValueAt(i, 0).toString();
            if (codigoTablaProductos.equals(codigoTablaPedidos)) {
                indiceExistencia = i;
                break;
            }
        }
        
        return indiceExistencia;
    }
    
    //Agrega a la tabla de ventas el producto seleccionado y la cantidad a vender
    //Si el producto ya esta en la lista, solo se agrega la cantidad y se calcula el subtotal
    public boolean agregarATablaVenta(JTable tablaProductos, JTable tablaVenta, int cantidad, int indiceExistencia){
        tablaVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int indice = tablaProductos.getSelectedRow();
        DefaultTableModel tmProducto = (DefaultTableModel) tablaProductos.getModel();
        DefaultTableModel tmPedido = (DefaultTableModel) tablaVenta.getModel();
        int stock = Integer.parseInt(tmProducto.getValueAt(indice, 7).toString());
        int cantidadTablaPedido = 0;
        float subtotal = 0;
        boolean exito = false;

        if (indiceExistencia == -1) {
            if (cantidad<=stock) {
                subtotal = Float.parseFloat(tmProducto.getValueAt(indice, 6).toString()) * cantidad;
                String[] pedido = {tmProducto.getValueAt(indice, 1).toString(), tmProducto.getValueAt(indice, 2).toString(),
                    Integer.toString(cantidad), tmProducto.getValueAt(indice, 6).toString(), Float.toString(subtotal)};
                
                tmPedido.addRow(pedido);
                exito = true;
            }
            else{
                JOptionPane.showMessageDialog(null, "La cantidad solicitada es mayor al stock.", "Error", JOptionPane.ERROR_MESSAGE);
                exito = false;
            }   
        }
        else{
            cantidadTablaPedido = Integer.parseInt(tmPedido.getValueAt(indiceExistencia, 2).toString());
            if ((cantidad+cantidadTablaPedido)<=stock) {
                subtotal = (Float.parseFloat(tmProducto.getValueAt(indice, 6).toString()) * cantidad) + Float.parseFloat(tmPedido.getValueAt(indiceExistencia, 4).toString());
                tmPedido.setValueAt(cantidad+cantidadTablaPedido, indiceExistencia, 2);
                tmPedido.setValueAt(subtotal, indiceExistencia, 4);
                
                exito = true;
            } 
            else{
                JOptionPane.showMessageDialog(null, "La cantidad solicitada es mayor al stock.", "Error", JOptionPane.ERROR_MESSAGE);
                exito = false;
            } 
        }    
        return exito;
    }
}
