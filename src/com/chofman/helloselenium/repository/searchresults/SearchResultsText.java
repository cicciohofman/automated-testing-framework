package com.chofman.helloselenium.repository.searchresults;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chofman.helloselenium.config.IDFBFWConfiguration;

public class SearchResultsText {

	private IDFBFWConfiguration config;
	
	public SearchResultsText(IDFBFWConfiguration config) {
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
	
	@FindBy(xpath="//div[@class='_NId']/div[@class='srg']/div[@class='g']")
	private List<WebElement> list_div_result;
	
	// ---------------------------------
	// Helper Methods for Above Elements
	// ---------------------------------
	
	public ArrayList<String> getResultTitles() {
		ArrayList<String> titles = new ArrayList<String>();
		for(WebElement e : list_div_result) {
			titles.add(e.findElement(By.xpath(".//h3")).getText());
		}
		
		return titles;
	}
	
}
