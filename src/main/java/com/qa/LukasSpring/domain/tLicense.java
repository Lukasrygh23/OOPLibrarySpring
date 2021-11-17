package com.qa.LukasSpring.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class tLicense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long licenseId;
	
	@Column(name = "recipient_username")
	private String recipientUsername;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	@ManyToOne
	private Book book;
	
	public tLicense() {}

	/**
	 * @param recipientUsername
	 * @param returnDate
	 */
	public tLicense(String recipientUsername, Date returnDate) {
		super();
		this.recipientUsername = recipientUsername;
		this.returnDate = returnDate;
	}

	/**
	 * @param licenseId
	 * @param recipientUsername
	 * @param returnDate
	 */
	public tLicense(Long licenseId, String recipientUsername, Date returnDate) {
		super();
		this.licenseId = licenseId;
		this.recipientUsername = recipientUsername;
		this.returnDate = returnDate;
	}

	public Long getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}

	public String getRecipientUsername() {
		return recipientUsername;
	}

	public void setRecipientUsername(String recipientUsername) {
		this.recipientUsername = recipientUsername;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licenseId == null) ? 0 : licenseId.hashCode());
		result = prime * result + ((recipientUsername == null) ? 0 : recipientUsername.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tLicense other = (tLicense) obj;
		

		if (licenseId != other.licenseId)
			return false;
		
		if (recipientUsername == null ) {
			if (other.recipientUsername != null)
				return false;
		} else if (!recipientUsername.equals(other.recipientUsername))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if(!returnDate.equals(other.returnDate))
			return false;
		
		return true;}

}
