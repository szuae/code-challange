package location.com.nearme.browse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMe;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;

public class ExploreList extends BaseFragment implements ListContract.View {

    private final static String SEARCH_OPTION_KEY = "search_option_key";

    @BindView(R.id.list_collapsingToolbarLayout)
    CollapsingToolbarLayout CollapsingToolbarLayout;

    @BindView(R.id.list_listView)
    RecyclerView listView;

    @BindView(R.id.list_parallax_header_imageview)
    ImageView headerImage;

    ListAdapter listAdapter;
    View view;


    @Inject
    ListContract.Presenter presenter;

    ApplicationConstant.SEARCH_OPTIONS searchType;

    public static ExploreList newInstance(ApplicationConstant.SEARCH_OPTIONS search_options) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(SEARCH_OPTION_KEY, search_options);
        ExploreList landingScreen = new ExploreList();
        landingScreen.setArguments(bundle);
        return landingScreen;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NearMeApplication) getActivity().getApplication()).getComponent().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRootView(container);
        view = inflater.inflate(R.layout.list_layout, container, false);
        searchType = (ApplicationConstant.SEARCH_OPTIONS) getArguments().getSerializable(SEARCH_OPTION_KEY);
        unbinder = ButterKnife.bind(this, view);
        presenter.setView(this);
        initView();
        return view;
    }

    private void setHeaderImage() {
        switch (searchType) {
            case ATM:
                headerImage.setImageResource(R.drawable.atm_img);
                break;
            case GASOLINE:
                headerImage.setImageResource(R.drawable.gas_img);
                break;
            case FITNESS:
                headerImage.setImageResource(R.drawable.fitness_img);
                break;
            case CAFE:
                headerImage.setImageResource(R.drawable.cafe_img);
                break;
            case MOVIES:
                headerImage.setImageResource(R.drawable.movies_img);
                break;
            case PARKING:
                headerImage.setImageResource(R.drawable.parking_img);
                break;
            case PHARMACY:
                headerImage.setImageResource(R.drawable.pharmacy_img);
                break;
            case RESTURANT:
                headerImage.setImageResource(R.drawable.resturant);
                break;
            case SHOPPING:
                headerImage.setImageResource(R.drawable.shopping_img);
                break;
        }
    }

    private void initView() {
        CollapsingToolbarLayout.setTitle(StringUtils.capitalize(searchType.name().toLowerCase()));
        setHeaderImage();
//        searchButton = view.findViewById(R.id.search_button);
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String lat = "" + ((NearMe) getActivity()).getMyLocation().getLatitude();
//                String lon = "" + ((NearMe) getActivity()).getMyLocation().getLongitude();
//                Log.e("saify", "::::" + lat + "::::"+ lon);
//                presenter.fetchCoOrdinates(lat, lon);
//            }
//        });
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
//        listView.setLayoutManager(mLayoutManager);
//        if(listAdapter == null)
//            listAdapter = new ListAdapter(getContext(), this);
//        listView.setAdapter(listAdapter);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onSucess(ArrayList<NearbyPlacesObject> list) {
        listAdapter.setData(list);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.setView(null);
    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), getResources().getString(R.string.connection_issue_msg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClicked(NearbyPlacesObject object) {
        ((NearMe) getActivity()).goToDetailScreen(object);
    }
}
