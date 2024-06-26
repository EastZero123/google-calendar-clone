package com.larry.fc.finalproject.api.config;

import com.larry.fc.finalproject.api.dto.AuthUser;
import com.larry.fc.finalproject.api.service.LoginService;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthUserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AuthUser.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final Long userId = (Long) webRequest.getAttribute(LoginService.LOGIN_SESSION_KEY, WebRequest.SCOPE_SESSION);
        if(userId == null){
            throw new RuntimeException("bad request. no session");
        }
        return AuthUser.of(userId);
    }
}
