package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
  
  @DataProvider
  public Iterator<Object[]> groupFromFile() throws IOException {
    List<GroupData> groups = GroupDataGenerator.loadGroupsFromXmlFile(new File("groups.xml"));
    List<Object[]> list = wrapGroupsForDataProvider(groups);
    return list.iterator();
  }

  @Test(dataProvider = "groupFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    // save old state
    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(group);
    
    // save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }

}
