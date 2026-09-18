package com.nanda.automation.config;

public final class Config {
    private Config() {
    }

    public static String browser() {
        return value("browser", "chrome");
    }

    public static String baseUrl() {
        return value("baseUrl", "https://example.com");
    }

    public static String loginUrl() {
        return value("loginUrl", baseUrl());
    }

    public static String apiBaseUrl() {
        return value("apiBaseUrl", "https://httpbin.org");
    }

    public static String username() {
        return value("username", "test.user@example.com");
    }

    public static String password() {
        return value("password", "change-me");
    }

    public static String usernameLocator() {
        return value("usernameLocator", "username");
    }

    public static String passwordLocator() {
        return value("passwordLocator", "password");
    }

    public static String loginButtonLocator() {
        return value("loginButtonLocator", "loginBtn");
    }

    public static String loginPageMarkerLocator() {
        return value("loginPageMarkerLocator", "login-form");
    }

    public static String homeHeadingLocator() {
        return value("homeHeadingLocator", "h1");
    }

    public static String dashboardMarkerLocator() {
        return value("dashboardMarkerLocator", "dashboard");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(value("headless", "true"));
    }

    public static long timeoutSeconds() {
        return Long.parseLong(value("timeoutSeconds", "10"));
    }

    private static String value(String key, String fallback) {
        return System.getProperty(key, System.getProperty("config." + key, fallback));
    }
}
