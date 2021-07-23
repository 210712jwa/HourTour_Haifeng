package fixtures;

public class Item extends Fixture {
	Item[] item;

	public Item(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	public void setItems(Item item, int i) {
		this.item[i] = item;
	}

	public Item[] getItem() {
		return this.item;
	}

	public String getItemName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

}
