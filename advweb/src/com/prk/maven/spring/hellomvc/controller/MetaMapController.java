/**
 * 
 */
package com.prk.maven.spring.hellomvc.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prk.maven.spring.hellomvc.service.MetaMapService;
import com.prk.maven.spring.hellomvc.util.AppWrappers;

/**
 * @author kolge
 *
 */
@Controller
public class MetaMapController {

	static final Logger LOG = LoggerFactory.getLogger(MetaMapController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AppWrappers appWrappers;

	@Autowired
	private MetaMapService metaMapService;

	@GetMapping("/metamap/addNote")
	public String addNote(Model model) {
		LOG.debug("Adding note");

		return "views/addNote";
	}

	@PostMapping("/metamap/parseNote")
	public ModelAndView parseNote(@RequestParam("noteText") String noteText, ModelAndView mv) {
		LOG.debug("NoteText: " + noteText);

		mv.addObject("currentDate", new Date());
		mv.addObject("results", metaMapService.parse(noteText, null));
		mv.setViewName("views/parseNote");

		return mv;
	}
}
