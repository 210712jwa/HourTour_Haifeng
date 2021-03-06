package game;

import java.util.*;

import fixtures.Item;
import fixtures.Room;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String[] input;
	private static Player player = new Player();
	private static RoomManager rM = new RoomManager();
	private static boolean run = true;
	private static List<Item> playerItem = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Command: go + direction, pick up + item name, open bag, put down, quit");
		rM.init();
		player.setRoom(rM.getStartingRoom());
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

	// print item in room
	private static void printItem(Player player) {
		Room cRoom = player.getCurrentRoom();
		System.out.println("Item:");
		for (int i = 0; i < cRoom.getItemSize(); i++) {
			if (cRoom.getItem(i) != null) {
				System.out.println(cRoom.getItemName(i));
			}
		}
		System.out.println("\n");
	}

	// split input by space
	private static String[] collectInput() {
		String inputTemp = sc.nextLine();
		input = inputTemp.split("\\s+");
		return input;

	}

	// take in user input and proceed command
	private static void parse(String[] command, Player player) {

		if (command[0].equalsIgnoreCase("quit")) {
			run = false;
			System.out.println("Quit successfully, goodbye!");
		}

		// pick up command
		if (command[0].equalsIgnoreCase("pick")) {
			if (command[1].equalsIgnoreCase("up")) {
				if (player.getCurrentRoom().getItemSize() != 0) {

					Item[] itemArray = player.getCurrentRoom().getItem();
					// remove item from stored array and put the removed item to array list(bag)
					for (int i = 0; i < itemArray.length - 1; i++) {
						if (player.getCurrentRoom().getItem(i) != null) {
							String itemName = player.getCurrentRoom().getItemName(i);
							if (command[2].equalsIgnoreCase(itemName)) {
								playerItem.add(player.getCurrentRoom().getItem(i));
								player.getCurrentRoom().removeItem(i);
								System.out.println("You pick up " + itemName + ".\n");
							}
						}
					}
				}
			}
		}

		// put down command
		if (command[0].equalsIgnoreCase("put")) {
			if (command[1].equalsIgnoreCase("down")) {
				for (int i = playerItem.size() - 1; i >= 0 ; i--) {
						if (command[2].equalsIgnoreCase(playerItem.get(i).toString())) {
							for (int j = 0; j < player.getCurrentRoom().getItem().length; j++) {
								if (player.getCurrentRoom().getItem(j) == null) {
									player.getCurrentRoom().setItemToRoom(playerItem.get(i), j);
									playerItem.remove(i);
									break;
								}
							
						}
					}
				}

			}
		}

		// see item in bag
		if (command[0].equalsIgnoreCase("open")) {
			if (command[1].equalsIgnoreCase("bag")) {
				if (playerItem.size() == 0) {
					System.out.println("Nothing in the bag!\n");
				} else {
					System.out.println("You have " + playerItem.toString() + ".\n");
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
					System.out.println("Invalid direction, try again!\n");
					break;

				}

			} else {
				System.out.println("Invaild input, try agin!\n");

			}

		}
	}

}
