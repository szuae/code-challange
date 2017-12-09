package location.com.nearme.detail;

/**
 * Created by Emirates on 12/2/17.
 */

public interface DetailContract {
    interface View {
        void actionOnvalidPhoneNumber(String phone);
        void actionOnCurruptPhoneNumber(String phone);

        void actionOnvalidFacebookId(String phone);
        void actionOnCurruptFacebookId(String phone);

        void actionOnvalidWhatsAppId(String phone);
        void actionOnCurruptWhatsAppId(String phone);

        void actionOnvalidTwitterId(String phone);
        void actionOnCurruptTwitterId(String phone);

    }

    interface Presenter{

        void validatePhoneNumber(String number);
        void validateTwitterId(String id);
        void validateWhatsAppId(String id);
        void validatefacebookId(String id);

        void setView(View view);
    }
}
