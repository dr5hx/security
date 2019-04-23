package com.dr5hx.core.properties;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 17:26
 */
public class ImageValidateCodeProperties extends SmsValidateCodeProperties {
    private int width = 60;
    private int height = 20;

    public ImageValidateCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
