/**
 * 
 */
package com.cognizant.dao;

import java.math.BigInteger;

import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;

/**
 * @author student
 *
 */
public interface IApplicationDAO {
	
	/**
	 * Updates the transaction entry in the {@link TransactionDetailsEntity} table.
	 * @param transactionDetailsEntity The actual entity to be written.
	 * @return Returns th Account Balance after updating the transation history.
	 */
	Double updateTransactionDetails(final TransactionDetailsEntity transactionDetailsEntity);
	
	UserDetailsEntity findUserDetails(final BigInteger accountNumber);

}
