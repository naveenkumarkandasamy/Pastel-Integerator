package com.prud.pastel.converter;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.prud.pastel.model.UserTransactionInfo;

public class XLSXtoJavaObject {

	public static void main(String[] args) throws Exception {
		// PoijiOptions options =
		// PoijiOptionsBuilder.settings().preferNullOverDefault(true) (1)
		// .build();

		// InputStream stream = new FileInputStream(new
		// File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()));
		// PoijiOptions options =
		// PoijiOptionsBuilder.settings().datePattern("yyyymmdd").build();
		// List<Employee> employees = Poiji.fromExcel(stream, PoijiExcelType.XLS,
		// Employee.class, options);

	}

	static public List<UserTransactionInfo> xlsxToJavaObject() throws Exception {
		PoijiOptions options = PoijiOptionsBuilder.settings().skip(2).build();
		List<UserTransactionInfo> people = Poiji.fromExcel(
				new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()),
				UserTransactionInfo.class);
		System.out.println(people.size());
		// 2
//		UserTransactionInfo person = people.get(1);
		// System.out.println(people.get(0));
		return people;
	}
}
