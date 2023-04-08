package enums;

public enum PagesUrl {

    REGISTRATION_AND_LOGIN_PAGE("https://lennertamas.github.io/roxo/index.html");

    private final String url;

    PagesUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
