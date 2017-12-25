package location.com.nearme.browse;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.IDInterface;
import location.com.nearme.model.ErrorObject;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.DataRepository;


public class ListPresenter implements ListContract.Presenter {

    @NonNull
    private final DataRepository repo;

    @NonNull
    private ListContract.View view;

    public ListPresenter(DataRepository repo) {
        this.repo = repo;
    }


    public void call(String location, ApplicationConstant.SEARCH_OPTIONS option) {
        repo.loadData(location, option)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.onFinishLoading();
                    }
                })
                .subscribe(new Consumer<NearbyPlacesObject>() {
                               @Override
                               public void accept(NearbyPlacesObject object) throws Exception {
                                   if (view != null)
                                       view.onSucess(object);
                                   Log.e("saify", "called:::" + object.getWebsite());
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable errorObject) throws Exception {
                                if (errorObject instanceof ErrorObject) {
                                    view.onFailure(getErrorMessage(((ErrorObject) errorObject).getErrorCode()));
                                }
                            }
                        });
    }


    @Override
    public void setView(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(String location, ApplicationConstant.SEARCH_OPTIONS option) {
        call(location, option);
    }


    @Override
    public int getErrorMessage(String errorCode) {
        int errorMessageId = IDInterface.ErrorIds.generic;
        switch (errorCode) {
            case ApplicationConstant.ApiStatusCode.GENERIC_ERROR:
            case ApplicationConstant.ApiStatusCode.REQUEST_INVALID:
                errorMessageId = IDInterface.ErrorIds.generic;
                break;
            case ApplicationConstant.ApiStatusCode.NO_RESULTS:
                errorMessageId = IDInterface.ErrorIds.noResult;
                break;
            case ApplicationConstant.ApiStatusCode.KEY_INVALID:
            case ApplicationConstant.ApiStatusCode.LIMIT_REACHED:
                errorMessageId = IDInterface.ErrorIds.limitReached;
                break;
        }
        return errorMessageId;
    }
}
