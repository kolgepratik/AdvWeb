package com.prk.maven.spring.hellomvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prk.maven.spring.hellomvc.repository.MetaMapRepository;

@Service
public class MetaMapService {

	@Autowired
	private MetaMapRepository metaMapRepository;

	public String parse(String text, String arguments) {
		return metaMapRepository.parse(text, arguments);
	}

}
