package com.mse.threads.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JobDownloader implements Runnable {

	private String jobUrl;

	public JobDownloader(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public void run() {
		try {
			Document document = Jsoup.connect(jobUrl).get();
			Elements select = document.select("body > table:nth-child(4) > tbody > tr > td > "
					+ "table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > b");
			System.out.println(select.text());

			select = document.select("body > table:nth-child(4) > tbody > tr > td > table > tbody > "
					+ "tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > a");
			System.out.println(select.text());

			select = document.select("body > table:nth-child(4) > tbody > tr > td > table > tbody > "
					+ "tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td");
			System.out.println(select.text());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
