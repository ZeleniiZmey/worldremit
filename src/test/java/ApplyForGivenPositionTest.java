import com.worldremit.data.UsersInfo;
import com.worldremit.pages.PositionDescriptionPage;
import com.worldremit.setup.UserSessionSetup;
import org.testng.annotations.Test;

import static com.worldremit.pages.PageAsserts.assertThat;


public class ApplyForGivenPositionTest {

    @Test
    public void applyForGivenTestPosition() {
        //given
        PositionDescriptionPage positionDescriptionPage = UserSessionSetup.openStartPage()
                .goToOpportunitiesSection()
                .selectCity()
                .selectDepartment()
                .applyToPosition();

        //when
        positionDescriptionPage.fillEmployeeInformation(UsersInfo.RANDOM_USER).clickApplyButton();

        //then
        assertThat(positionDescriptionPage).isErrorMessageDisplayed().haveExactText("Please attach a resume.");

    }
}
