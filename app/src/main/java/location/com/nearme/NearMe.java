package location.com.nearme;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

import location.com.nearme.browse.ExploreList;
import location.com.nearme.detail.ExploreDetail;
import location.com.nearme.landing.LandingScreen;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.ImageLoader;
import location.com.nearme.util.LocationHelper;

public class NearMe extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ActivityCompat.OnRequestPermissionsResultCallback {


    @Inject
    LocationHelper locationHelper;

    @Inject
    ImageLoader imageLoader;

    private Location lastLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_places);
        ((NearMeApplication) getApplication()).getComponent().inject(this);
        locationHelper.init(this);
        locationHelper.checkpermission();
        // check availability of play services
        if (locationHelper.checkPlayServices()) {
            // Building the GoogleApi client
            locationHelper.buildGoogleApiClient();
        }
        lastLocation = locationHelper.getLocation();

        goToLandingScreen();

        imageLoader.initImageViewer(getApplicationContext());
        //image viewer
//

    }

    public Location getMyLocation() {
        return locationHelper.getLocation();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        locationHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
        locationHelper.checkPlayServices();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i("Connection failed:", " ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {
        lastLocation = locationHelper.getLocation();
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        locationHelper.connectApiClient();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        locationHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void goToListScreen(ApplicationConstant.SEARCH_OPTIONS search_optionId, String location) {
        this.loadFragment(ExploreList.newInstance(search_optionId, location), TransactionType.Replace, AnimationType.Fading);
    }

    public void refreshFragmentOnLanguageChange(String fragmentTag) {
        // toolbar RTL update
        if (getWindow().getDecorView().getLayoutDirection() == View.LAYOUT_DIRECTION_LTR) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        } else {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(fragment);
        fragmentTransaction.attach(fragment);
        fragmentTransaction.commit();
    }

    public void goToLandingScreen() {
        this.loadFragment(LandingScreen.newInstance(), TransactionType.Add, AnimationType.FromLeft);
    }

    public void goToDetailScreen(NearbyPlacesObject obj) {
        this.loadFragment(ExploreDetail.newInstance(obj), TransactionType.Replace, AnimationType.Fading);
    }

    public void loadFragment(Fragment fragmentClass, TransactionType transactionType, AnimationType type) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        setFragmentAnimation(fragmentTransaction, type);
        setFragmentTransactionType(fragmentTransaction, fragmentClass, transactionType);
        fragmentTransaction.commit();
    }

    private void setFragmentAnimation(FragmentTransaction fragmentTransaction, AnimationType animationType) {
        switch (animationType) {
            case Fading:
                fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case FromLeft:
                fragmentTransaction.setCustomAnimations(R.anim.in_from_left, R.anim.out_to_right);
                break;
        }
    }

    private void setFragmentTransactionType(FragmentTransaction fragmentTransaction, Fragment fragmentClass, TransactionType action) {
        switch (action) {
            case Add:
                fragmentTransaction.add(R.id.container, fragmentClass, fragmentClass.getClass()
                        .getName());
                break;
            case Replace:
                fragmentTransaction.addToBackStack(fragmentClass.getClass().getName());
                fragmentTransaction.replace(R.id.container, fragmentClass, fragmentClass.getClass()
                        .getName());
                break;
        }
    }

    private enum AnimationType {
        FromLeft,
        Fading;
    }

    private enum TransactionType {
        Add,
        Replace;
    }
}
