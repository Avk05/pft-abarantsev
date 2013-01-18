package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {

  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.get("www.google.com");
    driver.navigate().to("http://seleniumhq.org/");
    driver.quit();
  }

}
