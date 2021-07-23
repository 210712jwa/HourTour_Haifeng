package fixtures;

public class Room extends Fixture {
	Room[] exits;
	Item[] item;

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[5];
		this.item = new Item[10];
	}

	public void setExists(Room room, int i) {
		this.exits[i] = room;

	}

	public void setItemToRoom(Item item, int i) {
		this.item[i] = item;
	}

	public Item[] getItem() {
		return this.item;
	}

	public Item getItem(int i) {
		return item[i];

	}

	public int getItemSize() {
		return this.item.length;
	}

	public String getItemName(int i) {
		return this.item[i].getItemName();

	}

	public void removeItem(int num) {
		this.item[num] = null;
	}

	public Room[] getExits() {
		return this.exits;
	}

	public Room getExit(String direction) {
		if (direction.equalsIgnoreCase("north")) {
			if (exits[0] != null) {
				return exits[0];
			}
		}
		if (direction.equalsIgnoreCase("south")) {
			if (exits[1] != null) {
				return exits[1];
			}
		}
		if (direction.equalsIgnoreCase("east")) {
			if (exits[2] != null) {
				return exits[2];
			}
		}
		if (direction.equalsIgnoreCase("west")) {
			if (exits[3] != null) {
				return exits[3];
			}
		}
		System.out.println("No such direction!\n");
		return exits[4];
	}

	public void printDirection() {
		if (exits[0] != null) {
			System.out.println("north: " + exits[0].name + "");
		}
		if (exits[1] != null) {
			System.out.println("south: " + exits[1].name + "");
		}
		if (exits[2] != null) {
			System.out.println("east: " + exits[2].name + "");
		}
		if (exits[3] != null) {
			System.out.println("west: " + exits[3].name + "");
		}
	}

	@Override
	public String toString() {
		return name + "\n\n" + shortDescription + "\n" + longDescription;
	}

}
