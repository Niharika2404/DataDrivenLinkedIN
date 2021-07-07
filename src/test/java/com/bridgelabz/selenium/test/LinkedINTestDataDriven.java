package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LinkedINTestDataDriven extends Base {


    @Test(priority = 0)
    public void sign_Application() throws FileNotFoundException {

        Login login = new Login(driver);
        login.login();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.linkedin.com/login";
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
