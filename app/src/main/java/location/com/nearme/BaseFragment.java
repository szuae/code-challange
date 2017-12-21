package location.com.nearme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import location.com.nearme.utilitycomponent.ConnectivityUtil;
import location.com.nearme.utilitycomponent.ConnectivityUtilImpl;


public class BaseFragment extends Fragment {

    @Nullable
    private ConnectivityUtil connectivityUtil;
    private ProgressBar progressBar;
    public ViewGroup rootView;
    public Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectivityUtil = new ConnectivityUtilImpl(getContext());
    }

    public boolean isNetworkAvailable() {
        return connectivityUtil != null && connectivityUtil.isNetworkAvailable();
    }

    public void setRootView(ViewGroup rootView) {
        this.rootView = rootView;
    }

    public void showProgressBar() {
        if (rootView != null && progressBar.getVisibility() != View.VISIBLE) {
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            progressBar = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleLarge);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            rootView.addView(progressBar, params);
            progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        }
    }


    public void hideProgressBar() {
        if (progressBar.getVisibility() == View.VISIBLE) {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(unbinder != null)
            unbinder.unbind();
    }
}
