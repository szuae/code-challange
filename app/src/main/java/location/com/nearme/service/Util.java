package location.com.nearme.service;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

import location.com.nearme.ApplicationConstant;
import location.com.nearme.BuildConfig;

public class Util {
    private interface PhotoServiceParameter {
        String ENDPOINT = "photo?";
        String KEY_PARAMETER = "key";
        String MAX_WIDTH = "maxwidth";
        String MAX_HEIGHT = "maxheight";
        String REFERENCE = "photoreference";
        String AMPERCENT = "&";
        String EQUAL = "=";
    }
    
    enum PlaceListKeys {
        location,
        radius,
        type,
        key,
        pagetoken,
        language
    }

    enum PlaceDetailKeys {
        placeid,
        key,
        language
    }


    public static LinkedHashMap<String, String> preparePlaceAPIQueryParam(String location, ApplicationConstant.SEARCH_OPTIONS type,
                                                                           ApplicationConstant.LANGUAGE language) {
        LinkedHashMap<String, String> queryparam = new LinkedHashMap<>();
        queryparam.put(PlaceListKeys.location.name(), location);
        queryparam.put(PlaceListKeys.type.name(), type.getValue());
        queryparam.put(PlaceListKeys.radius.name(), "1000");
        queryparam.put(PlaceListKeys.key.name(), BuildConfig.secret_key);
        queryparam.put(PlaceListKeys.language.name(), language.getValue());
        return queryparam;
    }


    public static LinkedHashMap<String, String> prepareDetailAPIQueryParam(String placeId, ApplicationConstant.LANGUAGE language) {
        LinkedHashMap<String, String> queryparam = new LinkedHashMap<>();
        queryparam.put(PlaceDetailKeys.placeid.name(), placeId);
        queryparam.put(PlaceDetailKeys.language.name(), language.getValue());
        queryparam.put(PlaceDetailKeys.key.name(), BuildConfig.secret_key);
        return queryparam;
    }

    public static String buildUrl(String reference, String width, String height) {
        return new StringBuilder()
                .append(BuildConfig.BaseURL)
                .append(PhotoServiceParameter.ENDPOINT)
                .append(PhotoServiceParameter.KEY_PARAMETER)
                .append(PhotoServiceParameter.EQUAL)
                .append(BuildConfig.secret_key)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.REFERENCE)
                .append(PhotoServiceParameter.EQUAL)
                .append(reference)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.MAX_WIDTH)
                .append(PhotoServiceParameter.EQUAL)
                .append(width)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.MAX_HEIGHT)
                .append(PhotoServiceParameter.EQUAL)
                .append(height).toString();
    }

}
