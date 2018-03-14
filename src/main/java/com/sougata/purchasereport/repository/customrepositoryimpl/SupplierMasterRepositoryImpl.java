package com.sougata.purchasereport.repository.customrepositoryimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.SupplierMaster;
import com.sougata.purchasereport.repository.customrepository.SupplierMasterCustomReposiory;

@Transactional
@Repository
public class SupplierMasterRepositoryImpl implements SupplierMasterCustomReposiory {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public SupplierMaster getSuppierMasterById(String Id) {
		
		return entityManager.find(SupplierMaster.class, Id);
	}

}
