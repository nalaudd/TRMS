package com.trms.accounts;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcctHistoryRepository extends CrudRepository<AccountHistory, Long> {
	
	/**
	 * insert new account history record
	 * @param account
	 * @param details
	 */
	default void createAcctHistory(Account account, String details) {
		AccountHistory history = new AccountHistory();
		long millis = System.currentTimeMillis();
		
		history.setDetails(details);
		history.setAccount(account);
		history.setDate(new Date(millis));
		
		save(history);
	} 
	
	/**
	 * get account history based on account id
	 * @return account history
	 */
	List<AccountHistory> findAllByAccount_IdOrderByDateDesc();

}
