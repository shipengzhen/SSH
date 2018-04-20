package com.bdqn.oa.service.impl;

import java.util.List;

import com.bdqn.oa.dao.IBizCvDetaillyDao;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.service.IBizCvDetaillyService;

public class BizCvDetaillyServiceImpl implements IBizCvDetaillyService {

	private IBizCvDetaillyDao bizCvDetaillyDao;
	//ͨ��id��ѯ
	@Override
	public void delCd(Integer id) {
		bizCvDetaillyDao.deleteById(id);
		
	}


	
	//���ڱ����� ��ϸ  ���
	@Override
	public void addCvd(List<BizCvDetailly> cvdList) {
		
		bizCvDetaillyDao.saveCvd(cvdList);
	}

	//ͨ������ id��ѯ��ϸ
	@Override
	public List<BizCvDetailly> findscdByid(BizClaimVoucher cv) {
	
		return bizCvDetaillyDao.findAllBybid(cv);
	}

	
	
	
	public IBizCvDetaillyDao getBizCvDetaillyDao() {
		return bizCvDetaillyDao;
	}

	public void setBizCvDetaillyDao(IBizCvDetaillyDao bizCvDetaillyDao) {
		this.bizCvDetaillyDao = bizCvDetaillyDao;
	}





	
	
}
