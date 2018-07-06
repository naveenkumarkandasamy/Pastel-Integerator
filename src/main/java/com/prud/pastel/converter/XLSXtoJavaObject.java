package com.prud.pastel.converter;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.prud.pastel.model.UserTransactionInfo;

public class XLSXtoJavaObject {

	public static List<UserTransactionInfo> xlsxToJavaObject(File file) throws Exception {
		PoijiOptions options = PoijiOptionsBuilder.settings().skip(2).build();
		List<UserTransactionInfo> people = Poiji.fromExcel(file,
				UserTransactionInfo.class);
		System.out.println(people.size());
		return people;
	}	
	
	public static List<UserTransactionInfo> xlsxToJavaObject() throws Exception {
		return xlsxToJavaObject(
				new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()));
	}
}
