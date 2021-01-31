package crawler;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseBrowserThread implements Runnable {

	private String companySelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > div > div > a.name";
	private String titleSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(1) > h1";
	private String descriptionSelector = "#description_div";
	private String publishedSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(75) > div:nth-child(8)";
	private String locationSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(2)";
	private String priceSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(2) > div:nth-child(2) > strong";

	private Collection<RealEstateOffer> repository;
	private String url;
	private WebDriver driver;

	public BaseBrowserThread(String companySelector, String titleSelector, String descriptionSelector,
			String publishedSelector, String locationSelector, String priceSelector,
			Collection<RealEstateOffer> repository, String url) {
		this.companySelector = companySelector;
		this.titleSelector = titleSelector;
		this.descriptionSelector = descriptionSelector;
		this.publishedSelector = publishedSelector;
		this.locationSelector = locationSelector;
		this.priceSelector = priceSelector;
		this.repository = repository;
		this.url = url;
	}

	@Override
	public void run() {
		this.driver = new ChromeDriver();
		this.driver.get(this.url);
		try {

			String company = this.driver.findElement(By.cssSelector(this.companySelector)).getText();
			String title = this.driver.findElement(By.cssSelector(this.titleSelector)).getText();
			String offerurl = url;
			String description = this.driver.findElement(By.cssSelector(this.descriptionSelector)).getText();
			String published = this.driver.findElement(By.cssSelector(this.publishedSelector))
					.getAttribute("textContent");
			String location = this.driver.findElement(By.cssSelector(this.locationSelector)).getText();
			String price = this.driver.findElement(By.cssSelector(this.priceSelector)).getText();

			RealEstateOffer rsOffer = new RealEstateOffer(company, title, offerurl, description, published, location,
					price);
			System.out.println(rsOffer);
			this.repository.add(rsOffer);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.driver.close();
		}

	}

}
