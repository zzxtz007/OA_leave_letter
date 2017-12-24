package top.haha233.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.haha233.oa.dal.UserMapper;
import top.haha233.oa.model.bo.UserBo;
import top.haha233.oa.model.dto.LoginDto;
import top.haha233.oa.model.po.UserPo;
import top.haha233.oa.service.UserService;
import top.haha233.oa.util.Tools;
import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Ice_Dog
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * 状态码设置规范
	 * 0 操作成功 + 可能需要返回相应的模型
	 * 1 未登录
	 * 2 传入值含有空值
	 * 3 类型转换错误
	 * 4 数据库操作错误
	 * 5 传出数据为空
	 * 6 其他异常
	 */

	@Autowired
	private UserMapper mapper;

	@Override
	public Response login(String username, String password, HttpSession session) {
		if (username == null || password == null || session == null) {
			return new Response(2);
		}
		UserPo userPo = new UserPo();
		userPo.setUsername(username);
		userPo.setPassword(password);
		List<UserBo> userBos = mapper.query(userPo);

		try {
			//验证登陆是否成功
			UserBo loginedUser = userBos.get(0);
			LoginDto user = new LoginDto();
			Long uid = loginedUser.getId();
			Long rid = loginedUser.getDepartmentId().getId();
			Long did = loginedUser.getRoleId().getId();
			Tools.initLogin(session,uid,rid,did);
			user.setId(uid);
			user.setName(loginedUser.getName());
			user.setDepartmentId(did);
			user.setRoleId(rid);
			return new Response(0);
		}catch (IndexOutOfBoundsException e){
			e.printStackTrace();
			return new Response(5);
		}catch (Exception e){
			e.printStackTrace();
		}
		return new Response(6);
	}
}
