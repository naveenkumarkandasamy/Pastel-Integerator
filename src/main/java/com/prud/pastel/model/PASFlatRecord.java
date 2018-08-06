package com.prud.pastel.model;

import com.poiji.annotation.ExcelCellName;

public class PASFlatRecord {									

	@ExcelCellName("Date")
	private String date;
	@ExcelCellName("Payment No")
	private String paymentNo;
	@ExcelCellName("Description")
	private String description;
	@ExcelCellName("Debit Number")
	private String debitNumber;
	@ExcelCellName("Beneficiary")
	private String beneficiary;
	@ExcelCellName("Policy No")
	private String policyNo;
	@ExcelCellName("Amount")
	private String amount;
	@ExcelCellName("Bank Ref No")
	private String bankRefNo;
	@ExcelCellName("Mode of Payment")
	private String modeOfPayment;
	@ExcelCellName("Income Account")
	private String incomeAccount;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
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
	public String getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}	
	public String getBankRefNo() {
		return bankRefNo;
	}
	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getIncomeAccount() {
		return incomeAccount;
	}
	public void setIncomeAccount(String incomeAccount) {
		this.incomeAccount = incomeAccount;
	}


}
