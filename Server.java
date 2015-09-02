

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
            
            for ( int numCli = 0; numCli < 3; numCli++)
            {
                Socket skCliente = skServidor.accept(); // crea objeto
                System.out.println("Sirvo al cliente " + numCli);
                
                Scanner recibe = new Scanner (skCliente.getInputStream());
                System.out.println(recibe.nextLine());
                
                //PrintWriter envia = new PrintWriter(cliente.getOutputStream());
                
                
                
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream (aux);
                flujo.writeUTF("Hola Cliente " + numCli);
                
                
                skCliente.close();
                skServidor.close();
            }
            System.out.println("Demasiados clientes");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
    
}