package location.com.nearme.model;


import java.io.Serializable;

public class NearbyPlacesObject  implements Serializable{
    String id;
    String phone;
    String twitterID;
    String address;
    String latitude;
    String longitude;
    String type;
    String imageUrl;
    String name;
    String whatsapp;
    String facebook;

    private NearbyPlacesObject(Builder builder) {
        id = builder.id;
        phone = builder.phone;
        address = builder.address;
        latitude = builder.latitude;
        longitude = builder.longitude;
        type = builder.type;
        imageUrl = builder.imageUrl;
        name = builder.name;
        whatsapp = builder.whatsapp;
        facebook = builder.facebook;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getTwitterID() {
        return twitterID;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getFacebook() {
        return facebook;
    }


    public static final class Builder {
        private String id;
        private String phone;
        private String address;
        private String latitude;
        private String longitude;
        private String type;
        private String imageUrl;
        private String name;
        private String whatsapp;
        private String facebook;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder latitude(String val) {
            latitude = val;
            return this;
        }

        public Builder longitude(String val) {
            longitude = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder imageUrl(String val) {
            imageUrl = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder whatsapp(String val) {
            whatsapp = val;
            return this;
        }

        public Builder facebook(String val) {
            facebook = val;
            return this;
        }

        public NearbyPlacesObject build() {
            return new NearbyPlacesObject(this);
        }
    }
}
