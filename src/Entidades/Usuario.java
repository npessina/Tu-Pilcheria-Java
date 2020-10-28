package Entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class Usuario {
    private String nombre, apellido, usuario, contrasenia, email;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String usuario, String contrasenia, String email) {
        setNombre(nombre);
        setApellido(apellido);
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setEmail(email);
    }

    //Getters y setters
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;   
    }
    
    
}
