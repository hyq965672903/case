package cn.hyqup.validator.aop;

import cn.hutool.core.util.ArrayUtil;
import cn.hyqup.validator.annations.ValidateParam;
import cn.hyqup.validator.annations.ValidateProperty;
import cn.hyqup.validator.core.ParamValidator;
import cn.hyqup.validator.enums.CheckType;
import cn.hyqup.validator.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Slf4j
@Aspect
@Component
public class ParamCheckAop {

//    @Pointcut("@annotation(cn.hyqup.validator.annations.ValidateProperty)")
//    public void checkParam() {
//    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void checkParam() {
    }


    @Around("checkParam()")
    public Object checkSingle(ProceedingJoinPoint joinPoint) throws Throwable {
        checkAnnotationParam(joinPoint);
        return joinPoint.proceed();
    }


    private static void checkAnnotationParam(ProceedingJoinPoint pjp) throws NoSuchFieldException, IllegalAccessException {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Object[] args = pjp.getArgs();
        log.info("所有的参数：{}", args.toString());
        //获取方法上所有参数上的注解
        Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            int paramIndex = ArrayUtil.indexOf(parameterAnnotations, parameterAnnotation);
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof ValidateParam) {
                    ValidateParam validateParam = (ValidateParam) annotation;
                    Class<? extends ParamValidator> clazz = validateParam.clazz();
                    Object value = args[paramIndex];
                    CheckType checkType = validateParam.checkType();
                    Boolean res = false;
                    if (!clazz.isInterface()) {
                        res = checkType.biFun.apply(value, clazz);
                    } else {
                        res = checkType.fun.apply(value);
                    }
                    if (!res) {
                        String message = validateParam.message().equals("参数校验不合法") ? checkType.msg : validateParam.message();
                        throw new ValidateException(message);
                    }
                }
            }
        }
    }


}
