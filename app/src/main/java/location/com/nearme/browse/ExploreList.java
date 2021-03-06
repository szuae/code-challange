package location.com.nearme.browse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    private final static String LOCATION_KEY = "location";

    @BindView(R.id.list_collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.list_listView)
    RecyclerView listView;

    @BindView(R.id.list_parallax_header_imageview)
    ImageView headerImage;

    @BindView(R.id.list_toolbar_android)
    Toolbar toolbar;

    ListAdapter listAdapter;
    View view;


    @Inject
    ListContract.Presenter presenter;


    ApplicationConstant.SEARCH_OPTIONS searchType;
    String location;

    public static ExploreList newInstance(ApplicationConstant.SEARCH_OPTIONS search_options, String location) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(SEARCH_OPTION_KEY, search_options);
        bundle.putSerializable(LOCATION_KEY, location);
        ExploreList landingScreen = new ExploreList();
        landingScreen.setArguments(bundle);
        return landingScreen;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NearMeApplication) getActivity().getApplication()).getComponent().inject(this);
        searchType = (ApplicationConstant.SEARCH_OPTIONS) getArguments().getSerializable(SEARCH_OPTION_KEY);
        location = (String) getArguments().getSerializable(LOCATION_KEY);
        presenter.loadData(location, searchType);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRootView(container);
        view = inflater.inflate(R.layout.list_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        presenter.setView(this);
        return view;
    }

    private void setHeaderImageAndTitle() {
        switch (searchType) {
            case ATM:
                headerImage.setImageResource(R.drawable.atm_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.atm_label));
                break;
            case GASOLINE:
                headerImage.setImageResource(R.drawable.gas_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.gas_label));
                break;
            case FITNESS:
                headerImage.setImageResource(R.drawable.fitness_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.fitness_label));
                break;
            case CAFE:
                headerImage.setImageResource(R.drawable.cafe_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.cafe_label));
                break;
            case MOVIES:
                headerImage.setImageResource(R.drawable.movies_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.movie_label));
                break;
            case PARKING:
                headerImage.setImageResource(R.drawable.parking_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.parking_label));
                break;
            case PHARMACY:
                headerImage.setImageResource(R.drawable.pharmacy_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.pharmacy_label));
                break;
            case RESTURANT:
                headerImage.setImageResource(R.drawable.resturant_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.resturant_label));
                break;
            case SHOPPING:
                headerImage.setImageResource(R.drawable.shopping_img);
                collapsingToolbarLayout.setTitle(getResources().getString(R.string.mall_label));
                break;
        }
    }

    private void setupBackNavigation(){
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
    private void initView() {
        setHeaderImageAndTitle();
        setupBackNavigation();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        listView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        listView.setLayoutManager(mLayoutManager);
        if (listAdapter == null)
            listAdapter = new ListAdapter(getContext(), this);
        listView.setAdapter(listAdapter);
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
    public void onSucess(NearbyPlacesObject object) {
        listAdapter.setData(object);
        listAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        presenter.setView(null);
    }

    @Override
    public void onFailure(int errorMessageId) {
       showMessage(getResources().getString(errorMessageId));
    }

    @Override
    public void onItemClicked(NearbyPlacesObject object) {
        ((NearMe) getActivity()).goToDetailScreen(object);
    }

    @Override
    public void onFinishLoading() {
        Log.e("saify", "onFinishLoading called...");
    }
}
