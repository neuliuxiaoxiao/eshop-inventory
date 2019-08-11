package com.roncoo.eshop.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.roncoo.eshop.inventory.listener.InitListener;

@SpringBootApplication
public class Application {

	/**
	 * 注册监听器
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean<InitListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<InitListener>();
		servletListenerRegistrationBean.setListener(new InitListener());
		return servletListenerRegistrationBean;
		
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
