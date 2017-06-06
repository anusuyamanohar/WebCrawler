# WebCrawler
Basic Web Crawler

This project crawls the  website "http://wiprodigital.com" to get all the URLs on the website.The URLs are further scanned for the images.The output is a text file "WebCrawler-Output" with all the URLs and respective images.

Jsoup 1.8.1 library is used to parse the HTML and get the URLs and the images.

This project is built using Java 8 and  maven.

ImageExtractor.java parses the website , gets the URLs ,respective images and writes to a file
App.java  is has the main() method to run this application.


