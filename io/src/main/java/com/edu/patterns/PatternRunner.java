package com.edu.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternRunner {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("([a]{2})+");
		Matcher matcher = pattern.matcher("aaaaaa");
	}

}
