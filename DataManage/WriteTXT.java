package DataManage;
import java.io.File;
import java.io.FileWriter;

public class WriteTXT
{
	public void run (String Information, String Archive)
	{

		//Un texto cualquiera guardado en una variable
		String info= Information;

		try
		{
			//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
			File archivo=new File(Archive +".txt");

			//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
			FileWriter escribir=new FileWriter(archivo,true);

			//Escribimos en el archivo con el metodo write 
			escribir.write(info);

			//Cerramos la conexion
			escribir.close();
		}

		//Si existe un problema al escribir cae aqui
		catch(Exception e)
		{
			System.out.println("Error al escribir");
		}
	}
}