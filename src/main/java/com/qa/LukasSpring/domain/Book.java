package com.qa.LukasSpring.domain;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		
		
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
