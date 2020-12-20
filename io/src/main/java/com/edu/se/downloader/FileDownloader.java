package com.edu.se.downloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloader {

	public static String download(String url, String filePath) {
		InputStream openStream = null;
		BufferedReader br = null;
		BufferedWriter brw = null;
		try {
			URL urlToDownload = new URL(url);
			openStream = urlToDownload.openStream();
			br = new BufferedReader(new InputStreamReader(openStream));

			brw = new BufferedWriter(new FileWriter(new File(filePath)));

			String line = "";
			while ((line = br.readLine()) != null) {
				brw.write(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				openStream.close();
				br.close();
				brw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
