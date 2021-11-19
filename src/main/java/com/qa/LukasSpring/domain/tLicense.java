package com.qa.LukasSpring.domain;

import java.sql.Date;
import java.util.Objects;

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

	public tLicense() {
	}

	/**
	 * @param recipientUsername
	 * @param returnDate
	 */
	public tLicense(String recipientUsername, Date returnDate, Book book) {
		super();
		this.recipientUsername = recipientUsername;
		this.returnDate = returnDate;
		this.book = book;
	}

	/**
	 * @param licenseId
	 * @param recipientUsername
	 * @param returnDate
	 * @param book
	 */

	public tLicense(Long licenseId, String recipientUsername, Date returnDate, Book book) {
		super();
		this.licenseId = licenseId;
		this.recipientUsername = recipientUsername;
		this.returnDate = returnDate;
		this.book = book;
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

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(licenseId, recipientUsername, returnDate, book);
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

		return Objects.equals(licenseId, other.licenseId) && Objects.equals(recipientUsername, other.recipientUsername)
				&& Objects.equals(returnDate, other.returnDate) && Objects.equals(book, other.book);

	}

}
