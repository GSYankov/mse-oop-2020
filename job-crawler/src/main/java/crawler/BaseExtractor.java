package crawler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseExtractor {

	private By offersSelector;
	private int pageNumber;

	WebDriver driver;
	protected String initialUrlPattern;
	private Queue<String> pageofferLinks;

	public BaseExtractor(String initialUrlPattern, By offersSelector) {
		this.pageNumber = 0;
		this.initialUrlPattern = initialUrlPattern;
		this.offersSelector = offersSelector;
		this.pageofferLinks = new LinkedList<String>();
	}

	private void collectPageOffers() {
		pageNumber += 1;
		String url = String.format(this.initialUrlPattern, this.pageNumber);
		this.driver = new ChromeDriver();
		this.driver.get(url);
		this.pageofferLinks = new LinkedList<String>(driver.findElements(this.offersSelector).stream()
				.map(el -> el.getAttribute("href")).collect(Collectors.toList()));
		this.driver.close();
	}

	public Queue<String> getPageOffers() {
		if (this.pageofferLinks.size() == 0) {
			collectPageOffers();
		}

		return this.pageofferLinks;
	}
}