package top.haha233.oa.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.haha233.oa.service.UserService;

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
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/spring/Spring-Dao.xml");
        UserService us = (UserService) context.getBean("userService");
		System.out.println(us.login("1", "1", null));

	}


} 
