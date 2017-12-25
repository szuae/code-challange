package location.com.nearme.browse;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import location.com.nearme.ApplicationConstant;
import location.com.nearme.model.ErrorObject;
import location.com.nearme.model.NearbyPlacesObject;
import location.com.nearme.repository.DataRepository;

import static location.com.nearme.ApplicationConstant.ApiStatusCode.GENERIC_ERROR;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.KEY_INVALID;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.LIMIT_REACHED;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.NO_RESULTS;
import static location.com.nearme.ApplicationConstant.ApiStatusCode.REQUEST_INVALID;
import static location.com.nearme.IDInterface.ErrorIds.generic;
import static location.com.nearme.IDInterface.ErrorIds.limitReached;
import static location.com.nearme.IDInterface.ErrorIds.noResult;


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
        int errorMessageId = generic;
        switch (errorCode) {
            case GENERIC_ERROR:
            case REQUEST_INVALID:
                errorMessageId = generic;
                break;
            case NO_RESULTS:
                errorMessageId = noResult;
                break;
            case KEY_INVALID:
            case LIMIT_REACHED:
                errorMessageId = limitReached;
                break;
        }
        return errorMessageId;
    }
}
