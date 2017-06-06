package com.exercise.WebCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageExtractor {

	private HashSet<String> links;
	private HashSet<String> imageLink;
	private FileWriter fileWriter;

	public ImageExtractor(String filename) {
		links = new HashSet<String>();
	
		try {
			fileWriter= new FileWriter(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Find all URLs that start with "http://wiprodigital.com/" and add them to
	// the HashSet
	public void getPageLinks(String URL) {
		if (!links.contains(URL)) {
			try {
				Document document = Jsoup.connect(URL).get();
				Elements otherLinks = document.select("a[href^=\"http://wiprodigital.com/\"]");

				for (Element page : otherLinks) {
					links.add(URL);
					getPageLinks(page.attr("abs:href"));
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	// Connect to each link find all the images in the page and write to a file
	public void ProcessLinks() {	
		
		links.forEach(x -> {
		try {
				Document document;
					document = Jsoup.connect(x).get();
					Elements images = document.getElementsByTag("img");
					System.out.println("Links on the page :- " + x + " \n");
					fileWriter.write("Links on the page :- " + x + " \n");
					imageLink = new HashSet<String>();
					for (Element image : images) {
						imageLink.add(image.attr("src"));
					}
					Enumeration<String> imgs = Collections.enumeration(imageLink);
					while (imgs.hasMoreElements()) {
						String temp = "			Images on the page:- " + imgs.nextElement() + " \n";
						// display to console
						System.out.println(temp);
						// save to file
						fileWriter.write(temp);
					}					
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}		
		});
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
}