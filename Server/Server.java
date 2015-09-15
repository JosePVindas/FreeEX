package Server;
import java.net.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import Clan.ClanClas;
import java.io.*;
import DataManage.*;
import net.sf.json.JSONObject;

public class Server extends Thread
{
	final int PUERTOENTRADA = 8080;
	
    ServerSocket skServidor;
    DataOutputStream mensaje;
    DataInputStream entrada;
    File FficheroClan =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClan.txt");
    File FficheroClient =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClient.txt");
    File FficheroPasswords =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBasePasswords.txt");
    
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
        		
////////////////////////////////////////////////////////////////////////////////////////////////////
        		 String q = TomarObjeto.Leer(FficheroClan, "Gaboclan");
        		 Gson o = new Gson();
        		 System.out.println(q);
        		 ClanClas b = o.fromJson(q, ClanClas.class);
        		 System.out.println(b.getImage());
////////////////////////////////////////////////////////////////////////////////////////////////////
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
            String jsondata = flujo.readUTF();
            
            if ((jsondata.contains("ClanName"))){
            	WriteTXT.EcribirFichero(FficheroClan, jsondata);
            	
            }
            if (jsondata.contains("ClientName")){
            	WriteTXT.EcribirFichero(FficheroClient, jsondata);
            }
	   		
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
       	    flujoc.writeUTF("Hola cliente " + numCli);

    	}
    	catch (Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
    
    
}