package Cliente;
import java.net.*;
import java.io.*;

public class cli {

    final String HOST = "localhost";
    final int PUERTOENTRADA = 8080;
    final int PUERTOSALIDA = 8081;
    Socket sc;
    DataOutputStream mensaje;
    DataInputStream entrada;


    public void initClient() {
        
        try {
            sc = new Socket(HOST, PUERTOENTRADA);
            OutputStream aux = sc.getOutputStream();
	        DataOutputStream flujo= new DataOutputStream(aux);
	        flujo.writeUTF( "Hola servidor");
            
            InputStream auxc = sc.getInputStream();
            DataInputStream flujoc = new DataInputStream(auxc);
            System.out.println(flujoc.readUTF());
            
            while (((flujoc.readUTF())) == null) {
                if ((flujoc.readUTF()) == null){
                    System.out.println((flujoc.readUTF()));
                    //flujoc.close();
                    break;
                } else {
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
