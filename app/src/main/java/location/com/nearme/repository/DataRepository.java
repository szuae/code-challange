package location.com.nearme.repository;

import java.util.ArrayList;

import io.reactivex.Observable;
import location.com.nearme.model.NearbyPlacesObject;


public interface DataRepository {
    Observable<ArrayList<NearbyPlacesObject>> fetchNearByPlaces(String lat, String lon);
}
