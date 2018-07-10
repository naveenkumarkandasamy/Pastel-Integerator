package com.prud.pastel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.prud.pastel.services.PastelConverterService;

@Controller
@RequestMapping("/api/convertor")
public class PastelRestContoller {

	@Autowired
	PastelConverterService pastelConverterService;
	static final Logger logger = Logger.getLogger(PastelRestContoller.class);

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.GET)
	@ResponseBody
	public void convertToPastel(HttpServletRequest request, HttpServletResponse response) {
		try {
			pastelConverterService.convertToPastel(response);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.POST)
	@ResponseBody
	public void convertPASToPastel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			pastelConverterService.convertToPastel(response, pasFile);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while converting file from PAS to Pastel  " + e);
		}
	}


}
