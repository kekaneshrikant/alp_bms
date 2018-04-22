package com.cognizant.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.IApplicationDAO;
import com.cognizant.dao.IViewTransactionDAO;
import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;

@Service
@Transactional(readOnly = true)
public class ViewTransactionService implements IViewTransactionService {

	@Autowired
	private IViewTransactionDAO viewTransactionDAO;

	@Autowired
	private IApplicationDAO applicationDAO;

	@Transactional
	@Override
	public List<TransactionDetailsEntity> retreiveTransactionDetails(BigInteger accountNumber,
			BigInteger transactionId) {

		List<TransactionDetailsEntity> transactionDetails = new ArrayList<TransactionDetailsEntity>();

		if (accountNumber != null && transactionId == null) {
			UserDetailsEntity userDetails = applicationDAO.findUserDetails(accountNumber);
			if (userDetails != null) {
				transactionDetails = userDetails.getTransactions();
			}
		} else {
			transactionDetails = viewTransactionDAO.retreiveTransactionDetails(accountNumber, transactionId);
		}
		return transactionDetails;
	}

}
