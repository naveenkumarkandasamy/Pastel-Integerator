package com.prud.pastel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.prud.pastel.converter.ObjectToCSV;
import com.prud.pastel.converter.XLSXtoJavaObject;
import com.prud.pastel.mapper.BeanMapper;
import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

@Controller
@RequestMapping("/api/convertor")
public class PastelRestContoller {

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.GET)
	@ResponseBody
	public void convertPAStoPastel(HttpServletRequest request, HttpServletResponse response) {
/*		HttpHeaders headers = new HttpHeaders();*/
		try {
			List<UserTransactionInfo> people = XLSXtoJavaObject.xlsxToJavaObject();
			BeanMapper mapper = new BeanMapper();
			List<UserConversionInfo> userList = mapper.userInfoMapper(people);

			ObjectToCSV objectCsv = new ObjectToCSV();

			File file;
			file = objectCsv.objectToCSV(userList);

			byte[] contents = fileToByte(file);
/*			headers.setContentType(MediaType.parseMediaType("text/plain"));*/

			String responseFile = "response.csv";
/*			headers.setContentDispositionFormData(responseFile, responseFile);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");*/
			//ResponseEntity<byte[]> csvBytes = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
			response.setContentType("text/plain");
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	        		responseFile);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] fileToByte(File file) {
		FileInputStream fileInputStream = null;

		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			int count = fileInputStream.read(bFile);
			fileInputStream.close();
			if (count > 0)
				return bFile;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bFile;
	}

}
