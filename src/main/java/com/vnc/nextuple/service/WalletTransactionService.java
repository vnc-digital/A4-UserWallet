package com.vnc.nextuple.service;

import com.vnc.nextuple.helper.WalletTransactionHelper;

public interface WalletTransactionService {

	String addingMoneyToWallet(WalletTransactionHelper walletTransactionHelper);

	String deductMoneyFromWallet(WalletTransactionHelper walletTransactionHelper);

}
