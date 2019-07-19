package com.vnc.nextuple.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserAccount {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "mobile_no", unique = true)
	private long mobileNo;

	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "address")
	private String adress;

	@Column(name = "wallet_amount")
	private float walletAmount;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "active_status")
	private String activeStatus;

	@Column(name = "deleted_date")
	private Date deletedDate;

	@JsonIgnore
	@OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
