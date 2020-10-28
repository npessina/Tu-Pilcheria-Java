package Operaciones;

import Entidades.*;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class OperacionesClases {
    
    //Instancia un objeto de tipo producto. Se verifica que el precio sea un numero.
    public Producto crearProducto(String nombre, String codigo, String categoria, String descripcion, String talle, String precio, String proveedor, String stock_minimo){
        Pattern patron = Pattern.compile("^\\d*\\.?\\d+$");
        Matcher m = patron.matcher(precio);
        if (m.find()==false) {
            precio="0";
        }
        
        patron = Pattern.compile("^\\d+$");
        m = patron.matcher(stock_minimo);
        if (m.find()==false) {
            stock_minimo="0";
        }

        Producto producto;
        switch (categoria) {
            case "Ropa Parte Superior":
                producto = new Ropa(codigo, nombre, descripcion, parseFloat(precio), Ropa.tipoRopa.ParteSuperior, talle, proveedor, parseInt(stock_minimo));
                break;
            case "Ropa Parte Inferior":
                producto = new Ropa(codigo, nombre, descripcion, parseFloat(precio), Ropa.tipoRopa.ParteInferior, talle, proveedor, parseInt(stock_minimo));
                break;
            case "Ropa Interior":
                producto = new Ropa(codigo, nombre, descripcion, parseFloat(precio), Ropa.tipoRopa.RopaInterior, talle, proveedor, parseInt(stock_minimo));
                break;
            case "Calzado":
                producto = new Calzado(codigo, nombre, descripcion, parseFloat(precio), talle, proveedor, parseInt(stock_minimo));
                break;
            default:
                producto = new Accesorio(codigo, nombre, descripcion, parseFloat(precio), proveedor, parseInt(stock_minimo));
                break;
        }
        return producto;
    }
    
    //Instancia un objeto de tipo cliente
    public Cliente crearCliente(String nombre, String apellido, String direccion, String dni, String telefono, String email, String fecha_nacimiento){
        Cliente cliente = new Cliente(nombre, apellido, direccion, telefono, email, dni, fecha_nacimiento);
        
        return cliente;
    }
    
    //Instancia un objeto de tipo proveedor
    public Proveedor crearProveedor(String nombre, String direccion, String telefono, String email){
        Proveedor proveedor = new Proveedor(nombre, direccion, telefono, email);
        
        return proveedor;
    }
    
    //Instancia un objeto de tipo usuario
    public Usuario crearUsuario(String nombre, String apellido, String usuario, String contrasenia, String email){
        Usuario user = new Usuario(nombre, apellido, usuario, contrasenia, email);
        
        return user;
    }
}
