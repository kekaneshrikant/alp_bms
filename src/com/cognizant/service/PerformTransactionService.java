package com.cognizant.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.IApplicationDAO;
import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;

@Service
@Transactional(readOnly = true)
public class PerformTransactionService implements IPerformTransactionService {

	@Autowired
	private IApplicationDAO applicationDAO;
	
	@Transactional
	@Override
	public Double updateTransactionDetails(TransactionDetailsEntity transactionDetailsEntity) {
		Double updatedBalance = applicationDAO.updateTransactionDetails(transactionDetailsEntity);
		return updatedBalance;
	}

	@Transactional
	@Override
	public UserDetailsEntity findUserDetails(BigInteger accountNumber) {
		UserDetailsEntity userDetailsEntity = applicationDAO.findUserDetails(accountNumber);
		return userDetailsEntity;
	}
}
