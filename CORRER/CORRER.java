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
			 System.out.println("no");
			 Socket skCliente = skServidor.accept();
		     Thread t = new Server(skCliente);
		     t.run();
		   }
    }
}