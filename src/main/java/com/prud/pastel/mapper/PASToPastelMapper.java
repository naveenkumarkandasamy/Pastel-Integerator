package com.prud.pastel.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.pastel.model.PastelRecord;
import com.prud.pastel.model.PASRecord;

@Component
public class PASToPastelMapper {

	@Autowired
	private ModelConverter converter;

	@Resource(name = "pasToPastelMapping")
	private Map<String, String> pasToPastelMapping;

	@Autowired
	PASToPastelMapper instance;


	static final Logger logger = Logger.getLogger(PASToPastelMapper.class);

	public List<PastelRecord> createPastelList(List<PASRecord> pasRecordsList) {
		List<PastelRecord> pastelRecordsList = null;
		if (null != pasRecordsList && !pasRecordsList.isEmpty()) {

			pastelRecordsList = new ArrayList<PastelRecord>();

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
