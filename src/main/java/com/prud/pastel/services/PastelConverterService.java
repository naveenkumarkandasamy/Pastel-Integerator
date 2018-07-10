package com.prud.pastel.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.converter.XLSXtoObjectConvertor;
import com.prud.pastel.mapper.PASToPastelMapper;
import com.prud.pastel.model.PASRecord;
import com.prud.pastel.model.PastelRecord;

@Component
public class PastelConverterService {
	
	@Autowired
	XLSXtoObjectConvertor xlsxToObjectConvertor;	
	
	@Autowired
	ObjectToCSVConvertor objectToCSVConvertor;	
	
	static final Logger logger = Logger.getLogger(PastelConverterService.class);
	
	public void convertToPastel(HttpServletResponse response) throws Exception {
		List<PASRecord> pasRecordsList = xlsxToObjectConvertor.xlsxToJavaObject();
		convertToPastel(response, pasRecordsList);
	}
	
	public void convertToPastel(HttpServletResponse response, MultipartFile pasFile) throws Exception {
		List<PASRecord> pasRecordsList = xlsxToObjectConvertor.xlsxToJavaObject(convert(pasFile));
		convertToPastel(response, pasRecordsList);
	}	

	private void convertToPastel(HttpServletResponse response, List<PASRecord> pasRecordsList) {
		PASToPastelMapper mapper = PASToPastelMapper.getInstance();
		List<PastelRecord> userList = mapper.createPastelList(pasRecordsList);
		File file;
		file = objectToCSVConvertor.convertObjectToCSV(userList);
		doCSVResponse(response, file);
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
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}

		response.setContentLength(contents.length);
		response.setHeader("Content-Disposition", "attachment;filename= " + responseFile);

		if (!file.delete()) {
			logger.error("Unable to delete file");
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
			e.printStackTrace();
			logger.error("Error while reading file inputStream" + e);
		} finally {
			if (fileInputStream != null)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return bFile;
	}	
	
	private File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		Boolean isFileNotCreated = convFile.createNewFile();
		if (isFileNotCreated) {
			logger.error("Unable to convert form mulitpart to file");
			return null;
		}
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}	
}
