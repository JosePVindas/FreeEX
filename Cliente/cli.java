package Cliente;
import java.net.*;
import java.io.*;

public class cli {
	PrintStream salidaControl = null;
	BufferedReader entradaControl = null;
	private String hostname;
        private int port;
        Socket socketClient;

        public cli(String hostname, int port){
            this.hostname = hostname;
            this.port = port;
        }

        public void connect() throws UnknownHostException, IOException{
            System.out.println("Attempting to connect to "+hostname+":"+port);
            socketClient = new Socket(hostname,port);
            System.out.println("Connection Established");
        }

        public void readResponse() throws IOException{
            String userInput;
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            System.out.println("Response from server:");
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println(userInput);
            }
        }
}