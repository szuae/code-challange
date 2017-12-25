package location.com.nearme.landing;

import android.support.annotation.VisibleForTesting;

import location.com.nearme.ApplicationConstant;

import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.ATM;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.CAFE;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.FITNESS;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.GASOLINE;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.MOVIES;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.PARKING;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.PHARMACY;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.RESTURANT;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.SHOPPING;
import static location.com.nearme.IDInterface.LandingPageIds.atmId;
import static location.com.nearme.IDInterface.LandingPageIds.cafeId;
import static location.com.nearme.IDInterface.LandingPageIds.fitnessId;
import static location.com.nearme.IDInterface.LandingPageIds.gasId;
import static location.com.nearme.IDInterface.LandingPageIds.mallId;
import static location.com.nearme.IDInterface.LandingPageIds.movieId;
import static location.com.nearme.IDInterface.LandingPageIds.parkingId;
import static location.com.nearme.IDInterface.LandingPageIds.pharmacyId;
import static location.com.nearme.IDInterface.LandingPageIds.resturantId;


public class LandingPresenter implements LandingContract.Presenter {

    LandingContract.View view;


    @Override
    public void identifyOptionIdForSearch(int resourceId) {
        switch (resourceId) {
            case atmId:
                onATMClicked();
                break;
            case fitnessId:
                onFitnessClicked();
                break;
            case cafeId:
                onCafeClicked();
                break;
            case gasId:
                onGasClicked();
                break;
            case mallId:
                onMallClicked();
                break;
            case movieId:
                onMoviesClicked();
                break;
            case parkingId:
                onParkingClicked();
                break;
            case pharmacyId:
                onPharmacyClicked();
                break;
            case resturantId:
                onResturantClicked();
                break;
        }

    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onATMClicked() {
        updateUI(ATM);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onCafeClicked() {
        updateUI(CAFE);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onFitnessClicked() {
        updateUI(FITNESS);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onGasClicked() {
        updateUI(GASOLINE);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onMallClicked() {
        updateUI(SHOPPING);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onMoviesClicked() {
        updateUI(MOVIES);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onParkingClicked() {
        updateUI(PARKING);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onPharmacyClicked() {
        updateUI(PHARMACY);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void onResturantClicked() {
        updateUI(RESTURANT);
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
