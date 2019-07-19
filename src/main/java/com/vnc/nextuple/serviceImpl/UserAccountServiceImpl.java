package com.vnc.nextuple.serviceImpl;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.nextuple.entity.UserAccount;
import com.vnc.nextuple.helper.WalletTransactionHelper;
import com.vnc.nextuple.repository.UserAccountRepository;
import com.vnc.nextuple.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	public static final String ACTIVE_STATUS_YES = "YES";
	public static final String ACTIVE_STATUS_NO = "NO";
	public static final String USER_NOT_AVAILABLE_EXCEPTION = "user is not available";
	public static final String MOBILE_PASSSWORD_DIDNOT_MATCH_EXCEPTION = "Mobile Number and Password did not match";

	@Autowired
	UserAccountRepository userAccountRepository;

	@Override
	public String findFirstByOrderByUserIdDesc() {
		UserAccount userLast = userAccountRepository.findFirstByOrderByUserIdDesc();
		String userNextId = null;
		if (userLast == null) {
			userNextId = "UB00001";
		} else {
			String userLastId = userLast.getUserId();
			int userIntId = Integer.parseInt(userLastId.substring(2));
			userIntId += 1;
			userNextId = "UB" + String.format("%05d", userIntId);
		}
		return userNextId;
	}

	@Override
	public void userCreate(UserAccount userAccount) {
		userAccount.setUserId(findFirstByOrderByUserIdDesc());
		userAccount.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		userAccount.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		userAccount.setActiveStatus(ACTIVE_STATUS_YES);
		userAccountRepository.save(userAccount);

	}

	@Override
	public UserAccount findByUserId(String userId) {
		return userAccountRepository.findByUserId(userId);
	}

	@Override
	public Iterable<UserAccount> getAllUsers() {
		return userAccountRepository.findAll();
	}

	@Override
	public UserAccount findByMobileNoAndPassword(long mobileNo, String password) {
		return userAccountRepository.findByMobileNoAndPassword(mobileNo, password);
	}

	@Override
	public UserAccount createWalletStatement(WalletTransactionHelper walletTransactionHelper) {
		UserAccount userAccount = findByMobileNoAndPassword(walletTransactionHelper.getMobileNo(),
				walletTransactionHelper.getPassword());
		if (userAccount == null) {
			throw new RuntimeException(MOBILE_PASSSWORD_DIDNOT_MATCH_EXCEPTION);
		}

		return userAccount;
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {

		UserAccount userAccount = findByUserId(userId);
		if (userAccount == null) {
			throw new RuntimeException(USER_NOT_AVAILABLE_EXCEPTION);

		}
		userAccount.setActiveStatus(ACTIVE_STATUS_NO);
		userAccount.setDeletedDate(new Timestamp(System.currentTimeMillis()));
		userAccountRepository.save(userAccount);

	}

	@Override
	public UserAccount updateUser(UserAccount userAccount, String userId) {
		UserAccount userAccountInfo = findByUserId(userId);
		if (userAccount == null) {
			throw new RuntimeException(USER_NOT_AVAILABLE_EXCEPTION);

		}
		userAccount.setActiveStatus(userAccountInfo.getActiveStatus());
		userAccount.setUserId(userAccountInfo.getUserId());
		userAccount.setWalletAmount(userAccountInfo.getWalletAmount());
		userAccount.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		userAccountRepository.save(userAccount);
		return userAccount;

	}

}
