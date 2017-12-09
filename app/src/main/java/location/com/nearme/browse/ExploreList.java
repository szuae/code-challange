package location.com.nearme.browse;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import javax.inject.Inject;

import location.com.nearme.BaseFragment;
import location.com.nearme.NearMe;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;

public class ExploreList extends BaseFragment implements ListContract.View {

    Toolbar androidToolbar;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout CollapsingToolbarLayout;
    RecyclerView listView;
    Adapter listAdapter;
    View view;
    Button searchButton;

    @Inject
    ListContract.Presenter presenter;

    public static ExploreList newInstance() {
        return new ExploreList();
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
        initView(view);
        return view;
    }

    private void initView(View view) {
        presenter.setView(this);
        CollapsingToolbarLayout = view.findViewById(R.id.collapsingToolbarLayout);
        CollapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        CollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));
        CollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        searchButton = view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = "" + ((NearMe) getActivity()).getMyLocation().getLatitude();
                String lon = "" + ((NearMe) getActivity()).getMyLocation().getLongitude();
                Log.e("saify", "::::" + lat + "::::"+ lon);
                presenter.fetchCoOrdinates(lat, lon);
            }
        });
        listView = view.findViewById(R.id.listView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        listView.setLayoutManager(mLayoutManager);
        if(listAdapter == null)
            listAdapter = new Adapter(getContext(), this);
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
    public void onSucess(ArrayList<NearbyPlacesObject> list) {
        listAdapter.setData(list);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onItemClicked(NearbyPlacesObject object) {
        ((NearMe)getActivity()).goToDetail(object);
    }
}
