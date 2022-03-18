package com.kamble.ebssbaandamazonrds1.repository;

import com.kamble.ebssbaandamazonrds1.model.ImageModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel, Integer> {

}
