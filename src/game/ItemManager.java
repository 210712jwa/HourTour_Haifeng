package game;
import fixtures.Item;


public class ItemManager {
	
	private Item[] items = new Item[5];
	
	public void init() {
		Item item1 = new Item("book", "some book", "description");
		this.items[0] = item1;
		
		Item item2 = new Item("a book2", "some book", "description");
		this.items[1] = item2;
		
		Item item3 = new Item("a book3", "some book", "description");
		this.items[2] = item3;
		
		Item item4 = new Item("a book4", "some book", "description");
		this.items[3] = item4;
		
		Item item5 = new Item("a book5", "some book", "description");
		this.items[4] = item5;
		
		
	}
	
	public Item getItem(int i) {
		return this.items[i];
	}
}
