package location.com.nearme.browse;

import java.util.ArrayList;

import location.com.nearme.model.NearbyPlacesObject;


public interface ListContract {
    interface View {
        void onSucess(ArrayList<NearbyPlacesObject> list);
        void onFailure();
        void onItemClicked(NearbyPlacesObject obj);
    }

    interface Presenter{
       void  fetchCoOrdinates(String lat, String lon);
       void setView(View view);
    }

}
