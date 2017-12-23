package top.haha233.oa.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class UserServiceImplTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: login(String username, String password, HttpSession session)
	 */
	@Test
	public void testLogin() throws Exception {
//TODO: Test goes here...
		System.out.println(new UserServiceImpl().login("1", "1", null));

	}


} 
