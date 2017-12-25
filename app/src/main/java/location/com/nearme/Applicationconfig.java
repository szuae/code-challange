package location.com.nearme;

import static location.com.nearme.ApplicationConstant.LANGUAGE.English;

public class Applicationconfig {

    ApplicationConstant.LANGUAGE language = English;


    public ApplicationConstant.LANGUAGE getLanguage() {
        return language;
    }

    public void setLanguage(ApplicationConstant.LANGUAGE language) {
        this.language = language;
    }

}
