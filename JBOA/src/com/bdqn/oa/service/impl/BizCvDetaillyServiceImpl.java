package com.bdqn.oa.service.impl;

import java.util.List;

import com.bdqn.oa.dao.IBizCvDetaillyDao;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.service.IBizCvDetaillyService;

public class BizCvDetaillyServiceImpl implements IBizCvDetaillyService {

	private IBizCvDetaillyDao bizCvDetaillyDao;
	//通过id查询
	@Override
	public void delCd(Integer id) {
		bizCvDetaillyDao.deleteById(id);
		
	}


	
	//现在报销单 明细  多个
	@Override
	public void addCvd(List<BizCvDetailly> cvdList) {
		
		bizCvDetaillyDao.saveCvd(cvdList);
	}

	//通过报单 id查询明细
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
