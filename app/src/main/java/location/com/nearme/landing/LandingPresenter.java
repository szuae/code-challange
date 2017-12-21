package location.com.nearme.landing;

import android.support.annotation.VisibleForTesting;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;


public class LandingPresenter implements LandingContract.Presenter {

    LandingContract.View view;


    @Override
    public void identifyOptionIdForSearch(int resourceId) {
        switch (resourceId) {
            case IDInterface.LandingPageIds.atmId:
                onATMClicked();
                break;
            case IDInterface.LandingPageIds.fitnessId:
                onFitnessClicked();
                break;
            case IDInterface.LandingPageIds.cafeId:
                onCafeClicked();
                break;
            case IDInterface.LandingPageIds.gasId:
                onGasClicked();
                break;
            case IDInterface.LandingPageIds.mallId:
                onMallClicked();
                break;
            case IDInterface.LandingPageIds.movieId:
                onMoviesClicked();
                break;
            case IDInterface.LandingPageIds.parkingId:
                onParkingClicked();
                break;
            case IDInterface.LandingPageIds.pharmacyId:
                onPharmacyClicked();
                break;
            case IDInterface.LandingPageIds.resturantId:
                onResturantClicked();
                break;
        }

    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onATMClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onCafeClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onFitnessClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onGasClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onMallClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onMoviesClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onParkingClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onPharmacyClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onResturantClicked() {
        updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void updateUI(ApplicationConstant.SEARCH_OPTIONS optionId) {
        if (view != null)
            view.openSearchListScreen(optionId);
    }

    @Override
    public void setView(LandingContract.View landingScreen) {
        this.view = landingScreen;
    }
}
