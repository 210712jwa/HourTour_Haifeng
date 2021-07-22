package game;

import java.util.*;

import fixtures.Room;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String[] input;
	private static Player player = new Player();
	//private static Room room = new Room();
	private static RoomManager rM = new RoomManager();

	public static void main(String[] args) {
		//RoomManager rM =  new RoomManager();
		rM.init();
		player.setRoom(rM.getStartingRoom());
		boolean run = true;
		while(run) {
		
		printRoom(player);
		collectInput();
		parse(input, player, rM);
		}

	}

	private static void printRoom(Player player) {
		Room cRoom = player.getCurrentRoom();
		System.out.println(cRoom);
		cRoom.printDirection();

	}

	private static String[] collectInput() {
		String inputTemp = sc.nextLine();
		input = inputTemp.split("\\s");

		System.out.println(input[0] + " " + input[1]);
		return input;

	}

	private static void parse(String[] command, Player player, RoomManager rM) {
		// do something with command
		String someString1 = command[0];
		String someString2 = command[1];
		
		//if case to change player currentroom
		if (someString1.equalsIgnoreCase("go")) {
			//System.out.println(player.getCurrentRoom());
			//System.out.println(rM.rooms[0]);
			if (player.getCurrentRoom() != null) {
				switch(someString2.toLowerCase()) {
					case "north":
						player.setRoom(player.getCurrentRoom().getExit("north"));
//						System.out.println(rM.getRoom(0).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "east":
						player.setRoom(rM.getRoom(0).getExit("east"));
//						System.out.println(rM.getRoom(0).getExit("east"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "south":
						player.setRoom(rM.getRoom(0).getExit("south"));
//						System.out.println(rM.getRoom(0).getExit("south"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "west":
						player.setRoom(rM.getRoom(0).getExit("west"));
//						System.out.println(rM.getRoom(0).getExit("west"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					default:
						System.out.print("Invalid input, try again!");
						break;

				}
				
			}else if(player.getCurrentRoom() == rM.getRoom(1)) {
				switch(someString2.toLowerCase()) {
					case "north":
						player.setRoom(rM.getRoom(1).getExit("north"));
//						System.out.println(rM.getRoom(0).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "south":
						player.setRoom(rM.getRoom(1).getExit("south"));
//						System.out.println(rM.getRoom(0).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "east":
						player.setRoom(rM.getRoom(1).getExit("east"));
//						System.out.println(rM.getRoom(1).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "west":
						player.setRoom(rM.getRoom(1).getExit("west"));
//						System.out.println(rM.getRoom(1).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					default:
						System.out.print("Invalid input, try again!");
						break;
				}
				
			}else if(player.getCurrentRoom() == rM.getRoom(2)) {
				switch(someString2.toLowerCase()) {
					case "north":
						player.setRoom(rM.getRoom(2).getExit("north"));
//						System.out.println(rM.getRoom(2).getExit("north"));
//						System.out.println(player.getCurrentRoom().toString());
						rM.getRoom(2).printDirection();
						break;
					case "south":
						player.setRoom(rM.getRoom(2).getExit("south"));
//						System.out.println(rM.getRoom(2).getExit("south"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "east":
						player.setRoom(rM.getRoom(2).getExit("east"));
//						System.out.println(rM.getRoom(2).getExit("east"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					case "west":
						player.setRoom(rM.getRoom(2).getExit("west"));
//						System.out.println(rM.getRoom(2).getExit("west"));
//						System.out.println(player.getCurrentRoom().toString());
						break;
					default:
						System.out.print("Invalid input, try again!");
						break;
				}
				
			}else if(player.getCurrentRoom() == rM.getRoom(3)) {
				switch(someString2.toLowerCase()) {
				case "north":
					player.setRoom(rM.getRoom(3).getExit("north"));
//					System.out.println(rM.getRoom(3).getExit("north"));
//					System.out.println(player.getCurrentRoom().toString());
					break;
				case "south":
					player.setRoom(rM.getRoom(3).getExit("south"));
//					System.out.println(rM.getRoom(3).getExit("south"));
//					System.out.println(player.getCurrentRoom().toString());
					break;
				case "east":
					player.setRoom(rM.getRoom(3).getExit("east"));
//					System.out.println(rM.getRoom(3).getExit("east"));
//					System.out.println(player.getCurrentRoom().toString());
					break;
				case "west":
					player.setRoom(rM.getRoom(3).getExit("west"));
//					System.out.println(rM.getRoom(3).getExit("west"));
//					System.out.println(player.getCurrentRoom().toString());
					break;
					default:
						System.out.print("Invalid input, try again!");
						break;
						
				}
			}
	
		} else {
			System.out.println("Invaild input, try agin!");

		}

	}

}
