package com.sougata.purchasereport.repository.customrepositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ItemMaster;
import com.sougata.purchasereport.repository.customrepository.ItemMasterCustomRepository;



@Transactional
@Repository
public class ItemMasterRepositoryImpl implements ItemMasterCustomRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ItemMaster> getAllItem() {
		String hql = "From ItemMaster as itemmaster ORDER BY itemmaster.id";
		return (List<ItemMaster>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public ItemMaster findByGroupCode(String groupCode) {
//		String hql = "From ItemMaster as itemmaster ORDER BY itemmaster.id";
		return entityManager.find(ItemMaster.class, groupCode);
	}
	
	

}
