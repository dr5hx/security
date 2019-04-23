package com.dr5hx.core.properties;

public class BrowserProperties {
    private String loginPage = "/dr5hx-signIn.html";//默认页
    private String userName = "userName"; //
    private String passWord = "passWord";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {

        this.loginPage = loginPage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
