package com.prud.pastel.mapper;

import java.util.ArrayList;
import java.util.List;

import com.prud.pastel.model.UserConversionInfo;
import com.prud.pastel.model.UserTransactionInfo;

public class BeanMapper {

	public List<UserConversionInfo> userInfoMapper(List<UserTransactionInfo> userTransactionInfoList) {
		List<UserConversionInfo> userConversionInfoList=new ArrayList<UserConversionInfo>();
		for(UserTransactionInfo userTransactionInfo:userTransactionInfoList) {
		UserConversionInfo userConversionInfo = new UserConversionInfo();
		userConversionInfo.setAccount(userTransactionInfo.getAccount());
		userConversionInfo.setAccountName(userTransactionInfo.getAccountName());
		userConversionInfo.setAmount(userTransactionInfo.getAmount());
		userConversionInfo.setBatchNo(userTransactionInfo.getBatchNo());
		userConversionInfo.setContraAccount(userTransactionInfo.getContraAccount());
		userConversionInfo.setDate(userTransactionInfo.getDate());
		userConversionInfo.setDescription(userTransactionInfo.getDescription());
		userConversionInfo.setGlAc(userTransactionInfo.getGlAc());
		userConversionInfo.setModule(userTransactionInfo.getModule());
		userConversionInfo.setProductCode(userTransactionInfo.getProductCode());
		userConversionInfo.setQuantity(userTransactionInfo.getQuantity());
		userConversionInfo.setReference(userTransactionInfo.getReference());
		userConversionInfo.setSource(userTransactionInfo.getSource());
		userConversionInfo.setTrancactionType(userTransactionInfo.getTrancactionType());
		userConversionInfo.setTransactionCode(userTransactionInfo.getTransactionCode());
		userConversionInfoList.add(userConversionInfo);
		}
		return userConversionInfoList;
	}
}
