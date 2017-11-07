package com.chofman.helloselenium.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.idfbins.selenium.driver.Browsers;
import com.idfbins.selenium.driver.DriverImplementation;

public class IDFBFWConfiguration extends DriverImplementation {
	
	public IDFBFWConfiguration(Browsers browserToUse) throws Exception {
		super();
		
		Properties prop = new Properties();
		InputStream input = null;
		boolean useEmbeddedDriver = true;
		String urlToUse = null;

		try {

			String filename = "config-local.properties";
			input = IDFBFWConfiguration.class.getClassLoader().getResourceAsStream(filename);
			prop.load(input);

			useEmbeddedDriver = Boolean.valueOf(prop.getProperty("useEmbeddedDriver"));
			urlToUse = prop.getProperty("urlToUse");

		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		loadImplementation(browserToUse, useEmbeddedDriver, urlToUse, null, null, 0);
	}

}
