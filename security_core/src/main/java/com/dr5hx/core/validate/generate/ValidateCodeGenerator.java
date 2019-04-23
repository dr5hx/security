package com.dr5hx.core.validate.generate;

import com.dr5hx.core.validate.code.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author dr5hx
 * @descript
 * @date 2019/04/14 19:30
 */
public interface ValidateCodeGenerator {
    ValidateCode generateValidateCode(ServletWebRequest request);
}
