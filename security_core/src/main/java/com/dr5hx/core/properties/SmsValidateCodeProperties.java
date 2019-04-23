package com.dr5hx.core.properties;

/**
 * 验证码属性
 *
 * @author dr5hx
 * @descript
 * @date 2019/04/14 17:22
 */
public class SmsValidateCodeProperties {
    private int length = 6;
    private int expireIn = 60;

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
