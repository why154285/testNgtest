package com.orientsec.test.suite;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginSogouMall(){
        Reporter.log("搜狗商场登录成功");
        System.out.println("login success--");
    }
}
