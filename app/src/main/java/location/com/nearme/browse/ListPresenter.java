package location.com.nearme.browse;

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


    public void call(String location) {
        repo.loadData(location).subscribe(new Consumer<ArrayList<NearbyPlacesObject>>() {
            @Override
            public void accept(ArrayList<NearbyPlacesObject> list) throws Exception {
                if (view != null)
                    view.onSucess(list);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                view.onFailure();
            }
        });
    }

    @Override
    public void fetchCoOrdinates(String location) {
        call(location);
    }

    @Override
    public void setView(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(String location) {
        call(location);
    }
}
