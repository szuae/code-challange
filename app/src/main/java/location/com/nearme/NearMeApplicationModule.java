package location.com.nearme;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import location.com.nearme.browse.ListContract;
import location.com.nearme.browse.ListPresenter;
import location.com.nearme.detail.DetailContract;
import location.com.nearme.detail.DetailPresenter;
import location.com.nearme.landing.LandingContract;
import location.com.nearme.landing.LandingPresenter;
import location.com.nearme.network.NetworkLayer;
import location.com.nearme.repository.DataRepository;
import location.com.nearme.repository.DataRepositoryImpl;
import location.com.nearme.repository.ImageLoader;
import location.com.nearme.repository.ImageLoaderImpl;
import location.com.nearme.service.GooglePlaceServices;
import location.com.nearme.util.LocationHelper;

@Module
public class NearMeApplicationModule {

    @Provides
    @Singleton
    public ListContract.Presenter providePresenter(DataRepository repo) {
        return new ListPresenter(repo);
    }

    @Provides
    @Singleton
    public Applicationconfig provideApplicationConfig() {
        return new Applicationconfig();
    }

    @Provides
    @Singleton
    public LocationHelper provideLocationHelper() {
        return new LocationHelper();
    }


    @Provides
    @Singleton
    public LandingContract.Presenter provideLandingScreenPresenter() {
        return new LandingPresenter();
    }


    @Provides
    @Singleton
    public ImageLoader provideImageLoader() {
        return new ImageLoaderImpl();
    }


    @Provides
    @Singleton
    public DetailContract.Presenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Singleton
    @Provides
    public DataRepository provideDataRepository(GooglePlaceServices service, Applicationconfig applicationconfig) {
        return new DataRepositoryImpl(service, Schedulers.io(), AndroidSchedulers.mainThread(), applicationconfig);
    }

    @Provides
    public GooglePlaceServices provideSerive(NetworkLayer networkLayer) {
        return networkLayer.createApiService(GooglePlaceServices.class);
    }

    @Provides
    public NetworkLayer provideNetworkLayer() {
        return new NetworkLayer();
    }

}
