package com.chofman.helloselenium.repository.searchlanding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chofman.helloselenium.config.IDFBFWConfiguration;
import com.chofman.helloselenium.repository.searchresults.SearchResultsText;

public class SearchText {
	
	private IDFBFWConfiguration config;
	
	public SearchText(IDFBFWConfiguration config) {
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
	
	@FindBy(xpath="//a[@class='gb_P' and contains(., 'Im')]")
	private WebElement link_ImagesSearch;
	
	// ---------------------------------
	// Helper Methods for Above Elements
	// ---------------------------------
	
	public void setSearchQuery(String searchQuery) {
		textfield_SearchQuery.sendKeys(searchQuery);
	}
	
	public SearchResultsText submitSearchQuery() {
		textfield_SearchQuery.submit();
		return new SearchResultsText(getConfig());
	}
	
	public SearchImage clickImagesLink() {
		link_ImagesSearch.click();
		return new SearchImage(getConfig());
	}

	

}
