package location.com.nearme;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import location.com.nearme.repository.DataRepositoryImplTest;
import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;
import location.com.nearme.repository.NearbyPlacesResponseDTO;

public class TestUtil {

    public static NearbyPlacesResponseDTO createNearbyPlacesDTOFromStub(String json) {
        InputStream inputStream = null;
        NearbyPlacesResponseDTO nearbyPlacesResponseDTO = null;
        try {
            inputStream = DataRepositoryImplTest.class.getClassLoader().getResourceAsStream(json);
            nearbyPlacesResponseDTO =
                    new Gson().fromJson(new InputStreamReader(inputStream), NearbyPlacesResponseDTO.class);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                }
            }
        }
        return nearbyPlacesResponseDTO;
    }

    public static NearbyPlacesDetailResponseDTO createNearbyPlacesDetailDTOFromStub(String json) {
        InputStream inputStream = null;
        NearbyPlacesDetailResponseDTO nearbyPlacesDetailResponseDTO = null;
        try {
            inputStream = DataRepositoryImplTest.class.getClassLoader().getResourceAsStream(json);
            nearbyPlacesDetailResponseDTO =
                    new Gson().fromJson(new InputStreamReader(inputStream), NearbyPlacesDetailResponseDTO.class);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                }
            }
        }
        return nearbyPlacesDetailResponseDTO;
    }

}
