package com.cognizant.service;

import java.math.BigInteger;
import java.util.List;

import com.cognizant.entity.TransactionDetailsEntity;

public interface IViewTransactionService {
	
	public List<TransactionDetailsEntity> retreiveTransactionDetails(BigInteger accountNumber, BigInteger transactionId);

}
