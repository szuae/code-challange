package location.com.nearme.landing;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.Applicationconfig;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMe;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;

public class LandingScreen extends BaseFragment implements LandingContract.View {

    @Inject
    LandingContract.Presenter presenter;

    @Inject
    Applicationconfig applicationconfig;

    @BindView(R.id.toolbar_id)
    Toolbar toolbar;
    View view;


    public static LandingScreen newInstance() {
        return new LandingScreen();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRootView(container);
        presenter.setView(this);
        view = inflater.inflate(R.layout.landing_layout, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return view;
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
                changeLanguage(getContext(), ApplicationConstant.LANGUAGE.Arabic);
                break;
            case R.id.lang_en:
                changeLanguage(getContext(), ApplicationConstant.LANGUAGE.English);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void changeLanguage(Context context, ApplicationConstant.LANGUAGE language) {
        Locale locale = new Locale(language.getValue());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
        applicationconfig.setLanguage(language);
        ((NearMe)getActivity()).refreshFragmentOnLanguageChange(getClass().getName());
    }

    @Override
    public void openSearchListScreen(String searchOptionId) {
        ((NearMe) getActivity()).goToListScreen(searchOptionId);
    }
}
