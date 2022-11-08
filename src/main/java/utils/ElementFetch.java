package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifiertype, String value){
        switch (identifiertype){
            case "ID":
                return BaseTest.driver.findElement(By.id(value));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(value));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifiertype, String value){
        switch (identifiertype){
            case "ID":
                return BaseTest.driver.findElements(By.id(value));
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(value));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(value));
            default:
                return null;
        }
    }
}
