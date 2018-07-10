package com.prud.pastel.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.model.PastelRecord;
import com.prud.pastel.model.PASRecord;

public class PASToPastelMapper {
	private static PASToPastelMapper instance = new PASToPastelMapper();
	static final Logger logger = Logger.getLogger(PASToPastelMapper.class);

	private PASToPastelMapper() {

	}

	public static PASToPastelMapper getInstance() {
		return instance;
	}

	public List<PastelRecord> createPastelList(List<PASRecord> pasRecordsList) {
		List<PastelRecord> pastelRecordsList = null;
		if (null != pasRecordsList && !pasRecordsList.isEmpty()) {
			pastelRecordsList = new ArrayList<PastelRecord>();
			for (PASRecord pasRecord : pasRecordsList) {
				if (null != pasRecord) {
					PastelRecord pastelRecord = new PastelRecord();
					pastelRecord.setAccountName(pasRecord.getAccountName());
					pastelRecord.setAmount(pasRecord.getAmount());
					pastelRecord.setBatchNo(pasRecord.getBatchOrTrack());
					// userConversionInfo.setDate(userTransactionInfo.getDate());
					pastelRecord.setDescription(pasRecord.getTransactionDescription());
					// userConversionInfo.setGlAc(userTransactionInfo.getGlAc());
					// userConversionInfo.setModule(userTransactionInfo.getModule());
					// userConversionInfo.setProductCode(userTransactionInfo.getProductCode());
					// userConversionInfo.setQuantity(userTransactionInfo.getQuantity());
					// userConversionInfo.setReference(userTransactionInfo.getReference());
					// userConversionInfo.setSource(userTransactionInfo.getSource());
					// userConversionInfo.setTrancactionType(userTransactionInfo.getTrancactionType());
					// userConversionInfo.setTransactionCode(userTransactionInfo.getTransactionCode());
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
