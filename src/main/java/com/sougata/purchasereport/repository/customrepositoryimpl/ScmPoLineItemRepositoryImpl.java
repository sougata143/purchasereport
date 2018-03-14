package com.sougata.purchasereport.repository.customrepositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmPoLineItem;
import com.sougata.purchasereport.repository.customrepository.ScmPoLineItemCustomRepository;

@Transactional
@Repository
public class ScmPoLineItemRepositoryImpl implements ScmPoLineItemCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ScmPoLineItem getScmPoLineItemById(Long Id) {
	return entityManager.find(ScmPoLineItem.class, Id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ScmPoLineItem> getAllScmPoLineItem() {
	String hql = "FROM ScmPoLineItem as scmpolineitem ORDER BY scmpolineitem.id";
	return (List<ScmPoLineItem>) entityManager.createQuery(hql).getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
	public List<ScmPoLineItem> getScmPoLineItemByIndentNo(String indentno) {
		String hql = "FROM ScmPoLineItem as scmpolineitem ORDER BY scmpolineitem.indentno";
		return (List<ScmPoLineItem>) entityManager.createQuery(hql).getResultList();
		
	}

	

  /*  @Override
    public void addAxialFan(AxialFan activity) {
	entityManager.merge(activity);
	
    }

    @Override
    public void updateAxialFan(AxialFan activity) {
    	AxialFan activityItem = entityManager.find(AxialFan.class, activity.getId());
    	activityItem.setActivityName(activity.getActivityName());
    	activityItem.setActivityStartDate(activity.getActivityStartDate());
    	activityItem.setActivityEndDate(activity.getActivityEndDate());
    	activityItem.setActivityStatus(activity.getActivityStatus());
    	activityItem.setmodby(activity.getmodby());
    	activityItem.setmodifiedOn(activity.getmodifiedOn());
    	
	       activityItem.setId(activity.getId());
	      entityManager.merge(activityItem);
	//entityManager.flush();
    }

    @Override
    public void deleteAxialFan(Long userId) {
	entityManager.remove(getActivityById(userId));
    }
    
    */

//    @Override
//    public boolean axialFanExists(String userName, String password) {
//	String hql = "FROM User as user WHERE user.userName = ? and user.password = ?";
//	int count = entityManager.createQuery(hql).setParameter(1, userName).setParameter(2, password).getResultList()
//		.size();
//	return count > 0 ? true : false;
//    }

}
