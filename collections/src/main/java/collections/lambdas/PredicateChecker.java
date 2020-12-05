package collections.lambdas;

import java.util.function.Predicate;

public class PredicateChecker {

	private static Predicate<Integer> isNegative = n -> (n < 0);

	private static Predicate<String> isCapitalized = str -> {
		char firstChar = str.charAt(0);
		return 65 <= firstChar && firstChar <= 90;
	};

	private static Arithmetics<Integer> sum = (firstNumber, secondNumber) -> (firstNumber * secondNumber);
	private static Arithmetics<Float> sumFloats = (firstNumber, secondNumber) -> (firstNumber - secondNumber);

	public static void main(String[] args) {
		System.out.println(isNegative.test(4));
		System.out.println(isNegative.test(-1));
		System.out.println(" ---------------------------- ");
		System.out.println(isCapitalized.test("A"));
		System.out.println(isCapitalized.test("a"));
		System.out.println(" ---------------------------- ");
		System.out.println(sum.calculate(2, 2));
		System.out.println(sumFloats.calculate(2.2f, 2.2f));

	}

}
