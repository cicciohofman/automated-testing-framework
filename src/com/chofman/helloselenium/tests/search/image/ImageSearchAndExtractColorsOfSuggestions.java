package com.chofman.helloselenium.tests.search.image;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chofman.helloselenium.config.IDFBFWConfiguration;
import com.chofman.helloselenium.repository.searchlanding.SearchImage;
import com.chofman.helloselenium.repository.searchlanding.SearchText;
import com.chofman.helloselenium.repository.searchresults.SearchResultsImage;
import com.idfbins.selenium.driver.Browsers;

public class ImageSearchAndExtractColorsOfSuggestions {
	
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
		SearchImage myImageSearchPage = myHomePage.clickImagesLink();
		myImageSearchPage.setSearchQuery("WebDriver");
		SearchResultsImage myImageSearchResultsPage = myImageSearchPage.submitSearchQuery();
		ArrayList<String> colors = myImageSearchResultsPage.getSuggestionColors();
		System.out.println("Total Num Suggestion Colors: " + colors.size());
		for(String color : colors) {
			System.out.println(color);
		}
		
	}
	
}
