package com.trms.requests;

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

import com.trms.users.User;

@XmlRootElement
@Entity
@Table(name = "USER_REQUESTS")
public class Request {

	@Id
	@SequenceGenerator(name = "REQUEST_ID_SEQ", sequenceName = "REQUEST_ID_SEQ")
	@GeneratedValue(generator = "REQUEST_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "AMOUNT_REQUEST")
	private double amountRequested;
	
	@Column(name = "AMOUNT_PAID")
	private double amountPaid;
	
	@Column
	private boolean approved;
	
	@ManyToOne
	@Column(nullable = true)
	private User user;
	
	@Column(name = "REQ_DATE")
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
