package DataManage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class WriteTXT
{
	public static void EcribirFichero(File Ffichero,String SCadena){  
		  try {  
		          //Si no Existe el fichero lo crea  
		           if(!Ffichero.exists()){  
		               Ffichero.createNewFile();  
		           }  
		          /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8.  
		           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)", 
		           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/  
		          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));  
		          /*Escribe en el fichero la cadena que recibe la función.  
		           *el string "\r\n" significa salto de linea*/  
		          Fescribe.write(SCadena + "\r\n");  
		          //Cierra el flujo de escritura  
		          System.out.println("Archivo Creado");
		          Fescribe.close();  
		       } catch (Exception ex) {  
		          //Captura un posible error le imprime en pantalla   
		          System.out.println(ex.getMessage());  
		       }   
		}
}