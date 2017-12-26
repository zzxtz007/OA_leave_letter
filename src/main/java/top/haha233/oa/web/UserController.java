package top.haha233.oa.web;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.haha233.oa.service.UserService;
import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ICE_DOG
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
	private static final Long ROLE=11L;
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/login", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestParam String userName, @RequestParam String password,
			HttpSession session) throws IOException {
		Response response = userService.login(userName, password, session);
		Gson g = new Gson();
		return g.toJson(response);
	}

	@RequestMapping(value = "/{roleId}", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
	public String gotoPage(@PathVariable("roleId") Long roleId) throws IOException {
		if (!ROLE.equals(roleId)){
			return "main11";
		}
		return "main"+roleId;
	}

}
