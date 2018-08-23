package cn.zgys.wifi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import sun.applet.Main;

import java.nio.charset.Charset;
import java.rmi.ServerError;
import java.util.List;

//springboot拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public MyInterceptor getSecurityInterceptor() {
		return new MyInterceptor();
	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}


	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(responseBodyConverter());
		// 这里必须加上加载默认转换器，不然bug玩死人，并且该bug目前在网络上似乎没有解决方案
		// 百度，谷歌，各大论坛等。你可以试试去掉。
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}


	//Spring Boot全局支持CORS（跨源请求）
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				.allowCredentials(true).maxAge(3600);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 拦截所有路径
		//excludePathPatterns 排除的路径（静态资源，登录验证方法）
		registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/login", "/assets/**", "/employee/login", "/approveOut/**",
						"/approve1", "/approve2", "/api/**", "/bootstrap/**", "/wifi", "/mybox/**",
						"/approve/findByAccount","/fault","/success");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//页面跳转
		registry.addViewController("login").setViewName("login");//登录页面
		registry.addViewController("index").setViewName("index");//首页
		registry.addViewController("list1").setViewName("table-font-list");//访客信息
		registry.addViewController("list2").setViewName("table-font-list1");//审批列表
		registry.addViewController("approveOut").setViewName("approve-1");//互联网审批页面
		registry.addViewController("approve1").setViewName("approve-2");//内网审批第一级页面
		registry.addViewController("approve2").setViewName("approve-3");//内网审批第二级页面
		registry.addViewController("wifi").setViewName("wifi");//前台页面
		registry.addViewController("fault").setViewName("fault");
		registry.addViewController("success").setViewName("success");//登录成功
	}



}
