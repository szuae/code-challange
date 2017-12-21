package location.com.nearme.service;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.BuildConfig;

public class Util {
    enum PlaceListKeys {
        location,
        radius,
        type,
        key,
        pagetoken
    }

    enum PlaceDetailKeys {
        placeid,
        key
    }


    public static LinkedHashMap<String, String> preparePlaceAPIQueryParam(String location, ApplicationConstant.SEARCH_OPTIONS type, String pageToken) {
        LinkedHashMap<String, String> queryparam = new LinkedHashMap<>();
        queryparam.put(PlaceListKeys.location.name(), location);
        queryparam.put(PlaceListKeys.type.name(), type.getValue());
        queryparam.put(PlaceListKeys.radius.name(), "1000");
        queryparam.put(PlaceListKeys.key.name(), BuildConfig.secret_key);
        if (StringUtils.isNotEmpty(pageToken))
            queryparam.put(PlaceListKeys.pagetoken.name(), pageToken);

        return queryparam;
    }


    public static LinkedHashMap<String, String> prepareDetailAPIQueryParam(String placeId) {
        LinkedHashMap<String, String> queryparam = new LinkedHashMap<>();
        queryparam.put(PlaceDetailKeys.placeid.name(), placeId);
        queryparam.put(PlaceDetailKeys.key.name(), BuildConfig.secret_key);
        return queryparam;
    }
}
