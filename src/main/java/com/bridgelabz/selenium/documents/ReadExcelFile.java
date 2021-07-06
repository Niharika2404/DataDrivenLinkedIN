package com.bridgelabz.selenium.documents;

import com.bridgelabz.selenium.pages.Login;

public class ReadExcelFile extends Login {
    public ReadExcelFile(String s) {

        super(driver);
        ReadExcelFile configuration = new ReadExcelFile("https://onedrive.live.com/edit.aspx?resid=F7838235F9AF7C5B!116&ithint=file%2cxlsx&wdOrigin=OFFICECOM-WEB.START.MRU");
    }
}
