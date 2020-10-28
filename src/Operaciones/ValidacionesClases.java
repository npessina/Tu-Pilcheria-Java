package Operaciones;

import Entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ValidacionesClases {
    
    //Verifica si los datos del producto son correctos y en caso de que se haya ingresado
    //algo mal, muestra un mensaje en pantalla
    public boolean ValidarProducto(Producto producto){
        if (ValidarNombre(producto.getNombre()) == false) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(producto.getPrecio()<=0){
            JOptionPane.showMessageDialog(null, "Error al ingresar el precio del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarCodigoProducto(producto.getCodigo()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el codigo del producto. Formato: 3 letras y 3 numeros. Ejemplo: CAL001", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(producto.getDescripcion().length()<1 || producto.getDescripcion().length()>50){
            JOptionPane.showMessageDialog(null, "Error al ingresar la descripcion del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(producto.getStock_minimo()<=0){
            JOptionPane.showMessageDialog(null, "Error al ingresar el stock minimo del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Verifica si los datos del cliente son correctos y en caso de que se haya ingresado
    //algo mal, muestra un mensaje en pantalla
    public boolean ValidarCliente(Cliente cliente){
        if (ValidarNombreClienteUsuario(cliente.getNombre()) == false) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el nombre del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarApellidoClienteUsuario(cliente.getApellido()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el apellido del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarDireccion(cliente.getDireccion()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar la direccion del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarTelefono(cliente.getTelefono()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el telefono del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarEmail(cliente.getEmail()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el email del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarDniCliente(cliente.getDni()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarFechaNacimientoCliente(cliente.getFecha_nacimiento()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar la fecha de nacimiento del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Verifica si los datos del proveedor son correctos y en caso de que se haya ingresado
    //algo mal, muestra un mensaje en pantalla
    public boolean ValidarProveedor(Proveedor proveedor){
        if (ValidarNombre(proveedor.getNombre()) == false) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el nombre del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarDireccion(proveedor.getDireccion()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar la direccion del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarTelefono(proveedor.getTelefono()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el telefono del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarEmail(proveedor.getEmail()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el email del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Verifica si los datos del usuario son correctos y en caso de que se haya ingresado
    //algo mal, muestra un mensaje en pantalla
    public boolean ValidarUsuario(Usuario usuario){
        if (ValidarNombreClienteUsuario(usuario.getNombre()) == false) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el nombre del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarApellidoClienteUsuario(usuario.getApellido()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el apellido del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarNombreUsuario(usuario.getUsuario()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el nombre de cuenta del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarContrasenia(usuario.getContrasenia()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar la contraseña de la cuenta del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(ValidarEmail(usuario.getEmail()) == false){
            JOptionPane.showMessageDialog(null, "Error al ingresar el email del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Devuelve un booleano indicando si el nombre del proveedor o el producto es correcto
    private boolean ValidarNombre(String nombre){
        Pattern patron = Pattern.compile("^[A-Za-z0-9\\ñ\\á\\é\\í\\ó\\ú\\Ñ\\Á\\É\\Í\\Ó\\Ú\\%\\/\\s]{3,40}$");
        Matcher m = patron.matcher(nombre);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el codigo del producto es correcto
    private boolean ValidarCodigoProducto(String codigo){
        Pattern patron = Pattern.compile("^[A-Z]{3}[0-9]{3}$");
        Matcher m = patron.matcher(codigo);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el nombre del cliente o el usuario es correcto
    private boolean ValidarNombreClienteUsuario(String nombre) {
        Pattern patron = Pattern.compile("^[A-Z][a-z\\ñ\\á\\é\\í\\ó\\ú]{2,13}$");
        Matcher m = patron.matcher(nombre);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el apellido del cliente o el usuario es correcto
    private boolean ValidarApellidoClienteUsuario(String apellido) {
        Pattern patron = Pattern.compile("^[A-Z][a-z\\ñ\\á\\é\\í\\ó\\ú]{2,13}$");
        Matcher m = patron.matcher(apellido);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si la direccion del proveedor o el cliente es correcta
    private boolean ValidarDireccion(String direccion) {
        Pattern patron = Pattern.compile("^[A-Za-z0-9\\ñ\\á\\é\\í\\ó\\ú\\Ñ\\Á\\É\\Í\\Ó\\.\\Ú\\s]{3,40}$");
        Matcher m = patron.matcher(direccion);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el telefono del proveedor o el cliente es correcto
    private boolean ValidarTelefono(String telefono) {
        Pattern patron = Pattern.compile("\\d{6,15}");
        Matcher m = patron.matcher(telefono);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el email del proveedor, cliente o usuario es correcto
    private boolean ValidarEmail(String email) {
        Pattern patron = Pattern.compile("^([\\w\\.\\-\\_]+)?\\w+@[\\w\\-\\_]+(\\.\\w+)+$");
        Matcher m = patron.matcher(email);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si el DNI del cliente es correcto
    private boolean ValidarDniCliente(String dni) {
        Pattern patron = Pattern.compile("\\d{8}");
        Matcher m = patron.matcher(dni);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si la fecha de nacimiento del cliente es correcta
    private boolean ValidarFechaNacimientoCliente(String fecha_nacimiento) {
        Pattern patron = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher m = patron.matcher(fecha_nacimiento);
        
        if (m.find() && esFecha(fecha_nacimiento)) {
            return true;
        }
        else{
            return false;
        }
    }   
    
    //Verifica si el String recibido es fecha o no
    private boolean esFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        try {
            formatoFecha.parse(fecha);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    
    //Devuelve un booleano indicando si el nombre de cuenta del usuario es correcta
    private boolean ValidarNombreUsuario(String nombre_usuario) {
        Pattern patron = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_]{3,32}$");
        Matcher m = patron.matcher(nombre_usuario);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    //Devuelve un booleano indicando si la contraseña de la cuenta del usuario es correcta
    private boolean ValidarContrasenia(String contrasenia) {
        Pattern patron = Pattern.compile("^[a-zA-Z0-9-_/]{3,32}$");
        Matcher m = patron.matcher(contrasenia);
        
        if (m.find()) {
            return true;
        }
        else{
            return false;
        }
    }
}
