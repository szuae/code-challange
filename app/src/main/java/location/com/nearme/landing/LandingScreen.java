package location.com.nearme.landing;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.Applicationconfig;
import location.com.nearme.BaseFragment;
import location.com.nearme.BuildConfig;
import location.com.nearme.NearMe;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.uiutil.AlertInterface;
import location.com.nearme.uiutil.AlertMessage;
import location.com.nearme.util.LocationHelper;

import static location.com.nearme.ApplicationConstant.AlertButton.SingleButton;
import static location.com.nearme.ApplicationConstant.AlertButton.TwoButtons;
import static location.com.nearme.ApplicationConstant.LANGUAGE.Arabic;
import static location.com.nearme.ApplicationConstant.LANGUAGE.English;

public class LandingScreen extends BaseFragment implements LandingContract.View {

    @Inject
    LandingContract.Presenter presenter;


    @Inject
    Applicationconfig applicationconfig;

    @Inject
    LocationHelper locationHelper;

    @BindView(R.id.landing_location)
    EditText locationInput;

    @BindView(R.id.toolbar_id)
    Toolbar toolbar;

    View view;
    String location;
    Location locationObj;

    public static LandingScreen newInstance() {
        return new LandingScreen();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRootView(container);
        presenter.setView(this);
        view = inflater.inflate(R.layout.landing_layout, container, false);
        setHasOptionsMenu(true);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    private void init() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        locationInput.setOnTouchListener(new View.OnTouchListener() {
            final int DRAWABLE_RIGHT = 2;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= (locationInput.getRight() - locationInput.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        fetchLocation();
                        return true;
                    }
                }
                return false;
            }
        });

    }

    private void fetchLocation() {
        Log.e("saify", "isgranted ::: " + locationHelper.isPermissionGranted());
        if (locationHelper.isPermissionGranted()) {
            locationObj = ((NearMe) getActivity()).getMyLocation();
            double lat = locationObj.getLatitude();
            double lon = locationObj.getLongitude();
            Log.e("saify", "::::" + lat + "::::" + lon);
            location = lat + "," + lon;
            locationInput.setText(locationHelper.getAddress(lat, lon));
        } else {
            new AlertMessage().show(getContext(),
                    getResources().getString(R.string.location_alert_title),
                    getResources().getString(R.string.location_alert_message),
                    TwoButtons,
                    new AlertInterface() {
                        @Override
                        public void onPositiveButtonClick() {
                            startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.parse("package:" + BuildConfig.APPLICATION_ID)));
                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //nothing
                        }
                    });

        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NearMeApplication) getActivity().getApplication()).getComponent().inject(this);
    }


    @OnClick({R.id.pharmacy_layout, R.id.resturant_layout, R.id.atm_layout,
            R.id.cafe_layout, R.id.fitness_layout, R.id.gas_layout,
            R.id.mall_layout, R.id.movies_layout, R.id.parking_layout})
    void onSearchOptionClicked(View view) {
        presenter.identifyOptionIdForSearch(view.getId());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.setView(null);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.lang_ar:
                changeLanguage(getContext(), Arabic);
                break;
            case R.id.lang_en:
                changeLanguage(getContext(), English);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void changeLanguage(Context context, ApplicationConstant.LANGUAGE language) {
        if (applicationconfig.getLanguage() != language) {
            Locale locale = new Locale(language.getValue());
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getApplicationContext().getResources().updateConfiguration(config, null);
            applicationconfig.setLanguage(language);
            ((NearMe) getActivity()).refreshFragmentOnLanguageChange(getClass().getName());
        }
    }

    @Override
    public void openSearchListScreen(ApplicationConstant.SEARCH_OPTIONS searchOptionId) {
        if (!isNetworkAvailable()) {
            showMessage(getResources().getString(R.string.no_internet_msg));
            return;
        }
        if (location != null) {
            ((NearMe) getActivity()).goToListScreen(searchOptionId, location);
        } else {
            new AlertMessage().show(getContext(),
                    getResources().getString(R.string.select_location_alert_title),
                    getResources().getString(R.string.select_location_alert_message),
                    SingleButton,
                    new AlertInterface() {
                        @Override
                        public void onPositiveButtonClick() {
                            //nothing
                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //nothing
                        }
                    });
        }

    }
}
