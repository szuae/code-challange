package location.com.nearme.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyPlacesDetailResponseDTO implements Serializable {
    public Result results;
    public String status;

    private NearbyPlacesDetailResponseDTO(Builder builder) {
        results = builder.results;
        status = builder.status;
    }

    public Result getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static public class Result implements Serializable {
        public String formatted_address;
        public String international_phone_number;
        public String name;
        public String id;
        public String place_id;
        public String reference;
        public String website;
        public String url;
        public double rating;

        public Coordinates geomerty;
        public WorkingHours opening_hours;
        public Photos[] photos;
        public Reviews[] reviews;

        private Result(Builder builder) {
            formatted_address = builder.formatted_address;
            international_phone_number = builder.international_phone_number;
            name = builder.name;
            id = builder.id;
            place_id = builder.place_id;
            reference = builder.reference;
            website = builder.website;
            url = builder.url;
            rating = builder.rating;
            geomerty = builder.geomerty;
            opening_hours = builder.opening_hours;
            photos = builder.photos;
            reviews = builder.reviews;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public String getInternational_phone_number() {
            return international_phone_number;
        }

        public String getName() {
            return name;
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

        public String getWebsite() {
            return website;
        }

        public String getUrl() {
            return url;
        }

        public double getRating() {
            return rating;
        }

        public Coordinates getGeomerty() {
            return geomerty;
        }

        public WorkingHours getOpening_hours() {
            return opening_hours;
        }

        public Photos[] getPhotos() {
            return photos;
        }

        public Reviews[] getReviews() {
            return reviews;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class Coordinates implements Serializable {
            public Location location;

            private Coordinates(Builder builder) {
                location = builder.location;
            }

            public Location getLocation() {
                return location;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            static public class Location implements Serializable {
                double lat;
                double lng;

                private Location(Builder builder) {
                    lat = builder.lat;
                    lng = builder.lng;
                }

                public double getLat() {
                    return lat;
                }

                public double getLng() {
                    return lng;
                }

                public static final class Builder {
                    private double lat;
                    private double lng;

                    public Builder() {
                    }

                    public Builder lat(double val) {
                        lat = val;
                        return this;
                    }

                    public Builder lng(double val) {
                        lng = val;
                        return this;
                    }

                    public Location build() {
                        return new Location(this);
                    }
                }
            }

            public static final class Builder {
                private Location location;

                public Builder() {
                }

                public Builder location(Location val) {
                    location = val;
                    return this;
                }

                public Coordinates build() {
                    return new Coordinates(this);
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class WorkingHours implements Serializable {
            public boolean open_now;
            public String[] weekday_text;

            private WorkingHours(Builder builder) {
                open_now = builder.open_now;
                weekday_text = builder.weekday_text;
            }

            public boolean isOpen_now() {
                return open_now;
            }

            public String[] getWeekday_text() {
                return weekday_text;
            }

            public static final class Builder {
                private boolean open_now;
                private String[] weekday_text;

                public Builder() {
                }

                public Builder open_now(boolean val) {
                    open_now = val;
                    return this;
                }

                public Builder weekday_text(String[] val) {
                    weekday_text = val;
                    return this;
                }

                public WorkingHours build() {
                    return new WorkingHours(this);
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class Photos implements Serializable {
            public int height;
            public int width;
            public String photo_reference;

            private Photos(Builder builder) {
                height = builder.height;
                width = builder.width;
                photo_reference = builder.photo_reference;
            }

            public int getHeight() {
                return height;
            }

            public int getWidth() {
                return width;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public static final class Builder {
                private int height;
                private int width;
                private String photo_reference;

                public Builder() {
                }

                public Builder height(int val) {
                    height = val;
                    return this;
                }

                public Builder width(int val) {
                    width = val;
                    return this;
                }

                public Builder photo_reference(String val) {
                    photo_reference = val;
                    return this;
                }

                public Photos build() {
                    return new Photos(this);
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class Reviews implements Serializable {

            public String author_name;
            public String relative_time_description;
            public String profile_photo_url;
            public String text;
            public int rating;

            private Reviews(Builder builder) {
                author_name = builder.author_name;
                relative_time_description = builder.relative_time_description;
                profile_photo_url = builder.profile_photo_url;
                text = builder.text;
                rating = builder.rating;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public String getRelative_time_description() {
                return relative_time_description;
            }

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public String getText() {
                return text;
            }

            public int getRating() {
                return rating;
            }

            public static final class Builder {
                private String author_name;
                private String relative_time_description;
                private String profile_photo_url;
                private String text;
                private int rating;

                public Builder() {
                }

                public Builder author_name(String val) {
                    author_name = val;
                    return this;
                }

                public Builder relative_time_description(String val) {
                    relative_time_description = val;
                    return this;
                }

                public Builder profile_photo_url(String val) {
                    profile_photo_url = val;
                    return this;
                }

                public Builder text(String val) {
                    text = val;
                    return this;
                }

                public Builder rating(int val) {
                    rating = val;
                    return this;
                }

                public Reviews build() {
                    return new Reviews(this);
                }
            }
        }

        public static final class Builder {
            private String formatted_address;
            private String international_phone_number;
            private String name;
            private String id;
            private String place_id;
            private String reference;
            private String website;
            private String url;
            private double rating;
            private Coordinates geomerty;
            private WorkingHours opening_hours;
            private Photos[] photos;
            private Reviews[] reviews;

            public Builder() {
            }

            public Builder formatted_address(String val) {
                formatted_address = val;
                return this;
            }

            public Builder international_phone_number(String val) {
                international_phone_number = val;
                return this;
            }

            public Builder name(String val) {
                name = val;
                return this;
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

            public Builder geomerty(Coordinates val) {
                geomerty = val;
                return this;
            }

            public Builder opening_hours(WorkingHours val) {
                opening_hours = val;
                return this;
            }

            public Builder photos(Photos[] val) {
                photos = val;
                return this;
            }

            public Builder reviews(Reviews[] val) {
                reviews = val;
                return this;
            }

            public Result build() {
                return new Result(this);
            }
        }
    }


    public static final class Builder {
        private Result results;
        private String status;

        public Builder() {
        }

        public Builder results(Result val) {
            results = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public NearbyPlacesDetailResponseDTO build() {
            return new NearbyPlacesDetailResponseDTO(this);
        }
    }
}
