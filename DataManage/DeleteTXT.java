package DataManage;

import java.io.File;
/** Esta clase corresponde al metodo de eliminar todo un archivo de texto de los cuales se guarda la informacio, util cuando se esta editando algo*/
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