package cn.hyqup.lab04validation.validate.annations;

import java.lang.annotation.*;

/**
 * 验证注解 一般放在 Controoler里的路由方法上使用
 *
 * @author liangbaikai
 * @version 0.1.0
 * @date 2020/5/15 18:16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateParams {

    /**
     * 多个CheckParam，由上往下判断
     *
     * @return
     */
    ValidateParam[] value();

    /**
     * true  多个验证时 只要有一个不通过就立即返回错误 并停止验证，效率稍微高点，尤其某些验证比较耗时，比如需要查库的
     * false 一次验证所有的，返回完整的错误信息，可更快看到完整错误信息
     * 何时使用 取决于你
     *
     * @return
     */
    boolean shortPath() default false;

    /**
     * true 多个条件    与（and）;
     * false 多个条件   或(or);
     * value.length<=1 时 无效；
     *
     * @return
     */
    boolean anded() default true;


}
