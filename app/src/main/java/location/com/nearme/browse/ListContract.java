package location.com.nearme.browse;

import java.util.ArrayList;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.model.NearbyPlacesObject;


public interface ListContract {
    interface View {
        void onSucess(NearbyPlacesObject object);

        void onFailure(int errorMessage);

        void onItemClicked(NearbyPlacesObject obj);

        void onFinishLoading();
    }

    interface Presenter {

        void setView(View view);

        void loadData(String location, ApplicationConstant.SEARCH_OPTIONS option);

        int getErrorMessage(String errorCode);
    }

}
