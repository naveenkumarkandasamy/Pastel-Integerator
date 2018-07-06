package com.prud.pastel.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.prud.pastel.converter.ObjectToCSVConvertor;
import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

public class BeanMapper {
	private static BeanMapper instance = new BeanMapper();
	static final Logger logger = Logger.getLogger(BeanMapper.class);

	private BeanMapper() {

	}

	public static BeanMapper getInstance() {
		return instance;
	}

	public List<UserConversionInfo> userInfoMapper(List<UserTransactionInfo> userTransactionInfoList) {
		List<UserConversionInfo> userConversionInfoList = null;
		if (null != userTransactionInfoList && !userTransactionInfoList.isEmpty()) {
			userConversionInfoList = new ArrayList<UserConversionInfo>();
			for (UserTransactionInfo userTransactionInfo : userTransactionInfoList) {
				if (null != userTransactionInfo) {
					UserConversionInfo userConversionInfo = new UserConversionInfo();
					userConversionInfo.setAccountName(userTransactionInfo.getAccountName());
					userConversionInfo.setAmount(userTransactionInfo.getAmount());
					userConversionInfo.setBatchNo(userTransactionInfo.getBatchOrTrack());
					// userConversionInfo.setDate(userTransactionInfo.getDate());
					userConversionInfo.setDescription(userTransactionInfo.getTransactionDescription());
					// userConversionInfo.setGlAc(userTransactionInfo.getGlAc());
					// userConversionInfo.setModule(userTransactionInfo.getModule());
					// userConversionInfo.setProductCode(userTransactionInfo.getProductCode());
					// userConversionInfo.setQuantity(userTransactionInfo.getQuantity());
					// userConversionInfo.setReference(userTransactionInfo.getReference());
					// userConversionInfo.setSource(userTransactionInfo.getSource());
					// userConversionInfo.setTrancactionType(userTransactionInfo.getTrancactionType());
					// userConversionInfo.setTransactionCode(userTransactionInfo.getTransactionCode());
					userConversionInfoList.add(userConversionInfo);
				} else {
					logger.debug("userTransactionInfo is null");
				}
			}
		} else {
			logger.debug("userTransactionInfoList is either null or empty");
		}
		return userConversionInfoList;
	}
}
