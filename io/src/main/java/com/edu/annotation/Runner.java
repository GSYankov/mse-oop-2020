package com.edu.annotation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		Fish fish1 = new BigFish("whale", 1000, true);
		Fish fish2 = new SmallFish("salmon", 1, false);
		Fish fish3 = new MediumFish("tuna", 10, true);

		List<Fish> fishes = Arrays.asList(fish1, fish2, fish3);
		Comparator<Fish> fishComparator = (a, b) -> {
			Order annotationA = (Order) a.getClass().getAnnotations()[0];
			Order annotationB = (Order) b.getClass().getAnnotations()[0];
			return annotationA.value() - annotationB.value();
		};
		fishes.sort(fishComparator);
		System.out.println(fishes);
	}

}
