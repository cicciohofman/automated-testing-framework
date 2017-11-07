package com.chofman.helloselenium.tests.persistence;

import org.testng.annotations.Test;

import com.chofman.helloselenium.persistence.entities.User;
import com.chofman.helloselenium.persistence.helpers.UserHelper;

public class UsersTest {
	
	@Test
	public void testGetRandomUser() throws Exception {
		User myUser = UserHelper.getRandomUser();
		System.out.println(myUser.getFirstName());
	}
	
	
}