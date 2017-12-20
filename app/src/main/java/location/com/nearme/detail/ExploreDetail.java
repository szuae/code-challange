package location.com.nearme.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import location.com.nearme.BaseFragment;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;


public class ExploreDetail extends BaseFragment implements DetailContract.View {

    public static final String SELECTED_ITEM = "selected_item";

    View view;

    @Inject
    DetailContract.Presenter presenter;

    @BindView(R.id.detail_photos)
    ImageView photo;

    @BindView(R.id.detail_name)
    TextView name;

    @BindView(R.id.detail_address)
    TextView address;

    @BindView(R.id.detail_ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.detail_is_working)
    TextView isWorkingStatus;

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
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NearbyPlacesObject obj = (NearbyPlacesObject) getArguments().getSerializable(SELECTED_ITEM);
        presenter.setView(this);
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
        showErrorToast(getResources().getString(R.string.phone_err_msg));
    }

    @Override
    public void actionIfValidWebAddress(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidWebAddress() {
        showErrorToast(getResources().getString(R.string.web_err_msg));
    }

    @Override
    public void actionIfValidMapUrl(String url) {
        openUrl(url);
    }

    @Override
    public void showErrorOnInvalidMapUrl() {
        showErrorToast(getResources().getString(R.string.map_err_msg));
    }


    private void showErrorToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
