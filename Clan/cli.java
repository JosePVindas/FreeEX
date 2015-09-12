package Clan;
import java.net.*;
import java.io.*;

public class cli {

    final String HOST = "192.168.15.141";
    final int PUERTOENTRADA = 8080;
    final int PUERTOSALIDA = 8081;
    Socket sc;
    DataOutputStream mensaje;
    DataInputStream entrada;


    public void initClient() {
        
        try {
            sc = new Socket("192.168.15.107", PUERTOENTRADA);
            OutputStream aux = sc.getOutputStream();
	    DataOutputStream flujo= new DataOutputStream(aux);
	    String a = "{\"name\": \"Gaboclan\", \"Image\": \"COlor\", \"Leader\": \"Gabriel\", int: 0, \"Clients\": \"Gabriel\", \"Request\": \"doo\"}";
            flujo.writeUTF(a);
                     
            InputStream auxc = sc.getInputStream();
            DataInputStream flujoc = new DataInputStream(auxc);
            System.out.println(flujoc.readUTF());
            
            while (((flujoc.readUTF())) == null) {
                if ((flujoc.readUTF()) == null){
                    System.out.println((flujoc.readUTF()));
                    //flujoc.close();
                    break;
                }
                else {
                    //flujoc.readUTF();
                }
}
            aux.close();
            flujoc.close();
            sc.close();
            
         } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}