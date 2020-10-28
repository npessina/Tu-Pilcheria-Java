package Datos;
import java.sql.*;


public class Conectar {
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "";
    String url = "jdbc:mysql://localhost:3306/";
    String nombreDB = "bd_tienda";
    
    //Conexion a la base de datos
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url+nombreDB,usuario,contrasenia);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conectar;
    }
}
