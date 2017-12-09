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
import location.com.nearme.network.NetworkLayer;
import location.com.nearme.repository.DataRepository;
import location.com.nearme.repository.DataRepositoryImpl;
import location.com.nearme.service.FoursquareServices;

@Module
public class NearMeApplicationModule {

    @Provides
    @Singleton
    public ListContract.Presenter providePresenter(DataRepository repo) {
        return new ListPresenter(repo);
    }


    @Provides
    @Singleton
    public DetailContract.Presenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Singleton
    @Provides
    public DataRepository provideDataRepository(FoursquareServices service) {
        return new DataRepositoryImpl(service, Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @Provides
    public FoursquareServices provideSerive(NetworkLayer networkLayer) {
        return networkLayer.createApiService(FoursquareServices.class);
    }

    @Provides
    public NetworkLayer provideNetworkLayer() {
        return new NetworkLayer();
    }

}
