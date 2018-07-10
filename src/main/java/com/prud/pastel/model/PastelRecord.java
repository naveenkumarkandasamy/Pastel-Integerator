package com.prud.pastel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Date", "Amount", "Module", "Dr/CR", "Account", "GL A/C", "Contra Account", "Transaction Code",
		"Batch No", "Reference", "Description", "Product Code", "Quantity", "Source","Account Name" })
public class PastelRecord {

	@JsonProperty("Date")
	private String date;
	@JsonProperty("Amount")
	private String amount;
	@JsonProperty("Module")
	private String module;
	@JsonProperty("Dr/CR")
	private String trancactionType; // credit or debit
	@JsonProperty("Account")
	private String account;
	@JsonProperty("GL A/C")
	private String glAc;
	@JsonProperty("Contra Account")
	private String contraAccount;
	@JsonProperty("Transaction Code")
	private String transactionCode;
	@JsonProperty("Batch No")
	private String batchNo;
	@JsonProperty("Reference")
	private String reference;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Product Code")
	private String productCode;
	@JsonProperty("Quantity")
	private double quantity;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("Account Name")
	private String accountName;
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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

	@Override
	public String toString() {
		return "UserTransactionInfo [date=" + date + ", amount=" + amount + ", module=" + module + ", trancactionType="
				+ trancactionType + ", account=" + account + ", glAc=" + glAc + ", contraAccount=" + contraAccount
				+ ", transactionCode=" + transactionCode + ", batchNo=" + batchNo + ", reference=" + reference
				+ ", description=" + description + ", productCode=" + productCode + ", quantity=" + quantity
				+ ", source=" + source + ", accountName=" + accountName + "]";
	}

}
