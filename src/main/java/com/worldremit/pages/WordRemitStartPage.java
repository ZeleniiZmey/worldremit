package com.worldremit.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.By.className;

//@Getter(AccessLevel.PACKAGE)
public class WordRemitStartPage {
    private SelenideElement contentSection = $(className("header-section"));
    private SelenideElement applyButton = $(byText("QA/Test Engineer"));
    private SelenideElement departmentDropDown = $(byId("department-select"));
    private SelenideElement cityDropDown = $(byId("office-select"));
    private SelenideElement jobsGrid = $(className("jobs-grid"));
    private SelenideElement opportunitiesSection = $(byText("Our opportunities"));

    public WordRemitStartPage waitTillPageLoaded() {
        contentSection.waitUntil(visible, timeout);
        return this;
    }

    public WordRemitStartPage goToOpportunitiesSection() {
        opportunitiesSection.scrollTo();
        return this;
    }

    public WordRemitStartPage selectDepartment() {
        departmentDropDown.selectOptionByValue("engineering & it");
        jobsGrid.waitUntil(visible, timeout);
        return this;
    }

    public WordRemitStartPage selectCity() {
        cityDropDown.selectOptionByValue("kraków");
        jobsGrid.waitUntil(visible, timeout);
        return this;
    }

    public PositionDescriptionPage applyToPosition() {
        applyButton.scrollTo().click();
        return page(PositionDescriptionPage.class).waitTillPageLoaded();
    }
}
