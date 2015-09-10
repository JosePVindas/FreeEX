package Weapon;

public abstract class Weapon {
	byte resource;
	int Ctime;
	int power;
	int time;
	boolean image;
	
	public byte getResource() {
		return resource;
	}

	public void setResource(byte resource) {
		this.resource = resource;
	}

	public int getCtime() {
		return Ctime;
	}

	public void setCtime(int ctime) {
		Ctime = ctime;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean getImage() {
		return img;
	}

	public void setImage(boolean img) {
		this.imge = img;
	}

	
	
	public boolean attack (){
		if (this.time != 0){
			return true;
		} else {
			return false;
		}
	}

}