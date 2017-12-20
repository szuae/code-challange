package location.com.nearme.landing;

/**
 * Created by Emirates on 12/2/17.
 */

public interface LandingContract {
    interface View {
       void openSearchListScreen(String searchOptionId);

    }

    interface Presenter{
        void identifyOptionIdForSearch(int resourceId);

        void setView(LandingContract.View landingScreen);
    }
}
