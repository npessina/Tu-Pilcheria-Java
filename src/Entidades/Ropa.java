package Entidades;

public class Ropa extends Producto {
    private tipoRopa categoria;
    private String talle;
    public enum tipoRopa{
        ParteSuperior, ParteInferior, RopaInterior;
    }

    public Ropa(String codigo, String nombre, String descripcion, float precio, tipoRopa categoria, String talle, String proveedor, int stock_minimo) {
        super(codigo, nombre, descripcion, precio, proveedor, stock_minimo);
        setCategoria(categoria); 
        setTalle(talle);
    }

    //Getters y setters
    
    public tipoRopa getCategoria() {
        return categoria;
    }

    public void setCategoria(tipoRopa categoria) {
        this.categoria = categoria;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }
    
}
