package com.amazon.config;


public class Config {
	public static final String url = "https://www.amazon.in/";
	public static final String userName = "9833772956";
	public static final String password = "12345678";
	public static final String BROWSER_NAME = TestConfig.BROWSER_FIREFOX;
    public static final int TIMEOUT_EXPLICIT_IN_SECS = 5000;

	public static final String RAMGB128 = "128 GB";
	public static final String RAMGB256 = "256 GB";

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

	public enum RamSize {
        GB128, GB256;
        @Override
        public String toString() {
            switch (this) {
                case GB128:
                    return RAMGB128;
                case GB256:
                    return RAMGB256;
                default:
                    return null;
            }
        }
    };
	
}
