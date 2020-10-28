package Entidades;

public class Calzado extends Producto{
    private String talla;
    
    public Calzado(String codigo, String nombre, String descripcion, float precio, String talla, String proveedor, int stock_minimo) {
        super(codigo, nombre, descripcion, precio, proveedor, stock_minimo);
        setTalla(talla);
    }

    //Getters y setters
    
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
