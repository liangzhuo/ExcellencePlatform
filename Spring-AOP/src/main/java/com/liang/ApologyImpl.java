package com.liang;

/**
 * Created by liangz on 2016/1/20.
 */
public class ApologyImpl implements Apology{
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry," + name);
    }
}
