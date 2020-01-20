package com.orientsec.test.suite;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PayTest {

    @Test
    public void paySuccess(){
        System.out.println("微信支付成功");
        Reporter.log("pay success--");
    }
}
