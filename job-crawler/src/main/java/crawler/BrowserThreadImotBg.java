package crawler;

import java.util.Collection;

public class BrowserThreadImotBg extends BaseBrowserThread {

	private static String companySelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > div > div > a.name";
	private static String titleSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(1) > h1";
	private static String descriptionSelector = "#description_div";
	private static String publishedSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(75) > div:nth-child(8)";
	private static String locationSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(1) > div:nth-child(2)";
	private static String priceSelector = "body > div:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > form:nth-child(3) > div:nth-child(73) > table > tbody > tr > td:nth-child(2) > div:nth-child(2) > strong";

	public BrowserThreadImotBg(Collection<RealEstateOffer> repository, String url) {
		super(companySelector, titleSelector, descriptionSelector, publishedSelector, locationSelector, priceSelector,
				repository, url);
	}
}
