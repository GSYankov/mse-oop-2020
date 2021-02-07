package edu.mse.re.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import edu.mse.re.extractor.BaseExtractor;
import edu.mse.re.extractor.ImotBgExreactor;
import edu.mse.re.extractor.ImotiNetExreactor;
import edu.mse.re.offer.RealEstateOffer;
import edu.mse.re.thread.BrowserThreadImotBg;
import edu.mse.re.thread.BrowserThreadImotiNet;

public class ProgramStart {

	public static void main(String[] args) throws IOException, InterruptedException {

		int parallelism = 1;
		int maxCoutOfOffers = 5;
		int delayConst = 2;
		ExecutorService executor = Executors.newFixedThreadPool(parallelism);

		Collection<RealEstateOffer> reOffers = Collections.synchronizedCollection(new ArrayList<RealEstateOffer>());

		String imotBgFilter = "6cku5f";
		String imotBgInitialUrlPattern = String.format("https://www.imot.bg/pcgi/imot.cgi?act=3&slink=%s&f1=%s",
				imotBgFilter, "%s");
		BaseExtractor ibe = new ImotBgExreactor(imotBgInitialUrlPattern);

		String imotiNetFilter = "fGKp6B";
		String imotiNetInitialUrlPattern = String
				.format("https://www.imoti.net/bg/obiavi/r/prodava/sofia/?page=%s&sid=%s", "%s", imotiNetFilter);
		BaseExtractor ine = new ImotiNetExreactor(imotiNetInitialUrlPattern);

		while (reOffers.size() <= maxCoutOfOffers) {

			int delay = (int) (Math.random() * delayConst *1000) ;
			TimeUnit.MICROSECONDS.sleep(delay);

			Integer activeThreads = Integer.parseInt(executor.toString().split(",")[2].split(" = ")[1]);

			if (activeThreads == parallelism) {
				continue;
			}

			if (ibe.getPageOffers().size() == 0 && ine.getPageOffers().size() == 0) {
				break;
			}

			if (ibe.getPageOffers().size() > 0) {
				String url = ibe.getPageOffers().poll();
				BrowserThreadImotBg browserThread = new BrowserThreadImotBg(reOffers, url);
				executor.execute(browserThread);
			}

			if (ine.getPageOffers().size() > 0) {
				String urlIne = ine.getPageOffers().poll();
				BrowserThreadImotiNet browserThreadIne = new BrowserThreadImotiNet(reOffers, urlIne);
				executor.execute(browserThreadIne);
			}

		}

		executor.shutdown();

		System.out.println("Finished all threads");
	}
}
