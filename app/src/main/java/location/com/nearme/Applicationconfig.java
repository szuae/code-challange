package location.com.nearme;

public class Applicationconfig {

    String paginationId;
    ApplicationConstant.LANGUAGE language;

    public String getPaginationId() {
        return paginationId;
    }

    public void setPaginationId(String paginationId) {
        this.paginationId = paginationId;
    }

    public ApplicationConstant.LANGUAGE getLanguage() {
        return language;
    }

    public void setLanguage(ApplicationConstant.LANGUAGE language) {
        this.language = language;
    }
}
