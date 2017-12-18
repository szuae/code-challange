package location.com.nearme.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyPlacesResponseDTO implements Serializable {
    public String next_page_token;
    public Result[] results;
    public String status;

    private NearbyPlacesResponseDTO(Builder builder) {
        next_page_token = builder.next_page_token;
        results = builder.results;
        status = builder.status;
    }

    public String getNext_page_token() {
        return next_page_token;
    }

    public Result[] getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    static public class Result implements Serializable {
        public Coordinates geomerty;
        public WorkingHours opening_hours;
        public String id;
        public String place_id;
        public String reference;
        public String name;
        public String vicinity;
        public double rating;

        private Result(Builder builder) {
            geomerty = builder.geomerty;
            opening_hours = builder.opening_hours;
            id = builder.id;
            place_id = builder.place_id;
            reference = builder.reference;
            name = builder.name;
            vicinity = builder.vicinity;
            rating = builder.rating;
        }

        public Coordinates getGeomerty() {
            return geomerty;
        }

        public WorkingHours getOpening_hours() {
            return opening_hours;
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

        public String getName() {
            return name;
        }

        public String getVicinity() {
            return vicinity;
        }

        public double getRating() {
            return rating;
        }


        @JsonIgnoreProperties(ignoreUnknown = true)
        static public class WorkingHours implements Serializable {
            boolean open_now;

            private WorkingHours(Builder builder) {
                open_now = builder.open_now;
            }

            public boolean isOpen_now() {
                return open_now;
            }

            public static final class Builder {
                private boolean open_now;

                public Builder() {
                }

                public Builder open_now(boolean val) {
                    open_now = val;
                    return this;
                }

                public WorkingHours build() {
                    return new WorkingHours(this);
                }
            }
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
                public double lat;
                public double lng;


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


        public static final class Builder {
            private Coordinates geomerty;
            private WorkingHours opening_hours;
            private String id;
            private String place_id;
            private String reference;
            private String name;
            private String vicinity;
            private double rating;

            public Builder() {
            }

            public Builder geomerty(Coordinates val) {
                geomerty = val;
                return this;
            }

            public Builder opening_hours(WorkingHours val) {
                opening_hours = val;
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

            public Builder name(String val) {
                name = val;
                return this;
            }

            public Builder vicinity(String val) {
                vicinity = val;
                return this;
            }

            public Builder rating(double val) {
                rating = val;
                return this;
            }

            public Result build() {
                return new Result(this);
            }
        }
    }

    public static final class Builder {
        private String next_page_token;
        private Result[] results;
        private String status;

        public Builder() {
        }

        public Builder next_page_token(String val) {
            next_page_token = val;
            return this;
        }

        public Builder results(Result[] val) {
            results = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public NearbyPlacesResponseDTO build() {
            return new NearbyPlacesResponseDTO(this);
        }
    }
