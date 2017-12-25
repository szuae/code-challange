package location.com.nearme.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.stfalcon.frescoimageviewer.ImageViewer;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;
import location.com.nearme.service.Util;


public class ExploreDetail extends BaseFragment implements DetailContract.View {

    public static final String SELECTED_ITEM = "selected_item";

    View view;

    @Inject
    DetailContract.Presenter presenter;


    @BindView(R.id.detail_name)
    TextView name;

    @BindView(R.id.detail_address)
    TextView address;

    @BindView(R.id.detail_ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.detail_is_working)
    TextView workingStatus;

    @BindView(R.id.detail_more_photos)
    TextView morePhotos;

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
        updateUI(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setupBackNavigation() {
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

    private void updateUI(View view) {
        setupBackNavigation();
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

        SimpleDraweeView photo = view.findViewById(R.id.detail_photos);

        if (ArrayUtils.isNotEmpty(nearbyPlacesObject.getPhotos())) {
            int imageSize = (int) getResources().getDimension(R.dimen.span_150dp);
            String url = Util.buildUrl(nearbyPlacesObject.getPhotos()[0].getPhoto_reference(),
                    "" + imageSize, "" + imageSize);
            Log.e("saify", url);
            photo.setImageURI(Uri.parse(url));
            morePhotos.setText(nearbyPlacesObject.getPhotos().length + " " + getResources().getString(R.string.more_label));
            morePhotos.setVisibility(View.VISIBLE);
        } else {
            photo.setImageResource(R.drawable.image_placeholder);
            morePhotos.setVisibility(View.GONE);
        }
        if (reviewAdapter == null)
            reviewAdapter = new ReviewAdapter(getContext(), this);
        if (ArrayUtils.isNotEmpty(nearbyPlacesObject.getReviews()))
            reviewAdapter.setData(Arrays.asList(nearbyPlacesObject.getReviews()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        listView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(reviewAdapter);
        reviewAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.detail_photos)
    public void onPhotoClicked() {
        int imageSize = (int) getResources().getDimension(R.dimen.span_150dp);
        List<String> urls = new ArrayList<>();
        for (NearbyPlacesDetailResponseDTO.Result.Photos photo : nearbyPlacesObject.getPhotos()) {
            urls.add(Util.buildUrl(photo.getPhoto_reference(),
                    "" + imageSize, "" + imageSize));
        }
        if (ArrayUtils.isNotEmpty(urls.toArray())) {
            new ImageViewer.Builder(getContext(), urls)
                    .allowZooming(true)
                    .setBackgroundColor(getResources().getColor(R.color.image_background_color))
                    .setStartPosition(0)
                    .show();
        }
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
        showMessage(getResources().getString(R.string.phone_err_msg));
    }

    @Override
    public void actionIfValidWebAddress(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidWebAddress() {
        showMessage(getResources().getString(R.string.web_err_msg));
    }

    @Override
    public void actionIfValidMapUrl(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidMapUrl() {
        showMessage(getResources().getString(R.string.map_err_msg));
    }


    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
