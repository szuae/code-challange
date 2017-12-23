package location.com.nearme;


import javax.inject.Singleton;

import dagger.Component;
import location.com.nearme.browse.ExploreList;
import location.com.nearme.detail.ExploreDetail;
import location.com.nearme.landing.LandingScreen;

@Singleton
@Component(modules = {NearMeApplicationModule.class})
public interface NearMeApplicationComponent {
    void inject(ExploreList exploxreList);

    void inject(ExploreDetail exploreDetail);

    void inject(LandingScreen landingScreen);

    void inject(NearMe nearMe);

}
