package location.com.nearme.browse;

import com.google.gson.Gson;

import junit.framework.TestResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import location.com.nearme.detail.DetailPresenter;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.DataRepositoryImpl;
import location.com.nearme.repository.DataRepositoryImplTest;
import location.com.nearme.repository.NearbyPlacesResponseDTO;
import location.com.nearme.service.FoursquareServices;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTest {

    DataRepositoryImpl repository;

    @Mock
    FoursquareServices services;

    ListPresenter presenter;

    @Mock
    ListContract.View view;

    @Before
    public void setup() {
        repository = new DataRepositoryImpl(services, Schedulers.trampoline(), Schedulers.trampoline());
        presenter = new ListPresenter(repository);
        presenter.setView(view);

    }

    @Test
    public void callMethodSucessTest() throws Exception {
        String lat = "25.291957";
        String lon = "55.365513";

        when(services.fetchNearByPlaces(any(LinkedHashMap.class)))
                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("success.json")));
        presenter.call(lat,lon);
        Observable< ArrayList<NearbyPlacesObject>> result = repository.fetchNearByPlaces(lat,lon);
        result.test().assertNoErrors();

        verify(view, Mockito.times(1)).onSucess(result.test().values().get(0));
        verify(view, Mockito.times(0)).onFailure();
    }


    @Test
    public void callMethodFailureTest() {
        String lat = "25.291957";
        String lon = "55.365513";

        when(services.fetchNearByPlaces(any(LinkedHashMap.class)))
                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("error.json")));
        presenter.call(lat,lon);
        Observable< ArrayList<NearbyPlacesObject>> result1 = repository.fetchNearByPlaces(lat,lon);
        result1.test().assertError(Exception.class);
        verify(view, Mockito.times(0)).onSucess(new ArrayList<NearbyPlacesObject>());
        verify(view, Mockito.times(1)).onFailure();
    }
    private NearbyPlacesResponseDTO createNearbyPlacesDTOFromStub(String json) {
        InputStream inputStream = null;
        NearbyPlacesResponseDTO nearbyPlacesResponseDTO = null;
        try {
            inputStream = DataRepositoryImplTest.class.getClassLoader().getResourceAsStream(json);
            nearbyPlacesResponseDTO =
                    new Gson().fromJson(new InputStreamReader(inputStream), NearbyPlacesResponseDTO.class);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                }
            }
        }
        return nearbyPlacesResponseDTO;
    }
}