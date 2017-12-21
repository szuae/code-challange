package location.com.nearme.service;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import location.com.nearme.repository.NearbyPlacesResponseDTO;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GooglePlaceServices {

    @GET ("nearbysearch/json")
    public Observable<NearbyPlacesResponseDTO> placeList(@QueryMap LinkedHashMap<String, String> data);

    @GET ("details/json")
    public Observable<NearbyPlacesResponseDTO> placeDetails(@QueryMap LinkedHashMap<String, String> data);
}
