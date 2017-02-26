/**
 * 
 */
package com.prk.maven.spring.hellomvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author kolge
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prk.maven.spring.hellomvc")
@PropertySource("/WEB-INF/properties/appconfig.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
	/**
	 * This is the default view resolver for Spring. Reference:
	 * http://viralpatel.net/blogs/spring-4-mvc-tutorial-maven-example/
	 */
	/*
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
	
		return viewResolver;
	}
	*/

	/**
	 * This configuration is required for accessing properties files.
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * This configuration is required for accessing static resources.
	 */
	/*
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	*/

	/**
	 * This configuration is required for accessing static resources. Either of
	 * the above can be used.
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}