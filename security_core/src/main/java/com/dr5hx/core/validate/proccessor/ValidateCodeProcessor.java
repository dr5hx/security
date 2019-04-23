package com.dr5hx.core.validate.proccessor;

import com.dr5hx.core.validate.exception.ValidateCodeException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 19:47
 */
public interface ValidateCodeProcessor {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception, ValidateCodeException;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest) throws ValidateCodeException;
}
