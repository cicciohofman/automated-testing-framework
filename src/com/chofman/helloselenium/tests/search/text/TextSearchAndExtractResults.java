package com.chofman.helloselenium.tests.search.text;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chofman.helloselenium.config.IDFBFWConfiguration;
import com.chofman.helloselenium.repository.searchlanding.SearchText;
import com.chofman.helloselenium.repository.searchresults.SearchResultsText;
import com.idfbins.selenium.driver.Browsers;

public class TextSearchAndExtractResults {
	
	IDFBFWConfiguration myConfig = null;
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws Exception {
		myConfig = new IDFBFWConfiguration(Browsers.Chrome);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Exception {
		myConfig.quit();
	}	

	@Test()
	public void testTextSearchAndExtractResults() throws Exception {
		
		SearchText myHomePage = new SearchText(myConfig);
		myHomePage.setSearchQuery("WebDriver");
		SearchResultsText mySearchResults = myHomePage.submitSearchQuery();
		ArrayList<String> titles = mySearchResults.getResultTitles();
		System.out.println("Total Num Search Results: " + titles.size());
		for(String title : titles) {
			System.out.println(title);
		}
		
	}
	
}
