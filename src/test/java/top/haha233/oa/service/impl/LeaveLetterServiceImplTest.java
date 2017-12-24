package top.haha233.oa.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.haha233.oa.model.po.LeaveLetterPo;
import top.haha233.oa.service.LeaveLetterService;

/**
 * LeaveLetterServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class LeaveLetterServiceImplTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: addLeaveLetter(HttpSession session, String message, String startTime, String endTime)
	 */
	@Test
	public void testAddLeaveLetter() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: updateLeaveLetter(HttpSession session, String feedback)
	 */
	@Test
	public void testUpdateLeaveLetter() throws Exception {
//TODO: Test goes here...
		AbstractXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/Spring-Dao.xml");
		LeaveLetterService ls = (LeaveLetterService) context.getBean("leaveLetterService");
		System.out.println(ls.updateLeaveLetter(null,"1","不行 滚！"));
	}


} 
