package com.why.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2");
    }
}
