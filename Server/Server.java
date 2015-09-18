package Server;
import java.net.*;
import com.google.gson.Gson;
import Clan.ClanClas;
import Clan.ClientClas;

import java.io.*;
import DataManage.*;

public class Server extends Thread 
{
	final int PUERTOENTRADA = 8080;
	DataOutputStream mensaje;
	DataInputStream entrada;
	//Rutas de creacion de los archivos
	File FficheroClan =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClan.txt");
	File FficheroClient =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClient.txt");
	File FficheroPasswords =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBasePasswords.txt");

	private Socket skCliente = null;
	
	public Server(Socket skCliente) {
		super("Server");
		this.skCliente = skCliente;
	}
	//Funcion principal donde empieza a correr el server
	public void run()
	{
		try
		{
			System.out.println("Escucho el puerto " + PUERTOENTRADA );
			System.out.println("Sirvo a un cliente");
			//readC (skCliente);
			
	/////////////////////////////////////////////////////////////////////////////////
			InputStream entra = skCliente.getInputStream();
			DataInputStream flujo = new DataInputStream(entra);
			int a = 10;
			while (true){
				String jsondata = flujo.readUTF();
				System.out.println(jsondata);
				a = a - 1;
				System.out.println(a);
				if (jsondata.contains("salir")){
					break;
				}
			}
	///////////////////////////////////////////////////////////////////////////////
			DataOutputStream flujoc= new DataOutputStream(skCliente.getOutputStream());
			int i = 10;
			while (i >0){
				flujoc.writeUTF("yes");
				flujoc.writeUTF("yes");
				flujoc.writeUTF("salir");
				i = i - 1;
				System.out.println(i);
			}
	///////////////////////////////////////////////////////////////////////////////
			skCliente.close();
			
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}    
	} 
	protected void readC (Socket socket)  
	{
		try 
		{
			InputStream entra = socket.getInputStream();
			DataInputStream flujo = new DataInputStream(entra);
			String jsondata = flujo.readUTF();
			Gson o = new Gson();
			
			if (jsondata.contains("Hola")){
				System.out.println("leido");
				writeC(socket, "yess");
			}

			if ((jsondata.contains("ClanName"))){
				ClanClas b = o.fromJson(jsondata, ClanClas.class);
				if ((TomarObjeto.Leer(FficheroClan, b.getName()))== "No se encontro la palabra solicitada"){
					WriteTXT.EcribirFichero(FficheroClan, jsondata);
				}else{
					writeC(socket, "Ya existe un clan con ese nombre");
				}
			}

			if (jsondata.contains("ClientName")){
				ClientClas c = o.fromJson(jsondata, ClientClas.class);
				if (jsondata.contains("newlogin")){		
					if ((TomarObjeto.Leer(FficheroClient, c.getName()))== "No se encontro la palabra solicitada"){
						WriteTXT.EcribirFichero(FficheroClient, jsondata);
						writeC(socket, "Registrado");
					} else {
						writeC(socket, "Ya estas registrado");
					}
				}
				
				if (c.getAction().equals("login")){
					if (((TomarObjeto.Leer(FficheroClient, c.getName()) == "No se encontro la palabra solicitada"))&& ((TomarObjeto.Leer(FficheroClient, c.getPassword()) == "No se encontro la palabra solicitada"))){
						writeC(socket, "No te has registrado");
					} else {
						
						writeC(socket, "De nuevo por aqui");
						
					}
				}
				if (c.getAction().equals("CrearArma")){
					String a = TomarObjeto.Leer(FficheroClan, c.getClan());
					ClanClas proponerarma = o.fromJson(a, ClanClas.class);
					proponerarma.getClients(1);
					//mandarall (socket,);
					

				}
				if (c.getAction().equals("CrearDefensa")){
					String a = TomarObjeto.Leer(FficheroClan, c.getClan());
					ClanClas proponerarma = o.fromJson(a, ClanClas.class);
					System.out.println(a);
					System.out.println(proponerarma.getName());


				}
				if (c.getAction().equals("UnirseaClan")){
					String a = TomarObjeto.Leer(FficheroClan, c.getClan());
					ClanClas proponerdefensa = o.fromJson(a, ClanClas.class);
					System.out.println(a);
					System.out.println(proponerdefensa.getLeader());
					
				}
				if (c.getAction().equals("PedirUbicaciones")){
					
					
				}
				if (c.getAction().equals("Votar")){

					
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
	
	protected void mandarall (Socket socket, String message)   
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