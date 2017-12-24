package top.haha233.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.haha233.oa.dal.LeaveLetterMapper;
import top.haha233.oa.model.bo.LeaveLetterBo;
import top.haha233.oa.model.dto.LeaveLetterDto;
import top.haha233.oa.model.po.LeaveLetterPo;
import top.haha233.oa.service.LeaveLetterService;
import top.haha233.oa.util.Response;
import top.haha233.oa.util.Tools;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ICE_DOG
 */
@Service("leaveLetterService")
public class LeaveLetterServiceImpl implements LeaveLetterService {

	/**
	 * 状态码设置规范
	 * 0 操作成功 + 可能需要返回相应的模型
	 * 1 未登录
	 * 2 传入值含有空值
	 * 3 类型转换错误
	 * 4 数据库操作错误
	 * 5 传出数据为空
	 */
	@Autowired
	private LeaveLetterMapper letterMapper;

	@Override
	public Response addLeaveLetter(HttpSession session, String message, String startTime,
			String endTime) {
		//确认是否登陆
		if (!Tools.checkLogin(session)) {
			return new Response(1);
		}
		Long uid = (Long) Tools.getUid(session);
		//2 传入值含有空值
		if (uid == null || message == null || startTime == null || endTime == null) {
			return new Response(2);
		}
		//3 类型转换错误
		Long start;
		Long end;
		try {
			start = Long.parseLong(startTime);
			end = Long.parseLong(endTime);
		} catch (Exception e) {
			return new Response(3);
		}
		LeaveLetterPo letterPo = new LeaveLetterPo();
		letterPo.setUserId(uid);
		letterPo.setMessage(message);
		letterPo.setStartTime(new Date(start));
		letterPo.setEndTime(new Date(end));
		letterPo.setUpdateUser(uid);
		letterPo.setInsertUser(uid);
		int ret = letterMapper.insert(letterPo);
		System.out.println(ret);
		return new Response(0);
	}

	@Override
	public Response updateLeaveLetter(HttpSession session, String id, String feedback) {
		//确认是否登陆
		if (!Tools.checkLogin(session)) {
			return new Response(1);
		}
		Long uid = (Long) Tools.getUid(session);
		//2 传入值含有空值
		if (uid == null || feedback == null) {
			return new Response(2);
		}
		//3 类型转换错误
		Long letterId;
		try {
			letterId = Long.parseLong(id);
		} catch (Exception e) {
			return new Response(3);
		}
		LeaveLetterPo letterPo = new LeaveLetterPo();
		letterPo.setId(letterId);
		letterPo.setFeedback(feedback);
		letterPo.setCheckId(uid);
		letterPo.setUpdateUser(uid);
		System.out.println(letterPo);
		int ret = letterMapper.update(letterPo);
		System.out.println(ret);
		return new Response(0);
	}

	public Response query(HttpSession session, String id, String uid) {
		//确认是否登陆
		if (!Tools.checkLogin(session)) {
			return new Response(1);
		}
		//权限确认
		Long updateId = (Long) Tools.getUid(session);
		//2 传入值含有空值
		if (id == null || updateId == null || uid == null) {
			return new Response(2);
		}
		//3 类型转换错误
		Long letterId;
		try {
			letterId = Long.parseLong(id);
		} catch (Exception e) {
			return new Response(3);
		}
		LeaveLetterPo letterPo = new LeaveLetterPo();
		letterPo.setId(letterId);
		System.out.println(letterPo);
		List<LeaveLetterBo> letterBos = letterMapper.query(letterPo);
		//5 传出数据为空
		if (letterBos.size() == 0) {
			return new Response(5);
		}
		List<LeaveLetterDto> letterDto = new ArrayList<>();
		for (LeaveLetterBo letterBo : letterBos){
			LeaveLetterDto dto = new LeaveLetterDto();
			dto.setId(letterBo.getId());
//			dto.set
//			letterDto.add();
		}
		System.out.println(letterBos);
		return new Response(0).add("dto", letterBos);
	}
}
