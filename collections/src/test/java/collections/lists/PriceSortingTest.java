package collections.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceSortingTest {

	// class under test
	private ShoppingList cut;

	private Product eggs = new Product("Eggs", 1, 10);
	private Product beer = new Product("Beer", 2, 4);
	private Product yoghurt = new Product("Yogurt", 3, 1);

	@BeforeEach
	public void init() {
		cut = new ShoppingList();
		cut.addProduct(eggs);
		cut.addProduct(beer);
		cut.addProduct(yoghurt);
	}

	@Test
	public void testPrintList() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
		cut.printList();
		System.setOut(old);

		String expected = "Product [name=Eggs, price=1, quantity=10]" + System.lineSeparator()
				+ "Product [name=Beer, price=2, quantity=4]" + System.lineSeparator()
				+ "Product [name=Yogurt, price=3, quantity=1]" + System.lineSeparator();

		String actual = baos.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSortingByName() {
		assertEquals(Arrays.asList(beer, eggs, yoghurt), cut.sortByName());
	}

	@Test
	public void testSortingByPrice() {
		assertEquals(Arrays.asList(eggs, beer, yoghurt), cut.sortByPrice());
	}

	@Test
	public void testIsProductContained() {
		assertTrue(cut.isProductContained(beer));
	}

}
