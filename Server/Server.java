package Server;
import java.net.*;
import com.google.gson.Gson;
import Clan.ClanClas;
import java.io.*;
import DataManage.*;

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
			for ( int numCli = 0; numCli < 100; numCli++) {
				Socket skCliente = skServidor.accept();
				System.out.println("Sirvo al cliente " + numCli);
				readC (skCliente, numCli);
				//writeC (skCliente, "");
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
			String jsondata = flujo.readUTF();
			
			jsondata.startsWith("vindas");
			
			if ((jsondata.contains("CreateClan"))){
				WriteTXT.EcribirFichero(FficheroClan, jsondata);
			}
			
			if (jsondata.contains("ClientName")){
				WriteTXT.EcribirFichero(FficheroClient, jsondata);
			}
			
			if (jsondata.contains("newlogin")){
				
				
				String a = jsondata.split(",");
			
				if ((TomarObjeto.Leer(FficheroPasswords, "v"))== "no se"){
					writeC(socket, "yeahh");
				}
				
				if ((TomarObjeto.Leer(FficheroPasswords, (jsondata.replaceAll("newlogin", " ")))) == "No se encontro la palabra solicitada"){
					WriteTXT.EcribirFichero(FficheroPasswords, (jsondata.replaceAll("newlogin", " ")));
					writeC(socket, "Registrado");
				} else {
					writeC(socket, "Ya estas registrado");
				}
			}
				
			if (jsondata.contains("login")){
				if ((TomarObjeto.Leer(FficheroPasswords, jsondata.replaceAll("login", " "))) == "No se encontro la palabra solicitada"){
					writeC(socket, "No te has registrado");
				} else {
					writeC(socket, "De nuevo por aqui");
				}
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
	protected void writeC (Socket socket, String message)   
	{
		try 
		{
			DataOutputStream flujoc= new DataOutputStream(socket.getOutputStream());
			flujoc.writeUTF(message);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
}