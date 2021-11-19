package com.qa.LukasSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.LukasSpring.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM t_license WHERE book_book_id = ?1", nativeQuery = true)
	void deleteLicenseById(Long id);
}
