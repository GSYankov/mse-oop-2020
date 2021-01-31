package crawler;

import org.openqa.selenium.By;


public class ImotBgExreactor extends BaseExtractor {

	private static By offersSelector = By.className("photoLink");

	public ImotBgExreactor(String initialUrlPattern) {
		super( initialUrlPattern, offersSelector);
	}


}
