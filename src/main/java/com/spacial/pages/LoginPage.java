package com.spacial.pages;

import org.openqa.selenium.By;

public class LoginPage {

    private LoginPage() {
        // Private constructor to prevent instantiation
    }

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By LOGIN_ERROR_MESSAGE = By.cssSelector("[data-test='error']");

}
