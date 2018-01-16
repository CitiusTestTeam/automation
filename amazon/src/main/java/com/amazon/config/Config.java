package com.amazon.config;


public class Config {
	public static final String url = "https://www.amazon.in/";
	public static final String userName = "9833772956";
	public static final String password = "12345678";
	public static final String BROWSER_NAME = TestConfig.BROWSER_FIREFOX;
    public static final int TIMEOUT_EXPLICIT_IN_SECS = 5000;

    
	public static String getUrl() {
		return url;
	}
	public static String getUsername() {
		return userName;
	}
	public static String getPassword() {
		return password;
	}
	public static String getBrowserName() {
		return BROWSER_NAME;
	}

}
