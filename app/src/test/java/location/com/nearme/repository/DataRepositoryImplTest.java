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
import java.util.LinkedHashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.Applicationconfig;
import location.com.nearme.TestUtil;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.service.GooglePlaceServices;

import static io.reactivex.Single.just;
import static location.com.nearme.ApplicationConstant.LANGUAGE.English;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DataRepositoryImplTest {
    DataRepositoryImpl repository;
    @Mock
    GooglePlaceServices services;

    @Mock
    Applicationconfig applicationconfig;


    @Mock
    ObservableEmitter<NearbyPlacesObject> emitter;

    @Before
    public void setup() {
        repository = Mockito.spy(
                new DataRepositoryImpl(services, Schedulers.trampoline(), Schedulers.trampoline(), applicationconfig));

    }


    @Test
    public void returnObjectTest() {
        NearbyPlacesDetailResponseDTO dto = TestUtil.createNearbyPlacesDetailDTOFromStub("place_detail.json");
        NearbyPlacesObject obj = repository.returnObject(dto);
        assertEquals(obj.getName(), dto.getResult().getName());
        assertEquals(obj.getWebsite(), dto.getResult().getWebsite());
        assertEquals(obj.getUrl(), dto.getResult().getUrl());
        assertEquals(obj.getPlace_id(), dto.getResult().getPlace_id());
        assertEquals(obj.getId(), dto.getResult().getId());
        assertEquals(obj.getRating(), dto.getResult().getRating(), 0.1);
        assertEquals(obj.getReference(), dto.getResult().getReference());
        assertEquals(obj.getPhone_number(), dto.getResult().getInternational_phone_number());
        assertEquals(obj.getAddress(), dto.getResult().getFormatted_address());
        assertEquals(obj.getLat(), dto.getResult().getGeometry().getLocation().getLat(), 0.1);
        assertEquals(obj.getLng(), dto.getResult().getGeometry().getLocation().getLng(), 0.1);
        assertEquals(obj.isOpen_now(), dto.getResult().getOpening_hours().isOpen_now());
        assertArrayEquals(obj.getPhotos(), dto.getResult().getPhotos());
        assertArrayEquals(obj.getReviews(), dto.getResult().getReviews());
    }

    @Test
    public void requestEachSucessTest() {
        NearbyPlacesDetailResponseDTO dto = TestUtil.createNearbyPlacesDetailDTOFromStub("place_detail.json");
        when(services.placeDetails(any(LinkedHashMap.class)))
                .thenReturn(Observable.just(dto));
        when(applicationconfig.getLanguage()).thenReturn(English);
        Observable<NearbyPlacesObject> result = repository.requestEach("", emitter);
        result.test().assertNoErrors();
        verify(repository, Mockito.times(1)).returnObject(dto);
        verify(repository, Mockito.times(0)).reportError(dto.getStatus(), emitter);


    }

    @Test
    public void requestEachFailureTest() {
        NearbyPlacesDetailResponseDTO dto = TestUtil.createNearbyPlacesDetailDTOFromStub("error.json");
        when(services.placeDetails(any(LinkedHashMap.class)))
                .thenReturn(Observable.just(dto));
        when(applicationconfig.getLanguage()).thenReturn(English);
        Observable<NearbyPlacesObject> result = repository.requestEach("", emitter);
        result.test().assertError(Exception.class);
        verify(repository, Mockito.times(0)).returnObject(dto);
        verify(repository, Mockito.times(1)).reportError(dto.getStatus(), emitter);
    }


    @Test
    public void requestAllSucessTest() {
        NearbyPlacesDetailResponseDTO detailDTO = TestUtil.createNearbyPlacesDetailDTOFromStub("place_detail.json");

        NearbyPlacesResponseDTO dto = TestUtil.createNearbyPlacesDTOFromStub("place_list.json");

        when(services.placeDetails(any(LinkedHashMap.class)))
                .thenReturn(Observable.just(detailDTO));

//        when(services.placeList(any(LinkedHashMap.class)))
//                .thenReturn(Single.just(dto));
        doReturn(Single.just(dto)).when(services).placeList(any(LinkedHashMap.class));

        when(applicationconfig.getLanguage()).thenReturn(English);
        TestObserver<NearbyPlacesObject> result = repository.requestAll("", ApplicationConstant.SEARCH_OPTIONS.ATM, emitter).test(false);
        result.assertNoErrors();
        verify(repository, Mockito.times(1)).requestEach("", emitter);
        verify(repository, Mockito.times(0)).reportError(dto.getStatus(), emitter);
    }


    @Test
    public void requestAllFailureTest() {
        NearbyPlacesDetailResponseDTO detailDTO = TestUtil.createNearbyPlacesDetailDTOFromStub("place_detail.json");

        NearbyPlacesResponseDTO dto = TestUtil.createNearbyPlacesDTOFromStub("error.json");

        when(services.placeDetails(any(LinkedHashMap.class)))
                .thenReturn(Observable.just(detailDTO));

        when(services.placeList(any(LinkedHashMap.class)))
                .thenReturn(just(dto));

        when(applicationconfig.getLanguage()).thenReturn(English);
        TestObserver<NearbyPlacesObject> result = repository.requestAll("", ApplicationConstant.SEARCH_OPTIONS.ATM, emitter).test();
        result.assertNoErrors();
        verify(repository, Mockito.times(0)).requestEach("", emitter);
        verify(repository, Mockito.times(1)).reportError(dto.getStatus(), emitter);
    }


    //
////    @Test
////    public void fetchNearbyPlacesPositiveCase() {
////
////        String lat = "25.291957";
////        String lon = "55.365513";
////
////        when(services.placeList(any(LinkedHashMap.class)))
////                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("success.json")));
////        TestObserver<ArrayList<NearbyPlacesObject>> testObserver = repository.fetchNearByPlaces(lat, lon).test();
////
////        assertTrue(testObserver.values().size() > 0);
////    }
////
////
////    @Test
////    public void fetchNearbyPlacesNagativeCase() {
////        String lat = "";
////        String lon = "";
////        when(services.placeList(any(LinkedHashMap.class)))
////                .thenReturn(io.reactivex.Observable.just(createNearbyPlacesDTOFromStub("error.json")));
////        TestObserver<ArrayList<NearbyPlacesObject>> testObserver1 = repository.fetchNearByPlaces(lat, lon).test();
////
////        assertTrue(testObserver1.values().size() == 0);
////
////    }
////
////    @Test
////    public void fetchNearbyPlacesWithPrePopulatedData() {
////        String lat = "25.291957";
////        String lon = "55.365513";
////        repository.data = new ArrayList<NearbyPlacesObject>();
////        NearbyPlacesObject nearbyPlacesObject = new NearbyPlacesObject.Builder().address("").build();
////        repository.data.add(nearbyPlacesObject);
////
////        TestObserver<ArrayList<NearbyPlacesObject>> testObserver1 = repository.fetchNearByPlaces(lat, lon).test();
////
////        assertTrue(testObserver1.values().size() == 1);
////
////        verify(services, Mockito.times(0)).placeList(any(LinkedHashMap.class));
////
////    }
//

}