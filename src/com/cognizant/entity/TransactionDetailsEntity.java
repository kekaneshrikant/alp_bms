package com.cognizant.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@NamedQueries({
		@NamedQuery(name = "getTransactionsByAccountNumber", query = "from TransactionDetailsEntity e where e.accountNumber.accountNumber = :accNumber"),
		@NamedQuery(name = "getTransactionsByTransactionId", query = "from TransactionDetailsEntity e where e.transactionId = :transactionId"),
		@NamedQuery(name = "getTransactionsByTransactionIdAndAccountNumber", query = "from TransactionDetailsEntity e where e.transactionId = :transactionId and e.accountNumber.accountNumber = :accNumber") })
public class TransactionDetailsEntity implements Serializable {

	/**
	 * The Generated Serial Version ID
	 */
	private static final long serialVersionUID = 2512631578739522290L;

	@Id
	@Column(name = "TRANSACTION_ID")
	private BigInteger transactionId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetailsEntity accountNumber;

	@Column(name = "TRANSACTION_DESCRIPTION")
	private String transactionDescription;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "ACCOUNT_BALANCE")
	private Long accountBalance;

	/**
	 * @return the transactionId
	 */
	public BigInteger getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the accountNumber
	 */
	public UserDetailsEntity getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(UserDetailsEntity accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the transactionDescription
	 */
	public String getTransactionDescription() {
		return transactionDescription;
	}

	/**
	 * @param transactionDescription
	 *            the transactionDescription to set
	 */
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the accountBalance
	 */
	public Long getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance
	 *            the accountBalance to set
	 */
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}

}
