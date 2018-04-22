package com.cognizant.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;

@Repository
public class ApplicationDAO implements IApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Double updateTransactionDetails(TransactionDetailsEntity transactionDetailsEntity) {
		sessionFactory.getCurrentSession().save(transactionDetailsEntity);
		Double updatedBalance = getUpdatedBalance(transactionDetailsEntity.getAccountNumber().getAccountNumber());
		UserDetailsEntity userDetailsEntity = transactionDetailsEntity.getAccountNumber();
		userDetailsEntity.setAccountBalance(updatedBalance.intValue());
		sessionFactory.getCurrentSession().save(userDetailsEntity);
		return updatedBalance;
	}

	/**
	 * Returns the updated Balance for the provided Bank Account Number.
	 * @param accountNumber The 16 digit account number against which the balance updates will be made.
	 * @return Returns the updated balance for the specified account.
	 */
	private Double getUpdatedBalance(final BigInteger accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<TransactionDetailsEntity> namedQuery = session.createNamedQuery("getTransactionsByAccountNumber");
		namedQuery.setParameter("accNumber", accountNumber);
		List<TransactionDetailsEntity> resultList = namedQuery.getResultList();
		Double updatedBalance = 0.0;
		for (TransactionDetailsEntity transactionDetailsEntity : resultList) {
			updatedBalance += transactionDetailsEntity.getAccountBalance();
		}
		return updatedBalance;
	}

	@Override
	public UserDetailsEntity findUserDetails(final BigInteger accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<UserDetailsEntity> namedQuery = session.createNamedQuery("getUserDetailsByAccountNumber");
		namedQuery.setParameter("accountNumber", accountNumber);
		UserDetailsEntity singleResult = namedQuery.getSingleResult();
		return singleResult;
	}
}
