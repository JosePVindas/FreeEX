package DataManage;

import java.io.*;
import java.util.Random;

import com.google.gson.Gson;

public class EditWordTXT{
    public static  void ModificarFichero(File FficheroAntiguo,String Satigualinea,String Snuevalinea){          
        /*Obtengo un numero aleatorio*/  
        Random numaleatorio= new Random(3816L);   
        /*Creo un nombre para el nuevo fichero apartir del 
         *numero aleatorio*/  
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";  
        /*Crea un objeto File para el fichero nuevo*/  
        File FficheroNuevo=new File(SnombFichNuev);  
        try {  
            /*Si existe el fichero inical*/  
            if(FficheroAntiguo.exists()){  
                /*Abro un flujo de lectura*/  
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));  
                String Slinea;  
         
            
                while((Slinea=Flee.readLine())!=null) {
                	
                	if (Slinea.contains(Satigualinea)){
	                	String resultado = Slinea.replace(Satigualinea, Snuevalinea);
	                	System.out.println(resultado);
	                	WriteTXT.EcribirFichero(FficheroNuevo,resultado);
                	}else{
                		WriteTXT.EcribirFichero(FficheroNuevo,Slinea);
                		Flee.close();
                		
                	}
                }
             
                  
                String SnomAntiguo=FficheroAntiguo.getName();  
                  
                Flee.close();  
                DeleteTXT.BorrarFichero(FficheroAntiguo);  
                
                FficheroNuevo.renameTo(FficheroAntiguo);  
                
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