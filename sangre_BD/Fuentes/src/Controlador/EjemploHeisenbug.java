package Controlador;

import Modelo.Usuario;

public class EjemploHeisenbug {
    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        final Usuario usuario = new Usuario("user", "pass");
        
        Thread loginThread = new Thread(() -> {
            usuario.ingresar(usuario.getUsuario(), usuario.getContrasena());
            stop = true; // cambio de estado del boolean stop
        });
        
        Thread logoutThread = new Thread(() -> {
            while (!stop) {} // espera hasta que stop sea verdadero
            usuario.salir();
        });

        loginThread.start();
        logoutThread.start();
        loginThread.join();
        logoutThread.join();
    }
}