package CORRER;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import com.google.gson.Gson;

import Clan.ClanClas;
import Clan.ClientClas;
import DataManage.*;
import Server.Server;
public class CORRER {

	public static void main(String[] args) throws IOException {
    	 //File FficheroClient =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClient.txt");
		final int PUERTOENTRADA = 8080;
		ServerSocket skServidor;
		skServidor = new ServerSocket(PUERTOENTRADA);
		System.out.println("Escucho el puerto " + PUERTOENTRADA);
		
		while (true) {
			 Socket skCliente = skServidor.accept();
		     Thread t = new Server(skCliente);
		     t.run();
		}
		
		//Liclas c = new Liclas ();
		//c.add("si");
		//c.add("no");
		//c.add("oi");
		
		//ClanClas a = new ClanClas("ganoclan", "nope", "gabriel", "0", c, "dooo");
		//System.out.println(a.getClients(2));
		//System.out.println(a.);
		//ClanClas d = new ClanClas("daclan", "nope", "Dalberth", "0", , "doo")
		   
    }
}