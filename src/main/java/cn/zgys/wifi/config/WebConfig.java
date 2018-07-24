package cn.zgys.wifi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//springboot拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
    public MyInterceptor getSecurityInterceptor() {
        return new MyInterceptor();
    }
	
	//Spring Boot全局支持CORS（跨源请求）
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("*")
	                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
	                .allowCredentials(true).maxAge(3600);
	  }
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 拦截所有路径
		//excludePathPatterns 排除的路径（静态资源，登录验证方法）
    	registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**")
    	.excludePathPatterns("/login","/assets/**","/employee/login","/approveOut/**",
    	"/approve1","/approve2","/approve3","/api/**","/bootstrap/**","/wifi","/approve/findByAccount","/mybox/**");
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
    	registry.addViewController("approve3").setViewName("approve-4");//内网审批第三级页面
    	registry.addViewController("wifi").setViewName("wifi");//前台页面
    }
    
}
