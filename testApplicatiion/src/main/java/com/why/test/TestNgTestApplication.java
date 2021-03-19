package com.why.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class TestNgTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestNgTestApplication.class, args);
    }


//    @Bean
    public void testXml(){
        TestNG testng = new TestNG();

        List suites = Lists.newArrayList();

        suites.add("testApplicatiion/src/main/resources/testng.xml");//path to xml..

        testng.setTestSuites(suites);

        testng.run();
    }

}
