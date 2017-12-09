package location.com.nearme.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyPlacesResponseDTO implements Serializable {
    public Meta meta;
    public response response;

    public NearbyPlacesResponseDTO(){

    }
    private NearbyPlacesResponseDTO(Builder builder) {
        meta = builder.meta;
        response = builder.response;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static public class Meta implements Serializable {
        int code;
        String errorType;
        String errorDetail;
        String requestId;

        private Meta(Builder builder) {
            code = builder.code;
            errorType = builder.errorType;
            errorDetail = builder.errorDetail;
            requestId = builder.requestId;
        }

        public static final class Builder {
            private int code;
            private String errorType;
            private String errorDetail;
            private String requestId;

            public Builder() {
            }

            public Builder code(int val) {
                code = val;
                return this;
            }

            public Builder errorType(String val) {
                errorType = val;
                return this;
            }

            public Builder errorDetail(String val) {
                errorDetail = val;
                return this;
            }

            public Builder requestId(String val) {
                requestId = val;
                return this;
            }

            public Meta build() {
                return new Meta(this);
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static public class response implements Serializable {
            public venues[] venues;

        private response(Builder builder) {
            venues = builder.venues;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class venues implements Serializable {
            public String id;
            public String name;
            public contact contact;
            public location location;
            public categories[] categories;
            public stats stats;

            private venues(Builder builder) {
                id = builder.id;
                name = builder.name;
                contact = builder.contact;
                location = builder.location;
                categories = builder.categories;
                stats = builder.stats;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            static public class contact implements Serializable {
                public String phone;
                public String formattedPhone;
                public String twitter;

                private contact(Builder builder) {
                    phone = builder.phone;
                    formattedPhone = builder.formattedPhone;
                    twitter = builder.twitter;
                }

                public static final class Builder {
                    private String phone;
                    private String formattedPhone;
                    private String twitter;

                    public Builder() {
                    }

                    public Builder phone(String val) {
                        phone = val;
                        return this;
                    }

                    public Builder formattedPhone(String val) {
                        formattedPhone = val;
                        return this;
                    }

                    public Builder twitter(String val) {
                        twitter = val;
                        return this;
                    }

                    public NearbyPlacesResponseDTO.response.venues.contact build() {
                        return new contact(this);
                    }
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            static public class location implements Serializable {
                public String address;
                public String country;
                public String crossStreet;
                public String lat;
                public String lng;

                private location(Builder builder) {
                    address = builder.address;
                    country = builder.country;
                    crossStreet = builder.crossStreet;
                    lat = builder.lat;
                    lng = builder.lng;
                }

                public static final class Builder {
                    private String address;
                    private String country;
                    private String crossStreet;
                    private String lat;
                    private String lng;

                    public Builder() {
                    }

                    public Builder address(String val) {
                        address = val;
                        return this;
                    }

                    public Builder country(String val) {
                        country = val;
                        return this;
                    }

                    public Builder crossStreet(String val) {
                        crossStreet = val;
                        return this;
                    }

                    public Builder lat(String val) {
                        lat = val;
                        return this;
                    }

                    public Builder lng(String val) {
                        lng = val;
                        return this;
                    }

                    public NearbyPlacesResponseDTO.response.venues.location build() {
                        return new location(this);
                    }
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            static public class categories implements Serializable {
                public String id;
                public String name;
                public String shortName;
                public icon icon;

                private categories(Builder builder) {
                    id = builder.id;
                    name = builder.name;
                    shortName = builder.shortName;
                    icon = builder.icon;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                static public class icon implements Serializable {
                    public String prefix;
                    public String suffix;

                    private icon(Builder builder) {
                        prefix = builder.prefix;
                        suffix = builder.suffix;
                    }

                    public static final class Builder {
                        private String prefix;
                        private String suffix;

                        public Builder() {
                        }

                        public Builder prefix(String val) {
                            prefix = val;
                            return this;
                        }

                        public Builder suffix(String val) {
                            suffix = val;
                            return this;
                        }

                        public NearbyPlacesResponseDTO.response.venues.categories.icon build() {
                            return new icon(this);
                        }
                    }
                }

                public static final class Builder {
                    private String id;
                    private String name;
                    private String shortName;
                    private NearbyPlacesResponseDTO.response.venues.categories.icon icon;

                    public Builder() {
                    }

                    public Builder id(String val) {
                        id = val;
                        return this;
                    }

                    public Builder name(String val) {
                        name = val;
                        return this;
                    }

                    public Builder shortName(String val) {
                        shortName = val;
                        return this;
                    }

                    public Builder icon(NearbyPlacesResponseDTO.response.venues.categories.icon val) {
                        icon = val;
                        return this;
                    }

                    public NearbyPlacesResponseDTO.response.venues.categories build() {
                        return new categories(this);
                    }
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            static public class stats implements Serializable {
                public int checkinsCount;
                public int tipCount;
                public int usersCount;

                private stats(Builder builder) {
                    checkinsCount = builder.checkinsCount;
                    tipCount = builder.tipCount;
                    usersCount = builder.usersCount;
                }

                public static final class Builder {
                    private int checkinsCount;
                    private int tipCount;
                    private int usersCount;

                    public Builder() {
                    }

                    public Builder checkinsCount(int val) {
                        checkinsCount = val;
                        return this;
                    }

                    public Builder tipCount(int val) {
                        tipCount = val;
                        return this;
                    }

                    public Builder usersCount(int val) {
                        usersCount = val;
                        return this;
                    }

                    public NearbyPlacesResponseDTO.response.venues.stats build() {
                        return new stats(this);
                    }
                }
            }

            public static final class Builder {
                private String id;
                private String name;
                private NearbyPlacesResponseDTO.response.venues.contact contact;
                private NearbyPlacesResponseDTO.response.venues.location location;
                private NearbyPlacesResponseDTO.response.venues.categories[] categories;
                private NearbyPlacesResponseDTO.response.venues.stats stats;

                public Builder() {
                }

                public Builder id(String val) {
                    id = val;
                    return this;
                }

                public Builder name(String val) {
                    name = val;
                    return this;
                }

                public Builder contact(NearbyPlacesResponseDTO.response.venues.contact val) {
                    contact = val;
                    return this;
                }

                public Builder location(NearbyPlacesResponseDTO.response.venues.location val) {
                    location = val;
                    return this;
                }

                public Builder categories(NearbyPlacesResponseDTO.response.venues.categories[] val) {
                    categories = val;
                    return this;
                }

                public Builder stats(NearbyPlacesResponseDTO.response.venues.stats val) {
                    stats = val;
                    return this;
                }

                public NearbyPlacesResponseDTO.response.venues build() {
                    return new venues(this);
                }
            }
        }

        public static final class Builder {
            private NearbyPlacesResponseDTO.response.venues[] venues;

            public Builder() {
            }

            public Builder venues(NearbyPlacesResponseDTO.response.venues[] val) {
                venues = val;
                return this;
            }

            public NearbyPlacesResponseDTO.response build() {
                return new response(this);
            }
        }
    }

    public static final class Builder {
        private Meta meta;
        private NearbyPlacesResponseDTO.response response;

        public Builder() {
        }

        public Builder meta(Meta val) {
            meta = val;
            return this;
        }

        public Builder response(NearbyPlacesResponseDTO.response val) {
            response = val;
            return this;
        }

        public NearbyPlacesResponseDTO build() {
            return new NearbyPlacesResponseDTO(this);
        }
    }
}
