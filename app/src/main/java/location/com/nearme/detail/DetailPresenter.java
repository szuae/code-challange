package location.com.nearme.detail;

import android.support.annotation.VisibleForTesting;
import android.util.Patterns;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.UrlValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import location.com.nearme.model.NearbyPlacesObject;

import static location.com.nearme.IDInterface.DetailPageIds.callId;
import static location.com.nearme.IDInterface.DetailPageIds.mapId;
import static location.com.nearme.IDInterface.DetailPageIds.webId;

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
            case callId:
                actionOnCallClick();
                break;

            case webId:
                actionOnWebClick();
                break;

            case mapId:
                actionOnMapClick();
                break;
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void actionOnCallClick() {
        String number = nearbyPlacesObject.getPhone_number();
        if (StringUtils.isNotEmpty(number) && isPhoneNumberValid(number.trim())) {
            view.actionIfValidPhoneNumber(nearbyPlacesObject.getPhone_number());
        } else {
            view.showErrorOnInvalidPhoneNumber();
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void actionOnWebClick() {
        String url = nearbyPlacesObject.getWebsite();
        if (StringUtils.isNotEmpty(url) && isUrlValid(url)) {
            view.actionIfValidWebAddress(nearbyPlacesObject.getWebsite());
        } else {
            view.showErrorOnInvalidWebAddress();
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public void actionOnMapClick() {
        String url = nearbyPlacesObject.getUrl();
        if (StringUtils.isNotEmpty(url) && isUrlValid(url)) {
            view.actionIfValidMapUrl(nearbyPlacesObject.getUrl());
        } else {
            view.showErrorOnInvalidMapUrl();
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean isUrlValid(String url) {
        UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        return urlValidator.isValid(url);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean isPhoneNumberValid(String number) {
        String regex = "^\\+?[0-9. ()-]{10,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

}
