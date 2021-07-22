package game;
import fixtures.Item;
public class ItemManager {
	
	private Item[] items = new Item[4];
	public void init() {
		Item item1 = new Item("a book", "some book", "description");
		this.items[0] = item1;
		
	}
}
