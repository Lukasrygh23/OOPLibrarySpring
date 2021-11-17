package com.qa.LukasSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.LukasSpring.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}
