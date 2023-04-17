package com.codecool.vizsgaremek.enums;

public enum PagesUrl {

    REGISTRATION_AND_LOGIN_PAGE("https://lennertamas.github.io/roxo/index.html"),
    LANDING_PAGE("https://lennertamas.github.io/roxo/landing.html");

    private final String url;

    PagesUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
