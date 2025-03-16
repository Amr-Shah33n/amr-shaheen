package org.moneyapp;

import java.net.MalformedURLException;
import java.net.URL;

public class URLRetriever {

    public static URL getUrlFromString(URLs urlString) {
        try {
            return new URL(urlString.getUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL: " + urlString.getUrl(), e);
        }
    }

    public enum URLs {
        BROWSER_STACK_APPIUM_SERVER("https://hub.browserstack.com/wd/hub");

        private final String url;

        URLs(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}
