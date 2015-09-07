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
    File Ffichero=new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBase.txt");
    
    public void run()
    {
        try
        {
        	skServidor = new ServerSocket(PUERTOENTRADA);
        	
        	System.out.println("Escucho el puerto " + PUERTOENTRADA );
            for ( int numCli = 0; numCli < 4; numCli++) {
        		 Socket skCliente = skServidor.accept();
	        	 System.out.println("Sirvo al cliente " + numCli);
	        	 readC (skCliente, numCli);
	        	 writeC (skCliente, numCli);
	        	 skCliente.close();
	        	 //skServidor.close();
	        	 
        	}
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
    } 
    protected void readC (Socket socket, int numCli)   
    {
    	try 
    	{
    		InputStream entra = socket.getInputStream();
            DataInputStream flujo = new DataInputStream(entra);
            //WriteTXT.EcribirFichero(Ffichero, (flujo.readUTF()) + numCli);
            
            
    	}
    	catch (Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    protected void writeC (Socket socket, int numCli)   
    {
    	try 
    	{
    		DataOutputStream flujoc= new DataOutputStream(socket.getOutputStream());
       	    flujoc.writeUTF( "Hola cliente " + numCli);
       	    //EditTXT.ModificarFichero(Ffichero, "Hola servidor2", "HEY");
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