package com.cognizant.vo;

import java.math.BigInteger;

public class TransactionVO {
	
	 private BigInteger accountNumber;
	 private BigInteger transactionId;
	 private String transactionType;
	 private Long transactionAmount;
	 private String description;
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigInteger getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
}
