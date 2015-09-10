package CORRER;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import com.google.gson.Gson;

import Clan.ClanClas;
import DataManage.*;
import Server.Server;
public class SocketServer {
	
	public static void main(String[] args) {
    	 File FficheroClient =new File("C:/Users/Gabriel/Documents/EclipseProjects/Pandora/Pandora-Under-Attack/DataBaseClient.txt");
    
		Server s = new Server ();
		s.run();
		
    	}
		
		
}