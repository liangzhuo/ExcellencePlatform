package com.liang;

import com.liang.annotation.Tag;
import org.springframework.stereotype.Component;

/**
 * Created by liangz on 2016/1/17.
 */
@Component
public class GreetingAnnotationImpl implements Greeting {
    @Tag
    @Override
    public void sayHello(String name) {
        System.out.println("Hello," + name);
        //throw new RuntimeException("error");
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning!" + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night!" + name);
    }
}
