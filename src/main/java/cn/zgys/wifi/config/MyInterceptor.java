package cn.zgys.wifi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.zgys.wifi.entity.UserBean;


//自定义拦截器
public class MyInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,Object handler) throws Exception {
		boolean flag = true;
		/**
		 * 防止用户绕过登录页面直接访问后台
		 * 登录验证成功后会把用户信息存入session
		 * 拦截所有请求，从session取用户信息，如果为空则重定向到登录页面
		 */
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		if(null==user) {
			response.sendRedirect("login");
			flag = false;
		}else {
			flag = true;
		}		
		return flag;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler,ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
			Object handler,Exception ex) throws Exception {
		
	}
		
}
