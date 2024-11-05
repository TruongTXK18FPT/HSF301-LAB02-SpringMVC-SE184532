package fall24.hsf301.edu.vn.FALL24_HSF301_Slot_01.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fall24.hsf301.slot1.pojo.Account;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getRequestURI();
		String contextPath = request.getContextPath();

		if (path.startsWith(contextPath + "/login")) {
			return true;
		}

		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("user");

		if (user == null) {
			response.sendRedirect(contextPath + "/login");
			return false;
		}

		if (!"admin".equals(user.getRole())) {
			response.sendRedirect(contextPath + "/login?error=nopermission");
			return false;
		}

		return true;
	}
}