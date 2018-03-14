package com.sougata.purchasereport.repository.customrepository;

import java.util.List;

import com.sougata.purchasereport.entity.ScmPoLineItem;

public interface ScmPoLineItemCustomRepository {

	ScmPoLineItem getScmPoLineItemById(Long Id);
	List<ScmPoLineItem> getScmPoLineItemByIndentNo(String indentno);

//    boolean axialFanExists(String userName, String password);

   /* void deleteAxialFan(Long userId);

    void updateAxialFan(AxialFan activity);

    void addAxialFan(AxialFan activity);
    
    */

    List<ScmPoLineItem> getAllScmPoLineItem();

}
