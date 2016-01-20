package com.liang.aspect;

import com.liang.Apology;
import com.liang.ApologyImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by liangz on 2016/1/18.
 */
@Aspect
@Component
public class GreetingDeclareAspect {

    @DeclareParents(value = "com.liang.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;
}
