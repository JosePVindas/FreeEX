

import java.net.*;
import java.io.*;

public class Conect {
final int PUERTO = 5000;
ServerSocket sc;
Socket so;
DataOutputStream salida;
String mensajeRecibido;

public void initserver ()
{
BufferedReader entrada;
try
{
    sc = new ServerSocket (PUERTO);
    System.out.println("Esperando coneccion");
    so = new Socket();
    so = sc.accept();
    System.out.println("Se ha conectado alguien");
    
    
    entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
    salida = new DataOutputStream(so.getOutputStream());
    System.out.println("Confirmando conexion al cliente....");
    salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
    mensajeRecibido = entrada.readLine();
    System.out.println(mensajeRecibido);
    salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
    salida.writeUTF("Gracias por conectarte, adios!");
    System.out.println("Cerrando conexión...");
    sc.close();//Aqui se cierra la conexión con el cliente

}
catch(Exception e)
{
    System.out.println("ERROR" + e.getMessage());
}
}
}