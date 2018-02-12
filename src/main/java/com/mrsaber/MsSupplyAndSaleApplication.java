package com.mrsaber;

import com.mrsaber.security.AuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MsSupplyAndSaleApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsSupplyAndSaleApplication.class, args);
	}
	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new AuthInterceptor());
		}
	}
}
