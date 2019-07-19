package com.vnc.nextuple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.nextuple.helper.WalletTransactionHelper;
import com.vnc.nextuple.serviceImpl.UserAccountServiceImpl;
import com.vnc.nextuple.serviceImpl.WalletTransactionServiceImpl;

@RestController
public class WalletTransactionController {

	@Autowired
	WalletTransactionServiceImpl walletTransactionServiceImpl;

	@Autowired
	UserAccountServiceImpl userAccountServiceImpl;

	/**
	 * 
	 * for adding money to wallet
	 */

	@RequestMapping(value = "/wallet/add", method = RequestMethod.POST)
	public String addingMoneyToWallet(@RequestBody WalletTransactionHelper walletTransactionHelper) {

		return walletTransactionServiceImpl.addingMoneyToWallet(walletTransactionHelper);
	}

	/**
	 * 
	 * for deduct money from wallet
	 */
	@RequestMapping(value = "/wallet/deduct", method = RequestMethod.POST)
	public String deductMoneyFromWallet(@RequestBody WalletTransactionHelper walletTransactionHelper) {

		return walletTransactionServiceImpl.deductMoneyFromWallet(walletTransactionHelper);
	}
}
