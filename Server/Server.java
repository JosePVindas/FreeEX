package Server;
import java.net.*;
import java.io.*;

class Server extends Thread
{
	final int PUERTOENTRADA = 8080;
    final int PUERTOSALIDA = 8081;
    ServerSocket skServidor;
    DataOutputStream mensaje;
    DataInputStream entrada;
    
    public void run()
    {
        try
        {
        	skServidor = new ServerSocket(PUERTOENTRADA);
        	
        	System.out.println("Escucho el puerto " + PUERTOENTRADA );
        	//for ( int numCli = 0; numCli < 3; numCli++) {
        	
        	while (true){
        		 int numCli = 1;
        		 Socket skCliente = skServidor.accept();
	        	 System.out.println("Sirvo al cliente " + numCli);
	        	 
	        	 InputStream entra = skCliente.getInputStream();
	             DataInputStream flujo = new DataInputStream(entra);
	             System.out.println (flujo.readUTF());
	           
	        	 DataOutputStream flujoc= new DataOutputStream(skCliente.getOutputStream());
	        	 flujoc.writeUTF( "Hola cliente " + numCli );
	        	 
	        	 flujo.close();
	        	 flujoc.close();
	        	 skCliente.close();
	        	 skServidor.close();
        	}
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }    
}