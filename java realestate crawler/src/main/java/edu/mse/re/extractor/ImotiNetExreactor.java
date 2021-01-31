package edu.mse.re.extractor;

import org.openqa.selenium.By;

public class ImotiNetExreactor extends BaseExtractor {

	private By offersSelector = By.cssSelector("ul.list-view.real-estates li a");

	public ImotiNetExreactor(String initialUrlPattern) {
		super(initialUrlPattern, By.cssSelector("ul.list-view.real-estates li a"));

	}

}
