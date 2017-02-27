package com.prk.maven.spring.hellomvc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import gov.nih.nlm.nls.skr.GenericObject;

@Component
public class MetaMapRepository {

	static final Logger LOG = LoggerFactory.getLogger(MetaMapRepository.class);

	public final String EMAIL = "kolge.pratik@gmail.com";
	public final String USERNAME = "kolgepratik";
	public final String PASSWORD = "May@2015";

	public final String ARGS_DEFAULT = "-iD --JSONf 2 -R MTH";

	public String parse(String text, String arguments) {
		String results = null;

		GenericObject myIntMMObj = new GenericObject(100, USERNAME, PASSWORD);

		myIntMMObj.setField("Email_Address", EMAIL);
		myIntMMObj.setField("APIText", text);
		myIntMMObj.setField("KSOURCE", "1516");
		myIntMMObj.setField("COMMAND_ARGS", (arguments == null ? ARGS_DEFAULT : arguments));

		try {
			results = myIntMMObj.handleSubmission();
			LOG.debug("Results: " + results);
		} catch (RuntimeException e) {
			LOG.error("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return results;
	}
}
