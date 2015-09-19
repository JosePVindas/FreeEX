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
import net.sf.json.util.JSONStringer;
/** Clase principal donde se crea el objeto Server, es aqui donde se crean los hilos de acuerdo a las conecciones que se reciben por parte de cliente*/
public class CORRER {
	
	public static void main(String[] args) throws IOException {
		try {
		final int PUERTOENTRADA = 8080;
		ServerSocket skServidor;
		skServidor = new ServerSocket(PUERTOENTRADA);
		System.out.println("Escucho el puerto " + PUERTOENTRADA);
		
		while (true) {
			 Socket skCliente = skServidor.accept();
		     Thread t = new Server(skCliente);
		     t.run();
		}
		
    } catch (Exception e)
		{
		System.out.println(e.getMessage());
		final int PUERTOENTRADA = 8080;
		 ServerSocket skServidor;
		 skServidor = new ServerSocket(PUERTOENTRADA);
		 System.out.println("Escucho el puerto " + PUERTOENTRADA);
		while (true) {
			 Socket skCliente = skServidor.accept();
		     Thread t = new Server(skCliente);
		     t.run();
		}
	}    
}
}