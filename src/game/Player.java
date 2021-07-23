package game;

import fixtures.Room;

public class Player {
	private Room currentRoom;

	public Player() {
		setRoom(currentRoom);
	}

	public void setRoom(Room currentRoom) {
		this.currentRoom = currentRoom;

	}

	public Room getCurrentRoom() {
		return this.currentRoom;
	}

}
