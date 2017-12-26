package location.com.nearme.model;


import java.io.Serializable;
import java.util.Arrays;

import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;

public class NearbyPlacesObject  implements Serializable {
    String id;
    String place_id;
    String reference;
    String address;
    String phone_number;
    String name;
    String website;
    String url;
    double rating;
    double lat;
    double lng;
    boolean open_now;
    NearbyPlacesDetailResponseDTO.Result.Photos[] photos;
    NearbyPlacesDetailResponseDTO.Result.Reviews[] reviews;
    String ErrorCode;
    String ErrorMessage;


    private NearbyPlacesObject(Builder builder) {
        id = builder.id;
        place_id = builder.place_id;
        reference = builder.reference;
        address = builder.address;
        phone_number = builder.phone_number;
        name = builder.name;
        website = builder.website;
        url = builder.url;
        rating = builder.rating;
        lat = builder.lat;
        lng = builder.lng;
        open_now = builder.open_now;
        photos = builder.photos;
        reviews = builder.reviews;
        ErrorCode = builder.ErrorCode;
        ErrorMessage = builder.ErrorMessage;
    }


    public String getId() {
        return id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String getReference() {
        return reference;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getUrl() {
        return url;
    }

    public double getRating() {
        return rating;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public boolean isOpen_now() {
        return open_now;
    }

    public NearbyPlacesDetailResponseDTO.Result.Photos[] getPhotos() {
        return photos;
    }

    public NearbyPlacesDetailResponseDTO.Result.Reviews[] getReviews() {
        return reviews;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public static final class Builder {
        private String id;
        private String place_id;
        private String reference;
        private String address;
        private String phone_number;
        private String name;
        private String website;
        private String url;
        private double rating;
        private double lat;
        private double lng;
        private boolean open_now;
        private NearbyPlacesDetailResponseDTO.Result.Photos[] photos;
        private NearbyPlacesDetailResponseDTO.Result.Reviews[] reviews;
        private String ErrorCode;
        private String ErrorMessage;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder place_id(String val) {
            place_id = val;
            return this;
        }

        public Builder reference(String val) {
            reference = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder phone_number(String val) {
            phone_number = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder website(String val) {
            website = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder rating(double val) {
            rating = val;
            return this;
        }

        public Builder lat(double val) {
            lat = val;
            return this;
        }

        public Builder lng(double val) {
            lng = val;
            return this;
        }

        public Builder open_now(boolean val) {
            open_now = val;
            return this;
        }

        public Builder photos(NearbyPlacesDetailResponseDTO.Result.Photos[] val) {
            photos = val;
            return this;
        }

        public Builder reviews(NearbyPlacesDetailResponseDTO.Result.Reviews[] val) {
            reviews = val;
            return this;
        }

        public Builder ErrorCode(String val) {
            ErrorCode = val;
            return this;
        }

        public Builder ErrorMessage(String val) {
            ErrorMessage = val;
            return this;
        }

        public NearbyPlacesObject build() {
            return new NearbyPlacesObject(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NearbyPlacesObject that = (NearbyPlacesObject) o;

        if (Double.compare(that.rating, rating) != 0) return false;
        if (Double.compare(that.lat, lat) != 0) return false;
        if (Double.compare(that.lng, lng) != 0) return false;
        if (open_now != that.open_now) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (place_id != null ? !place_id.equals(that.place_id) : that.place_id != null)
            return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone_number != null ? !phone_number.equals(that.phone_number) : that.phone_number != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photos, that.photos)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(reviews, that.reviews)) return false;
        if (ErrorCode != null ? !ErrorCode.equals(that.ErrorCode) : that.ErrorCode != null)
            return false;
        if (ErrorMessage != null ? !ErrorMessage.equals(that.ErrorMessage) : that.ErrorMessage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (place_id != null ? place_id.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (open_now ? 1 : 0);
        result = 31 * result + Arrays.hashCode(photos);
        result = 31 * result + Arrays.hashCode(reviews);
        result = 31 * result + (ErrorCode != null ? ErrorCode.hashCode() : 0);
        result = 31 * result + (ErrorMessage != null ? ErrorMessage.hashCode() : 0);
        return result;
    }
}
