package com.liang.advice;

import com.liang.Apology;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * 引入增强（对类的增强）
 * Created by liangz on 2016/1/18.
 */
@Component
public class GreetingInroAdvice extends DelegatingIntroductionInterceptor implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }
}
