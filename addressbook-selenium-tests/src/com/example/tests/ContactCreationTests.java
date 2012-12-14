package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContact() throws Exception {
    ContactData contact = new ContactData();
    contact.firstName = "Ivan";
    contact.lastName = "Ivanoff";
    contact.address = "Moscow";
    contact.address2 = "Saint-Petersburg";
    contact.homePhone = "01";
    contact.mobilePhone = "02";
    contact.workPhone = "03";
    contact.phone2 = "1234567890";
    contact.email = "ivanoff@test.com";
    contact.email2 = "ivanf@test.com";
    contact.birthDay = "1";
    contact.birthMonth = "January";
    contact.birthYear = "1970";
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
