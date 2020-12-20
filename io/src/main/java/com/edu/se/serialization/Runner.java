package com.edu.se.serialization;

import com.edu.annotation.Fish;

public class Runner {

	public static void main(String[] args) {
		// FishSerializer.serialize(new Fish("barakuda", 1, true), "C:\\tmp\\fish.txt");
		Fish fish = FishSerializer.deserialize("C:\\tmp\\fish.txt");
		Fish fish1 = FishSerializer.deserialize("C:\\tmp\\fish.txt");
		Fish fish3 = FishSerializer.deserialize("C:\\tmp\\fish.txt");
		System.out.println(fish.hashCode() + " " + fish1.hashCode() + " " + fish3.hashCode());
		System.out.println(fish);
	}

}
