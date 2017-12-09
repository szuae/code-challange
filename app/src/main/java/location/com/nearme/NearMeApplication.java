package location.com.nearme;

import android.app.Application;

public class NearMeApplication extends Application {

    private NearMeApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerNearMeApplicationComponent.builder().build();
    }

    public NearMeApplicationComponent getComponent() {
        return component;
    }

}
