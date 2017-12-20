package location.com.nearme.landing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.annotation.meta.When;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;
import location.com.nearme.detail.DetailContract;
import location.com.nearme.detail.DetailPresenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LandingPresenterTest {

    @Spy
    LandingPresenter presenter;
    @Mock
    LandingContract.View view;

    @Before
    public void setup() {
        presenter = new LandingPresenter();
        presenter.setView(view);
    }

    @Test
    public void identifyOptionIdForSearchWhenViewIsSetTest() {

        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.atmId);
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.cafeId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.fitnessId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.movieId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.mallId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());


        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.resturantId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());

        Mockito.reset(view);
        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.pharmacyId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(1)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }


    @Test
    public void identifyOptionIdForSearchWhenViewIsNullTest() {

        presenter.setView(null);

        presenter.identifyOptionIdForSearch(IDInterface.LandingPageIds.atmId);
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.ATM.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.CAFE.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.FITNESS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
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
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.GAS.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PARKING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.PHARMACY.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.MOVIES.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.SHOPPING.getValue());
        verify(view, Mockito.times(0)).openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS.RESTURANT.getValue());
    }
}