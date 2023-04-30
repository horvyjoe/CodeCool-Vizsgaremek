package com.codecool.vizsgaremek.enums;

public enum PagesUrl {

    REGISTRATION_AND_LOGIN_PAGE("https://lennertamas.github.io/roxo/index.html"),
    LANDING_PAGE("https://lennertamas.github.io/roxo/landing.html"),
    ABOUT_PAGE("https://lennertamas.github.io/roxo/about/"),
    GET_IN_TOUCH("https://lennertamas.github.io/roxo/contact/"),
    PROFILE_PAGE("https://lennertamas.github.io/roxo/profile");

    private final String url;

    PagesUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
