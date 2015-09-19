package DataManage;

/*********************************************************** 
 * Modifica un fichero de texto, consiste en leer un archivo 
 *y escribir su con tenido en uno nuevo llamado X, excepto la  
 *linea a modificar que se remplaza con la linea nueva.Luego 
 *se borra el fichero inicial y se renombra el nuevo fichero 
 *con el nombre del archivo inicial  
 *PARÁMETROS: 
 *FficheroAntiguo:Objeto File del fichero a modificar 
 *Satigualinea:Linea que se busca para modificar 
 *Snuevalinea:Linea con la que se va a remplazar la vieja 
 ***********************************************************/
import java.io.*;
import java.util.Random;

public class EditTXT{
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
                /*Recorro el fichero de texto linea a linea*/              
                while((Slinea=Flee.readLine())!=null) {   
                    /*Si la lia obtenida es igual al la bucada 
                     *para modificar*/  
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {  
                       /*Escribo la nueva linea en vez de la que tenia*/  
                        WriteTXT.EcribirFichero(FficheroNuevo, Snuevalinea);
  
                    }else{  
                        /*Escribo la linea antigua*/  
                         WriteTXT.EcribirFichero(FficheroNuevo,Slinea);  
                    }               
                }  
                /*Obtengo el nombre del fichero inicial*/  
                String SnomAntiguo=FficheroAntiguo.getName();  
                /*Borro el fichero inicial*/  
                Flee.close();  
                DeleteTXT.BorrarFichero(FficheroAntiguo);  
                /*renombro el nuevo fichero con el nombre del  
                *fichero inicial*/  
                FficheroNuevo.renameTo(FficheroAntiguo);  
                /*Cierro el flujo de lectura*/  
                //Flee.close();  
            }else{  
                System.out.println("Fichero No Existe");  
            }  
        } catch (Exception ex) {  
            /*Captura un posible error y le imprime en pantalla*/   
             System.out.println(ex.getMessage());  
        }  
    }  
/*********************************************************** 
        *Eliminar un registro dentro de un fichero de texto,  
        *consiste en leer un archivo y escribir su contenido en uno  
        *nuevo llamado X, excepto la linea a eliminar.Luego se borra  
        *el fichero inicial y se renombra el nuevo fichero con el  
        *nombre del archivo inicial  
        *********************************************************** 
        *PARÁMETROS: 
        *FficheroAntiguo:Objeto File del fichero a eliminar el reg 
        *Satigualinea:Linea que se busca para eliminar 
        ***********************************************************/      
       public static  void EliminarRegistro (File FficheroAntiguo,String Satigualinea){          
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
                /*Recorro el fichero de texto linea a linea*/  
                while((Slinea=Flee.readLine())!=null) {   
                     /*Si la linea obtenida es distinta al la buscada 
                     *para eliminar*/  
                    if (!Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {  
                       /*la escribo en el fichero nuevo*/   
                       WriteTXT.EcribirFichero(FficheroNuevo,Slinea);  
                    }else{  
                        /*Si es igual simple mete no hago nada*/  
                    }               
                }  
                /*Obtengo el nombre del fichero inicial*/  
                String SnomAntiguo=FficheroAntiguo.getName();  
                /*Borro el fichero inicial*/  
                Flee.close();  
                DeleteTXT.BorrarFichero(FficheroAntiguo);  
                /*renombro el nuevo fichero con el nombre del fichero inicial*/  
                FficheroNuevo.renameTo(FficheroAntiguo);  
                /*Cierro el flujo de lectura*/  
                //Flee.close();  
            }else{  
                System.out.println("Fichero No Existe");  
            }  
        } catch (Exception ex) {  
             System.out.println(ex.getMessage());  
        }  
    }
}