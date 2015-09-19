package Clan;
/** Clase cliente, posee todos lo atributos y metodos que de un cliente, como gets y set para cada uno de ellos*/
public class ClientClas {
	
	private String ClientName;
	private String password;
	private String range = "Recluta";
	private String positionx;
	private String positiony;
	private String possessiona;
	private String possessiond;
	private String action;
	private String Clan;

	public ClientClas(String Name, String Password, String Range, String Positionx, String Positiony, String Possessiona, String Possessiond, String Action, String clan) {
		this.ClientName = Name;
		this.password = Password;
		this.range = Range;
		this.positionx = Positionx;
		this.positiony = Positiony;
		this.possessiona = Possessiona;
		this.possessiond = Possessiond;
		this.action = Action;
		this.Clan = clan;
	}
	
	public String getName() {
		return ClientName;
	}
	
	public void setName(String Name) {
		this.ClientName = Name;
	}
	
	public void setPassword(String Password) {
		this.password = Password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRange(String Range) {
		this.range = Range;
	}
	
	public String getRange() {
		return range;
	}
	
	public String getPositionx() {
		return positionx;
	}
	
	public void setPositionx(String Positionx) {
		this.positionx = Positionx;
	}
	
	public String getPositiony() {
		return positiony;
	}
	
	public void setPositiony(String Positiony) {
		this.positiony = Positiony;
	}
	
	public void setPossessiona(String Possessiona) {
		this.possessiona = Possessiona;
	}
	public String getPossessiona() {
		return possessiona;
	}
	
	public void setPossessiond(String Possessiond) {
		this.possessiond = Possessiond;
	}
	public String getPossessiond() {
		return possessiond;
	}
	
	public void setAction(String Action) {
		this.action = Action;
	}
	public String getAction() {
		return action;
	}
	public String getClan() {
		return Clan;
	}
	
	public void setClan(String clan) {
		this.Clan = clan;
	}
	/** Se encarga de convertir en un string todo el objeto cliente*/
	public String toString() {
	    return "{ClientName: " + getName() +", password: "+ getPassword() + ", range: " + getRange() + ", positionx: "+ getPositionx()+ ", positiony: "+ getPositiony()+ ", possessiona:"+ getPossessiona()+", possessiond:"+ getPossessiond()+", action:"+ getAction()+", Clan:"+ getClan()+"}";
	  }
}