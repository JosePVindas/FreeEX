package Cliente;

public class ClientClas {
	
	private String name;
	private String password;
	private String range;
	private int positionx;
	private int positiony;
	
	

	public ClientClas(String Name, String Password, String Range, int Positionx, int Positiony) {
		this.name = Name;
		this.password = Password;
		this.range = Range;
		this.positionx = Positionx;
		this.positiony = Positiony;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
		
	public void setImage(String Image) {
		this.Imag = Image;
	}
	
	public String getImage() {
		return Imag;
	}
	
	public void setLeader(String Leader) {
		this.leader = Leader;
	}
	
	public String getLeader() {
		return leader;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int Days) {
		this.days = Days;
	}
	
	public String getClients() {
		return clients;
	}
	
	public void setClients(String Clients) {
		this.clients = Clients;
	}
	
	public String getRequest() {
		return Request;
	}
	
	public void setRequest(String Request) {
		this.Request = Request;
	}
	
}