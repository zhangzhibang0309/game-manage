package com.teammanage.teams.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Sept Zhang
 * @create 2021-04-09 21:20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
//		registry.addMapping("/**").allowedOrigins("http://localhost:808")
				.allowedHeaders("*")
				.allowedMethods("*")
				.maxAge(30*1000);
	}
}
