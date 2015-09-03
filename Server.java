import java.net.*;
import java.util.Scanner;
import java.io.*;

class Server extends Thread
{
    public void run()
    {
        try
        {
            ServerSocket skServidor = new ServerSocket (8080);
            System.out.println("Escucho el puerto " + 8080);
            
            while (true)
            {
            	Socket skCliente = skServidor.accept(); // crea objeto
    
                BufferedReader inmsj = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
                System.out.println(inmsj.readLine());
                
                DataOutputStream mensaje = new DataOutputStream(skCliente.getOutputStream());
              
                mensaje.writeUTF("Hola!!");
                
                skCliente.close();
                //skServidor.close();
            }
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