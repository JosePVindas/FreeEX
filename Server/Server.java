package Server;
import java.net.*;
import com.google.gson.Gson;
import Clan.ClanClas;
import Clan.ClientClas;

import java.io.*;
import DataManage.*;
/**Corresponde a la funcion principal del servidor, donde se recibe la informacion proveniente del cliente y se toman las deciciones de acuerdo a lo solicitado*/
public class Server extends Thread 
{
	final int PUERTOENTRADA = 8080;
	DataOutputStream mensaje;
	DataInputStream entrada;
	/**Rutas de creacion de los archivos .txt*/
	File FficheroClan =new File("C:/Users/Jose P Vindas/Documents/DataBase/DataBaseClan.txt");
	File FficheroClient =new File("C:/Users/Jose P Vindas/Documents/DataBase/DataBaseClient.txt");
	File FficheroPasswords =new File("C:/Users/Jose P Vindas/Documents/DataBase/DataBasePasswords.txt");

	private Socket skCliente = null;
	/** Funcion que permite establecer el socket desde la funcion main*/
	
	public Server(Socket skCliente) {
		super("Server");
		this.skCliente = skCliente;
	}
	/**Funcion principal donde empieza a correr el server*/
	
	public void run()
	{
		int h = 1;
		
		try
		{
			System.out.println("Escucho el puerto " + PUERTOENTRADA );
			System.out.println("Sirvo a un cliente");
			
			
			readC (skCliente);
			
			
			
			skCliente.close();
			
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
			
		}  
	} 
	/** Se encarga de leer los String que provienen desde el cliene y redirecciona de acuerdo a las acciones solicitadas*/
	protected void readC (Socket socket)  
	{
		try 
		{
			InputStream entra = socket.getInputStream();
			DataInputStream flujo = new DataInputStream(entra);
			String jsondata = flujo.readUTF();
			Gson o = new Gson();
			
			if (jsondata.contains("Joao")){
				System.out.println("POR FIIIIN PERRAAAAAAA!!");
				writeC(socket, "HELLOOOO");
			}

			
			if (jsondata.contains("Hola")){
				System.out.println("leido");
				writeC(socket, "HELLOOOO");
			}
			if (jsondata.contains("Jose")){
				System.out.println(jsondata);
				writeC(socket, "HELLOOOO");
			}

			if ((jsondata.contains("ClanName"))){
				System.out.println(jsondata);
				ClanClas b = o.fromJson(jsondata, ClanClas.class);
				
				if ((TomarObjeto.Leer(FficheroClan, b.getName()))== "No se encontro la palabra solicitada"){
					WriteTXT.EcribirFichero(FficheroClan, jsondata);
				}else{
					writeC(skCliente, "Ya existe un clan con ese nombre");
				}
				
				if (b.getRequest().equals("doo")){
					
					//b.setClients("hello");
					System.out.println(b.toString());
					WriteTXT.EcribirFichero(FficheroPasswords, b.toString());
					System.out.println("yess");
					
					System.out.println(b.getClients());
					writeC(socket, "daaa");
					
				}
			}

			if (jsondata.contains("ClientName")){
				System.out.println(jsondata);
				ClientClas c = o.fromJson(jsondata, ClientClas.class);
				if (jsondata.contains("newlogin")){		
					if ((TomarObjeto.Leer(FficheroClient, c.getName()))== "No se encontro la palabra solicitada"){
						WriteTXT.EcribirFichero(FficheroClient, jsondata);
						writeC(socket, "Registrado");
					} else {
						writeC(socket, "Ya estas registrado");
					}
				}
				//System.out.println("Joao es playo");
			
		
				
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
					proponerarma.getClients();
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
	/** Esta funcion permite mandar mensajes al socket del cliente, mensajes en forma de Strings*/
	protected void writeC (Socket socket, String message)   
	{
		try 
		{
			OutputStream mensajess = socket.getOutputStream();
			DataOutputStream flujoc= new DataOutputStream(mensajess);
			flujoc.writeUTF(message);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
	/** Es la etapa beta de la fucion que permite mandar un mismo mensaje a varios clientes a la vez*/
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