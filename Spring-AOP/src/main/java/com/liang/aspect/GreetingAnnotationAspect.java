package com.liang.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by liangz on 2016/1/18.
 */
@Aspect
@Component
public class GreetingAnnotationAspect {
    /**
     * 第一个 * 表示方法的返回值是任意的
     * 第二个 * 表示匹配该类中所有的方法
     * (..) 表示方法的参数是任意的
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.liang.annotation.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
