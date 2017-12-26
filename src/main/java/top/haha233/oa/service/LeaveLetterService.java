package top.haha233.oa.service;

import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;

/**
 * @author ICE_DOG
 */
public interface LeaveLetterService {
	/**
	 * 用户申请请假
	 *
	 * @param session   用于验证登陆
	 * @param message   用户输入的 信息
	 * @param startTime 请假的开始时间
	 * @param endTime   请假的结束时间
	 * @return 状态码
	 */
	Response addLeaveLetter(HttpSession session, String message, String startTime, String endTime);

	/**
	 * hr确认请假条 并返回
	 *
	 * @param session  用于验证登陆
	 * @param id       请假条的id
	 * @param feedback hr返回的信息
	 * @return 状态码
	 */
	Response updateLeaveLetter(HttpSession session, String id, String feedback);

	/**
	 * 查询请假条
	 *
	 * @param session    用于验证登陆
	 * @param id         请假条的id 可选
	 * @param status     请假条状态 必选
	 * @param startIndex 请假条的id 必选
	 * @param count      请假条的id 必选
	 * @return 状态码+dto 请假条模型结果集
	 */
	Response query(HttpSession session, String id, String status, Integer startIndex,
			Integer count);

	/**
	 * 查询请假条数量
	 *
	 * @param session 用于验证登陆
	 * @param id      请假条的id 可选
	 * @param status  请假条状态 必选
	 * @return 状态码+count 请假条的数量
	 */
	Response count(HttpSession session, String id, String status);
}
