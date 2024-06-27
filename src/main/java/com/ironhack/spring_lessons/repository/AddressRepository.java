package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
