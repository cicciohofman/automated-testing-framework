package com.chofman.helloselenium.repository.searchresults;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chofman.helloselenium.config.IDFBFWConfiguration;

public class SearchResultsImage {

	private IDFBFWConfiguration config;
	
	public SearchResultsImage(IDFBFWConfiguration config) {
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
	
	@FindBy(xpath="//div[@class='_Hyg']/a")
	private List<WebElement> list_anchor_suggestions;
	
	// ---------------------------------
	// Helper Methods for Above Elements
	// ---------------------------------
	
	public ArrayList<String> getSuggestionColors() {
		ArrayList<String> colors = new ArrayList<String>();
		for(WebElement e : list_anchor_suggestions) {
			String color = e.getCssValue("background-color");
			colors.add(color);
		}
		
		return colors;
	}
	
}
