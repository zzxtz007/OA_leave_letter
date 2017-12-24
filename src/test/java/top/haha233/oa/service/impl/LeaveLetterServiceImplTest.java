package top.haha233.oa.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.haha233.oa.service.LeaveLetterService;

import java.util.Date;

/**
 * LeaveLetterServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class LeaveLetterServiceImplTest {
	private AbstractXmlApplicationContext context;
	private LeaveLetterService ls;

	@Before
	public void before() throws Exception {
		context = new ClassPathXmlApplicationContext("/spring/Spring-Dao.xml");
		ls = (LeaveLetterService) context.getBean("leaveLetterService");
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: addLeaveLetter(HttpSession session, String message, String startTime, String endTime)
	 */
	@Test
	public void testAddLeaveLetter() throws Exception {
//		System.out.println(ls.addLeaveLetter(null, "我要请假", String.valueOf(new Date().getTime()),
//				String.valueOf(new Date().getTime())));
//TODO: Test goes here... 
	}

	/**
	 * Method: updateLeaveLetter(HttpSession session, String feedback)
	 */
	@Test
	public void testUpdateLeaveLetter() throws Exception {
//TODO: Test goes here...

//		System.out.println(ls.query(null, "1", null));
	}


} 
