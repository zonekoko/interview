package com.zyp.interview.config.annotion;

import java.lang.annotation.*;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/12/3 17:19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RsaVerify {

    /**
     * 是否启用验签功能，默认验签
     * @return
     */
    boolean verifySign() default true;
}
