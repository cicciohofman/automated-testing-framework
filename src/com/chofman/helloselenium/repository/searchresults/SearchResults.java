package com.chofman.helloselenium.repository.searchresults;

import org.openqa.selenium.support.PageFactory;

import com.chofman.helloselenium.config.IDFBFWConfiguration;

public class SearchResults {
	
	private IDFBFWConfiguration config;
	
	public SearchResults(IDFBFWConfiguration config) {
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
	
	
	
	// ---------------------------------
	// Helper Methods for Above Elements
	// ---------------------------------
	
	

}
