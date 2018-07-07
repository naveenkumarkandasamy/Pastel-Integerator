package com.prud.pastel.converter;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.prud.pastel.model.UserTransactionInfo;

@Component
public class XLSXtoObjectConvertor {
	static final Logger logger = Logger.getLogger(XLSXtoObjectConvertor.class);
	public List<UserTransactionInfo> xlsxToJavaObject(File file) {

		List<UserTransactionInfo> people = null;
		try {
			people = Poiji.fromExcel(
					file,
					UserTransactionInfo.class);
		} catch (Exception e) {
			logger.error("error while reading from XLSX file and converting into Object " + e);
			e.printStackTrace();
		}
		return people;
	}
	
	public List<UserTransactionInfo> xlsxToJavaObject() throws Exception {
		return xlsxToJavaObject(
				new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/DDACC.xlsx").toURI()));
	}	
}
