//package cn.hyqup.lab04validation.base.validator.aop;
//
//import cn.hyqup.lab04validation.base.validator.utils.ValidateUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class ParamCheckAop {
//
//    @Pointcut("execution(public * cn.hyqup.lab04validation.controller.*.*(..))")
////    @Pointcut("@annotation(cn.hyqup.lab04validation.base.validator.annations.ParamCheck)")
//    public void checkParam() {
//    }
//
//
//    @Around("checkParam()")
//    public Object checkSingle(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("进入拦截");
//        Object[] args = joinPoint.getArgs();
//        if (args == null) {
//            return joinPoint.proceed();
//        }
//        for (Object o : args) {
//            if (o == null) {
//                continue;
//            }
//            ValidateUtil.validate(o);
//        }
//        return joinPoint.proceed();
//    }
//
//
//}
