package fixtures;
import java.util.*;

public class Item extends Fixture {
	Item[] item;
	
	public Item(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		// TODO Auto-generated constructor stub
	}
	
	public void setItems(Item item, int i) {
		this.item[i] = item;	
	}
	
	public Item[] getItem() {
		return this.item;
	}

	public void removeItem(Item[] item, int num) {
		
		Item[] itemCopy = new Item[item.length - 1];
		for(int i = 0, j = 0; i < item.length; i++ ) {
			if(i != num) {
				itemCopy[j++] = item[i];
			}
			this.item = itemCopy;
		}
}
}
