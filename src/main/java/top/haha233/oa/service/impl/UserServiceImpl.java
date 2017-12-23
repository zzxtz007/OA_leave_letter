package top.haha233.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.haha233.oa.dal.RoleMapper;
import top.haha233.oa.dal.UserMapper;
import top.haha233.oa.model.po.UserPo;
import top.haha233.oa.service.UserService;
import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;

/**
 * @author Ice_Dog
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public Response login(String username, String password, HttpSession session) {
		UserPo user = new UserPo();
		user.setUsername("admin");
		user.setPassword("admin");
		return new Response(2).add("lists",mapper.query(user));
	}
}
