package location.com.nearme.repository;

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

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.service.FoursquareServices;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DataRepositoryImplTest {
    DataRepositoryImpl repository;
    @Mock
    FoursquareServices services;

    @Before
    public void setup() {
        repository = new DataRepositoryImpl(services, Schedulers.trampoline(), Schedulers.trampoline());

    }

    @Test
    public void fetchNearbyPlacesPositiveCase() {

        String lat = "25.291957";
        String lon = "55.365513";

        when(services.fetchNearByPlaces(any(LinkedHashMap.class)))
                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("success.json")));
        TestObserver<ArrayList<NearbyPlacesObject>> testObserver = repository.fetchNearByPlaces(lat, lon).test();

        assertTrue(testObserver.values().size() > 0);
    }


    @Test
    public void fetchNearbyPlacesNagativeCase() {
        String lat = "";
        String lon = "";
        when(services.fetchNearByPlaces(any(LinkedHashMap.class)))
                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("error.json")));
        TestObserver<ArrayList<NearbyPlacesObject>> testObserver1 = repository.fetchNearByPlaces(lat, lon).test();

        assertTrue(testObserver1.values().size() == 0);

    }

    @Test
    public void fetchNearbyPlacesWithPrePopulatedData() {
        String lat = "25.291957";
        String lon = "55.365513";
        repository.data = new ArrayList<NearbyPlacesObject>();
        NearbyPlacesObject nearbyPlacesObject = new NearbyPlacesObject.Builder().address("").build();
        repository.data.add(nearbyPlacesObject);

        TestObserver<ArrayList<NearbyPlacesObject>> testObserver1 = repository.fetchNearByPlaces(lat, lon).test();

        assertTrue(testObserver1.values().size() == 1);

        verify(services, Mockito.times(0)).fetchNearByPlaces(any(LinkedHashMap.class));

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