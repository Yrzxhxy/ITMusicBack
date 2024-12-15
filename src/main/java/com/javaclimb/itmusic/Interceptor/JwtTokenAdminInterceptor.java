package com.javaclimb.itmusic.Interceptor;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.javaclimb.itmusic.exception.CustomException;
import com.javaclimb.itmusic.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    /*
    * 校验jwt
    * */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader("token");

    try{
        //2.校验令牌
        JWTUtils.verify(token);
        return true;
    }catch (SignatureVerificationException e){
        throw new CustomException(500,"无效签名");

    }catch (TokenExpiredException e){
        throw new CustomException(-1,"token过期");
    }catch (Exception e){
        throw new CustomException(-1,"用户未登录");
    }
    }
}
