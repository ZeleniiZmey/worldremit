package com.worldremit.setup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.worldremit.pages.WordRemitStartPage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static com.worldremit.config.Configuration.CONFIGURATION;

@Getter(AccessLevel.PUBLIC)
public class UserSessionSetup {

    private static final String HOST = CONFIGURATION.getHostUrl();
    private final WebDriver webDriver;

    private UserSessionSetup(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static void configureDriver() {
        if (hasWebDriverStarted()) {
            WebDriverRunner.getAndCheckWebDriver();
            return;
        }
        setBasicDriverSettings();
        Configuration.browserCapabilities = new DesiredCapabilities(new FirefoxOptions().setAcceptInsecureCerts(true));
    }

    private static void setBasicDriverSettings() {
        Configuration.baseUrl = CONFIGURATION.getHostUrl();
        Configuration.browser = CONFIGURATION.getDriverBrowserType();
        Configuration.fastSetValue = true;
    }

    public static WordRemitStartPage openStartPage() {
        configureDriver();
        open(HOST);
        return new WordRemitStartPage().waitTillPageLoaded();
    }
}
