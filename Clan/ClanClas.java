package Clan;

import DataManage.Liclas;

public class ClanClas {
	
	private String ClanName;
	private String Imag;
	private String leader;
	private String days = "0";
	private Liclas clients = new Liclas();
	private String Request;	

	public ClanClas(String Name, String Image, String Leader, String Days, Liclas Clients, String Request) {
		this.ClanName = Name;
		this.Imag = Image;
		this.leader = Leader;
		this.days = Days;
		this.clients = Clients;
		this.Request = Request;
	}
	
	public String getName() {
		return ClanName;
	}
	public void setName(String Name) {
		this.ClanName = Name;
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
	
	public String getDays() {
		return days;
	}
	
	public void setDays(String Days) {
		this.days = Days;
	}
	
	public Object getClients(int i) {
		return clients.get(i);
	}
	
	public void setClients(String Clients) {
		this.clients.add(Clients);;
	}
	
	public String getRequest() {
		return Request;
	}
	
	public void setRequest(String Request) {
		this.Request = Request;
	}
	
}