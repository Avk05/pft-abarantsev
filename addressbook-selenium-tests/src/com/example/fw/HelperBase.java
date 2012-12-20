package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperBase {
  
  protected ApplicationManager manager;
  protected WebDriver driver;
  public boolean acceptNextAlert = true;
  private WebDriverWait wait;

  public HelperBase(ApplicationManager manager) {
    this.manager = manager;
    this.driver = manager.driver;
    wait = new WebDriverWait(driver, 10);
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }

  protected void type(By locator, String text) {
    WebElement element = wait.until(visibilityOfElementLocated(locator));
    if (text != null) {
      element.clear();
      element.sendKeys(text);
    }
  }

  protected void click(By locator) {
    wait.until(visibilityOfElementLocated(locator)).click();
  }

  protected void selectByText(By locator, String text) {
    WebElement element = wait.until(visibilityOfElementLocated(locator));
    new Select(element).selectByVisibleText(text);
  }

}
