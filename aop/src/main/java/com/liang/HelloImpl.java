package com.liang;

/**
 * Created by liangz on 2016/1/17.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}
