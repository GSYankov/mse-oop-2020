package edu.mse.re.unused;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JobExtractor implements Runnable {

	private String COMPANY_SELECTOR = "body > table:nth-child(4) > tbody > tr > td > table > tbody > "
			+ "tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > a";
	private String JOBTITLE_SELECTOR = "body > table:nth-child(4) > tbody > tr > td > "
			+ "table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > b";
	private String DESCRIPTION_SELECOR = "N/A";
	private String REFNUM_SELECTOR = "N/A";
	private String LOCATION_SELECTOR = "body > table:nth-child(4) > tbody > tr > td > table > tbody > "
			+ "tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td";
	private String SALARY_SELECTOR = "N/A";
	private String DOMAIN = "https://www.jobs.bg/";

	private String jobUrl;
	private ArrayList<JobOffer> offers;

	public JobExtractor(String attr, ArrayList<JobOffer> offers) {
		this.jobUrl = this.DOMAIN + attr;
		this.offers = offers;
	}

	public void run() {
		try {
			Document document = Jsoup.connect(this.jobUrl).get();
			String jobTitle = document.select(this.JOBTITLE_SELECTOR).text();
			String company = document.select(this.COMPANY_SELECTOR).text();
			String location = document.select(this.LOCATION_SELECTOR).text();
 			String salary = document.select(this.SALARY_SELECTOR).text();
			String description = document.select(this.DESCRIPTION_SELECOR).text();
			String refNum = document.select(this.REFNUM_SELECTOR).text();

			JobOffer offer = new JobOffer(company, jobTitle, this.jobUrl, description, refNum, location, salary);
			this.offers.add(offer);
			System.out.println(offer);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
