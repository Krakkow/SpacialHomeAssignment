package com.dotCompliance.pageutils;

import com.dotCompliance.pages.LoginPage;
import com.dotCompliance.utils.WebDriverCommonFunc;

public class LoginPageUtils {

    private WebDriverCommonFunc driverUtils;

    public LoginPageUtils(WebDriverCommonFunc driverUtils) {
        this.driverUtils = driverUtils;
    }

    public void goToLoginPage(String url) {
        driverUtils.goToPage(url);
    }

    public void fillLoginForm(String username, String password) {
        driverUtils.type(LoginPage.USERNAME_INPUT, username);
        driverUtils.type(LoginPage.PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        driverUtils.click(LoginPage.LOGIN_BUTTON);
    }

    public boolean isLoginPageDisplayed() {
        return driverUtils.isVisible(LoginPage.USERNAME_INPUT) &&
                driverUtils.isVisible(LoginPage.PASSWORD_INPUT) &&
                driverUtils.isVisible(LoginPage.LOGIN_BUTTON);
    }

}
