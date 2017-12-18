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
        public String id;
        public String place_id;
        public String reference;

        private Result(Builder builder) {
            id = builder.id;
            place_id = builder.place_id;
            reference = builder.reference;
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


        public static final class Builder {
            private String id;
            private String place_id;
            private String reference;

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
}
