package com.sougata.purchasereport.repository.customrepositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmPoLineItemHist;
import com.sougata.purchasereport.repository.customrepository.ScmPoLineItemHistCustomRepository;

@Transactional
@Repository
public class ScmPoLineItemHistRepositoryImpl implements ScmPoLineItemHistCustomRepository{

	@PersistenceContext
	EntityManager entityManage;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ScmPoLineItemHist> getAllScmPoLineItemHist() {
		String hql = "FROM ScmPoLineItemHist as scmPoLineItemHist ORDER BY scmPoLineItemHist.ammendmentNo";
		return (List<ScmPoLineItemHist>) entityManage.createQuery(hql).getResultList();
	}

}
