package location.com.nearme.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import location.com.nearme.BaseFragment;
import location.com.nearme.NearMeApplication;
import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;


public class ExploreDetail extends BaseFragment implements DetailContract.View {

    public static final String SELECTED_ITEM = "selected_item";

    @NonNull
    NearbyPlacesObject nearbyPlacesObject;

    TextView title;
    TextView category;
    TextView address;
    ImageView phone;
    ImageView facebook;
    ImageView whatsapp;
    ImageView twitter;


    @Inject
    DetailContract.Presenter presenter;


    public static ExploreDetail newInstance(NearbyPlacesObject obj) {
        ExploreDetail detail = new ExploreDetail();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SELECTED_ITEM, obj);
        detail.setArguments(bundle);
        return detail;
    }

    private void initUI(NearbyPlacesObject obj, View view) {
        nearbyPlacesObject = obj;

        title = view.findViewById(R.id.detail_title);
        title.setText(obj.getName());
        category = view.findViewById(R.id.detail_category);
        category.setText(obj.getType());
        address = view.findViewById(R.id.detail_address);
        address.setText(obj.getAddress());
        phone = view.findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validatePhoneNumber(nearbyPlacesObject.getPhone());
            }
        });
        whatsapp = view.findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateWhatsAppId(nearbyPlacesObject.getWhatsapp());
            }
        });

        twitter = view.findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateTwitterId(nearbyPlacesObject.getTwitterID());
            }
        });

        facebook = view.findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validatefacebookId(nearbyPlacesObject.getFacebook());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((NearMeApplication) getActivity().getApplication()).getComponent().inject(this);
        return inflater.inflate(R.layout.detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NearbyPlacesObject obj = (NearbyPlacesObject) getArguments().getSerializable(SELECTED_ITEM);
        presenter.setView(this);
        initUI(obj, view);
    }

    @Override
    public void actionOnvalidPhoneNumber(String phone) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ phone));
        startActivity(callIntent);
    }

    @Override
    public void actionOnCurruptPhoneNumber(String phone) {
        showAlert(digitalChannels.PHONE);
    }

    @Override
    public void actionOnvalidFacebookId(String phone) {
        showAlertForupcomingFunctionality(digitalChannels.FACEBOOK);
    }

    @Override
    public void actionOnCurruptFacebookId(String phone) {
        showAlert(digitalChannels.FACEBOOK);
    }

    @Override
    public void actionOnvalidWhatsAppId(String phone) {
        showAlertForupcomingFunctionality(digitalChannels.WHATSAPP);
    }

    @Override
    public void actionOnCurruptWhatsAppId(String phone) {
        showAlert(digitalChannels.WHATSAPP);
    }

    @Override
    public void actionOnvalidTwitterId(String phone) {
        showAlertForupcomingFunctionality(digitalChannels.TWITTER);
    }

    @Override
    public void actionOnCurruptTwitterId(String phone) {
        showAlert(digitalChannels.TWITTER);
    }

    private void showAlertForupcomingFunctionality(digitalChannels channel) {

        Toast.makeText(getContext(),
                channel.name() +" " + getResources().getString(R.string.no_funcationality)
                , Toast.LENGTH_LONG).show();
    }

    private void showAlert(digitalChannels channel) {
        Toast.makeText(getContext(),
                getResources().getString(R.string.sorry) + " "
                        + channel.name() +" "+ getResources().getString(R.string.message)
                , Toast.LENGTH_LONG).show();
    }

    public enum digitalChannels {
        PHONE,
        WHATSAPP,
        FACEBOOK,
        TWITTER;
    }

}
