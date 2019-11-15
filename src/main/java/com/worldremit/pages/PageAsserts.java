package com.worldremit.pages;

import com.worldremit.assertions.PositionDescriptionPageAssert;

public class PageAsserts {

    public static PositionDescriptionPageAssert assertThat(PositionDescriptionPage positionDescriptionPage) {
        return new PositionDescriptionPageAssert(positionDescriptionPage);
    }
}
