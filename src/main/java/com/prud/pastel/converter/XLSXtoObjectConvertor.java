package com.prud.pastel.converter;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.prud.pastel.model.PASRecord;

@Component
public class XLSXtoObjectConvertor {
	static final Logger logger = Logger.getLogger(XLSXtoObjectConvertor.class);

	public List<PASRecord> xlsxToJavaObject(File file) {

		List<PASRecord> people = null;
		try {
			logger.debug("converting xlsx to POJO");
			people = Poiji.fromExcel(file, PASRecord.class);
		} catch (Exception e) {
			logger.error("error while reading from XLSX file and converting into Object " + e);
			e.printStackTrace();
		}
		return people;
	}

	public List<PASRecord> xlsxToJavaObject() throws Exception {
		return xlsxToJavaObject(
				new File(XLSXtoObjectConvertor.class.getClassLoader().getResource("xlsx/Uganda/IL.xlsx").toURI()));
	}
}
