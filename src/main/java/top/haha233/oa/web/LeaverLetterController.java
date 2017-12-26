package top.haha233.oa.web;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.haha233.oa.enums.StatusEnum;
import top.haha233.oa.service.LeaveLetterService;
import top.haha233.oa.util.Response;

import javax.servlet.http.HttpSession;

/**
 * @author Ice_Dog
 */
@RequestMapping("/leaveLetter")
@Controller
public class LeaverLetterController {

	@Autowired
	private LeaveLetterService letterService;

	@RequestMapping(value = "/count", method = {RequestMethod.GET}, produces = "json/application;charset=utf-8")
	@ResponseBody
	public String count(HttpSession session, @RequestParam String status) {
		return new Gson().toJson(letterService.count(session, null, status));
	}

	@RequestMapping(value = "/query", method = {RequestMethod.GET}, produces = "json/application;charset=utf-8")
	@ResponseBody
	public String query(HttpSession session, @RequestParam String pageNum,
			@RequestParam String pageSize, @RequestParam String status) {
		Response response;
		try {
			Integer startIndex = Integer.parseInt(pageNum) * Integer.parseInt(pageSize);
			Integer count = Integer.parseInt(pageSize);
			response = letterService.query(session, null, status, startIndex, count);
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response(StatusEnum.stateOf(2));
		}
		return new Gson().toJson(response);
	}

}
