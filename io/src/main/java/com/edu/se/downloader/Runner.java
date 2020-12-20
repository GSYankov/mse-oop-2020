package com.edu.se.downloader;

public class Runner {

	public static void main(String[] args) {
		FileDownloader.download("https://www.google.com", "C:\\tmp\\site.txt");
	}

}
