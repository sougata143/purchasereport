package com.sougata.purchasereport.repository.customrepositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.JuteGateEntryHdr;
import com.sougata.purchasereport.repository.customrepository.JuteGateEntryHdrCustomRepository;

@Transactional
@Repository
public class JuteGateEntryHdrRepositoryImpl implements JuteGateEntryHdrCustomRepository {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<JuteGateEntryHdr> getJuteGateEntryHdrByPoNo(String Id) {
		return (List<JuteGateEntryHdr>) entityManager.find(JuteGateEntryHdr.class, Id);
	}

}
