package top.haha233.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.haha233.oa.dal.UserMapper;
import top.haha233.oa.enums.StatusEnum;
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
	 * 状态码
	 * 0 操作成功
	 * 1 未登录
	 * 2 账号密码错误
	 * 3 类型转换错误
	 * 4 传入值含有空值
	 * 5 传出数据为空
	 * 6 权限错误
	 */

	@Autowired
	private UserMapper mapper;

	@Override
	public Response login(String username, String password, HttpSession session) {
		if (username == null || password == null || session == null) {
			return new Response(StatusEnum.stateOf(4));
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
			return new Response(StatusEnum.stateOf(0)).add("user",user);
		}catch (IndexOutOfBoundsException e){
			e.printStackTrace();
			return new Response(StatusEnum.stateOf(2));
		}catch (Exception e){
			e.printStackTrace();
		}
		return new Response(StatusEnum.stateOf(6));
	}
}
