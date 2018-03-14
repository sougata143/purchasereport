package com.sougata.purchasereport.repository.customrepository;

import java.util.List;

import com.sougata.purchasereport.entity.JuteGateEntryHdr;

public interface JuteGateEntryHdrCustomRepository {
	List<JuteGateEntryHdr> getJuteGateEntryHdrByPoNo(String Id);
}
