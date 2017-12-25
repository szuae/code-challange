package location.com.nearme.service;

import java.util.LinkedHashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;
import location.com.nearme.repository.NearbyPlacesResponseDTO;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GooglePlaceServices {

    @GET ("nearbysearch/json")
    public Single<NearbyPlacesResponseDTO> placeList(@QueryMap LinkedHashMap<String, String> data);
//    public Observable<NearbyPlacesResponseDTO> placeList(@QueryMap LinkedHashMap<String, String> data);

    @GET ("details/json")
    public Observable<NearbyPlacesDetailResponseDTO> placeDetails(@QueryMap LinkedHashMap<String, String> data);
}
