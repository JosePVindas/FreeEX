package Server;
import java.net.*;
//import com.google.gson.Gson;


import java.io.*;


public class Server extends Thread 
{
	final int PUERTOENTRADA = 8080;
	private DataOutputStream outgoing;
	private DataInputStream incoming;

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
		}

		
		catch (Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
	/** Esta funcion permite mandar mensajes al socket del cliente, mensajes en forma de Strings*/
	protected void sendMessage (Socket socket, String message)   
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
	protected void sendToAll (Socket socket, String message)   
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
