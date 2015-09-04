package Cliente;
import java.io.IOException;
import java.net.UnknownHostException;

public class CLIENTEPRUEBA {

    public static void main(String[] args) {
        
        cli o = new cli("localhost",8080);
            try {
                //trying to establish connection to the server
                o.connect();
                //if successful, read response from server
                o.readResponse();

            } catch (UnknownHostException e) {
                System.err.println("Host unknown. Cannot establish connection");
            } catch (IOException e) {
                System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
            }}
    
}