package com.sougata.purchasereport.repository.customrepository;

import java.util.List;

import com.sougata.purchasereport.entity.ScmIndentLineItem;

public interface ScmIndentLineItemCustomRepository {

	ScmIndentLineItem getScmIndentLineItemById(int Id);

    boolean axialFanExists(String userName, String password);

   /* void deleteAxialFan(Long userId);

    void updateAxialFan(AxialFan activity);

    void addAxialFan(AxialFan activity);
    
    */

    List<ScmIndentLineItem> getAllScmIndentLineItem();

}
