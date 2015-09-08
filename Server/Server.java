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
    File FficheroClan =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClan.txt");
    File FficheroClient =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClient.txt");
    
    
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
	        	 skServidor.close();
	        	 
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
            System.out.println(flujo.readUTF());
            
            String q;
            q = flujo.readUTF();
            
            if (q == "New Client"){
            	CreateClientUser ("Marco", "123");
            	
            }
            
            //WriteTXT.EcribirFichero(FficheroClan, (flujo.readUTF()) + numCli);
            
            
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
       	    //EditTXT.ModificarFichero(FficheroClan, "Hola servidor2", "HEY");
    	}
    	catch (Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    protected void CreateClientUser (String User, String Password)
    {
    	System.out.println("si");
        WriteTXT.EcribirFichero(FficheroClient, "HELLO" + User + Password);
    }
}