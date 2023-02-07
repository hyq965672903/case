package cn.hyqup.validator.aop;

import cn.hyqup.validator.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ParamCheckAop {

    @Pointcut("@annotation(cn.hyqup.validator.annations.ValidateProperty)")
    public void checkParam() {
    }


    @Around("checkParam()")
    public Object checkSingle(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args == null) {
            return joinPoint.proceed();
        }
        for (Object o : args) {
            if (o == null) {
                continue;
            }
            ValidateUtil.validate(o);
        }
        return joinPoint.proceed();
    }


}
