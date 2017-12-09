package location.com.nearme.service;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import location.com.nearme.repository.NearbyPlacesResponseDTO;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface FoursquareServices {

    @GET ("v2/venues/search")
    public Observable<NearbyPlacesResponseDTO> fetchNearByPlaces(@QueryMap LinkedHashMap<String, String> data);
}
