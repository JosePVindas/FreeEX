package Server;
import java.net.*;
import java.io.*;
import DataManage.*;

class Server extends Thread
{
	final int PUERTOENTRADA = 8080;
    ServerSocket skServidor;
    DataOutputStream mensaje;
    DataInputStream entrada;
    
    public void run()
    {
        try
        {
        	skServidor = new ServerSocket(PUERTOENTRADA);
        	
        	System.out.println("Escucho el puerto " + PUERTOENTRADA );
            for ( int numCli = 0; numCli < 3; numCli++) {
        		 Socket skCliente = skServidor.accept();
	        	 System.out.println("Sirvo al cliente " + numCli);
	        	 read (skCliente);
	        	 write (skCliente, numCli);
	        	 skCliente.close();
	        	 skServidor.close();
	        	 
        	}
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
    } 
    protected void read (Socket socket)   
    {
    	try 
    	{
    		InputStream entra = socket.getInputStream();
            DataInputStream flujo = new DataInputStream(entra);
            
            WriteTXT Archive = new WriteTXT();
            Archive.run((flujo.readUTF()), "Base");
            
    	}
    	catch (Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    protected void write (Socket socket, int numCli)   
    {
    	try 
    	{
    		DataOutputStream flujoc= new DataOutputStream(socket.getOutputStream());
       	    flujoc.writeUTF( "Hola cliente " + numCli);
    	}
    	catch (Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    protected void Savejson ()
    {
    	
    }
}