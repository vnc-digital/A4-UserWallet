package com.vnc.nextuple.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vnc.nextuple.entity.WalletTransaction;

@Repository
public interface WalletTransactionRepository extends CrudRepository<WalletTransaction, String> {

}
