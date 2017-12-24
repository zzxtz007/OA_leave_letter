package top.haha233.oa.web;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.haha233.oa.service.UserService;
import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ICE_DOG
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@RequestMapping(value = "user/login", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestParam String userName, @RequestParam String password,
			HttpSession session) throws IOException {
		Response response = userService.login(userName, password, session);
		System.out.println(response);
		Gson g = new Gson();
		System.out.println(session);
		return g.toJson(response);
	}
}
