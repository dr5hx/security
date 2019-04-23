package com.dr5hx.core.validate.code;

import java.awt.image.BufferedImage;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 19:18
 */
public class ImageCode extends ValidateCode {

    private BufferedImage bufferedImage;

    public ImageCode(String code, int sec, BufferedImage bufferedImage) {
        super(code, sec);
        this.bufferedImage = bufferedImage;

    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
