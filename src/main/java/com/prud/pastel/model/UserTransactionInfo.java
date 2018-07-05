package com.prud.pastel.model;

import com.poiji.annotation.ExcelCellName;

public class UserTransactionInfo {




	@Override
	public String toString() {
		return "UserTransactionInfo [date=" + date + ", amount=" + amount + ", module=" + module + ", trancactionType="
				+ trancactionType + ", account=" + account + ", glAc=" + glAc + ", contraAccount=" + contraAccount
				+ ", transactionCode=" + transactionCode + ", batchNo=" + batchNo + ", reference=" + reference
				+ ", description=" + description + ", productCode=" + productCode + ", quantity=" + quantity
				+ ", source=" + source + ", accountName=" + accountName + "]";
	}

	@ExcelCellName("Date")
	private String date;
	@ExcelCellName("Amount")
	private double amount;
	@ExcelCellName("Module")
	private String module;
	@ExcelCellName("Dr/CR")
	private String trancactionType; // credit or debit
	@ExcelCellName("Account")
	private String account;
	@ExcelCellName("GL A/C")
	private String glAc;
	@ExcelCellName("Contra Account")
	private String contraAccount;
	@ExcelCellName("Transaction Code")
	private String transactionCode;
	@ExcelCellName("batchNo")
	private String batchNo;
	@ExcelCellName("Reference")
	private String reference;
	@ExcelCellName("Description")
	private String description;
	@ExcelCellName("Product Code")
	private String productCode;
	@ExcelCellName("Quantity")
	private double quantity;
	@ExcelCellName("Source")
	private String source;
	@ExcelCellName("Account Name")
	private String accountName;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getTrancactionType() {
		return trancactionType;
	}
	public void setTrancactionType(String trancactionType) {
		this.trancactionType = trancactionType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGlAc() {
		return glAc;
	}
	public void setGlAc(String glAc) {
		this.glAc = glAc;
	}
	public String getContraAccount() {
		return contraAccount;
	}
	public void setContraAccount(String contraAccount) {
		this.contraAccount = contraAccount;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	

}
