package location.com.nearme.detail;

import android.support.annotation.VisibleForTesting;

import org.apache.commons.validator.UrlValidator;

import location.com.nearme.IDInterface;
import location.com.nearme.model.NearbyPlacesObject;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;
    NearbyPlacesObject nearbyPlacesObject;


    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void setData(NearbyPlacesObject obj) {
        this.nearbyPlacesObject = obj;
    }


    @Override
    public void invokeContactOption(int resourceId) {
        switch (resourceId) {
            case IDInterface.DetailPageIds.callId:
                if (isPhoneNumberValid(nearbyPlacesObject.getPhone_number())) {
                    view.actionIfValidPhoneNumber(nearbyPlacesObject.getPhone_number());
                } else {
                    view.showErrorOnInvalidPhoneNumber();
                }
                break;

            case IDInterface.DetailPageIds.webId:
                if (isUrlValid(nearbyPlacesObject.getWebsite())) {
                    view.actionIfValidWebAddress(nearbyPlacesObject.getWebsite());
                } else {
                    view.showErrorOnInvalidWebAddress();
                }
                break;

            case IDInterface.DetailPageIds.mapId:
                if (isUrlValid(nearbyPlacesObject.getUrl())) {
                    view.actionIfValidMapUrl(nearbyPlacesObject.getUrl());
                } else {
                    view.showErrorOnInvalidMapUrl();
                }
                break;
        }
    }


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean isUrlValid(String url) {
        UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        return urlValidator.isValid(url);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean isPhoneNumberValid(String number) {
        String regex = "^[+0-9-\\(\\)\\s]*{6,14}$";
        return number.matches(regex);
    }

}
