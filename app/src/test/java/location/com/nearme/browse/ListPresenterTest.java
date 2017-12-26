package location.com.nearme.browse;

import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.Applicationconfig;
import location.com.nearme.IDInterface;
import location.com.nearme.TestUtil;
import location.com.nearme.model.ErrorObject;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.DataRepositoryImpl;
import location.com.nearme.repository.DataRepositoryImplTest;
import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;
import location.com.nearme.repository.NearbyPlacesResponseDTO;
import location.com.nearme.service.GooglePlaceServices;

import static location.com.nearme.ApplicationConstant.ApiStatusCode.GENERIC_ERROR;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.KEY_INVALID;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.LIMIT_REACHED;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.NO_RESULTS;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.REQUEST_INVALID;
import static location.com.nearme.ApplicationConstant.SEARCH_OPTIONS.ATM;
import static location.com.nearme.IDInterface.ErrorIds.generic;
import static location.com.nearme.IDInterface.ErrorIds.limitReached;
import static location.com.nearme.IDInterface.ErrorIds.noResult;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTest {

    DataRepositoryImpl repository;

    @Mock
    GooglePlaceServices services;

    @Mock
    Applicationconfig applicationconfig;

    ListPresenter presenter;

    @Mock
    ListContract.View view;

    @Before
    public void setup() {
        repository = new DataRepositoryImpl(services, Schedulers.trampoline(), Schedulers.trampoline(), applicationconfig);
        presenter = Mockito.spy(new ListPresenter(repository));
        presenter.setView(view);

    }


    @Test
    public void loadDataTest() {
        presenter.loadData("",ATM);
        verify(presenter,Mockito.times(1)).call("",ATM);
    }

    @Test
    public void getErrorMessageTest() {
        int errorMessageId = presenter.getErrorMessage(GENERIC_ERROR);
        Assert.assertEquals(errorMessageId,generic);
        Assert.assertNotEquals(errorMessageId,noResult);
        Assert.assertNotEquals(errorMessageId,limitReached);

        errorMessageId = presenter.getErrorMessage(REQUEST_INVALID);
        Assert.assertEquals(errorMessageId,generic);
        Assert.assertNotEquals(errorMessageId,noResult);
        Assert.assertNotEquals(errorMessageId,limitReached);


        errorMessageId = presenter.getErrorMessage(NO_RESULTS);
        Assert.assertNotEquals(errorMessageId,generic);
        Assert.assertEquals(errorMessageId,noResult);
        Assert.assertNotEquals(errorMessageId,limitReached);

        errorMessageId = presenter.getErrorMessage(KEY_INVALID);
        Assert.assertNotEquals(errorMessageId,generic);
        Assert.assertNotEquals(errorMessageId,noResult);
        Assert.assertEquals(errorMessageId,limitReached);

        errorMessageId = presenter.getErrorMessage(LIMIT_REACHED);
        Assert.assertNotEquals(errorMessageId,generic);
        Assert.assertNotEquals(errorMessageId,noResult);
        Assert.assertEquals(errorMessageId,limitReached);
    }


    @Test
    public void callMethodSucessTest() throws Exception {
        String location = "25.291957,55.365513";

        when(services.placeDetails(any(LinkedHashMap.class)))
                .thenReturn(Observable.just(TestUtil.createNearbyPlacesDetailDTOFromStub("place_detail.json")));

        when(services.placeList(any(LinkedHashMap.class)))
                .thenReturn(Single.just(TestUtil.createNearbyPlacesDTOFromStub("place_list.json")));


        when(applicationconfig.getLanguage()).thenReturn(ApplicationConstant.LANGUAGE.English);

        presenter.call(location, ATM);
        Observable<NearbyPlacesObject> result = repository.loadData(location, ATM);
        result.test().assertNoErrors();

        verify(view, Mockito.times(1)).onSucess(result.test().values().get(0));
        verify(view, Mockito.times(0)).onFailure(0);
    }



    @Test
    public void callMethodFailureTest() throws Exception {
        String location = "25.291957,55.365513";

        when(services.placeList(any(LinkedHashMap.class)))
                .thenReturn(Single.just(TestUtil.createNearbyPlacesDTOFromStub("error.json")));


        when(applicationconfig.getLanguage()).thenReturn(ApplicationConstant.LANGUAGE.English);

        presenter.call(location, ATM);
        Observable<NearbyPlacesObject> result = repository.loadData(location, ATM);
        result.test().assertError(ErrorObject.class);

        verify(view, Mockito.times(0)).onSucess(new NearbyPlacesObject.Builder().build());
        verify(view, Mockito.times(1)).onFailure(IDInterface.ErrorIds.generic);
    }
}