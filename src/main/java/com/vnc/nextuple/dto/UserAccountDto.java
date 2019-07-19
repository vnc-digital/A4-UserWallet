package com.vnc.nextuple.dto;

import java.util.Date;

import java.util.List;

import com.vnc.nextuple.entity.WalletTransaction;

public class UserAccountDto {

	private String userId;

	private String userName;

	private String name;

	private long mobileNo;

	private String password;

	private String email;

	private String adress;

	private float walletAmount;

	private Date createdDate;

	private Date updatedDate;

	private String activeStatus;

	private Date deletedDate;

	private List<WalletTransaction> walletTransaction;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public float getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(float walletAmount) {
		this.walletAmount = walletAmount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<WalletTransaction> getWalletTransaction() {
		return walletTransaction;
	}

	public void setWalletTransaction(List<WalletTransaction> walletTransaction) {
		this.walletTransaction = walletTransaction;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

}
