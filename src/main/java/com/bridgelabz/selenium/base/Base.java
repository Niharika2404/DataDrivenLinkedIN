package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.pages.XSSFSheet;
import com.bridgelabz.selenium.pages.XSSFWorkbook;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    public static WebDriver driver;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static BSPTree<Space> cell;




    @BeforeTest
    public void serUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/login");
        driver.manage().window().maximize();

        Thread.sleep(300);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
