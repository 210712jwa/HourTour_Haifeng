package game;

import fixtures.Item;

public class ItemManager {

	private Item[] items = new Item[6];

	// initialize item
	public void init() {
		Item cup = new Item("cup", "some cup", "a tea cup fill with water");
		this.items[0] = cup;

		Item towel = new Item("towel", "some towel", "a white shower towel");
		this.items[1] = towel;

		Item ipad = new Item("ipad", "some ipad", "a black ipad pro");
		this.items[2] = ipad;

		Item iphone = new Item("iphone", "some iphone", "a black iphone 8");
		this.items[3] = iphone;

		Item bowl = new Item("bowl", "some bowl", "a large bowl of rice");
		this.items[4] = bowl;

		Item book = new Item("key", "some key", "house key and keys for different room");
		this.items[5] = book;
	}

	public Item getItem(int i) {
		return this.items[i];
	}
}
