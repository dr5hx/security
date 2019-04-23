package com.dr5hx.core.validate.generate.impl;

import com.dr5hx.core.properties.SecurityProperties;
import com.dr5hx.core.validate.code.ValidateCode;
import com.dr5hx.core.validate.generate.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 19:42
 */
public class SmsCodeGenerator implements ValidateCodeGenerator {
    /**
     * 系统配置
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generateValidateCode(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getValidate().getCode().getLength());
        return new ValidateCode(code, securityProperties.getValidate().getCode().getExpireIn());
    }
}
