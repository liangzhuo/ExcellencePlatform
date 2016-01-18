package com.liang;

import com.liang.proxy.jdk.DynamicProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by liangz on 2016/1/17.
 */
public class DynamicProxyTest {
    @Test
    public void testDynamicProxy() {
        /*
        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),// ClassLoader
                hello.getClass().getInterfaces(),// Hello 接口的所有接口
                dynamicProxy// 动态代理对象
        );
        */
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello helloProxy = dynamicProxy.getProxy();

        helloProxy.say("Peter");
    }
}
