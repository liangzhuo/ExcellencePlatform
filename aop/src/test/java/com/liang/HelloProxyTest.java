package com.liang;

import org.junit.Test;

/**
 * Created by liangz on 2016/1/17.
 */
public class HelloProxyTest {
    @Test
    public void testHelloProxy() {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("aop");
    }
}
