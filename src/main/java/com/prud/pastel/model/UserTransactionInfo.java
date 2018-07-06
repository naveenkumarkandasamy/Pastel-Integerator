package com.prud.pastel.model;

import com.poiji.annotation.ExcelCellName;

public class UserTransactionInfo {

	@ExcelCellName("Branch Number")
	private String branchNumber;
	@ExcelCellName("Branch Name")
	private String branchName;
	@ExcelCellName("Account Number")
	private String accountNumber;
	@ExcelCellName("Account Name")
	private String accountName; // credit or debit

	@ExcelCellName("By Order Of/Beneficiary")
	private String byOrderOf;
	@ExcelCellName("Statement Date")
	private String statementDate;
	@ExcelCellName("Entry Date")
	private String entryDate;
	@ExcelCellName("Transaction Description")
	private String transactionDescription;
	@ExcelCellName("Narrative")
	private String narrative;
	@ExcelCellName("Bank Reference")
	private String bankReference;
	@ExcelCellName("Customer Reference")
	private String customerReference;
	@ExcelCellName("Value Date")
	private double valueDate;
	@ExcelCellName("Transaction Currency")
	private String transactionCurrency;
	@ExcelCellName("Amount")
	private String amount;
	@ExcelCellName("Batch/Track")
	private String batchOrTrack;
	@ExcelCellName("IBAN Number")
	private String ibanNumber;

	public String getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getByOrderOf() {
		return byOrderOf;
	}

	public void setByOrderOf(String byOrderOf) {
		this.byOrderOf = byOrderOf;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public String getBankReference() {
		return bankReference;
	}

	public void setBankReference(String bankReference) {
		this.bankReference = bankReference;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public double getValueDate() {
		return valueDate;
	}

	public void setValueDate(double valueDate) {
		this.valueDate = valueDate;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getIbanNumber() {
		return ibanNumber;
	}

	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}

	public String getBatchOrTrack() {
		return batchOrTrack;
	}

	public void setBatchOrTrack(String batchOrTrack) {
		this.batchOrTrack = batchOrTrack;
	}

}
