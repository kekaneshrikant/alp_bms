package com.cognizant.service;

import java.math.BigInteger;

import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;
import com.cognizant.vo.TransactionVO;

public interface IPerformTransactionService {
	
	/**
	 * Updates the transaction entry in the {@link TransactionVO} table.
	 * @param transactionDetailsEntity The actual entity to be written.
	 * @return Returns the Account Balance after updating the transaction history.
	 */
	Double updateTransactionDetails(final TransactionDetailsEntity transactionDetailsEntity);
	
	UserDetailsEntity findUserDetails(final BigInteger accountNumber);

}
