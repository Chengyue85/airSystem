package com.plus.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 普通用户登陆拦截器
 */
@Configuration
public class UserSecurityConfig implements WebMvcConfigurer {

	@Override
	// 进行拦截器的注册
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		InterceptorRegistration addInterceptor = registry.addInterceptor(new HandlerInterceptor() { // 此处，我才用内部类的形式，来定义一个登陆拦截器

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {

				HttpSession session = request.getSession();

				// 判断是否已有该用户登录的session
				if (session.getAttribute("userid") != null) {
					return true;
				}
				// 跳转到登录页
				response.sendRedirect(request.getContextPath() + "login.html");
				return false;
			}

		}).excludePathPatterns("/login").excludePathPatterns("/register").excludePathPatterns("/login.html")
				.excludePathPatterns("/register.html").excludePathPatterns("/error").excludePathPatterns("/logout")
				.addPathPatterns("/order/**").addPathPatterns("/plane/**");

	}

}
