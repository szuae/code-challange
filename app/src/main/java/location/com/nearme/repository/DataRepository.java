package location.com.nearme.repository;

import io.reactivex.Observable;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.model.NearbyPlacesObject;


public interface DataRepository {
    Observable<NearbyPlacesObject> loadData(String location, ApplicationConstant.SEARCH_OPTIONS option);
}
