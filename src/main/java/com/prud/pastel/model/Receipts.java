package com.prud.pastel.model;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.poiji.annotation.ExcelCellName;

public class Receipts {


	public String date;
	public String rcptNo;
	public String description;
	public String debitNumber;
	public String clientName;
	public String amount;
	public static final String currency = "UGX";
	public String policyNo;
	public String bankRefNo;
	public String originalType;
	public String incomeAccount;
	public String bankCode;
	public static final String codePayment = "CA";
	public static final String batchNumber = "1";
	public String entryNumbers;
	public static final String rmitType = "5";
	public static final String docType = "1";
	public static final String idinvcmtch = "***New***";
	public static final String paymentType = "2";
	public static final Integer lineNo = 20;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRcptNo() {
		return rcptNo;
	}
	public void setRcptNo(String rcptNo) {
		this.rcptNo = rcptNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDebitNumber() {
		return debitNumber;
	}
	public void setDebitNumber(String debitNumber) {
		this.debitNumber = debitNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getBankRefNo() {
		return bankRefNo;
	}
	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}
	public String getOriginalType() {
		return originalType;
	}
	public void setOriginalType(String originalType) {
		this.originalType = originalType;
	}
	public String getIncomeAccount() {
		return incomeAccount;
	}
	public void setIncomeAccount(String incomeAccount) {
		this.incomeAccount = incomeAccount;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCodePayment() {
		return codePayment;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public String getEntryNumbers() {
		return entryNumbers;
	}
	public void setEntryNumbers(String entryNumbers) {
		this.entryNumbers = entryNumbers;
	}
	public String getRmitType() {
		return rmitType;
	}
	public String getDocType() {
		return docType;
	}
	public String getIdinvcmtch() {
		return idinvcmtch;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public Integer getLineNo() {
		return lineNo;
	}
	public Receipts(Map<String, String> recordMap, Properties flatToPastelMapper) {
		Field [] fields = this.getClass().getFields();
		for(Field field : fields){
			try {
				field.set(this, recordMap.get(flatToPastelMapper.get(field.getName())));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}	
}