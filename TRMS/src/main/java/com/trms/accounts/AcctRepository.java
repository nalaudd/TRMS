package com.trms.accounts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trms.users.User;

@Repository
public interface AcctRepository extends CrudRepository<Account, Long> {
	
	/**
	 * get account by user id
	 * @param user id
	 * @return account
	 */
	Account findByUser_Id(long id);
	
	/**
	 * make a deposit to an account
	 * @param account id
	 * @param deposit
	 */
	@Transactional
	@Modifying
	@Query("update Account acct set acct.deposit = (acct.deposit + :amount) where acct.id = :id")
	void deposit(@Param("id") long id, @Param("amount") double amount);
	
	/**
	 * make a withdrawal from an account
	 * @param account id
	 * @param deposit
	 */
	@Transactional
	@Modifying
	@Query("update Account acct set acct.deposit = (acct.deposit - :amount) where acct.id = :id")
	void withdraw(@Param("id") long id, @Param("amount") double amount);
	
	
	/**
	 * create new bank account for user
	 * @param user
	 * @param deposit
	 */
	default void createAccount(User user, double deposit) {
		Account acct = new Account();
		acct.setUser(user);
		acct.setDeposit(deposit);
		
		save(acct);
	}

}
