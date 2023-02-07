package cn.hyqup.validator.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class ValiIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("方法执行前执行");
//        //获取请求参数
//        String queryString = request.getQueryString();
//        log.info("请求参数:{}", queryString);
//
//        //获取请求body
//        byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
//        String body = new String(bodyBytes, request.getCharacterEncoding());
//
//        log.info("请求体：{}", body);
//        if(handler instanceof HandlerMethod) {
//            HandlerMethod handler1 = (HandlerMethod) handler;
//            MethodParameter[] methodParameters = handler1.getMethodParameters();
//            System.out.println(methodParameters);
//
//        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
