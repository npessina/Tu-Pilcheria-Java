package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private String nombre, apellido, direccion, telefono, email, dni, fecha_nacimiento;

    public Cliente() {
    }
  
    public Cliente(String nombre, String apellido, String direccion, String telefono, String email, String dni, String fecha_nacimiento) {
        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setTelefono(telefono);
        setEmail(email);
        setDni(dni);
        setFecha_nacimiento(fecha_nacimiento);
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }   
}
