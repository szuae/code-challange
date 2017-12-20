package location.com.nearme.landing;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;


public class LandingPresenter implements LandingContract.Presenter {

    LandingContract.View view;


    @Override
    public void identifyOptionIdForSearch(int resourceId) {
        String optionId = "";
        switch (resourceId) {
            case IDInterface.LandingPageIds.atmId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.ATM.getValue();
                break;
            case IDInterface.LandingPageIds.fitnessId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue();
                break;
            case IDInterface.LandingPageIds.cafeId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue();
                break;
            case IDInterface.LandingPageIds.gasId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.GAS.getValue();
                break;
            case IDInterface.LandingPageIds.mallId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue();
                break;
            case IDInterface.LandingPageIds.movieId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue();
                break;
            case IDInterface.LandingPageIds.parkingId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue();
                break;
            case IDInterface.LandingPageIds.pharmacyId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue();
                break;
            case IDInterface.LandingPageIds.resturantId:
                optionId = ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue();
                break;
        }
        if (view != null)
            view.openSearchListScreen(optionId);
    }

    @Override
    public void setView(LandingContract.View landingScreen) {
        this.view = landingScreen;
    }
}
