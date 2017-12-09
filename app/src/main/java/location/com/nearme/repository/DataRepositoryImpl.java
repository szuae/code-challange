package location.com.nearme.repository;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.service.FoursquareServices;
import location.com.nearme.service.Util;

public class DataRepositoryImpl implements DataRepository {

    @NonNull
    private final FoursquareServices services;
    @NonNull private final Scheduler backgroundThread;
   @NonNull private final io.reactivex.Scheduler mainThread;

    public DataRepositoryImpl(FoursquareServices services, Scheduler backgroundThread, Scheduler mainThread) {
        this.services = services;
        this.backgroundThread = backgroundThread;
        this.mainThread = mainThread;
    }


    ArrayList<NearbyPlacesObject> data = new ArrayList<>();

    @Override
    public Observable<ArrayList<NearbyPlacesObject>> fetchNearByPlaces(final String lat, final String lon) {
        if (data != null && !data.isEmpty()) {
            return Observable.just(data);
        } else {
            return services.fetchNearByPlaces(Util.prepareNearByPlaceAPIQueryParam(lat, lon))
                    .map(new Function<NearbyPlacesResponseDTO, ArrayList<NearbyPlacesObject>>() {
                        @Override
                        public ArrayList<NearbyPlacesObject> apply(NearbyPlacesResponseDTO nearbyPlacesResponseDTO) throws Exception {
                            if(isError(nearbyPlacesResponseDTO)
                                    || ArrayUtils.isEmpty(nearbyPlacesResponseDTO.response.venues))
                                return null;

                            parseToObject(nearbyPlacesResponseDTO);
                            return data;
                        }
                    }).subscribeOn(backgroundThread)
                    .observeOn(mainThread);
        }
    }

    private boolean isError(NearbyPlacesResponseDTO nearbyPlacesResponseDTO) {
        return nearbyPlacesResponseDTO.meta.code != 200;
    }

    private ArrayList<NearbyPlacesObject> parseToObject(NearbyPlacesResponseDTO nearbyPlacesResponseDTO) {
        data.clear();
        for(NearbyPlacesResponseDTO.response.venues venuesObj : nearbyPlacesResponseDTO.response.venues) {
            data.add(new NearbyPlacesObject.Builder()
                    .name(venuesObj.name)
                    .address(venuesObj.location.crossStreet + " " + venuesObj.location.address)
                    .id(venuesObj.id)
                    .latitude(venuesObj.location.lat)
                    .longitude(venuesObj.location.lng)
                     .phone(venuesObj.contact.phone)
                    .facebook("")
                    .whatsapp("")
                    .type(venuesObj.categories[0].name)
                    .imageUrl(venuesObj.categories[0].icon.prefix + venuesObj.categories[0].icon.suffix)
                    .build());
        }
        return data;
    }
}
