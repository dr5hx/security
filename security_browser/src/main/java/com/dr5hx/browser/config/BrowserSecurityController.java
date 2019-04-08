package com.dr5hx.browser.config;

import com.dr5hx.browser.response.SimpleResponse;
import com.dr5hx.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BrowserSecurityController {
    private RequestCache requestCache = new HttpSessionRequestCache();

    Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SecurityProperties properties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        SavedRequest request = requestCache.getRequest(httpServletRequest, httpServletResponse);
        if (request != null) {
            String targetUrl = request.getRedirectUrl();
            logger.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, properties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("请引导用户登录");
    }
}
