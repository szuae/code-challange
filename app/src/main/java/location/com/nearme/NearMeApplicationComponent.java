package location.com.nearme;


import javax.inject.Singleton;

import dagger.Component;
import location.com.nearme.browse.ExploreList;
import location.com.nearme.detail.ExploreDetail;

@Singleton
@Component(modules = {NearMeApplicationModule.class})
public interface NearMeApplicationComponent {
    void inject(ExploreList exploxreList);

    void inject(ExploreDetail exploreDetail);
}
