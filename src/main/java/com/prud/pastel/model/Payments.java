package com.prud.pastel.model;

public class Payments {
public String transactionType; //BTCHTYPE
public String batchNo; //CNTBTCH
public String entryNumber; //CNTENTR
public String chequeNo; //IDRMIT
public String beneficiaryNo; //IDVEND
public String date; //DATERMIT
public String description; //TEXTRMIT
public String beneficiary; //NAMERMIT
public String bankReference; //policyNumer ;TXTRMITREF
public String amount; //AMTRMIT
public String codePayment; //CODEPAAYM
public String bankCode; //IDBANK
public String paymentType; //RMITTYPE
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public String getBatchNo() {
	return batchNo;
}
public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
}
public String getEntryNumber() {
	return entryNumber;
}
public void setEntryNumber(String entryNumber) {
	this.entryNumber = entryNumber;
}
public String getChequeNo() {
	return chequeNo;
}
public void setChequeNo(String chequeNo) {
	this.chequeNo = chequeNo;
}
public String getBeneficiaryNo() {
	return beneficiaryNo;
}
public void setBeneficiaryNo(String beneficiaryNo) {
	this.beneficiaryNo = beneficiaryNo;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getBeneficiary() {
	return beneficiary;
}
public void setBeneficiary(String beneficiary) {
	this.beneficiary = beneficiary;
}
public String getBankReference() {
	return bankReference;
}
public void setBankReference(String bankReference) {
	this.bankReference = bankReference;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getCodePayment() {
	return codePayment;
}
public void setCodePayment(String codePayment) {
	this.codePayment = codePayment;
}
public String getBankCode() {
	return bankCode;
}
public void setBankCode(String bankCode) {
	this.bankCode = bankCode;
}
public String getPaymentType() {
	return paymentType;
}
public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}
}
