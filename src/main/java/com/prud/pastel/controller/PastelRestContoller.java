package com.prud.pastel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.BeanMapper;
import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

@Controller
@RequestMapping("/api/convertor")
public class PastelRestContoller {
	@Autowired
	XLSXtoObjectConvertor xLSXtoObjectConvertor;
	@Autowired
	ObjectToCSVConvertor objectCsv;
	static final Logger logger = Logger.getLogger(PastelRestContoller.class);

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.GET)
	@ResponseBody
	public void convertToPastel(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<UserTransactionInfo> userTransactionInfo = xLSXtoObjectConvertor.xlsxToJavaObject();

			BeanMapper mapper = BeanMapper.getInstance();
			List<UserConversionInfo> userList = mapper.userInfoMapper(userTransactionInfo);

			File file;
			file = objectCsv.objectToCSV(userList);
			doCSVResponse(response, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.POST)
	@ResponseBody
	public void convertPASToPastel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			System.out.print("Here");
			List<UserTransactionInfo> people = xLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
			BeanMapper mapper = BeanMapper.getInstance();
			List<UserConversionInfo> userList = mapper.userInfoMapper(people);

			File file;
			file = objectCsv.objectToCSV(userList);
			doCSVResponse(response, file);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while converting file from PAS to Pastel  " + e);
		}
	}

	private void doCSVResponse(HttpServletResponse response, File file) {
		byte[] contents = fileToByte(file);
		String responseFile = "response.csv";
		response.setContentType("text/plain");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", responseFile);
		response.setHeader(headerKey, headerValue);
		OutputStream os;
		try {
			os = response.getOutputStream();
			os.write(contents);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		response.setContentLength(contents.length);
		response.setHeader("Content-Disposition", "attachment;filename= " + responseFile);

		if (!file.delete()) {
			System.out.println("Unable to delete file");
		}
	}

	private byte[] fileToByte(File file) {
		FileInputStream fileInputStream = null;

		byte[] bFile = new byte[(int) file.length()];

		try {
			fileInputStream = new FileInputStream(file);
			int count = fileInputStream.read(bFile);
			fileInputStream.close();
			if (count > 0)
				return bFile;
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error while reading file inputStream" + e);
		}

		return bFile;
	}

	private File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}
