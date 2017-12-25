package location.com.nearme.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.ImageLoader;


public class ExploreDetail extends BaseFragment implements DetailContract.View {

    public static final String SELECTED_ITEM = "selected_item";

    View view;

    @Inject
    DetailContract.Presenter presenter;

    @Inject
    ImageLoader imageLoader;

    @BindView(R.id.detail_photos)
    ImageView photo;

    @BindView(R.id.detail_name)
    TextView name;

    @BindView(R.id.detail_address)
    TextView address;

    @BindView(R.id.detail_ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.detail_is_working)
    TextView workingStatus;

    @BindView(R.id.deatil_toolbar_id)
    Toolbar toolbar;

    @BindView(R.id.detail_review_list)
    RecyclerView listView;

    NearbyPlacesObject nearbyPlacesObject;

    ReviewAdapter reviewAdapter;

    public static ExploreDetail newInstance(NearbyPlacesObject obj) {
        ExploreDetail detail = new ExploreDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SELECTED_ITEM, obj);
        detail.setArguments(bundle);
        return detail;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((NearMeApplication) getActivity().getApplication()).getComponent().inject(this);
        view = inflater.inflate(R.layout.detail, container, false);
        nearbyPlacesObject = (NearbyPlacesObject) getArguments().getSerializable(SELECTED_ITEM);
        presenter.setData(nearbyPlacesObject);
        unbinder = ButterKnife.bind(this, view);
        presenter.setView(this);
        updateUI();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    private void updateUI() {
        name.setText(nearbyPlacesObject.getName());
        address.setText(nearbyPlacesObject.getAddress());
        ratingBar.setRating((float) nearbyPlacesObject.getRating());
        if (nearbyPlacesObject.isOpen_now()) {
            workingStatus.setText(getResources().getString(R.string.open_label));
            workingStatus.setTextColor(getResources().getColor(R.color.open_text_color));
        } else {
            workingStatus.setText(getResources().getString(R.string.close_label));
            workingStatus.setTextColor(getResources().getColor(R.color.colorPrimary));
        }

        if (ArrayUtils.isNotEmpty(nearbyPlacesObject.getPhotos())) {
            imageLoader.loadImage(photo, getContext(),
                    nearbyPlacesObject.getPhotos()[0].getPhoto_reference(),
                    photo.getHeight(), photo.getWidth());
        }
        else {
            photo.setImageResource(R.drawable.image_placeholder);
        }
        if (reviewAdapter == null)
            reviewAdapter = new ReviewAdapter(getContext(), this);
        reviewAdapter.setData(Arrays.asList(nearbyPlacesObject.getReviews()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        listView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(reviewAdapter);
        reviewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.setView(null);
    }


    @OnClick({R.id.map_layout, R.id.call_layout, R.id.web_layout})
    void onContactOptionClicked(View view) {
        presenter.invokeContactOption(view.getId());
    }

    @Override
    public void actionIfValidPhoneNumber(String number) {
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)));
    }


    @Override
    public void showErrorOnInvalidPhoneNumber() {
        showError(getResources().getString(R.string.phone_err_msg));
    }

    @Override
    public void actionIfValidWebAddress(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidWebAddress() {
        showError(getResources().getString(R.string.web_err_msg));
    }

    @Override
    public void actionIfValidMapUrl(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidMapUrl() {
        showError(getResources().getString(R.string.map_err_msg));
    }


    private void showError(String msg) {
        Snackbar.make(getActivity().findViewById(android.R.id.content),
                msg, Snackbar.LENGTH_LONG).show();
    }

    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
