/**
 * 
 */
package com.prk.maven.spring.hellomvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.prk.maven.spring.hellomvc.util.AppWrappers;

/**
 * @author kolge
 *
 */
@Controller
public class HelloController {

	static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AppWrappers appWrappers;

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "John Doe");

		return "welcome";
	}

	@GetMapping("/data")
	public ModelAndView getData(ModelAndView mv) {
		mv.addObject("currentDate", new Date());
		mv.setViewName("views/data");

		return mv;
	}

	@GetMapping("/themes")
	public String themes(Model model) {
		return "views/themes";
	}

	@GetMapping("/fileupload")
	public ModelAndView getFile(ModelAndView mv) {
		mv.setViewName("views/fileupload");

		return mv;
	}

	@PostMapping("/handleFormUpload")
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		LOG.trace("handleFormUpload: " + messageSource.getMessage("app.title", null, Locale.US));
		LOG.trace(appWrappers.getThymeleafViewPath("views"));
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "redirect:fileupload";
		}

		return "redirect:fileupload";
	}

	@PostMapping(value = "/handleMultipleFormUpload")
	public String handleMultipleFormUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile[] files) {
		String fileName = null;
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				try {
					fileName = files[i].getOriginalFilename();
					byte[] bytes = files[i].getBytes();
					LOG.debug("You have successfully uploaded: " + fileName);
				} catch (Exception e) {
					return "views/fileupload";
				}
			}
			return "views/fileupload";
		} else {
			return "views/fileupload";
		}
	}
}
