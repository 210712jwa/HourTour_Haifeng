package game;

import fixtures.Room;

public class RoomManager {

	private Room startingRoom;

	private Room[] rooms = new Room[4];
	
	private ItemManager itemManager = new ItemManager();

	public void init() {
		itemManager.init();
		Room foyer = new Room("Enterance", "The small entryway of a neo-colonial house.", "The hardwood floor leads west into doorway,\n");
		this.rooms[0] = foyer;
		//System.out.println(this.rooms[0]);
		this.startingRoom = foyer;

		

		Room room1 = new Room("room1", "shortDes", "long\n");
		this.rooms[1] = room1;

		Room room2 = new Room("room2", "shortDes",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
						+ "\n"
						+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
						+ "\n" + "To the north is a small room, where you can see a piano\n.");
		this.rooms[2] = room2;

		Room room3 = new Room("room3", "shortDes",
				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen."
						+ "\n"
						+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor."
						+ "\n" + "To the north is a small room, where you can see a piano\n.");
		this.rooms[3] = room3;
	
		foyer.setExists(room1, 0);
		foyer.setExists(foyer, 4);
		
		//room 1
		room1.setExists(room2, 0);
		room1.setExists(foyer, 1);
		room1.setExists(room3, 2);
		room1.setExists(room1, 4);
		
		//room 2
		room2.setExists(room3, 0);
		room2.setExists(room1, 1);
		room2.setExists(room2, 4);
		
		//room 3
		room3.setExists(room2, 1);
		room3.setExists(room1, 3);
		room3.setExists(room3, 4);
		
		foyer.setItemToRoom(itemManager.getItem(0), 0);
		room1.setItemToRoom(itemManager.getItem(0), 0);
		room1.setItemToRoom(itemManager.getItem(1), 1);
		room2.setItemToRoom(itemManager.getItem(2), 0);
		room3.setItemToRoom(itemManager.getItem(3), 0);
		//room3.setItemToRoom(itemManager.getItem(4), 1);
	
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	

}
