package fixtures;

public class Room extends Fixture {
	Room[] exits;
	//Room testReturn;
	
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4];
		// TODO Auto-generated constructor stub
	}
//	
//	public Room(String name, String shortDescription, String longDescription) {
//		super(name, shortDescription, longDescription);
//		this.exits = new Room[3]; // size is your choice
//	}
	
	


	public void setExists(Room room, int i) {
		this.exits[i] = room;
		
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		if(direction.equalsIgnoreCase("north")) {
			return exits[0];
		}
		if(direction.equalsIgnoreCase("south")) {
			return exits[1];
		}
		if(direction.equalsIgnoreCase("east")) {
			return exits[2];
		}
		return exits[3];
		
	}
	
	public void printDirection() {
		if(exits[0] != null) {
			System.out.println("north: " + exits[0].name + "");
		}
		if(exits[1] != null) {
			System.out.println("south: " + exits[1].name + "");
		}
		if(exits[2] != null) {
			System.out.println("east: " + exits[2].name + "");
		}
		if(exits[3] != null) {
			System.out.println("west: " + exits[3].name + "");
		}
	}

	@Override
	public String toString() {
		return name + "\n\n" + shortDescription + "\n" + longDescription;
	}
	
	


}
