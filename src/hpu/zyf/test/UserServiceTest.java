package hpu.zyf.test;

import static org.junit.Assert.*;
import hpu.zyf.service.UserService;
import hpu.zyf.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
	private UserService us;
	@Before
	public void setUp() throws Exception {
		us = new UserServiceImpl();
	}

	@Test
	public void testLogin() throws Exception {
		System.out.println(us.userLogin("18939171376", "123456"));
	}

}
