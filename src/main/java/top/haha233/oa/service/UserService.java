package top.haha233.oa.service;

import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;

/**
 * @author Ice_Dog
 */
public interface UserService {
	/**
	 * 用户登录service
	 * @param username 用户名
	 * @param password 密码
	 * @param session 服务器session
	 * @return 状态码内含有LoginDto
	 */
	Response login(String username,String password,HttpSession session);
}
