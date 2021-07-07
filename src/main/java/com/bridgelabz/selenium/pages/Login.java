package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.w3c.dom.css.CSSFontFaceRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Login extends Base {

    public Login(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void login () throws FileNotFoundException {
        File file = new File("https://onedrive.live.com/edit.aspx?resid=F7838235F9AF7C5B!116&ithint=file%2cxlsx&wdOrigin=OFFICECOM-WEB.START.MRU");
        FileInputStream files = new FileInputStream(file);
        workbook = new XSSFWorkbook(files);
        workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNumber(); i++) {

            cell =  sheet.getRow(i);
            DataFormatter formatter = new DataFormatter();
            String username = formatter.formatCellValue((Cell) cell);
            cell = sheet.getRow(i);
            String password = formatter.formatCellValue((Cell) cell);

            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.name("submit")).click();

            var timeouts = driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(driver.findElement(By.linkText("signin")).isDisplayed());
            driver.findElement(By.linkText("signin")).click();

        }




    }


}
