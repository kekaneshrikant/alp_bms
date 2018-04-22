package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.entity.UserDetailsEntity;
import com.cognizant.service.IPerformTransactionService;
import com.cognizant.vo.TransactionVO;

@RestController
public class PerformTransactionController {

	@Autowired
	private IPerformTransactionService performTransactionService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> initiateTransaction(@RequestBody TransactionVO transactionVO) {

		UserDetailsEntity userDetailsEntity = performTransactionService.findUserDetails(transactionVO.getAccountNumber());
		
		if(userDetailsEntity != null) {
			TransactionDetailsEntity transactionDetailsEntity = new TransactionDetailsEntity();
			transactionDetailsEntity.setTransactionDescription(transactionVO.getDescription());
			transactionDetailsEntity.setTransactionId(transactionVO.getTransactionId());
			transactionDetailsEntity.setTransactionType(transactionVO.getTransactionType());
			if(transactionDetailsEntity.getTransactionType().equals("Deposit")) {
				transactionDetailsEntity.setAccountBalance(transactionVO.getTransactionAmount());
			} else if(transactionDetailsEntity.getTransactionType().equals("Withdrawal")) {
				transactionDetailsEntity.setAccountBalance(transactionVO.getTransactionAmount() * -1); // Negates the original positive value as it is Withdrawal.
			}
			
			transactionDetailsEntity.setAccountNumber(userDetailsEntity);
			Double updatedBalance = performTransactionService.updateTransactionDetails(transactionDetailsEntity);
			return ResponseEntity.ok().body(updatedBalance);
		} else {
			return ResponseEntity.ok().body(null);
		}
	}
}
