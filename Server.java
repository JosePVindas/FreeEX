import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server
{
    public void iniser()
    {
        try
        {
            ServerSocket skServidor = new ServerSocket (8080);
            System.out.println("Escucho el puerto " + 8080);
            
            for (int numCli = 0; numCli < 3; numCli++)
            {
            	Socket skCliente = skServidor.accept(); // crea objeto
                System.out.println("Sirvo al cliente " + numCli);
                
                BufferedReader inmsj = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
                System.out.println(inmsj.readLine());
                
                DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());
                salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
                
                skCliente.close();
                //skServidor.close();
            }
            System.out.println("Demasiados clientes");
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    public void parar ()
    {
    	
    	System.out.println("yeaaahhh");
    }
}