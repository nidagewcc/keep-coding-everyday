package com.gkd.gkduttestng;

import com.gkd.gkduttestng.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@SpringBootTest
@Listeners(ExtentTestNGIReporterListener.class)
public class HelloServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private HelloService helloService;

    @Test
    public void sayHelloTest() {
        String s = helloService.sayHello();
        Assert.assertEquals(s, "Hello World");
    }
}
