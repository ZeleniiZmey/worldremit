package com.worldremit.pages;

import com.codeborne.selenide.SelenideElement;
import com.worldremit.data.UsersInfo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

//@Getter(AccessLevel.PACKAGE)
public class PositionDescriptionPage {
    private SelenideElement contentSection = $(className("job-content-header"));
    private SelenideElement jobAppForm = $(byId("job-app-form"));
    private SelenideElement userFirstNameInput = $(byId("First_Name"));
    private SelenideElement userLastNameInput = $(byId("Last_Name"));
    private SelenideElement userEmailInput = $(byId("Email"));
    private SelenideElement userPhoneInput = $(byId("Phone"));
    private SelenideElement applyButton = $(byValue("Apply Now"));
    public SelenideElement errorMessage = $(byId("message_for_Resume"));

    PositionDescriptionPage waitTillPageLoaded() {
        contentSection.waitUntil(visible, timeout);
        return this;
    }

    public PositionDescriptionPage fillEmployeeInformation(UsersInfo userInfo) {
        jobAppForm.scrollTo();
        userFirstNameInput.setValue(userInfo.getFirstName());
        userLastNameInput.setValue(userInfo.getLastName());
        userEmailInput.setValue(userInfo.getEmail());
        userPhoneInput.setValue(userInfo.getPhone().toString());
        return this;
    }

    public void clickApplyButton() {
        applyButton.click();
    }
}
