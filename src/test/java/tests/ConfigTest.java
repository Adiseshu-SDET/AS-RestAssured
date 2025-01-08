package tests;

import config.ConfigManager;

public class ConfigTest {

    public static void main(String[] args) {
        System.out.println("Base URL: " + ConfigManager.getProperty("base.url"));
        System.out.println("Timeout: " + ConfigManager.getIntProperty("timeout"));
        System.out.println("Environment: " + ConfigManager.getProperty("environment"));
    }
}
