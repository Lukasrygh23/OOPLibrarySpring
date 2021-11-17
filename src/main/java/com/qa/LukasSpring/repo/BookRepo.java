package com.qa.LukasSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.LukasSpring.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

}
