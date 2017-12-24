package top.haha233.oa.service;

import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @author ICE_DOG
 */
public interface LeaveLetterService {
	/** 用户申请请假
	 * @param session 用于验证登陆
	 * @param message 用户输入的 信息
	 * @param startTime 请假的开始时间
	 * @param endTime 请假的结束时间
	 * @return 状态码
	 */
	Response addLeaveLetter(HttpSession session,String message,String startTime,String endTime);
	Response updateLeaveLetter(HttpSession session,String id,String feedback);
}
