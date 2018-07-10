package com.prud.pastel.converter;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.prud.pastel.model.PASRecord;

public class XLSXtoJavaObject {

	public static List<PASRecord> xlsxToJavaObject(File file) throws Exception {
		PoijiOptions options = PoijiOptionsBuilder.settings().skip(2).build();
		List<PASRecord> people = Poiji.fromExcel(file,
				PASRecord.class);
		System.out.println(people.size());
		return people;
	}	
	
	public static List<PASRecord> xlsxToJavaObject() throws Exception {
		return xlsxToJavaObject(
				new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()));
	}
}
