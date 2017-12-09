package location.com.nearme.detail;

import android.support.annotation.VisibleForTesting;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;

    @Override
    public void validatePhoneNumber(String number) {
        if (StringUtils.isNotEmpty(number) && validateNumber(number))
            view.actionOnvalidPhoneNumber(number);
        else
            view.actionOnCurruptPhoneNumber(number);
    }

    @Override
    public void validateTwitterId(String id) {
        if (StringUtils.isEmpty(id)) {
            view.actionOnCurruptTwitterId(id);
            return;
        }
        Pattern p;
        Matcher m;
        String twitterHandlePattern = "@([A-Za-z0-9_]+)";
        p = Pattern.compile(twitterHandlePattern);
        m = p.matcher(id);
        if (id.matches(twitterHandlePattern))
            view.actionOnvalidTwitterId(id);
        else
            view.actionOnCurruptTwitterId(id);

    }

    @Override
    public void validateWhatsAppId(String id) {
        if (StringUtils.isNotEmpty(id) && validateNumber(id))
            view.actionOnvalidWhatsAppId(id);
        else
            view.actionOnCurruptWhatsAppId(id);
    }

    @Override
    public void validatefacebookId(String id) {
        if (StringUtils.isNotEmpty(id) && validateEmail(id))
            view.actionOnvalidFacebookId(id);
        else
            view.actionOnCurruptFacebookId(id);
    }

    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean validateNumber(String number) {
        String regex = "^[+0-9-\\(\\)\\s]*{6,14}$";
        return number.matches(regex);
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public boolean validateEmail(String email) {
        if (email == null)
            return false;

        Pattern p;
        Matcher m;
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        p = Pattern.compile(emailPattern);
        m = p.matcher(email);
        return m.matches();
    }
}
