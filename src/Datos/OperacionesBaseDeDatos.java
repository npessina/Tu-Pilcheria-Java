package Datos;
import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;


public class OperacionesBaseDeDatos {
    //Conexion
    private Conectar con=new Conectar();
    private Connection cn=con.conectar();
    
    
    //Metodos relacionados con los productos
    
    //Busca en la base de datos y devuelve una lista de productos usando el codigo o nombre de producto ingresado
    public ArrayList buscarProducto(String textoBuscar, String seleccion){
        ArrayList lista_productos = new ArrayList();
        
        try{
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos");
           ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `productos`");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock"), rs.getString("estado"), rs.getString("proveedor"), rs.getString("stock_minimo")};
                    lista_productos.add(producto);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE `"+seleccion+"` LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock"), rs.getString("estado"), rs.getString("proveedor"), rs.getString("stock_minimo")};
                    lista_productos.add(producto);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_productos; 
    }
    
    //Guarda en la base de datos el producto nuevo
    public boolean guardarProductoNuevo(Producto producto, String categoria){
        String talle="";
        boolean encontrado=false;
        
        if (categoria.equals("Ropa Parte Superior") || categoria.equals("Ropa Parte Inferior") || categoria.equals("Ropa Interior")){
            talle=((Ropa) producto).getTalle();
        }
        else if (categoria.equals("Calzado")){
            talle=((Calzado) producto).getTalla();
        }

        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `productos` WHERE `codigo` LIKE '"+producto.getCodigo()+"';");
            if(rs.next()){
                encontrado=true;
            }
                
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO productos(codigo, nombre, categoria, descripcion, talle, precio, proveedor, stock_minimo) VALUE(?,?,?,?,?,?,?,?)");
                ps.setString(1, producto.getCodigo());
                ps.setString(2, producto.getNombre());
                ps.setString(3, categoria);
                ps.setString(4, producto.getDescripcion());
                if (categoria.equals("Calzado")){
                    talle=((Calzado) producto).getTalla();
                }
                else if (categoria.equals("Ropa Parte Superior") || categoria.equals("Ropa Parte Inferior") || categoria.equals("Ropa Interior")){
                    talle=((Ropa) producto).getTalle();
                }
                ps.setString(5, talle);
                ps.setFloat(6, producto.getPrecio());
                ps.setString(7, producto.getProveedor());
                ps.setInt(8, producto.getStock_minimo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return encontrado;
    }
    
    //Guarda en la base de datos el producto que se modifico
    public boolean guardarProductoModificado(Producto producto, String categoria, String estado, String id){
        String talle="";
        boolean encontrado=false;
        
        if (categoria.equals("Ropa Parte Superior") || categoria.equals("Ropa Parte Inferior") || categoria.equals("Ropa Interior")){
            talle=((Ropa) producto).getTalle();
        }
        else if (categoria.equals("Calzado")){
            talle=((Calzado) producto).getTalla();
        }
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM productos");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `productos` WHERE `codigo` LIKE '"+producto.getCodigo()+"';");
            if(rs.next()){
                if (!id.equals(rs.getString("id"))) {
                    encontrado=true;
                }
            } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE productos SET codigo='"+producto.getCodigo()+"', nombre='"+producto.getNombre()+"', categoria='"+categoria+"',"
                        + " descripcion='"+producto.getDescripcion()+"', talle='"+talle+"', precio='"+producto.getPrecio()+"',"
                                + " estado='"+estado+"', proveedor='"+producto.getProveedor()+"', stock_minimo='"+producto.getStock_minimo()+"' WHERE id='"+id+"'");
                ps.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
        
        return encontrado;
    }
       
    
    //Metodos relacionados con los clientes
    
    //Busca en la base de datos y devuelve una lista de clientes usando el DNI o apellido del cliente ingresado
    public ArrayList buscarCliente(String textoBuscar, String tipo){
        ArrayList lista_clientes = new ArrayList();
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `clientes`");
                while(rs.next()){
                    String[] cliente={rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"), rs.getString("fecha_nacimiento"), rs.getString("estado")};
                    lista_clientes.add(cliente);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `clientes` WHERE `"+tipo+"` LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] cliente={rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"), rs.getString("fecha_nacimiento"), rs.getString("estado")};
                    lista_clientes.add(cliente);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_clientes; 
    } 
    
    //Guarda en la base de datos el cliente nuevo
    public boolean guardarClienteNuevo(Cliente cliente){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `clientes` WHERE `dni` LIKE '"+cliente.getDni()+"';");
            if(rs.next()){
                encontrado=true;
            } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO clientes(nombre, apellido, dni, direccion, telefono, email, fecha_nacimiento) VALUE(?,?,?,?,?,?,?)");
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                ps.setString(3, cliente.getDni());
                ps.setString(4, cliente.getDireccion());
                ps.setString(5, cliente.getTelefono());
                ps.setString(6, cliente.getEmail());
                ps.setString(7, cliente.getFecha_nacimiento());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return encontrado;
    }
    
    //Guarda en la base de datos el cliente que se modifico
    public boolean guardarClienteModificado(Cliente cliente, String estado, String id){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `clientes` WHERE `dni` LIKE '"+cliente.getDni()+"';");
            if(rs.next()){
                if (!id.equals(rs.getString("id"))) {
                    encontrado=true;
                }
            } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE clientes SET nombre='"+cliente.getNombre()+"', apellido='"+cliente.getApellido()+"', dni='"+cliente.getDni()+"',"
                        + " direccion='"+cliente.getDireccion()+"', telefono='"+cliente.getTelefono()+"', email='"+cliente.getEmail()+"', "
                                + "fecha_nacimiento='"+cliente.getFecha_nacimiento()+"', estado='"+estado+"' WHERE id='"+id+"'");
                ps.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
        return encontrado;
    } 
    
    
    //Metodos relacionados con los proveedores
    
    //Busca en la base de datos y devuelve una lista de proveedores usando el nombre del proveedor ingresado
    public ArrayList buscarProveedor(String textoBuscar){
        ArrayList lista_proveedores = new ArrayList();
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `proveedores`");
                while(rs.next()){
                    String[] proveedor={rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"), rs.getString("estado")};
                    lista_proveedores.add(proveedor);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `proveedores` WHERE `nombre` LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] proveedor={rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"),
                        rs.getString("telefono"), rs.getString("email"), rs.getString("estado")};
                    lista_proveedores.add(proveedor);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_proveedores; 
    } 
    
    //Busca en la base de datos y devuelve una lista con los nombres de todos los proveedores
    public ArrayList obtenerProveedores(){
        ArrayList lista_proveedores = new ArrayList();
        String nombreProveedor;
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM proveedores WHERE estado='Habilitado'");
            while(rs.next()){
                nombreProveedor=rs.getString("nombre");
                lista_proveedores.add(nombreProveedor);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_proveedores; 
    }
    
    //Guarda en la base de datos el proveedor nuevo
    public boolean guardarProveedorNuevo(Proveedor proveedor){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `proveedores` WHERE `nombre` LIKE '"+proveedor.getNombre()+"';");
                if(rs.next()){
                    encontrado=true;
                    
                } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO proveedores(nombre, direccion, telefono, email) VALUE(?,?,?,?)");
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getDireccion());
                ps.setString(3, proveedor.getTelefono());
                ps.setString(4, proveedor.getEmail());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return encontrado;
    }
    
    //Guarda en la base de datos el proveedor que se modifico
    public boolean guardarProveedorModificado(Proveedor proveedor, String estado, String id){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM proveedores");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `proveedores` WHERE `nombre` LIKE '"+proveedor.getNombre()+"';");
                if(rs.next()){
                    if (!id.equals(rs.getString("id"))) {
                        encontrado=true;
                    }
                } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE proveedores SET nombre='"+proveedor.getNombre()+"', direccion='"+proveedor.getDireccion()+"', "
                        + "telefono='"+proveedor.getTelefono()+"', email='"+proveedor.getEmail()+"', estado='"+estado+"' WHERE id='"+id+"'");
                ps.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } 
        return encontrado;
    } 
    
    
    //Metodos relacionados con los pedidos
    
    //Busca en la base de datos y devuelve una lista de productos que sean del proveedor elegido y codigo/nombre ingresados 
    public ArrayList buscarProductoPedido(String textoBuscar, String seleccion, String proveedor){
        ArrayList lista_productos = new ArrayList();
        
        try{
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM `productos`");
           ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE proveedor='"+proveedor+"'");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock")};
                    lista_productos.add(producto);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE proveedor='"+proveedor+"' and `"+seleccion+"` LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock")};
                    lista_productos.add(producto);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_productos; 
    }
    
    //Actualiza el stock de los productos pedidos
    public boolean actualizarStockPedido(HashMap<String, Integer> dicPedido){
        int stock=0;
        try{
            for (HashMap.Entry<String, Integer> p : dicPedido.entrySet()) {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM `productos`");
                ResultSet rs;
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE `codigo` LIKE '"+p.getKey()+"';");
                if (rs.next()) {
                    stock = Integer.parseInt(rs.getString("stock"))+p.getValue();
                }
                ps = cn.prepareStatement("UPDATE productos SET stock='"+stock+"' WHERE codigo='"+p.getKey()+"'");
                ps.executeUpdate();
            }
            return true;
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    
    //Guarda en la base de datos el registro de los productos pedidos: nombre de cada producto, precio, cantidad, etc. 
    public void guardarRegistroPedidos(HashMap<String, ArrayList<String>> listaPedidos, String fecha){
        for (HashMap.Entry<String, ArrayList<String>> producto : listaPedidos.entrySet()) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO pedidos(fecha, codigo, nombre, cantidad, precio_unidad, precio_total) VALUE(?,?,?,?,?,?)");
                ps.setString(1, fecha);
                ps.setString(2, producto.getKey());
                ps.setString(3, producto.getValue().get(0));
                ps.setInt(4, Integer.parseInt(producto.getValue().get(1)));
                ps.setFloat(5, Float.parseFloat(producto.getValue().get(2)));
                ps.setFloat(6, Float.parseFloat(producto.getValue().get(3)));
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    public void guardarRegistroProductosVendidos2(HashMap<String, ArrayList<String>> listaVenta){
        int id = obtenerUltimoID();
        for (HashMap.Entry<String, ArrayList<String>> producto : listaVenta.entrySet()) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO productos_vendidos(id_venta, codigo, nombre, cantidad, precio_unidad, precio_total) VALUE(?,?,?,?,?,?)");
                ps.setInt(1, id);
                ps.setString(2, producto.getKey());
                ps.setString(3, producto.getValue().get(0));
                ps.setInt(4, Integer.parseInt(producto.getValue().get(1)));
                ps.setFloat(5, Float.parseFloat(producto.getValue().get(2)));
                ps.setFloat(6, Float.parseFloat(producto.getValue().get(3)));
               
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }  
    }
    
    
    //Metodos relacionados con las ventas
    
    //Verifica la existencia del cliente en la base de datos mediante el DNI
    public boolean verificarExistenciaDNI(String DNI){
        boolean encontrado=false;
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `clientes` WHERE `dni` LIKE '"+DNI+"' and `estado` LIKE 'Habilitado'");
            if(rs.next()){
                encontrado = true;
            } 
            else{
                encontrado = false;
            }
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return encontrado;
    }
    
    //Busca en la base de datos y devuelve una lista de productos usando el codigo o nombre de producto ingresado
    public ArrayList buscarProductoVentas(String textoBuscar, String seleccion){
        ArrayList lista_productos = new ArrayList();
        
        try{
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM `productos`");
           ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE `estado` LIKE 'Habilitado'");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock"), rs.getString("stock_minimo")};
                    lista_productos.add(producto);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE `"+seleccion+"` LIKE '"+textoBuscar+"%' and `estado` LIKE 'Habilitado'");
                while(rs.next()){
                    String[] producto={rs.getString("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("talle"), rs.getString("precio"), rs.getString("stock"), rs.getString("stock_minimo")};
                    lista_productos.add(producto);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_productos; 
    }
    
    //Guarda en la base de datos el registro de la venta: id del cliente, nombre de cliente, vendedor, precio. 
    public void guardarRegistroVenta(String fecha, String vendedor, String precioTotal, String dniCliente){
        int idCliente=0;
        String nombreCliente="";
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `clientes` WHERE `dni` LIKE '"+dniCliente+"'");
                if(rs.next()){
                    idCliente = rs.getInt("id");
                    nombreCliente = rs.getString("nombre") + " " +rs.getString("apellido");
                }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO ventas(fecha, id_cliente, nombre_cliente, vendedor, precio) VALUE(?,?,?,?,?)");
            ps.setString(1, fecha);
            ps.setInt(2, idCliente);
            ps.setString(3, nombreCliente);
            ps.setString(4, vendedor);
            ps.setFloat(5, Float.parseFloat(precioTotal));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }  
    } 
    
    //Actualiza el stock de los productos vendidos
    public boolean actualizarStockVenta(HashMap<String, Integer> dicVentas){
        int stock=0;
        try{
            for (HashMap.Entry<String, Integer> p : dicVentas.entrySet()) {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM `productos`");
                ResultSet rs;
                rs = ps.executeQuery("SELECT * FROM `productos` WHERE `codigo` LIKE '"+p.getKey()+"';");
                if (rs.next()) {
                    stock = rs.getInt("stock")-p.getValue();
                }
                ps = cn.prepareStatement("UPDATE productos SET stock='"+stock+"' WHERE codigo='"+p.getKey()+"'");
                ps.executeUpdate();
            }
            return true;
       
        }catch(SQLException ex){
            return false;
        } 
    }
     
    //Busca en la base de datos el ultimo ID de venta y lo devuelve
    public int obtenerUltimoID(){
        int id = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM `ventas`");
            ResultSet rs;
            rs = ps.executeQuery("SELECT MAX(id) AS `id` FROM `ventas`");
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    //Guarda en la base de datos el registro de todos los productos que se vendieron en esa venta
    public void guardarRegistroProductosVendidos(HashMap<String, ArrayList<String>> listaVenta){
        int id = obtenerUltimoID();
        for (HashMap.Entry<String, ArrayList<String>> producto : listaVenta.entrySet()) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO productos_vendidos(id_venta, codigo, nombre, cantidad, precio_unidad, precio_total) VALUE(?,?,?,?,?,?)");
                ps.setInt(1, id);
                ps.setString(2, producto.getKey());
                ps.setString(3, producto.getValue().get(0));
                ps.setInt(4, Integer.parseInt(producto.getValue().get(1)));
                ps.setFloat(5, Float.parseFloat(producto.getValue().get(2)));
                ps.setFloat(6, Float.parseFloat(producto.getValue().get(3)));
               
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }  
    }
    
    
    //Metodos relacionados con los usuarios
    
    //Guarda en la base de datos el usuario nuevo
    public boolean guardarUsuarioNuevo(Usuario user){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `usuarios` WHERE `usuario` LIKE '"+user.getUsuario()+"';");
            if(rs.next()){
                encontrado=true;
            } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios(tipo, nombre, apellido, usuario, contrasenia, email) VALUE(?,?,?,?,?,?)");
                ps.setString(1, "Usuario");
                ps.setString(2, user.getNombre());
                ps.setString(3, user.getApellido());
                ps.setString(4, user.getUsuario());
                ps.setString(5, user.getContrasenia());
                ps.setString(6, user.getEmail());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return encontrado;
    }
    
    //Cada vez que se abre el programa, se verifica si existe un administrador,
    //si no existe se crea uno por defecto
    public void crearAdminPorDefecto(){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `usuarios` WHERE tipo='Administrador'");
            if(rs.next()){
                encontrado=true;
            } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios(tipo, nombre, apellido, usuario, contrasenia, email) VALUE(?,?,?,?,?,?)");
                ps.setString(1, "Administrador");
                ps.setString(2, "Nicolas");
                ps.setString(3, "Pessina");
                ps.setString(4, "admin");
                ps.setString(5, "admin");
                ps.setString(6, "nico.pessina7@gmail.com");
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Busca en la base de datos y devuelve una lista de usuarios usando nombre de producto ingresado
    //Solo el administrador puede buscar
    public ArrayList buscarUsuario(String textoBuscar){
        ArrayList lista_usuarios = new ArrayList();
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM usuarios WHERE tipo='Usuario'");
                while(rs.next()){
                    String[] usuario={rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("usuario"), rs.getString("contrasenia"), rs.getString("email"), rs.getString("estado")};
                    lista_usuarios.add(usuario);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM usuarios WHERE tipo='Usuario' and nombre LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] usuario={rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("usuario"), rs.getString("contrasenia"), rs.getString("email"), rs.getString("estado")};
                    lista_usuarios.add(usuario);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_usuarios; 
    } 
    
    //Guarda en la base de datos el usuario modificado
    //Solo el administrador puede modificar
    public boolean guardarUsuarioModificado(Usuario user, String estado, String id){
        boolean encontrado=false;
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `usuarios` WHERE `nombre` LIKE '"+user.getUsuario()+"';");
                if(rs.next()){
                    if (!id.equals(rs.getString("id"))) {
                        encontrado=true;
                    }
                } 
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (encontrado==false) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE usuarios SET nombre='"+user.getNombre()+"', apellido='"+user.getApellido()+"', "
                        + "usuario='"+user.getUsuario()+"', contrasenia='"+user.getContrasenia()+"', email='"+user.getEmail()+"', estado='"+estado+"' WHERE id='"+id+"'");
                ps.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return encontrado;
    } 
    
    
    //Metodos relacionados con el login
    
    //Busca en la base de datos el usuario y la contraseña ingresados y devuelve el tipo de usuario
    public String buscarUsuarioIngresado(String usuario, String contrasenia){
        String tipoUsuario = "";
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' and estado='Habilitado'");
            if(rs.next()){
                rs = ps.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' and contrasenia='"+contrasenia+"' and estado='Habilitado'");
                if (rs.next()) {
                    tipoUsuario = rs.getString("tipo");
                }   
            }
        }
        
        catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return tipoUsuario;
    } 
    
    
    //Metodos del menu ver
    
    //Busca en la base de datos y devuelve una lista de ventas usando el id de venta o nombre del vendedor ingresado
    public ArrayList buscarRegistroVentas(String textoBuscar, String seleccion){
        ArrayList lista_registros = new ArrayList();
        
        
        try{
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM `ventas`");
           ResultSet rs;
            if (textoBuscar.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `ventas`");
                while(rs.next()){
                    String[] registro={rs.getString("id"), rs.getString("fecha"), rs.getString("id_cliente"), rs.getString("nombre_cliente"), rs.getString("vendedor"), rs.getString("precio")};
                    lista_registros.add(registro);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `ventas` WHERE `"+seleccion+"` LIKE '"+textoBuscar+"%'");
                while(rs.next()){
                    String[] registro={rs.getString("id"), rs.getString("fecha"), rs.getString("id_cliente"), rs.getString("nombre_cliente"), rs.getString("vendedor"), rs.getString("precio")};
                    lista_registros.add(registro);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_registros; 
    }
    
    //Busca en la base de datos y devuelve una lista de ventas usando la fecha ingresada
    public ArrayList buscarRegistroVentasPorFecha(String fecha){
        ArrayList lista_registros = new ArrayList();
        
        try{
           PreparedStatement ps = cn.prepareStatement("SELECT * FROM `ventas`");
           ResultSet rs;
            if (fecha.isEmpty()) {
                rs = ps.executeQuery("SELECT * FROM `ventas`");
                while(rs.next()){
                    String[] registro={rs.getString("id"), rs.getString("fecha"), rs.getString("id_cliente"), rs.getString("nombre_cliente"), rs.getString("vendedor"), rs.getString("precio")};
                    lista_registros.add(registro);
                }
            }
            else{
                rs = ps.executeQuery("SELECT * FROM `ventas` WHERE fecha='"+fecha+"'");
                while(rs.next()){
                    String[] registro={rs.getString("id"), rs.getString("fecha"), rs.getString("id_cliente"), rs.getString("nombre_cliente"), rs.getString("vendedor"), rs.getString("precio")};
                    lista_registros.add(registro);
                }
            }
           
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_registros; 
    }
    
    //Busca en la base de datos y devuelve una lista de los productos vendidos en la venta seleccionada
    public ArrayList obtenerProductosVendidos(int id){
        ArrayList lista_productos = new ArrayList();
        
        try{
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM `productos_vendidos`");
            ResultSet rs;
            rs = ps.executeQuery("SELECT * FROM `productos_vendidos` WHERE id_venta='"+id+"'");
            while(rs.next()){
                String[] producto_vendido={rs.getString("codigo"), rs.getString("nombre"), rs.getString("cantidad"), rs.getString("precio_unidad"), rs.getString("precio_total")};
                lista_productos.add(producto_vendido);
            }  
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return lista_productos;
    }
}
