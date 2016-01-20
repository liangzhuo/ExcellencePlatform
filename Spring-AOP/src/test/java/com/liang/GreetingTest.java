package com.liang;

import com.liang.advice.GreetingAfterAdvice;
import com.liang.advice.GreetingAroundAdvice;
import com.liang.advice.GreetingBeforeAdvice;
import com.liang.advice.GreetingBeforeAndAfterAdvice;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liangz on 2016/1/17.
 */
public class GreetingTest {
    @Test
    public void testAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Peter");
    }

    @Test
    public void testAdvice1() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Peter");
    }

    @Test
    public void testAdvice2() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Peter");
    }

    @Test
    public void testAdviceXml() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        // 调用代理的方法
        greeting.sayHello("Jack");
    }

    @Test
    public void testAdviceXml1() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 注意：转型为目标类，而并非它的 Greeting 接口
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy1");
        // 调用代理的方法
        greetingImpl.sayHello("Jack");
        //将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也是“接口动态实现”功能）
        Apology apology = (Apology) greetingImpl;
        apology.saySorry("Peter");
    }

    @Test
    public void testAdvisor() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        GreetingImpl geetingImpl = (GreetingImpl)context.getBean("greetingProxy");
        geetingImpl.sayHello("Jack");
        geetingImpl.goodMorning("Peter");
        geetingImpl.goodNight("John");
    }

    @Test
    public void testAutoAdvisor() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("autoAop.xml");
        GreetingImpl geetingImpl = (GreetingImpl)context.getBean("greetingImpl");
        geetingImpl.sayHello("Jack");
        geetingImpl.goodMorning("Peter");
        geetingImpl.goodNight("John");
    }

    @Test
    public void testAutoAdvisor1() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("autoAop1.xml");
        GreetingImpl greetingImpl = (GreetingImpl)context.getBean("greetingImpl");
        greetingImpl.sayHello("Jack");
        greetingImpl.goodMorning("Peter");
        greetingImpl.goodNight("John");
    }

    @Test
    public void testAspect() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingImpl");
        greetingImpl.sayHello("jack");
        greetingImpl.goodMorning("Peter");
        greetingImpl.goodNight("John");
    }

    @Test
    public void testAnnotationAspect() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
        GreetingAnnotationImpl greetingImpl = (GreetingAnnotationImpl) context.getBean("greetingAnnotationImpl");
        greetingImpl.sayHello("jack");
        greetingImpl.goodMorning("Peter");
        greetingImpl.goodNight("John");
    }

    @Test
    public void testDeclareAspect() {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("jack");

        Apology apology = (Apology) greeting;
        apology.saySorry("peter");
    }


}
