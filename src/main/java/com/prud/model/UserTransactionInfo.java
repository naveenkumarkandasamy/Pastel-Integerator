package com.prud.model;

import java.sql.Date;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;

public class UserTransactionInfo {

	@Override
	public String toString() {
		return "UserTransactionInfo [date=" + date + ", amount=" + amount + ", module=" + module + ", trancactionType="
				+ trancactionType + ", account=" + account + ", contraCode=" + contraCode + ", transactionCode="
				+ transactionCode + ", batchNo=" + batchNo + ", reference=" + reference + ", description=" + description
				+ ", productCode=" + productCode + ", quantity=" + quantity + ", source=" + source + ", accountName="
				+ accountName + "]";
	}

	@ExcelCellName("date")
	private Date date;
	@ExcelCellName("amount")
	private double amount;
	@ExcelCellName("module")
	private String module;
	@ExcelCellName("trancactionType")
	private String trancactionType; // credit or debit
	@ExcelCellName("account")
	private String account;
	@ExcelCellName("contraCode")
	private String contraCode;
	@ExcelCellName("transactionCode")
	private String transactionCode;
	@ExcelCellName("batchNo")
	private String batchNo;
	@ExcelCellName("reference")
	private String reference;
	@ExcelCellName("description")
	private String description;
	@ExcelCellName("productCode")
	private String productCode;
	@ExcelCellName("quantity")
	private double quantity;
	@ExcelCellName("source")
	private String source;
	@ExcelCellName("accountName")
	private String accountName;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public String getContraCode() {
		return contraCode;
	}

	public void setContraCode(String contraCode) {
		this.contraCode = contraCode;
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
