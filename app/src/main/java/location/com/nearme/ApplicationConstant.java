package location.com.nearme;


public interface ApplicationConstant {

    public static enum SEARCH_OPTIONS {
        ATM("atm"),
        CAFE("cafe"),
        FITNESS("gym"),
        GASOLINE("gas_station"),
        SHOPPING("shopping_mall"),
        MOVIES("movie_theater"),
        PARKING("parking"),
        PHARMACY("pharmacy"),
        RESTURANT("restaurant");

        private final String id;

        SEARCH_OPTIONS(String id) {
            this.id = id;
        }

        public String getValue() {
            return id;
        }
    }


    public static enum LANGUAGE {
        English("en"),
        Arabic("ar");
        private final String id;

        LANGUAGE(String id) {
            this.id = id;
        }

        public String getValue() {
            return id;
        }
    }
}
