package game;
import fixtures.Item;


public class ItemManager {
	
	private Item[] items = new Item[5];
	
	public void init() {
		Item item1 = new Item("book", "some book", "description");
		this.items[0] = item1;
		
		Item item2 = new Item("switch", "some book", "description");
		this.items[1] = item2;
		
		Item item3 = new Item("ipad", "some book", "description");
		this.items[2] = item3;
		
		Item item4 = new Item("iphone", "some book", "description");
		this.items[3] = item4;
		
		Item item5 = new Item("cup", "some book", "description");
		this.items[4] = item5;
		
		
	}
	
	public Item getItem(int i) {
		return this.items[i];
	}
}
