package com.sougata.purchasereport.component;

import java.util.Optional;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sougata.purchasereport.entity.SupplierMaster;
import com.sougata.purchasereport.repository.SupplierMaserRepository;

@Component
public class SupplierMasterDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierMasterDao.class);
    @Autowired
    DataSource dataSource;
    
    @Autowired
    SupplierMaserRepository suppliermasterRepository;

	@Transactional
	public Optional<SupplierMaster> getSupplierMasterById(String Id) {

		return suppliermasterRepository.findById(Id);
	}

}
