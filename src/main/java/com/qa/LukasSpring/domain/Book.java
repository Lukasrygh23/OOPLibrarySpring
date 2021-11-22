package com.qa.LukasSpring.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name = "book_name", nullable = false)
	private String bookName;
	
	//For some reason I can't default to null? I guess it's already default.
	@Column(name = "author_name")
	private String authorName;

	//Default constructor
	public Book() {}

	/**
	 * @param bookName
	 * @param authorName
	 */
	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}

	/**
	 * @param bookId
	 * @param bookName
	 * @param authorName
	 */
	public Book(Long bookId, String bookName, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bookId, bookName, authorName);

	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		

		if (bookId != other.bookId)
			return false;
		
		if (bookName == null ) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if(!authorName.equals(other.authorName))
			return false;
		
		return true;
	}
	
}
