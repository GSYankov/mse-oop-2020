package collections.lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ShoppingList {

	private List<Product> products = new LinkedList<Product>();
	private Comparator<Product> productComparatorByName = (p1, p2) -> (p1.getName().compareTo(p2.getName()));
	private Comparator<Product> productComparatorByPrice = (p1, p2) -> (p1.getPrice() - p2.getPrice());

	public void addProduct(Product product) {
		products.add(product);
	}

	public List<Product> sortByName() {

		Collections.sort(products, productComparatorByName);
		return products;
	}

	public void printList() {
		products.forEach(System.out::println);
	}

	public List<Product> sortByPrice() {

		Collections.sort(products, productComparatorByPrice);
		return products;
	}

	public Boolean isProductContained(Product product) {
		Predicate<Product> isProductEqual = (p1 -> product.getName().toLowerCase().equals(p1.getName().toLowerCase()));
		return products.stream().anyMatch(isProductEqual);
	}
}
