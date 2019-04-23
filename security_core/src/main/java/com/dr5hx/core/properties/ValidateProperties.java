package com.dr5hx.core.properties;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 17:20
 */
public class ValidateProperties {

    SmsValidateCodeProperties sms = new SmsValidateCodeProperties();
    ImageValidateCodeProperties image = new ImageValidateCodeProperties();

    public SmsValidateCodeProperties getCode() {
        return sms;
    }

    public void setCode(SmsValidateCodeProperties sms) {
        this.sms = sms;
    }

    public ImageValidateCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageValidateCodeProperties image) {
        this.image = image;
    }
}
