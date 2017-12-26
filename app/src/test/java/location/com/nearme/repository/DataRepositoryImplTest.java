package location.com.nearme.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
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

        when(services.placeList(any(LinkedHashMap.class)))
                .thenReturn(Single.just(dto));

        when(applicationconfig.getLanguage()).thenReturn(English);
        repository.requestAll("", ApplicationConstant.SEARCH_OPTIONS.ATM, emitter);
        NearbyPlacesObject actualObject = repository.returnObject(detailDTO);

        verify(repository, Mockito.times(1)).requestEach(dto.getResults()[0].place_id, emitter);
        verify(emitter, Mockito.times(1)).onNext(actualObject);
        verify(repository, Mockito.times(0)).reportError(dto.getStatus(), emitter);
    }


    @Test
    public void requestAllResponseFailureTest() {

        NearbyPlacesResponseDTO dto = TestUtil.createNearbyPlacesDTOFromStub("error.json");

        when(services.placeList(any(LinkedHashMap.class)))
                .thenReturn(just(dto));

        when(applicationconfig.getLanguage()).thenReturn(English);
        repository.requestAll("", ApplicationConstant.SEARCH_OPTIONS.ATM, emitter);
        verify(repository, Mockito.times(0)).requestEach("", emitter);
        verify(repository, Mockito.times(1)).reportError(dto.getStatus(), emitter);
    }
}