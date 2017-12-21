package location.com.nearme.landing;

import location.com.nearme.ApplicationConstant;

/**
 * Created by Emirates on 12/2/17.
 */

public interface LandingContract {
    interface View {
       void openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS searchOptionId);

    }

    interface Presenter{
        void identifyOptionIdForSearch(int resourceId);

        void setView(LandingContract.View landingScreen);
    }
}
