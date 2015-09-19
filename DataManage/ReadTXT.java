package DataManage;
import java.io.*;
/** Es la clase que permite leer todo un fichero*/
public class ReadTXT
{
	/*Función que lee el contenido de un fichero de texto 
	*Parámetro:Ffichero. Objeto de la clase file donde se va a leer*/      
	public static void LeerFichero(File Ffichero){  
	   try {  
	       /*Si existe el fichero*/  
	       if(Ffichero.exists()){  
	           /*Abre un flujo de lectura a el 
	            * fichero*/  
	           BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));  
	           String Slinea;  
	           System.out.println("**********Leyendo Fichero***********");  
	           /*Lee el fichero linea a linea hasta llegar a la ultima*/  
	           while((Slinea=Flee.readLine())!=null) {  
	           /*Imprime la linea leida*/      
	           System.out.println(Slinea);                
	           }  
	           System.out.println("*********Fin Leer Fichero**********");  
	           /*Cierra el flujo*/  
	           Flee.close();  
	         }else{  
	           System.out.println("Fichero No Existe");  
	         }  
	   } catch (Exception ex) {  
	       /*Captura un posible error y le imprime en pantalla*/   
	        System.out.println(ex.getMessage());  
	   }  
	 }  
}
