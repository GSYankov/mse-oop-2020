package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProgramStart {

	public static void main(String[] args) throws IOException {

		int parallelism = 1;
		int maxCoutOfOffers = 5;
		ExecutorService executor = Executors.newFixedThreadPool(parallelism);

		Collection<RealEstateOffer> reOffers = Collections.synchronizedCollection(new ArrayList<RealEstateOffer>());

		String imotBgFilter = "6atskq";
		String imotBgInitialUrlPattern = String.format("https://www.imot.bg/pcgi/imot.cgi?act=3&slink=%s&f1=%s",
				imotBgFilter, "%s");
		BaseExtractor ibe = new ImotBgExreactor(imotBgInitialUrlPattern);

		String imotiNetFilter = "fGKp6B";
		String imotiNetInitialUrlPattern = String
				.format("https://www.imoti.net/bg/obiavi/r/prodava/sofia/?page=%s&sid=%s", "%s", imotiNetFilter);
		BaseExtractor ine = new ImotiNetExreactor(imotiNetInitialUrlPattern);

		while (reOffers.size() <= maxCoutOfOffers) {

			Integer activeThreads = Integer.parseInt(executor.toString().split(",")[2].split(" = ")[1]);

			if (activeThreads == parallelism) {
				continue;
			}

			if (ibe.getPageOffers().size() == 0 && ine.getPageOffers().size() == 0) {
				break;
			}

//			if (ibe.getPageOffers().size() > 0) {
//				String url = ibe.getPageOffers().poll();
//				BrowserThreadImotBg browserThread = new BrowserThreadImotBg(reOffers, url);
//				executor.execute(browserThread);
//			}

			if (ibe.getPageOffers().size() > 0) {
				String urlIne = ine.getPageOffers().poll();
				BrowserThreadImotiNet browserThreadIne = new BrowserThreadImotiNet(reOffers, urlIne);
				executor.execute(browserThreadIne);
			}

		}

		executor.shutdown();

		System.out.println("Finished all threads");
	}

	private static void extractFromImotiNet(ArrayList<RealEstateOffer> rsOffers) {

		By offersSelector = By.cssSelector("ul.list-view.real-estates li a");
		String companySelector = "body > div.site > main > div.wrapper.sidebar-layout.padded-none > div > section:nth-child(11) > ul > li:nth-child(1) > div > div > table > tbody > tr > td.block-mobile > h6 > a";
		String titleSelector = "#js-ad-container > header > h2";
		String descriptionSelector = "#js-ad-container > div.text > p";
		String publishedSelector = "#js-ad-container > header > ul";
		String locationSelector = "#js-ad-container > header > span.location";
		String priceSelector = "body > div.site > main > div.wrapper.sidebar-layout.padded-none > div > aside > section > header > div.big-price > strong";

		int pageNumber = 1;
		String filter = "fGKp6B";
		String initialUrl = String.format("https://www.imoti.net/bg/obiavi/r/prodava/sofia/?page=%s&sid=%s", pageNumber,
				filter);

//		System.setProperty("webdriver.chrome.driver", "C:\\tmp\\selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--window-size=1400,800");
		WebDriver driver = new ChromeDriver(options);
		driver.get(initialUrl);
		Queue<String> offerLinks = new LinkedList<>(driver.findElements(offersSelector).stream()
				.map(el -> el.getAttribute("href")).collect(Collectors.toList()));

		while (offerLinks.size() > 0) {

			while (offerLinks.size() > 0) {
				String url = offerLinks.poll();
				driver.get(url);

				String company = driver.findElement(By.cssSelector(companySelector)).getText();
				String title = driver.findElement(By.cssSelector(titleSelector)).getText();
				String offerurl = url;
				String description = driver.findElement(By.cssSelector(descriptionSelector)).getText();
				String published = driver.findElement(By.cssSelector(publishedSelector)).getAttribute("textContent");
				String location = driver.findElement(By.cssSelector(locationSelector)).getText();
				String price = driver.findElement(By.cssSelector(priceSelector)).getText();

				RealEstateOffer rsOffer = new RealEstateOffer(company, title, offerurl, description, published,
						location, price);
				System.out.println(rsOffer);
				rsOffers.add(rsOffer);

			}

			pageNumber += 1;
			String url = String.format("https://www.imot.bg/pcgi/imot.cgi?act=3&slink=%s&f1=%s", filter, pageNumber);
			driver.get(url);
			offerLinks = new LinkedList<>(driver.findElements(By.className("photoLink")).stream()
					.map(el -> el.getAttribute("href")).collect(Collectors.toList()));
		}

	}

	private static void extractFromImotBg(ArrayList<RealEstateOffer> rsOffers) {

		By offersSelector = By.className("photoLink");
		String companySelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > div > div > a.name";
		String titleSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(1) > h1";
		String descriptionSelector = "#description_div";
		String publishedSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(75) > div:nth-child(8)";
		String locationSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(2)";
		String priceSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(2) > div:nth-child(2) > strong";

		int pageNumber = 1;
		String filter = "6atskq";
		String initialUrl = String.format("https://www.imot.bg/pcgi/imot.cgi?act=3&slink=%s&f1=%s", filter, pageNumber);

//		System.setProperty("webdriver.chrome.driver", "C:\\tmp\\selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--window-size=1400,800");
		WebDriver driver = new ChromeDriver(options);
		driver.get(initialUrl);
		Queue<String> offerLinks = new LinkedList<>(driver.findElements(offersSelector).stream()
				.map(el -> el.getAttribute("href")).collect(Collectors.toList()));

		while (offerLinks.size() > 0) {

			while (offerLinks.size() > 0) {
				String url = offerLinks.poll();
				driver.get(url);

				String company = driver.findElement(By.cssSelector(companySelector)).getText();
				String title = driver.findElement(By.cssSelector(titleSelector)).getText();
				String offerurl = url;
				String description = driver.findElement(By.cssSelector(descriptionSelector)).getText();
				String published = driver.findElement(By.cssSelector(publishedSelector)).getAttribute("textContent");
				String location = driver.findElement(By.cssSelector(locationSelector)).getText();
				String price = driver.findElement(By.cssSelector(priceSelector)).getText();

				RealEstateOffer rsOffer = new RealEstateOffer(company, title, offerurl, description, published,
						location, price);
				System.out.println(rsOffer);
				rsOffers.add(rsOffer);

			}

			pageNumber += 1;
			String url = String.format("https://www.imot.bg/pcgi/imot.cgi?act=3&slink=%s&f1=%s", filter, pageNumber);
			driver.get(url);
			offerLinks = new LinkedList<>(driver.findElements(By.className("photoLink")).stream()
					.map(el -> el.getAttribute("href")).collect(Collectors.toList()));
		}

	}

	public static void extractFromJobsbg(ArrayList<JobOffer> jobOffers) throws IOException {
		for (int i = 0; i < 15; i += 15) {
			Document dom = Jsoup.connect("https://www.jobs.bg/front_job_search.php?frompage=0").get();
			Elements elements = dom.select(".joblink");

			elements.forEach(element -> {
				String attr = element.attr("href");
				JobExtractor jobExtractor = new JobExtractor(attr, jobOffers);
				Thread thread = new Thread(jobExtractor);
				thread.start();
			});

		}
	}

}
