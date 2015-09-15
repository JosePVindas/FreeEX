package DataManage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TomarObjeto{
	public static String Leer (File FficheroAntiguo, String Satigualinea){          
		try {
			/*Si existe el fichero inical*/  
			if(FficheroAntiguo.exists()){  
				/*Abro un flujo de lectura*/  
				BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));  
				String Slinea;  
				while((Slinea=Flee.readLine())!=null) {
					if (Slinea.contains(Satigualinea)){
						System.out.println("hola");
						return Slinea;
					}
				}  
				Flee.close(); 
			}else{  
				System.out.println("Fichero No Existe");  
			}  
		} catch (Exception ex) {  
			/*Captura un posible error y le imprime en pantalla*/   
			System.out.println(ex.getMessage());  
		}
		return "No se encontro la palabra solicitada";
	}
}