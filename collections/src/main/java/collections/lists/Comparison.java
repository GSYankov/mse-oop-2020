package collections.lists;

public class Comparison {

	public static void main(String[] args) {
		ShoppingList list = new ShoppingList();
		Product eggs = new Product("Eggs", 1, 10);
		Product beer = new Product("Beer", 2, 4);
		Product yoghurt = new Product("Yogurt", 3, 1);

		list.printList();
	}

}
