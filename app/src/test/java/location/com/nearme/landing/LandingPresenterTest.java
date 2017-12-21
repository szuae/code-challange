package location.com.nearme.landing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;

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
        presenter.updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
    }

    @Test
    public void updateUITestWhenViewIsSet() {
        presenter.updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
    }

    @Test
    public void onATMClickedTest() {
        presenter.onATMClicked();
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onCafeClickedTest() {
        presenter.onCafeClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onFitnessClickedTest() {
        presenter.onFitnessClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onGasClickedTest() {
        presenter.onGasClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onParkingClickedTest() {
        presenter.onParkingClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onMovieClickedTest() {
        presenter.onMoviesClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onMallClickedTest() {
        presenter.onMallClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onResturantClickedTest() {
        presenter.onResturantClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void onPharmacyClickedTest() {
        presenter.onPharmacyClicked();
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(presenter, Mockito.times(1)).updateUI(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(presenter, Mockito.times(0)).updateUI(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }

    @Test
    public void identifyOptionIdForSearchTest() {

        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.atmId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.cafeId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.fitnessId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.gasId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.parkingId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.movieId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.mallId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.resturantId);
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
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.pharmacyId);
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

        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.atmId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.cafeId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.fitnessId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.gasId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.parkingId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.movieId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.mallId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.resturantId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());

        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.pharmacyId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GASOLINE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }
}