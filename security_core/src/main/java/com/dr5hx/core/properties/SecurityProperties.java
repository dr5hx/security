package com.dr5hx.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dr5hx.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateProperties validate = new ValidateProperties();

    public ValidateProperties getValidate() {
        return validate;
    }

    public void setValidate(ValidateProperties validate) {
        this.validate = validate;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
