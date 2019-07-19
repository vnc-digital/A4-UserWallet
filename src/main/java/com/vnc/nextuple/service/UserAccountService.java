package com.vnc.nextuple.service;

import com.vnc.nextuple.entity.UserAccount;
import com.vnc.nextuple.helper.WalletTransactionHelper;

public interface UserAccountService {

	String findFirstByOrderByUserIdDesc();

	void userCreate(UserAccount user);

	UserAccount createWalletStatement(WalletTransactionHelper walletTransactionHelper);

	UserAccount findByUserId(String userId);

	Iterable<UserAccount> getAllUsers();

	UserAccount findByMobileNoAndPassword(long mobileNo, String password);

	void deleteUser(String userId);

	UserAccount updateUser(UserAccount userAccount, String userId);

}
