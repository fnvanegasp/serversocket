
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Servidor {
    public static void main(String[] args){
        try{
            ServerSocket servidor = new ServerSocket(8000);         //establecer servidor
            System.out.println("Esperando cliente");
            Socket cliente = servidor.accept();                     //aceptar conexión
            System.out.println("Cliente conectado");
            InputStream flujoEntrada = cliente.getInputStream();    //abrir IO
            OutputStream flujoSalida = cliente.getOutputStream();   
            
            //Convertir bytes en texto
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
            BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter salida = new PrintWriter(flujoSalida,true);
            
            String message = "";
            String sendingMessage = "";
            while(true){
                message = entrada.readLine();
                System.out.println(message);
                System.out.println("Enviar: ");
                sendingMessage = datosUsuario.readLine();
                salida.println(sendingMessage);
            }
        } catch (IOException ex){
            
        }
    }
}
