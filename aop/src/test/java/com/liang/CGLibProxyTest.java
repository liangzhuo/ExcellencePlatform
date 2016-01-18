package com.liang;

import com.liang.proxy.cglib.CGLibProxy;
import org.junit.Test;

/**
 * Created by liangz on 2016/1/17.
 */
public class CGLibProxyTest {
    @Test
    public void testCGLibProxy() {
        /*
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("Peter!");
        */
    }

    @Test
    public void testCGLibProxy1() {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Jack!");
    }

}
