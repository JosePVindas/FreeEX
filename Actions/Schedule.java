package Actions;

public class Schedule {

	public static void main(String[] args) {
		int x = 3;
		int dias = x-1;
		int horas=23;
		int minutos=60;
		int segundos = 60;
		for (dias=dias;dias>-1;dias--){
			for(horas=23;horas>-1;horas--){
				for(minutos=60;minutos>-1;minutos--){
					System.out.println("D: H: M: S");
					System.out.println(dias + ":"+ horas + ":" + minutos);					
					for(segundos=60;segundos>-1;segundos--){
						delaySegundo();
					}	
				}
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