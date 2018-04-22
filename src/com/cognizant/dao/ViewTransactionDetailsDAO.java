package com.cognizant.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.TransactionDetailsEntity;

@Repository
public class ViewTransactionDetailsDAO implements IViewTransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionDetailsEntity> retreiveTransactionDetails(BigInteger accountNumber,
			BigInteger transactionId) {
		Session session = sessionFactory.getCurrentSession();
		List<TransactionDetailsEntity> resultList = new ArrayList<TransactionDetailsEntity>();
		Query<TransactionDetailsEntity> namedQuery;
		if (accountNumber == null && transactionId != null) {
			namedQuery = session.createNamedQuery("getTransactionsByTransactionId");
			namedQuery.setParameter("transactionId", transactionId);
			resultList = namedQuery.getResultList();
		} else {
			namedQuery = session.createNamedQuery("getTransactionsByTransactionIdAndAccountNumber");
			namedQuery.setParameter("accNumber", accountNumber);
			namedQuery.setParameter("transactionId", transactionId);
			resultList = namedQuery.getResultList();
		}
		return resultList;
	}

}
