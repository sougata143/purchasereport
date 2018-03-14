package com.sougata.purchasereport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.SupplierMaster;

@Repository
public interface SupplierMaserRepository extends JpaRepository<SupplierMaster, String>{
	
	Optional<SupplierMaster> findById(String id);

}
