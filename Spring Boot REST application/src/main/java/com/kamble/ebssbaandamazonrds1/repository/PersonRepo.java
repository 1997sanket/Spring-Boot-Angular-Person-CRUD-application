package com.kamble.ebssbaandamazonrds1.repository;

import com.kamble.ebssbaandamazonrds1.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
