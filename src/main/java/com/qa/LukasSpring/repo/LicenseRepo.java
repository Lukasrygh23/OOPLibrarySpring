package com.qa.LukasSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.LukasSpring.domain.tLicense;

@Repository
public interface LicenseRepo extends JpaRepository<tLicense, Long> {

}
