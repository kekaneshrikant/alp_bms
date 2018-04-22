package com.cognizant.dao;

import java.math.BigInteger;
import java.util.List;

import com.cognizant.entity.TransactionDetailsEntity;

public interface IViewTransactionDAO {
	
	public List<TransactionDetailsEntity> retreiveTransactionDetails(BigInteger accountNumber, BigInteger transactionId);

}
