package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
  
  public static boolean CREATION = true;
  public static boolean MODIFICATION = false;

  public ContactHelper(ApplicationManager manager) {
    super(manager);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contact, boolean formType) {
    type(By.name("firstname"), contact.firstName);
    type(By.name("lastname"), contact.lastName);
    type(By.name("address"), contact.address);
    type(By.name("home"), contact.homePhone);
    type(By.name("mobile"), contact.mobilePhone);
    type(By.name("work"), contact.workPhone);
    type(By.name("email"), contact.email);
    type(By.name("email2"), contact.email2);
    selectByText(By.name("bday"), contact.birthDay);
    selectByText(By.name("bmonth"), contact.birthMonth);
    type(By.name("byear"), contact.birthYear);
    if (formType == CREATION) {
      // selectByText(By.name("new_group"), "group 1");
    } else {
      if (driver.findElements(By.name("new_group")).size() != 0) {
        throw new Error("Group selector exists in contact modification form");
      }
    }
    type(By.name("address2"), contact.address2);
    type(By.name("phone2"), contact.phone2);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

}
