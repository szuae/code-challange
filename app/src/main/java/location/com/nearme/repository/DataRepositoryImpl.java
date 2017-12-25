package location.com.nearme.repository;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.Applicationconfig;
import location.com.nearme.BuildConfig;
import location.com.nearme.model.ErrorObject;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.service.GooglePlaceServices;
import location.com.nearme.service.Util;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepositoryImpl implements DataRepository {

    Applicationconfig applicationconfig;

    @NonNull
    private final GooglePlaceServices services;
    @NonNull
    private final Scheduler backgroundThread;
    @NonNull
    private final io.reactivex.Scheduler mainThread;

    public DataRepositoryImpl(GooglePlaceServices services, Scheduler backgroundThread, Scheduler mainThread,
                              Applicationconfig applicationconfig) {
        this.services = services;
        this.backgroundThread = backgroundThread;
        this.mainThread = mainThread;
        this.applicationconfig = applicationconfig;
    }

    private NearbyPlacesObject requestEach(final String id, final ObservableEmitter<NearbyPlacesObject> emitter) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        services.placeDetails(Util.prepareDetailAPIQueryParam(id,
                applicationconfig.getLanguage()))
                .map(new Function<NearbyPlacesDetailResponseDTO, NearbyPlacesObject>() {
                    @Override
                    public NearbyPlacesObject apply(NearbyPlacesDetailResponseDTO nearbyPlacesDetailResponseDTO) throws Exception {
                        if (nearbyPlacesDetailResponseDTO.getStatus().equals(ApplicationConstant.ApiStatusCode.OK)) {
                            return returnObject(nearbyPlacesDetailResponseDTO);
                        } else {
                            reportError(nearbyPlacesDetailResponseDTO.getStatus(), emitter);
                        }
                        return null;
                    }
                })
                .subscribe(new Consumer<NearbyPlacesObject>() {
                               @Override
                               public void accept(NearbyPlacesObject object) throws Exception {
                                   Log.e("saify", "eac request:: accept:::" + index++);
                                   if (object != null)
                                       emitter.onNext(object);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                emitter.onError(new ErrorObject.Builder()
                                        .errorCode(ApplicationConstant.ApiStatusCode.GENERIC_ERROR)
                                        .build());
                                Log.e("saify", "error:::" + throwable.getMessage() + "::::" + index);
                            }
                        }
                );

        return new NearbyPlacesObject.Builder().build();
    }

    private void reportError(String status, ObservableEmitter<NearbyPlacesObject> emitter) {
        emitter.onError(new ErrorObject.Builder()
                .errorCode(status)
                .build());
    }

    int index;

    private NearbyPlacesObject returnObject(NearbyPlacesDetailResponseDTO dto) {
        NearbyPlacesDetailResponseDTO.Result.Coordinates.Location locationObject = null;
        NearbyPlacesDetailResponseDTO.Result.WorkingHours openingHours = null;
        try {
            locationObject = dto.getResult().getGeometry().getLocation();
            openingHours = dto.getResult().getOpening_hours();
        } catch (Exception e) {
            Log.e(DataRepositoryImpl.class.getName(), "Location or Opening hour object is not available");
        }
        return new NearbyPlacesObject.Builder()
                .website(dto.getResult().getWebsite())
                .url(dto.getResult().getUrl())
                .phone_number(dto.getResult().getInternational_phone_number())
                .address(dto.getResult().getFormatted_address())
                .name(dto.getResult().getName())
                .lat(locationObject != null ? locationObject.getLat() : 0.0)
                .lng(locationObject != null ? locationObject.getLng() : 0.0)
                .open_now(openingHours != null ? openingHours.isOpen_now() : true)
                .photos(dto.getResult().getPhotos())
                .place_id(dto.getResult().getPlace_id())
                .id(dto.getResult().getId())
                .rating((float) dto.getResult().getRating())
                .reference(dto.getResult().getReference())
                .reviews(dto.getResult().getReviews())
                .build();
    }

    private Single<NearbyPlacesObject> requestAll(String location,
                                                  ApplicationConstant.SEARCH_OPTIONS option,
                                                  final ObservableEmitter<NearbyPlacesObject> emitter) {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        Log.e("saify", "response:::" + response.body().string());
                        return response;
                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        GooglePlaceServices services1  =retrofit.create(GooglePlaceServices.class);
        services1.placeList(Util.preparePlaceAPIQueryParam(location, option,
                applicationconfig.getLanguage()))
                .subscribeOn(backgroundThread)
                .subscribe(new Consumer<NearbyPlacesResponseDTO>() { //background thread
                               @Override
                               public void accept(NearbyPlacesResponseDTO nearbyPlacesResponseDTO) throws Exception {
                                   if (nearbyPlacesResponseDTO.getStatus().equals(ApplicationConstant.ApiStatusCode.OK)) {
                                       for (NearbyPlacesResponseDTO.Result result : nearbyPlacesResponseDTO.getResults()) {
                                           emitter.onNext(requestEach(result.getPlace_id(), emitter));
                                       }
                                       emitter.onComplete();
                                   } else {
                                       reportError(nearbyPlacesResponseDTO.getStatus(), emitter);
                                   }
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                emitter.onError(new ErrorObject.Builder()
                                .errorCode(ApplicationConstant.ApiStatusCode.GENERIC_ERROR)
                                .build());
                                Log.e("saify", "error:::" + throwable.getMessage());
                            }
                        }
                );
        return null;
    }


    private List<String> generatePlaceIdArray(NearbyPlacesResponseDTO nearbyPlacesResponseDTO) {

        List<String> placeIds = new ArrayList<>();
        for (NearbyPlacesResponseDTO.Result results : nearbyPlacesResponseDTO.getResults()) {
            placeIds.add(results.getPlace_id());
        }
        return placeIds;
    }

    @Override
    public Observable<NearbyPlacesObject> loadData(final String location, final ApplicationConstant.SEARCH_OPTIONS option) {
        return Observable.create(new ObservableOnSubscribe<NearbyPlacesObject>() {
            @Override
            public void subscribe(ObservableEmitter<NearbyPlacesObject> emitter) throws Exception {
                requestAll(location, option, emitter);
            }
        });


    }
}
