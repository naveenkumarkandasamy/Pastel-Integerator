package com.prud.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.prud.model.UserTransactionInfo;

public class XLSXtoJavaObject {

	
	public static void main(String[] args) throws Exception {
//		PoijiOptions options = PoijiOptionsBuilder.settings().preferNullOverDefault(true) (1)
//                .build();
		
//		InputStream stream = new FileInputStream(new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()));
		PoijiOptions options = PoijiOptionsBuilder.settings().datePattern("yyyymmdd").build();
//				List<Employee> employees = Poiji.fromExcel(stream, PoijiExcelType.XLS, Employee.class, options);
		List<UserTransactionInfo> people = Poiji.fromExcel(new File(XLSXtoJavaObject.class.getClassLoader().getResource("xlsx/test.xls").toURI()),UserTransactionInfo.class);
		System.out.println(people.size());
		// 2
		UserTransactionInfo person = people.get(1);
		System.out.println(people.get(0));
	}
}
