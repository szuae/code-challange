package location.com.nearme.browse;

import java.util.ArrayList;

import location.com.nearme.model.NearbyPlacesObject;


public interface ListContract {
    interface View {
        void onSucess(ArrayList<NearbyPlacesObject> list);

        void onFailure();

        void onItemClicked(NearbyPlacesObject obj);
    }

    interface Presenter {
        void fetchCoOrdinates(String location);

        void setView(View view);

        void loadData(String location);
    }

}
