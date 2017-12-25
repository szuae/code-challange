package location.com.nearme;

public class Applicationconfig {

    ApplicationConstant.LANGUAGE language = ApplicationConstant.LANGUAGE.English;


    public ApplicationConstant.LANGUAGE getLanguage() {
        return language;
    }

    public void setLanguage(ApplicationConstant.LANGUAGE language) {
        this.language = language;
    }

}
