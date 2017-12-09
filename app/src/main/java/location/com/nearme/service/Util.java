package location.com.nearme.service;

import java.util.LinkedHashMap;

import location.com.nearme.BuildConfig;

public class Util {
    enum NearBy {
        v,
        ll,
        intent,
        radius,
        categoryId,
        client_id,
        client_secret
    }

    public static   LinkedHashMap<String, String> prepareNearByPlaceAPIQueryParam(String lat, String lon) {
        LinkedHashMap<String, String> queryparam = new LinkedHashMap<>();
        queryparam.put(NearBy.v.name(), BuildConfig.API_Version);
        queryparam.put(NearBy.ll.name(),concatLatLon(lat,lon));
        queryparam.put(NearBy.intent.name(), "browse");
        queryparam.put(NearBy.radius.name(), "1000");
        queryparam.put(NearBy.categoryId.name(), "4d4b7105d754a06374d81259");
        queryparam.put(NearBy.client_id.name(), BuildConfig.client_id);
        queryparam.put(NearBy.client_secret.name(), BuildConfig.secret_key);

        return queryparam;
    }

    private static String concatLatLon(String lat, String lon) {
        return lat+","+lon;
    }


}
