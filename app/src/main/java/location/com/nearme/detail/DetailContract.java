package location.com.nearme.detail;

import location.com.nearme.model.NearbyPlacesObject;

/**
 * Created by Emirates on 12/2/17.
 */

public interface DetailContract {
    interface View {
        void actionIfValidPhoneNumber(String number);
        void showErrorOnInvalidPhoneNumber();

        void actionIfValidWebAddress(String url);
        void showErrorOnInvalidWebAddress();

        void actionIfValidMapUrl(String url);
        void showErrorOnInvalidMapUrl();

    }

    interface Presenter{

        void setView(View view);
        void setData(NearbyPlacesObject obj);
        void invokeContactOption(int resourceId);
    }
}
