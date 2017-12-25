package location.com.nearme.detail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import location.com.nearme.IDInterface;
import location.com.nearme.model.NearbyPlacesObject;

import static location.com.nearme.IDInterface.DetailPageIds.callId;
import static location.com.nearme.IDInterface.DetailPageIds.mapId;
import static location.com.nearme.IDInterface.DetailPageIds.webId;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    DetailPresenter presenter;
    @Mock
    DetailContract.View view;

    NearbyPlacesObject positiveObject;
    NearbyPlacesObject negativeObject;

    @Before
    public void setup() {
        presenter = Mockito.spy(new DetailPresenter());
        presenter.setView(view);
        //positive scenario
        positiveObject = new NearbyPlacesObject.Builder()
                .phone_number("+971554598927")
                .url("http://www.google.com?value=123")
                .website("http://www.google.com")
                .build();

        //Negative scenario
        negativeObject = new NearbyPlacesObject.Builder()
                .phone_number("abc")
                .url("abc")
                .website("abc")
                .build();
    }

    @Test
    public void validPhoneNumberTest() {
        String number = "+971554598927";
        assertTrue(presenter.isPhoneNumberValid(number));

         number = "+971 554598927";
        assertTrue(presenter.isPhoneNumberValid(number));

        number = "+971 55 4598927";
        assertTrue(presenter.isPhoneNumberValid(number));

        number = "abcd";
        assertFalse(presenter.isPhoneNumberValid(number));

        number = "abcd23e34";
        assertFalse(presenter.isPhoneNumberValid(number));

        number = "00971554598927";
        assertTrue(presenter.isPhoneNumberValid(number));

        number = "00971554598927";
        assertTrue(presenter.isPhoneNumberValid(number));
    }


    @Test
    public void validateUrlTest() {
        String url = "http://www.google.com";
        assertTrue(presenter.isUrlValid(url));

        url = "http://google.com";
        assertTrue(presenter.isUrlValid(url));

        url = "https://www.google.com";
        assertTrue(presenter.isUrlValid(url));

        url = "https://www.google.com/";
        assertTrue(presenter.isUrlValid(url));

        url = "https://www.google.com/?value=abc";
        assertTrue(presenter.isUrlValid(url));

        url = "https://www.google.com?value=abc";
        assertTrue(presenter.isUrlValid(url));

        url = "https://www.google.com/?value=abc&value=123";
        assertTrue(presenter.isUrlValid(url));

        url = "";
        assertFalse(presenter.isUrlValid(url));

        url = null;
        assertFalse(presenter.isUrlValid(url));

        url = "https://www.google/?value=abc&value=123";
        assertFalse(presenter.isUrlValid(url));

    }

    @Test
    public void actionOnCallClickTest() {
        presenter.setData(positiveObject);
        presenter.actionOnCallClick();
        verify(view, Mockito.times(1)).actionIfValidPhoneNumber(positiveObject.getPhone_number());

        Mockito.reset(presenter);

        presenter.setData(negativeObject);
        presenter.actionOnCallClick();
        verify(view, Mockito.times(1)).showErrorOnInvalidPhoneNumber();
    }

    @Test
    public void actionOnwebClickTest() {
        presenter.setData(positiveObject);
        presenter.actionOnWebClick();
        verify(view, Mockito.times(1)).actionIfValidWebAddress(positiveObject.getWebsite());

        Mockito.reset(presenter);

        presenter.setData(negativeObject);
        presenter.actionOnWebClick();
        verify(view, Mockito.times(1)).showErrorOnInvalidWebAddress();
    }


    @Test
    public void actionOnMapClickTest() {
        presenter.setData(positiveObject);
        presenter.actionOnMapClick();
        verify(view, Mockito.times(1)).actionIfValidMapUrl(positiveObject.getUrl());

        Mockito.reset(presenter);

        presenter.setData(negativeObject);
        presenter.actionOnMapClick();
        verify(view, Mockito.times(1)).showErrorOnInvalidMapUrl();
    }


    @Test
    public void invokeContactOptionTest() {
        presenter.setData(positiveObject);
        presenter.invokeContactOption(callId);
        verify(presenter, Mockito.times(1)).actionOnCallClick();
        verify(presenter, Mockito.times(0)).actionOnMapClick();
        verify(presenter, Mockito.times(0)).actionOnWebClick();


        Mockito.reset(presenter);

        presenter.setData(positiveObject);
        presenter.invokeContactOption(mapId);
        verify(presenter, Mockito.times(1)).actionOnMapClick();
        verify(presenter, Mockito.times(0)).actionOnWebClick();
        verify(presenter, Mockito.times(0)).actionOnCallClick();


        Mockito.reset(presenter);

        presenter.setData(positiveObject);
        presenter.invokeContactOption(webId);
        verify(presenter, Mockito.times(0)).actionOnMapClick();
        verify(presenter, Mockito.times(0)).actionOnMapClick();
        verify(presenter, Mockito.times(1)).actionOnWebClick();

    }

}