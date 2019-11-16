package com.worldremit.assertions;

import com.worldremit.pages.PositionDescriptionPage;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PositionDescriptionPageAssert extends AbstractAssert<PositionDescriptionPageAssert, PositionDescriptionPage> {

    public PositionDescriptionPageAssert(PositionDescriptionPage actual) {
        super(actual, PositionDescriptionPageAssert.class);
    }

    public PositionDescriptionPageAssert hasErrorMessage() {
        assertThat(actual.errorMessage.isDisplayed()).isTrue();
        return this;
    }

    public void haveExactText(String errorMessage) {
        String errorMessageText = actual.errorMessage.getAttribute("data-message-error");
        assertThat(errorMessageText).isEqualTo(errorMessage);
    }
}
