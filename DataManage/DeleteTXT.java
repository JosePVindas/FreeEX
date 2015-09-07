package DataManage;

import java.io.File;

public class DeleteTXT{

	public static  void BorrarFichero(File Ffichero){  
	     try {  
	         /*Si existe el fichero*/  
	         if(Ffichero.exists()){  
	           /*Borra el fichero*/    
	           Ffichero.delete();   
	           System.out.println("Fichero Borrado con Exito");  
	         }  
	     } catch (Exception ex) {  
	         /*Captura un posible error y le imprime en pantalla*/   
	          System.out.println(ex.getMessage());  
	     }  
	}
}