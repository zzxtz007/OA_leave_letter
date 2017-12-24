package top.haha233.oa.util;

import javax.servlet.http.HttpSession;

/**
 * @author ICE_DOG
 */
public class Tools {
	public static boolean checkLogin(HttpSession session) {
		return session.getAttribute("uid") != null;
	}

	public static void initLogin(HttpSession session, Long uid, Long rid, Long did) {
		session.setAttribute("uid", uid);
		session.setAttribute("rid", rid);
		session.setAttribute("did", did);
	}

	public static Object getUid(HttpSession session) {
		return session.getAttribute("uid");
	}

	public static Object getRid(HttpSession session) {
		return session.getAttribute("rid");
	}

	public static Object getDid(HttpSession session) {
		return session.getAttribute("did");
	}
}
