package com.chofman.helloselenium.repository.searchlanding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chofman.helloselenium.config.IDFBFWConfiguration;
import com.chofman.helloselenium.repository.searchresults.SearchResultsImage;

public class SearchImage {
	
	private IDFBFWConfiguration config;
	
	public SearchImage(IDFBFWConfiguration config) {
		setConfig(config);
		PageFactory.initElements(getConfig().getWebDriver(), this);
	}
	
	public IDFBFWConfiguration getConfig() {
		return config;
	}

	private void setConfig(IDFBFWConfiguration config) {
		this.config = config;
	}

	// ------------------------------------
	// "Recorded Elements" and their XPaths
	// ------------------------------------
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement textfield_SearchQuery;
	
	// ---------------------------------
	// Helper Methods for Above Elements
	// ---------------------------------
	
	public void setSearchQuery(String searchQuery) {
		textfield_SearchQuery.sendKeys(searchQuery);
	}
	
	public SearchResultsImage submitSearchQuery() {
		textfield_SearchQuery.submit();
		return new SearchResultsImage(getConfig());
	}

}
