package com.vnc.nextuple.controller;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.nextuple.dto.UserAccountDto;
import com.vnc.nextuple.entity.UserAccount;
import com.vnc.nextuple.helper.WalletTransactionHelper;
import com.vnc.nextuple.serviceImpl.UserAccountServiceImpl;

@RestController
public class UserAccountController {

	@Autowired
	UserAccountServiceImpl userAccountServiceImpl;

	/**
	 * 
	 * for creating of new User
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void userCreate(@RequestBody UserAccountDto userDto) {
		UserAccount user = new UserAccount();
		BeanUtils.copyProperties(userDto, user);
		userAccountServiceImpl.userCreate(user);

	}

	/**
	 * 
	 * For getting all Users details
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Iterable<UserAccount> getAllUsers() {

		return userAccountServiceImpl.getAllUsers();
	}

	/**
	 * 
	 * for creating json format statement
	 * 
	 */
	@RequestMapping(value = "/user/statement", method = RequestMethod.POST)
	public UserAccount createWalletStatement(@RequestBody WalletTransactionHelper walletTransactionHelper) {

		return userAccountServiceImpl.createWalletStatement(walletTransactionHelper);
	}

	/**
	 * 
	 * for changing status of user
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public void deleteUser(@PathVariable("userId") String userId) {

		userAccountServiceImpl.deleteUser(userId);
	}

	/**
	 * 
	 * 
	 * for updating of user
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	public UserAccount updateUser(@RequestBody UserAccount userAccount, @PathVariable("userId") String userId) {

		return userAccountServiceImpl.updateUser(userAccount, userId);
	}

}
