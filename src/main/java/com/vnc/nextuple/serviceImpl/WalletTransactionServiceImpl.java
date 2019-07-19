package com.vnc.nextuple.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.nextuple.entity.UserAccount;
import com.vnc.nextuple.entity.WalletTransaction;
import com.vnc.nextuple.helper.WalletTransactionHelper;
import com.vnc.nextuple.repository.WalletTransactionRepository;
import com.vnc.nextuple.service.WalletTransactionService;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService {

	public static final String MOBILE_PASSSWORD_DIDNOT_MATCH_EXCEPTION = "Please check your MobileNo and Password";
	public static final String WALLET_TRANSACTION_CREDIT = "CREDIT";
	public static final String WALLET_TRANSACTION_DEBIT = "DEBIT";
	public static final String WALLET_TRANSACTION_DECUCT_AMOUNT_MSG = "deducted succesfully from your Account";
	public static final String WALLET_TRANSACTION_CREDIT_AMOUNT_MSG = "added succesfully into your Account";
	public static final String WALLET_TRANSACTION_INSUFFIECIENT_BALANCE_EXCEPTION = "you have insufficient balance with anount ";
	@Autowired
	WalletTransactionRepository walletTransactionRepository;

	@Autowired
	UserAccountServiceImpl userAccountServiceImpl;

	@Override
	public String addingMoneyToWallet(WalletTransactionHelper walletTransactionHelper) {

		WalletTransaction walletTransaction = new WalletTransaction();
		String password = walletTransactionHelper.getPassword();
		long mobileNo = walletTransactionHelper.getMobileNo();
		float transactionAmount = walletTransactionHelper.getAmount();
		UserAccount userAccount = userAccountServiceImpl.findByMobileNoAndPassword(mobileNo, password);

		if (userAccount == null) {
			throw new RuntimeException(MOBILE_PASSSWORD_DIDNOT_MATCH_EXCEPTION);

		}

		userAccount.setWalletAmount(userAccount.getWalletAmount() + transactionAmount);
		walletTransaction.setTransactionAmount(transactionAmount);
		walletTransaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
		walletTransaction.setTransactionType(WALLET_TRANSACTION_CREDIT);
		walletTransaction.setUserAccount(userAccount);
		walletTransactionRepository.save(walletTransaction);
		return transactionAmount + WALLET_TRANSACTION_CREDIT_AMOUNT_MSG;
	}

	
	@Override
	public String deductMoneyFromWallet(WalletTransactionHelper walletTransactionHelper) {
		WalletTransaction walletTransaction = new WalletTransaction();
		String password = walletTransactionHelper.getPassword();
		long mobileNo = walletTransactionHelper.getMobileNo();
		float transactionAmount = walletTransactionHelper.getAmount();
		UserAccount userAccount = userAccountServiceImpl.findByMobileNoAndPassword(mobileNo, password);

		if (userAccount == null) {
			throw new RuntimeException(MOBILE_PASSSWORD_DIDNOT_MATCH_EXCEPTION);

		}

		if (userAccount.getWalletAmount() < transactionAmount) {
			throw new RuntimeException(
					WALLET_TRANSACTION_INSUFFIECIENT_BALANCE_EXCEPTION + userAccount.getWalletAmount());

		}

		userAccount.setWalletAmount(userAccount.getWalletAmount() - transactionAmount);
		walletTransaction.setTransactionAmount(transactionAmount);
		walletTransaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
		walletTransaction.setTransactionType(WALLET_TRANSACTION_DEBIT);
		walletTransaction.setUserAccount(userAccount);
		walletTransactionRepository.save(walletTransaction);
		return transactionAmount + WALLET_TRANSACTION_DECUCT_AMOUNT_MSG;
	}

}
