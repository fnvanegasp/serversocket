import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Establecer comunicación con el servidor
        try{
            Socket cliente = new Socket("localhost",8000);
            
            InputStream flujoEntrada = cliente.getInputStream();    //abrir IO
            OutputStream flujoSalida = cliente.getOutputStream();   
            
            //Convertir bytes en texto
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter salida = new PrintWriter(flujoSalida,true);
            
            //capturar datos del teclado
            
            BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            String sendingMessage = "";
            String receivingMessage = "";
            
            while(true){
                System.out.println("Enviar:");
                sendingMessage = datosUsuario.readLine();
                salida.println(sendingMessage);
                receivingMessage = entrada.readLine();
                System.out.println(receivingMessage);
            }
        } catch(IOException ex){
            
        }
    }
    
}
