package Operaciones;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class Logica {
    
    //Cambia el label alerta para indicar el estado del stock de un producto.
    //Se compara el stock actual del producto con el stock minimo requerido.
    public void alertaStock(JTable tablaProductos, JLabel alerta){
        int indice = tablaProductos.getSelectedRow();
        DefaultTableModel tm = (DefaultTableModel) tablaProductos.getModel();
        int stock = Integer.parseInt(tm.getValueAt(indice, 7).toString());
        int stock_minimo = Integer.parseInt(tm.getValueAt(indice, 10).toString());
        if (stock==0) {
            alerta.setForeground(new java.awt.Color(255, 0, 0));
            alerta.setText("No hay mas stock de este producto");
        }
        else if(stock<=stock_minimo){
            alerta.setForeground(new java.awt.Color(255, 0, 0));
            alerta.setText("Stock: critico. Se necesita restock");
        }
        else{
            alerta.setForeground(new java.awt.Color(0, 204, 51));
            alerta.setText("Stock: OK");
        }
    }
    
    //Devuelve la fecha actual
    public String obtenerFecha(){
        Date fecha = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fecha);
    }
    
    //Genera la factura de la venta
    public void imprimir(JTable tablaVenta, String precioTotal, int numeroFactura){
        try {
            DefaultTableModel tm = (DefaultTableModel) tablaVenta.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(tm);
            JasperReport jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/Factura/factura.jasper"));
            
            HashMap parametros = new HashMap<String, Object>();
            parametros.put("NumeroFactura", numeroFactura);
            parametros.put("Fecha", obtenerFecha());
            parametros.put("Total", precioTotal);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, ds);
            JasperViewer.viewReport(jp, false);
            
        } catch (JRException ex) {
            Logger.getLogger(OperacionesInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Genera la factura del registro de venta buscado
    public void imprimirRegistro(JTable tablaProductosVendidos, JTable tablaRegistros){
        try {
            int indice = tablaRegistros.getSelectedRow();
            DefaultTableModel tm = (DefaultTableModel) tablaProductosVendidos.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(tm);
            JasperReport jr = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/Factura/factura.jasper")); 
            
            HashMap parametros = new HashMap<String, Object>();
            parametros.put("NumeroFactura", tablaRegistros.getValueAt(indice, 0));
            parametros.put("Fecha", tablaRegistros.getValueAt(indice, 1));
            parametros.put("Total", tablaRegistros.getValueAt(indice, 5));
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros,ds);
            
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(OperacionesInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Pasa el codigo del producto y la cantidad de la tabla recibida a un HashMap
    public HashMap<String, Integer> hashMapStock (JTable tabla){
        HashMap<String, Integer> prueba = new HashMap();
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < tm.getRowCount(); i++) {
            prueba.put(tm.getValueAt(i, 0).toString(), Integer.parseInt(tm.getValueAt(i, 2).toString()));
        }
        return prueba;
    }
    
    //Agrega todos los productos del carrito de ventas recibido a un HashMap
    public HashMap<String, ArrayList<String>> hashMapVenta (JTable tabla){
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        HashMap<String, ArrayList<String>> listaVentas = new HashMap();
        for (int i = 0; i < tm.getRowCount(); i++) {
            ArrayList<String> a = new ArrayList();
            a.add(tm.getValueAt(i, 1).toString());
            a.add(tm.getValueAt(i, 2).toString());
            a.add(tm.getValueAt(i, 3).toString());
            a.add(tm.getValueAt(i, 4).toString());
            listaVentas.put(tm.getValueAt(i, 0).toString(), a);
        }
        return listaVentas;
    }
}
