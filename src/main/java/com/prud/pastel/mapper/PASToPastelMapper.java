package com.prud.pastel.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.pastel.model.PastelRecord;
import com.prud.pastel.model.PASRecord;

@Component
public class PASToPastelMapper {

	private static Map<String, String> pasToPastelMapping = new HashMap<String, String>();	

	private static PASToPastelMapper instance = new PASToPastelMapper();	

	static Properties prop = new Properties();
	static InputStream input = null;	

	public static PASToPastelMapper getInstance() {
		return instance;
	}

	static{
		String filename = "PasToPastelMapping.properties";
		input = PASToPastelMapper.class.getClassLoader().getResourceAsStream(filename);
		try {
			prop.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String key : prop.stringPropertyNames()) {
		    String value = prop.getProperty(key);
		    pasToPastelMapping.put(key, value);
		}
	}

	static final Logger logger = Logger.getLogger(PASToPastelMapper.class);

	public List<PastelRecord> createPastelList(List<PASRecord> pasRecordsList) {
		List<PastelRecord> pastelRecordsList = null;
		if (null != pasRecordsList && !pasRecordsList.isEmpty()) {

			pastelRecordsList = new ArrayList<PastelRecord>();
			
			OrikaModelConverter converter = OrikaModelConverter.getInstance();

			for (PASRecord pasRecord : pasRecordsList) {
				if (null != pasRecord) {
					PastelRecord pastelRecord = (PastelRecord)converter.map(pasRecord,PASRecord.class, PastelRecord.class, pasToPastelMapping);	
					pastelRecordsList.add(pastelRecord);
				} else {
					logger.debug("PAS Record is null");
				}
			}
		} else {
			logger.debug("PAS RecordsList is either null or empty");
		}
		return pastelRecordsList;
	}



}
