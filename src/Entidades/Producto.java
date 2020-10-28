package Entidades;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private float precio;
    private String proveedor;
    private int stock_minimo;
    
    public Producto(String codigo, String nombre, String descripcion, float precio, String proveedor, int stock_minimo) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion); 
        setPrecio(precio);
        setProveedor(proveedor);
        setStock_minimo(stock_minimo);
    }

    //Getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }  

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }
}

