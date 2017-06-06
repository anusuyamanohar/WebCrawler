package com.exercise.WebCrawler;

public class App 
{
    public static void main( String[] args )
    {
    		ImageExtractor imageExtractor = new ImageExtractor("WebCrawler-Output");
    		imageExtractor.getPageLinks("http://wiprodigital.com");
    		imageExtractor.ProcessLinks();
    	
    }   	
}
