package com.sougata.purchasereport.repository.customrepositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.purchasereport.entity.ScmPoHdr;
import com.sougata.purchasereport.repository.customrepository.ScmPoHdrCustomRepository;

@Transactional
@Repository
public class ScmPoHdrRepositoryImpl implements ScmPoHdrCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ScmPoHdr getScmPoHdrById(String Id) {
	return entityManager.find(ScmPoHdr.class, Id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ScmPoHdr> getAllScmPoHdr() {
	String hql = "FROM ScmPoHdr as scmpohdr ORDER BY scmpohdr.id";
	return (List<ScmPoHdr>) entityManager.createQuery(hql).getResultList();
    }

//	@Override
//	public ScmPoHdr getScmPoHdrByPoType(String poType) {
//		return entityManager.find(ScmPoHdr.class, poType);
//	}

    
//	@Override
//	public List<ScmPoHdr> getScmPoHdrByPoType(String poType) {
//		String hql = "select * from ScmPoHdr scmpohdr where scmpohdr.poType=:poType";
//		return (List<ScmPoHdr>) entityManager.createQuery(hql).getResultList();
//	}

	
	@Override
	public ScmPoHdr getScmPoHdrByPoType(String poType) {
		String hql = "from ScmPoHdr scmpohdr where scmpohdr.poType=:poType";
		return  (ScmPoHdr) entityManager.createQuery(hql).getResultList();
	}

	

}
