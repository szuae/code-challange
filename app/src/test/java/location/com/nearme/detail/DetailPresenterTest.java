package location.com.nearme.detail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    DetailPresenter presenter;
    @Mock
    DetailContract.View view;

    @Before
    public void setup() {
        presenter = new DetailPresenter();
        presenter.setView(view);
    }

    @Test
    public void validPhoneNumberTest() {
        String number = "+971554598927";
        assertTrue(presenter.validateNumber(number));

        number = "abcd";
        assertFalse(presenter.validateNumber(number));

        number = "abcd23e34";
        assertFalse(presenter.validateNumber(number));

        number = "00971554598927";
        assertTrue(presenter.validateNumber(number));

        number = "00971554598927";
        assertTrue(presenter.validateNumber(number));
    }

    @Test
    public void validEmailTest() {
        String email = "saifuddin@gmail.com";
        assertTrue(presenter.validateEmail(email));

        email = "saifuddin123@gmail.com";
        assertTrue(presenter.validateEmail(email));

        email = "saifuddin";
        assertFalse(presenter.validateEmail(email));

        email = "saifuddin gmail.com";
        assertFalse(presenter.validateEmail(email));

        email = "saifuddin@gmail";
        assertFalse(presenter.validateEmail(email));


        email = "saifuddin.com";
        assertFalse(presenter.validateEmail(email));


        email = "23@gmail.com";
        assertTrue(presenter.validateEmail(email));
    }

    @Test
    public void validatePhoneNumberTest() {
        String number = "+971554598927";
        presenter.validatePhoneNumber(number);
        verify(view, Mockito.times(1)).actionOnvalidPhoneNumber(number);
        verify(view, Mockito.times(0)).actionOnCurruptPhoneNumber(number);

        number = "";
        presenter.validatePhoneNumber(number);
        verify(view, Mockito.times(0)).actionOnvalidPhoneNumber(number);
        verify(view, Mockito.times(1)).actionOnCurruptPhoneNumber(number);

        number = null;
        presenter.validatePhoneNumber(number);
        verify(view, Mockito.times(0)).actionOnvalidPhoneNumber(number);
        verify(view, Mockito.times(1)).actionOnCurruptPhoneNumber(number);

    }

    @Test
    public void validateTwitterTest() {
        String twitterId = "@saifuddin";
        presenter.validateTwitterId(twitterId);
        verify(view, Mockito.times(1)).actionOnvalidTwitterId(twitterId);
        verify(view, Mockito.times(0)).actionOnCurruptTwitterId(twitterId);


        twitterId = "@123";
        presenter.validateTwitterId(twitterId);
        verify(view, Mockito.times(1)).actionOnvalidTwitterId(twitterId);
        verify(view, Mockito.times(0)).actionOnCurruptTwitterId(twitterId);


        twitterId = "saifuddin";
        presenter.validateTwitterId(twitterId);
        verify(view, Mockito.times(0)).actionOnvalidTwitterId(twitterId);
        verify(view, Mockito.times(1)).actionOnCurruptTwitterId(twitterId);

        twitterId = "123";
        presenter.validateTwitterId(twitterId);
        verify(view, Mockito.times(0)).actionOnvalidTwitterId(twitterId);
        verify(view, Mockito.times(1)).actionOnCurruptTwitterId(twitterId);
    }

    @Test
    public void validateFacebookId() {
        String email = "saifuddin@gmail.com";
        presenter.validatefacebookId(email);
        verify(view, Mockito.times(1)).actionOnvalidFacebookId(email);
        verify(view, Mockito.times(0)).actionOnCurruptFacebookId(email);

        email = "";
        presenter.validatefacebookId(email);
        verify(view, Mockito.times(0)).actionOnvalidFacebookId(email);
        verify(view, Mockito.times(1)).actionOnCurruptFacebookId(email);

        email = null;
        presenter.validatefacebookId(email);
        verify(view, Mockito.times(0)).actionOnvalidFacebookId(email);
        verify(view, Mockito.times(1)).actionOnCurruptFacebookId(email);

        email = "saifuddin";
        presenter.validatefacebookId(email);
        verify(view, Mockito.times(0)).actionOnvalidFacebookId(email);
        verify(view, Mockito.times(1)).actionOnCurruptFacebookId(email);
    }

    @Test
    public void validateWhatsappId() {
        String number = "+971554598927";
        presenter.validateWhatsAppId(number);
        verify(view, Mockito.times(1)).actionOnvalidWhatsAppId(number);
        verify(view, Mockito.times(0)).actionOnCurruptWhatsAppId(number);

        number = "";
        presenter.validateWhatsAppId(number);
        verify(view, Mockito.times(0)).actionOnvalidWhatsAppId(number);
        verify(view, Mockito.times(1)).actionOnCurruptWhatsAppId(number);

        number = null;
        presenter.validateWhatsAppId(number);
        verify(view, Mockito.times(0)).actionOnvalidWhatsAppId(number);
        verify(view, Mockito.times(1)).actionOnCurruptWhatsAppId(number);

        number = "abcd";
        presenter.validateWhatsAppId(number);
        verify(view, Mockito.times(0)).actionOnvalidWhatsAppId(number);
        verify(view, Mockito.times(1)).actionOnCurruptWhatsAppId(number);
    }
}