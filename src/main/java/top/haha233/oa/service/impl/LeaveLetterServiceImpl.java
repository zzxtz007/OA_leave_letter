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
	private final Long ROLE = 11L;
	/**
	 * 状态码设置规范
	 * 0 操作成功 + 可能需要返回相应的模型
	 * 1 未登录
	 * 2 传入值含有空值
	 * 3 类型转换错误
	 * 4 数据库操作错误
	 * 5 传出数据为空
	 * 6 权限错误
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
		letterPo.setStatus(1);
		letterPo.setCheckId(uid);
		letterPo.setUpdateUser(uid);
		System.out.println(letterPo);
		int ret = letterMapper.update(letterPo);
		System.out.println(ret);
		return new Response(0);
	}

	@Override
	public Response query(HttpSession session, String id, String status, Integer startIndex,
			Integer count) {
		//确认是否登陆
		if (!Tools.checkLogin(session)) {
			return new Response(1);
		}
		//2 判读是否为空
		if (startIndex == null || count == null||status == null) {
			return new Response(2);
		}
		//6 权限确认
		Long roleId = (Long) Tools.getRid(session);
		if (!roleId.equals(ROLE)) {
			return new Response(6);
		}
		//3 类型转换错误
		Long letterId = null;
		if (id != null) {
			try {
				letterId = Long.parseLong(id);
			} catch (Exception e) {
				return new Response(3);
			}
		}
		Integer sstatus ;
		try {
			sstatus = Integer.parseInt(status);
		} catch (Exception e) {
			return new Response(3);
		}
		LeaveLetterPo letterPo = new LeaveLetterPo();
		letterPo.setId(letterId);
		letterPo.setStatus(sstatus);
		System.out.println(letterPo);
		List<LeaveLetterBo> letterBos = letterMapper.query(letterPo, startIndex, count);
		//5 传出数据为空
		if (letterBos.size() == 0) {
			return new Response(5);
		}
		List<LeaveLetterDto> letterDto = new ArrayList<>();
		for (LeaveLetterBo letterBo : letterBos) {
			LeaveLetterDto dto = new LeaveLetterDto();
			dto.setId(letterBo.getId());
			dto.setMessage(letterBo.getMessage());
			if (letterBo.getCheckId() == null) {
				dto.setCheckId(null);
				dto.setCheckName(null);
			} else {
				dto.setCheckId(letterBo.getCheckId().getId());
				dto.setCheckName(letterBo.getCheckId().getName());
			}
			if (letterBo.getUserId() == null) {
				dto.setUserId(letterBo.getUserId().getId());
				dto.setUserName(letterBo.getUserId().getName());
			} else {
				dto.setUserId(letterBo.getUserId().getId());
				dto.setUserName(letterBo.getUserId().getName());
			}
			dto.setFeedback(letterBo.getFeedback());
			dto.setStatus(letterBo.getStatus());
			dto.setStartTime(letterBo.getStartTime());
			dto.setEndTime(letterBo.getEndTime());
			letterDto.add(dto);
		}
		System.out.println(letterBos);
		return new Response(0).add("dto", letterDto);
	}

	@Override
	public Response count(HttpSession session, String id, String status) {
		//1 确认是否登陆
		if (!Tools.checkLogin(session)) {
			return new Response(1);
		}
		//2 是否为空
		if (status == null) {
			return new Response(2);
		}
		//6 权限确认
		Long roleId = (Long) Tools.getRid(session);
		if (!roleId.equals(ROLE)) {
			return new Response(6);
		}
		//3 类型转换错误
		Long letterId = null;
		if (id != null) {
			try {
				letterId = Long.parseLong(id);
			} catch (Exception e) {
				return new Response(3);
			}
		}
		Integer sstatus ;
		try {
			sstatus = Integer.parseInt(status);
		} catch (Exception e) {
			return new Response(3);
		}

		LeaveLetterPo letterPo = new LeaveLetterPo();
		letterPo.setStatus(sstatus);
		letterPo.setId(letterId);
		System.out.println(letterPo);
		Integer ret = letterMapper.count(letterPo);
		//5 传出数据为空
		if (ret == null) {
			return new Response(5);
		}
		System.out.println(ret);
		return new Response(0).add("count", ret);
	}
}
