package com.prk.maven.spring.hellomvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppWrappers {

	@Autowired
	private Environment env;

	public String getThymeleafViewPath(String path) {
		return env.getProperty("thymeleaf.basefolder") + path;
	}
}
