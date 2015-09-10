package Armor;

public abstract class Armor {
	protected int time; 
	protected int capacity;
	protected int Ctime;
	protected boolean image;
	protected int damage;
	
	
		protected byte resource;
		public byte getResource() {
			return resource;
		}


		public void setResource(byte resource) {
			this.resource = resource;
		}


		public int getTime() {
			return time;
		}


		public void setTime(int time) {
			this.time = time;
		}


		public int getCapacity() {
			return capacity;
		}


		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}


		public int getCtime() {
			return Ctime;
		}


		public void setCtime(int ctime) {
			Ctime = ctime;
		}


		public boolean isImage() {
			return image;
		}


		public void setImage(boolean image) {
			this.image = image;
		}


		public int getDamage() {
			return damage;
		}


		public void setDamage(int damage) {
			this.damage = damage;
		}
	
		public boolean defend(){
			if(this.damage < this.capacity){
				return true;
			} else{
				return false;
			}
			
		}

}