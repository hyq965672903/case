package cn.hyqup.generate.common.core.domain.model;

import lombok.Data;


/**
 * 短信登录对象
 *
 * @author Lion Li
 */

@Data
public class SmsLoginBody {

    /**
     * 用户名
     */
    private String phonenumber;

    /**
     * 用户密码
     */
    private String smsCode;

}
