/*
{�StringClanName�: GABOCLAN, �ImageEmblem�: Image, �StringLeader�: �Gabriel�, �IntDays�: 3, �ImageRelic�: Image, �ObjectsClients�: [{�Gabriel�: get.position}, {�Pablo�: get.position}], �StringRequest�: �Accion�}
{�ClienteName�: �Gabo�, �StringPassword�: �CODE�, �Contributions�: [�IntResource1�: 23, �IntResource2�: 45, �IntResource3�: 45, �IntResource4�: 47], �StringAction�: �Accion�}
  */

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
            
            
            ///////////////////////////////////////////////////////////////
            String jsondata = flujo.readUTF();
            System.out.println(jsondata);
            Gson jsonclan = new Gson();
            ClanClas obj = jsonclan.fromJson(jsondata, ClanClas.class);
            obj.getDays();
    		System.out.println(obj.getDays());
    		
    		
    	///////////////////////////////////////////////////////////////////
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