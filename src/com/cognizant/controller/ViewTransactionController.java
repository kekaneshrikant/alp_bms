package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.TransactionDetailsEntity;
import com.cognizant.service.IViewTransactionService;
import com.cognizant.vo.TransactionVO;

@RestController
public class ViewTransactionController {

	@Autowired
	private IViewTransactionService viewTransactionService;

	@RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDetailsEntity>> searchUserTransactions(
			@RequestBody TransactionVO transactionVO) {
		List<TransactionDetailsEntity> transactionDetails = viewTransactionService
				.retreiveTransactionDetails(transactionVO.getAccountNumber(), transactionVO.getTransactionId());
		return ResponseEntity.ok().body(transactionDetails);
	}

}
