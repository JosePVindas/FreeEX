

import java.net.*;
import java.io.*;

public class ser
{
    public void iniser()
    {
        try
        {
            ServerSocket skServidor = new ServerSocket (5000);
            System.out.println("Escucho el puerto " + 5000);
            
            for ( int numCli = 0; numCli < 20; numCli++)
            {
                Socket skCliente = skServidor.accept(); // crea objeto
                System.out.println("Sirvo al cliente " + numCli);
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream (aux);
                flujo.writeUTF("Hola Cliente " + numCli);
                skCliente.close();
            }
            System.out.println("Demasiados clientes");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}