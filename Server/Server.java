package Server;
import java.net.*;
import java.util.Scanner;
import java.io.*;

class Server extends Thread
{
    public void run()
    {
        try
        {
        	ServerSocket skServidor = new ServerSocket(8080);
        	System.out.println("Escucho el puerto " + 8080 );
        	//for ( int numCli = 0; numCli < 3; numCli++) {
        	while (true){
        		 int numCli = 1;
        		 Socket skCliente = skServidor.accept();
	        	 System.out.println("Sirvo al cliente " + numCli);
	        	 
	        	 InputStream entra = skCliente.getInputStream();
	             DataInputStream flujo = new DataInputStream(entra);
	             System.out.println (flujo.readUTF());
	           
	        	 
	        	 OutputStream sale = skCliente.getOutputStream();
	        	 DataOutputStream flujoc= new DataOutputStream(sale);
	        	 flujoc.writeUTF( "Hola cliente " + numCli );
	        	 skCliente.close();
        	}
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }    
}