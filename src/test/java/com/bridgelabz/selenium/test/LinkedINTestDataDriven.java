package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedINTestDataDriven extends Base {

    @Test
    public void linkedinlogin() throws InterruptedException {
        Login login = new Login(driver);
        login.login();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.linkedin.com/login";
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
