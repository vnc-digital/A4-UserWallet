package com.vnc.nextuple.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vnc.nextuple.entity.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

	UserAccount findFirstByOrderByUserIdDesc();

	UserAccount findByUserId(String userId);

	UserAccount findByMobileNoAndPassword(long mobileNo, String password);

}
