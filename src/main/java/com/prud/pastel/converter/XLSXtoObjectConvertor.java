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
	/*
	 * public static void main(String[] args) throws Exception { PoijiOptions
	 * options = PoijiOptionsBuilder.settings().preferNullOverDefault(true) (1)
	 * .build();
	 * 
	 * InputStream stream = new FileInputStream(new
	 * File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").
	 * toURI())); PoijiOptions options =
	 * PoijiOptionsBuilder.settings().datePattern("yyyymmdd").build();
	 * List<Employee> employees = Poiji.fromExcel(stream, PoijiExcelType.XLS,
	 * Employee.class, options);
	 * 
	 * }
	 */

	public List<UserTransactionInfo> xlsxToJavaObject() {

		// PoijiOptions options = PoijiOptionsBuilder.settings().skip(2).build();
		List<UserTransactionInfo> people = null;
		try {
			people = Poiji.fromExcel(
					new File(XLSXtoObjectConvertor.class.getClassLoader().getResource("xlsx/test.xlsx").toURI()),
					UserTransactionInfo.class);
		} catch (URISyntaxException e) {
			logger.error("error while reading from XLSX file and converting into Object " + e);
		}
		// System.out.println(people.size());
		// 2
		// UserTransactionInfo person = people.get(1);
		// System.out.println(people.get(0));
		return people;
	}
}
