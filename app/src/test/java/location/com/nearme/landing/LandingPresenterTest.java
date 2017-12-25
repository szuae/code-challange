package location.com.nearme.landing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;

import static location.com.nearme.IDInterface.LandingPageIds.atmId;
import static location.com.nearme.IDInterface.LandingPageIds.cafeId;
import static location.com.nearme.IDInterface.LandingPageIds.fitnessId;
import static location.com.nearme.IDInterface.LandingPageIds.gasId;
import static location.com.nearme.IDInterface.LandingPageIds.mallId;
import static location.com.nearme.IDInterface.LandingPageIds.movieId;
import static location.com.nearme.IDInterface.LandingPageIds.parkingId;
import static location.com.nearme.IDInterface.LandingPageIds.pharmacyId;
import static location.com.nearme.IDInterface.LandingPageIds.resturantId;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LandingPresenterTest {

    LandingPresenter presenter;
    @Mock
    LandingContract.View view;

    @Before
    public void setup() {
        presenter = Mockito.spy(new LandingPresenter());
        presenter.setView(view);
    }

    @Test
    public void updateUITestWhenViewIsNull() {
        presenter.setView(null);
        presenter.updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
    }

    @Test
    public void updateUITestWhenViewIsSet() {
        presenter.updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
    }

    @Test
    public void onATMClickedTest() {
        presenter.onATMClicked();
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onCafeClickedTest() {
        presenter.onCafeClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onFitnessClickedTest() {
        presenter.onFitnessClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onGasClickedTest() {
        presenter.onGasClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onParkingClickedTest() {
        presenter.onParkingClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onMovieClickedTest() {
        presenter.onMoviesClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onMallClickedTest() {
        presenter.onMallClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onResturantClickedTest() {
        presenter.onResturantClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void onPharmacyClickedTest() {
        presenter.onPharmacyClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }

    @Test
    public void identifyOptionIdForSearchTest() {

        presenter.identifyOptionIdForSearch(atmId);
        verify(presenter, Mockito.times(1)).onATMClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(cafeId);
        verify(presenter, Mockito.times(1)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(fitnessId);
        verify(presenter, Mockito.times(1)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(gasId);
        verify(presenter, Mockito.times(1)).onGasClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(parkingId);
        verify(presenter, Mockito.times(1)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(movieId);
        verify(presenter, Mockito.times(1)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(mallId);
        verify(presenter, Mockito.times(1)).onMallClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();


        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(resturantId);
        verify(presenter, Mockito.times(1)).onResturantClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();

        Mockito.reset(presenter);
        presenter.identifyOptionIdForSearch(pharmacyId);
        verify(presenter, Mockito.times(1)).onPharmacyClicked();
        verify(presenter, Mockito.times(0)).onMallClicked();
        verify(presenter, Mockito.times(0)).onParkingClicked();
        verify(presenter, Mockito.times(0)).onFitnessClicked();
        verify(presenter, Mockito.times(0)).onCafeClicked();
        verify(presenter, Mockito.times(0)).onATMClicked();
        verify(presenter, Mockito.times(0)).onGasClicked();
        verify(presenter, Mockito.times(0)).onMoviesClicked();
        verify(presenter, Mockito.times(0)).onResturantClicked();

    }


    @Test
    public void identifyOptionIdForSearchWhenViewIsNullTest() {

        presenter.setView(null);

        presenter.identifyOptionIdForSearch(atmId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(cafeId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(fitnessId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(gasId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(parkingId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(movieId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(mallId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(resturantId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);

        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(pharmacyId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT);
    }
}