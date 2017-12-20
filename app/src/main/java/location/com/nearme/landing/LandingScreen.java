package location.com.nearme.landing;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMe;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;

public class LandingScreen extends BaseFragment implements LandingContract.View {

    @Inject
    LandingContract.Presenter presenter;

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
    public void openSearchListScreen(String searchOptionId) {
        ((NearMe) getActivity()).goToListScreen(searchOptionId);
    }
}
