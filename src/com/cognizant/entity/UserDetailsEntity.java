package com.cognizant.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_DETAILS")
@NamedQueries({ @NamedQuery(name = "getUserDetailsByAccountNumber", query = "from UserDetailsEntity e where e.accountNumber = :accountNumber") })
public class UserDetailsEntity implements Serializable{
	
	public UserDetailsEntity() {
	}

	/**
	 * The Generated Serial Version UID
	 */
	private static final long serialVersionUID = -7749905097573490144L;

	@Id
	@Column(name="ACCOUNT_NUMBER")
	private BigInteger accountNumber;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	
	@Column(name="ACCOUNT_BALANCE")
	private Integer accountBalance;
	
	@OneToMany(mappedBy="accountNumber", fetch= FetchType.EAGER)
	@JsonIgnore
	private List<TransactionDetailsEntity> transactions;

	/**
	 * @return the accountNumber
	 */
	public BigInteger getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the accountBalance
	 */
	public Integer getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the transactions
	 */
	public List<TransactionDetailsEntity> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<TransactionDetailsEntity> transactions) {
		this.transactions = transactions;
	}
	
}
