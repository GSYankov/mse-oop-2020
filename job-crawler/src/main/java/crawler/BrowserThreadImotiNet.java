package crawler;

import java.util.Collection;

public class BrowserThreadImotiNet extends BaseBrowserThread  {
	
	private static String companySelector = "body > div.site > main > div.wrapper.sidebar-layout.padded-none > div > section:nth-child(11) > ul > li:nth-child(1) > div > div > table > tbody > tr > td.block-mobile > h6 > a";
	private static String titleSelector = "#js-ad-container > header > h2";
	private static String descriptionSelector = "#js-ad-container > div.text > p";
	private static String publishedSelector = "#js-ad-container > header > ul";
	private static String locationSelector = "#js-ad-container > header > span.location";
	private static String priceSelector = "body > div.site > main > div.wrapper.sidebar-layout.padded-none > div > aside > section > header > div.big-price > strong";

	public BrowserThreadImotiNet(Collection<RealEstateOffer> repository, String url) {
		super(companySelector, titleSelector, descriptionSelector, publishedSelector, locationSelector, priceSelector,
				repository, url);
	}

}
