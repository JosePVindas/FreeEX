package Actions;
/**Se encarga de crear los tiempos de creacion en armas, escudos, toma de recursos*/
public class Time {

	public static void main(String[] args) {
		int x = 3;
		int minutos=x-1;
		int segundos = 60;
		for(minutos=minutos;minutos>-1;minutos--){
			for(segundos=60;segundos>-1;segundos--){
				System.out.println(minutos+":"+segundos);
				delaySegundo();
			}
		}

	}
	private static void delaySegundo(){
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){}
	}

}