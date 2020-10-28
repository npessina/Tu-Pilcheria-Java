package tpfinal;

import Interfaz.Login;
import Interfaz.Inicio;
import Interfaz.InicioAdmin;

public class TPFinal {

    public static void main(String[] args) {
        //Inicia la interfaz de usuario
        Inicio inicio = new Inicio();

        //Inicia la interfaz de administrador
//       InicioAdmin inicio = new InicioAdmin();
        
        //Inicia la inferfaz login, necesita db
//        Login inicio = new Login();
//        inicio.setVisible(true);
    }
}
