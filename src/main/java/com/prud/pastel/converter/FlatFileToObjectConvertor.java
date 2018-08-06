package com.prud.pastel.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.prud.pastel.model.PastelRecord;

@Component
public class FlatFileToObjectConvertor {
	static final Logger logger = Logger.getLogger(XLSXtoObjectConvertor.class);

	static Properties flatFileDescriptionMapper = new OrderedProperties();
	static Properties flatFileToPastelMapper = new Properties();
	static InputStream inputStream1, inputStream2 = null;	
	
	static{
		String filename = "flatfile/Uganda/flatFileMapper.properties";
		inputStream1 = FlatFileToObjectConvertor.class.getClassLoader().getResourceAsStream(filename);
		try {
			flatFileDescriptionMapper.load(inputStream1);
			inputStream1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String filename2 = "flatfile/Uganda/FlatFormatToPastel.properties";
		inputStream2 = FlatFileToObjectConvertor.class.getClassLoader().getResourceAsStream(filename2);
		try {
			flatFileToPastelMapper.load(inputStream2);
			inputStream2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<PastelRecord> convertToPastelRecord(File file) {

		List<PastelRecord> records = new ArrayList<PastelRecord>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Map<String, String> recordMap = getRecordFromFlatFile(bufferedReader, line);
				PastelRecord pastelRecord = new PastelRecord(recordMap, flatFileToPastelMapper);
				records.add(pastelRecord);
			}
			fileReader.close();
		} catch (Exception e) {
			logger.error("error while reading from XLSX file and converting into Object " + e);
			e.printStackTrace();
		}
		return records;
	}

	public Map<String, String> getRecordFromFlatFile(BufferedReader bufferedReader, String line) throws IOException {
		Integer start = 0;
		Integer end = 0;
		Enumeration keys = flatFileDescriptionMapper.propertyNames();
		Map<String, String> recordMap = new HashMap<String, String>();
		while (keys.hasMoreElements()) {
			String fieldName = (String) keys.nextElement();
			if(StringUtils.contains(fieldName,"BREAK")){
				line = bufferedReader.readLine();
				start=0; end=0;
				continue;
			}
		    String length = flatFileDescriptionMapper.getProperty(fieldName);
		    String value;
		    if(StringUtils.contains(length, "."))
		    {
		    	String leng[]  = StringUtils.split(length, ".");
		    	end = start + Integer.parseInt(leng[0]) + Integer.parseInt(leng[1]);
		    }
		    else
		    	end = start + Integer.parseInt(length);
		    value = StringUtils.substring(line, start, end);
		    start = end;
		    recordMap.put(fieldName, value);
		}
		return recordMap;
	}

	public List<PastelRecord> convertToPastelRecord() throws Exception {
		return convertToPastelRecord(new File(
				XLSXtoObjectConvertor.class.getClassLoader().getResource("flatfile/Uganda/BACSDC0006.txt").toURI()));
	}

	public static void main(String[] args) throws Exception {
		List<PastelRecord> records = new FlatFileToObjectConvertor().convertToPastelRecord();
		System.out.println(records);
	}
	
}
