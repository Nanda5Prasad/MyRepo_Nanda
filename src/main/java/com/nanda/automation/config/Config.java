package com.nanda.automation.config;

public final class Config {
    private Config() {}

    public static String browser() { return value("browser", "chrome"); }
    public static String baseUrl() { return value("baseUrl", "https://example.com"); }
    public static boolean headless() { return Boolean.parseBoolean(value("headless", "true")); }
    public static long timeoutSeconds() { return Long.parseLong(value("timeoutSeconds", "10")); }

    private static String value(String key, String fallback) {
        return System.getProperty(key, System.getProperty("config." + key, fallback));
    }
}
