package game;

import fixtures.Room;

public class RoomManager {

	private Room startingRoom;

	private Room[] rooms = new Room[5];

	private ItemManager itemManager = new ItemManager();

	// initialize rooms
	public void init() {
		itemManager.init();
		Room entrance = new Room("The Entrance", "The small entryway of the house.",
				"The hardwood floor leads north into living room.\n");
		this.rooms[0] = entrance;
		this.startingRoom = entrance;

		Room livingRoom = new Room("The Living Room", "square dining room/living room combo.",
				"A bathroom is open to the north. " + "\n" + "At the south is the entrance. " + "\n"
						+ "To the west is a large bedroom, where you can see wall lamps." + "\n"
						+ "A kitchen is located at the east.");
		this.rooms[1] = livingRoom;

		Room bathroom = new Room("The Bathroom", "A bathroom.",
				"A bedroom is open to the north with a well-stocked bookshelf." + "\n"
						+ "At the south is the living room.");
		this.rooms[2] = bathroom;

		Room bedroom = new Room("The Bedroom", "A large bedroom.",
				"A large, rectangular bedroom.  The floor is carpeted and the walls are papered." + "\n"
						+ " Light is provided by wall lamps.  The room is done in cool colors and overall has a clean look.");
		this.rooms[3] = bedroom;

		Room kitchen = new Room("The Kitchen", "A large kitchen.", "A living room is visible to the south.");
		this.rooms[4] = kitchen;

		// 0 north 1 south 2 east 3 west 4 remain
		// set exit for different room

		entrance.setExists(livingRoom, 0);
		entrance.setExists(entrance, 4);

		livingRoom.setExists(bathroom, 0);
		livingRoom.setExists(entrance, 1);
		livingRoom.setExists(bedroom, 2);
		livingRoom.setExists(kitchen, 3);
		livingRoom.setExists(livingRoom, 4);

		bathroom.setExists(bedroom, 0);
		bathroom.setExists(livingRoom, 1);
		bathroom.setExists(bathroom, 4);

		bedroom.setExists(bathroom, 1);
		bedroom.setExists(livingRoom, 3);
		bedroom.setExists(bedroom, 4);

		kitchen.setExists(livingRoom, 0);
		kitchen.setExists(kitchen, 4);

		// put different item to room
		entrance.setItemToRoom(itemManager.getItem(5), 0);
		livingRoom.setItemToRoom(itemManager.getItem(0), 0);
		bathroom.setItemToRoom(itemManager.getItem(1), 0);
		bedroom.setItemToRoom(itemManager.getItem(3), 0);
		kitchen.setItemToRoom(itemManager.getItem(4), 0);

	}

	public Room getStartingRoom() {
		return this.startingRoom;
	}

}
