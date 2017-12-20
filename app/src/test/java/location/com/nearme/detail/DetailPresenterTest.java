package location.com.nearme.detail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import location.com.nearme.IDInterface;
import location.com.nearme.model.NearbyPlacesObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
    public void invokeContactOptionPositiveTest() {
        //positive scenario
        NearbyPlacesObject object = new NearbyPlacesObject.Builder()
                .phone_number("+971554598927")
                .url("http://www.google.com?value=123")
                .website("http://www.google.com")
                .build();

        presenter.setData(object);

        presenter.invokeContactOption(IDInterface.DetailPageIds.callId);
        verify(view, Mockito.times(1)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(0)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(0)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(0)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(0)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(0)).showErrorOnInvalidWebAddress();

        Mockito.reset(view);
        presenter.invokeContactOption(IDInterface.DetailPageIds.mapId);
        verify(view, Mockito.times(0)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(1)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(0)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(0)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(0)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(0)).showErrorOnInvalidWebAddress();


        Mockito.reset(view);
        presenter.invokeContactOption(IDInterface.DetailPageIds.webId);
        verify(view, Mockito.times(0)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(0)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(1)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(0)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(0)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(0)).showErrorOnInvalidWebAddress();
    }

    @Test
    public void invokeContactOptionNegativeTest() {
        //Negative scenario
        NearbyPlacesObject object = new NearbyPlacesObject.Builder()
                .phone_number("abc")
                .url("abc")
                .website("abc")
                .build();

        presenter.setData(object);

        presenter.invokeContactOption(IDInterface.DetailPageIds.callId);
        verify(view, Mockito.times(0)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(0)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(0)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(1)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(0)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(0)).showErrorOnInvalidWebAddress();

        Mockito.reset(view);
        presenter.invokeContactOption(IDInterface.DetailPageIds.mapId);
        verify(view, Mockito.times(0)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(0)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(0)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(0)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(1)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(0)).showErrorOnInvalidWebAddress();

        Mockito.reset(view);
        presenter.invokeContactOption(IDInterface.DetailPageIds.webId);
        verify(view, Mockito.times(0)).actionIfValidPhoneNumber(object.getPhone_number());
        verify(view, Mockito.times(0)).actionIfValidMapUrl(object.getUrl());
        verify(view, Mockito.times(0)).actionIfValidWebAddress(object.getWebsite());
        verify(view, Mockito.times(0)).showErrorOnInvalidPhoneNumber();
        verify(view, Mockito.times(0)).showErrorOnInvalidMapUrl();
        verify(view, Mockito.times(1)).showErrorOnInvalidWebAddress();
    }
}