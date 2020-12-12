package collectons.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTester {

	public static void main(String[] args) {
		// ~30 elements
		Map<Integer, Integer> aMap = new LinkedHashMap<Integer, Integer>();
		aMap.put(10, 1);
		aMap.put(-2, 2);
		aMap.put(3, 3);
		aMap.put(0, 4);

		Integer reduce = aMap.entrySet().parallelStream().map(e -> e.getValue()).reduce(1,
				(currentSum, currentElement) -> (currentSum * currentElement));

		System.out.println(reduce);

	}

}
