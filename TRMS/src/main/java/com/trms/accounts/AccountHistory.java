package com.trms.accounts;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "ACCT_HISTORY")
public class AccountHistory {
	
	@Id
	@SequenceGenerator(name = "ACCT_HISTORY_ID_SEQ", sequenceName = "ACCT_HISTORY_ID_SEQ")
	@GeneratedValue(generator = "ACCT_HISTORY_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@Column(nullable = true)
	private Account account;
	
	@Column
	private String details;
	
	@Column
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
