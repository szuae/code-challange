package location.com.nearme.browse;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTest {

    DataRepositoryImpl repository;

    @Mock
    FoursquareServices services;

    ListPresenter presenter;

    @Mock
    ExploreList view;

    @Before
    public void setup() {
        repository = new DataRepositoryImpl(services, Schedulers.trampoline(), Schedulers.trampoline());
        presenter = new ListPresenter(repository);
        presenter.setView(view);

    }

    @Test
    public void call() throws Exception {
        TestSubscriber<ArrayList<NearbyPlacesObject>> testSubscriber;

        String lat = "25.291957";
        String lon = "55.365513";
        when(services.fetchNearByPlaces(any(LinkedHashMap.class)))
                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("success.json")));
        TestObserver<ArrayList<NearbyPlacesObject>> testObserver = repository.fetchNearByPlaces(lat, lon).test().assertSubscribed();
        assertTrue(testObserver.values().size() > 0);

        verify(view, Mockito.times(1)).onSucess(any(ArrayList.class));
        verify(view, Mockito.times(0)).onFailure();


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