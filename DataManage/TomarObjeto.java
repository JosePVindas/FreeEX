package DataManage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**Permite tomar una linea de texto en un archivo .txt mediante la busqueda de un pedazo de string que pertenezca a esta. atributos: Archivo por leer, texto por buscar*/
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