package exceptions.demo;

public class ChainingDemo {

	private static void testMethod(int b) {
		if (b < 3) {
			throw new IllegalArgumentException("b < 3");
		}
	}

	public static void main(String[] args) {
		try {
			testMethod(2);
		} catch (Exception e) {
			throw new CustomException("Exception occured in the method main", e);
		}
	}

}
