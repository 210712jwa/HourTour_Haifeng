package game;

import java.util.*;

import fixtures.Item;
import fixtures.Room;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String[] input;
	private static Player player = new Player();
	// private static Room room = new Room();
	private static RoomManager rM = new RoomManager();
	// private static ItemManager itemManager = new ItemManager();
	private static boolean run = true;
	// private ArrayList<Item> = new ArrayList<Item>();

	public static void main(String[] args) {
		// RoomManager rM = new RoomManager();
		// itemManager.init();
		rM.init();

		player.setRoom(rM.getStartingRoom());
		// player.getCurrentRoom().printDirection();
		// boolean run = true;
		while (run) {
			printRoom(player);
			printItem(player);
			printExit(player);
			collectInput();
			parse(input, player);
		}

	}

	private static void printRoom(Player player) {
		Room cRoom = player.getCurrentRoom();
		System.out.println(cRoom);

	}

	private static void printExit(Player player) {
		System.out.println("Exits:");
		Room cRoom = player.getCurrentRoom();
		cRoom.printDirection();
	}

	private static void printItem(Player player) {
		Room cRoom = player.getCurrentRoom();
		System.out.println("Item:");
		for (int i = 0; i < cRoom.getItemSize(); i++) {
			if (cRoom.getItem(i) != null) {
				System.out.println(cRoom.getItemName(i));
			}
		}
		System.out.print("\n");
	}

	private static void pickUpItem(Player player) {
		Room cRoom = player.getCurrentRoom();
		// cRoom.removeItem(, 0);
	}

	private static String[] collectInput() {
		String inputTemp = sc.nextLine();
		input = inputTemp.split("\\s+");

		// System.out.println(input[0] + " " + input[1]);
		return input;

	}

	private static void parse(String[] command, Player player) {

		if (command[0].equalsIgnoreCase("quit")) {
			run = false;
			System.out.println("Quit successfully, goodbye!");
		}
		
		if (command[0].equalsIgnoreCase("pick")) {
			if (command[1].equalsIgnoreCase("up")) {
				if (player.getCurrentRoom().getItemSize() != 0) {
					Item[] itemArray = player.getCurrentRoom().getItem();
					for (int i = 0; i < itemArray.length - 1; i++) {
						String itemName = player.getCurrentRoom().getItemName(i);
						if (command[2].equalsIgnoreCase(itemName)) {
							player.getCurrentRoom().removeItem(player.getCurrentRoom().getItem(), i);
							System.out.println("You pick up " + itemName);
						}

					}
				}
			}
		}

		// if case to change player current room
		if (command[0].equalsIgnoreCase("go")) {

			if (player.getCurrentRoom() != null) {
				switch (command[1].toLowerCase()) {
				case "north":
					player.setRoom(player.getCurrentRoom().getExit("north"));
					break;
				case "east":
					player.setRoom(player.getCurrentRoom().getExit("east"));

					break;
				case "south":
					player.setRoom(player.getCurrentRoom().getExit("south"));

					break;
				case "west":
					player.setRoom(player.getCurrentRoom().getExit("west"));

					break;
				default:
					System.out.print("Invalid input, try again!/n");
					break;

				}

			} else {
				System.out.println("Invaild input, try agin!/n");

			}

		}
	}

}
