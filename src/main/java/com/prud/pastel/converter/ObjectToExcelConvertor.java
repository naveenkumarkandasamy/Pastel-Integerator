package com.prud.pastel.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import com.prud.pastel.model.Receipts;

public class ObjectToExcelConvertor {

	public File convertObjectToExcel(List<Receipts> receipts) {
		File tempFile = new File("receipts.xlsx");
		try {
			URL fileResource = this.getClass().getClassLoader().getResource("xlsx/Uganda/RECEIPT_TEMPLATE.xls");
			File file = new File(fileResource.toURI());
			List<Receipts> miscellaneousReceipts = receipts;
			InputStream is = new FileInputStream(file);
			
			OutputStream os = new FileOutputStream(tempFile);
			Context context = new Context();
			context.putVar("receipts", receipts);
			context.putVar("miscellaneousReceipts", miscellaneousReceipts);
			JxlsHelper.getInstance().processTemplate(is, os, context);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tempFile;
	}
}
