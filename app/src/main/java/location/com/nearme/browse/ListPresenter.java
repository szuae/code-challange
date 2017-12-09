package location.com.nearme.browse;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.DataRepository;


public class ListPresenter implements ListContract.Presenter {

    @NonNull
    private final DataRepository repo;

    @NonNull
    private ListContract.View view;

    public ListPresenter(DataRepository repo) {
        this.repo = repo;
    }


    public void call(String lat, String lon) {
        repo.fetchNearByPlaces(lat, lon).subscribe(new Consumer<ArrayList<NearbyPlacesObject>>() {
            @Override
            public void accept(ArrayList<NearbyPlacesObject> list) throws Exception {
                Log.e("saify", "done::: " + list.size());
                view.onSucess(list);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("saify", "erro::: " + throwable);
                view.onFailure();
            }
        });
    }

    @Override
    public void fetchCoOrdinates(String lat, String lon) {
        call(lat, lon);
    }

    @Override
    public void setView(ListContract.View view) {
        this.view = view;
    }
}
