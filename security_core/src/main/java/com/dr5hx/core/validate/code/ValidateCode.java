package com.dr5hx.core.validate.code;

import java.time.LocalDateTime;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 19:13
 */
public class ValidateCode {
    private String code;
    private LocalDateTime localDateTime;

    public ValidateCode(String code, int sec) {
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(sec);
    }

    /**
     * @return
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(localDateTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
