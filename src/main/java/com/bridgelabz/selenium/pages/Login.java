package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.documents.ReadExcelFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.datatransfer.Clipboard;

public class Login extends Base {

    @FindBy(xpath = "//input[@id='username']")
    WebElement UserName;

    @FindBy (xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"organic-div\"]/form/div[3]/button")
    WebElement Signin;

    public Login(WebDriver driver) {
        PageFactory.initElements(Base.driver,this);
    }

    @Test(dataProvider="testdata")
    public void login() throws InterruptedException {

        UserName.sendKeys("niharikang24@gmail.com");
        password.sendKeys("niharikang24");
        Signin.click();

        Thread.sleep(300);
    }

    @DataProvider(name="testdata")
    public Object[][] testData(){
        ReadExcelFile configuration = new ReadExcelFile("https://onedrive.live.com/edit.aspx?resid=F7838235F9AF7C5B!116&ithint=file%2cxlsx&wdOrigin=OFFICECOM-WEB.START.MRU");
        int rows = configuration.getRowCount(0);
        Object[][]signin_credentials = new Object[rows][2];

        for(int i=0;i<rows;i++)
        {
            Clipboard config = null;
            signin_credentials[i][0] = config.getData(0, i, 0);
            signin_credentials[i][1] = config.getData(i, 0, 1);
        }
        return signin_credentials;
    }

    public int getRowCount(int i) {

        return i;
    }

}
