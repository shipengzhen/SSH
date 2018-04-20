package com.bdqn.oa.service.impl;

import com.bdqn.oa.dao.IBizCheckResultDao;
import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.service.IBizCheckResultService;

public class BizCheckResultServiceImpl implements IBizCheckResultService {

	
	private IBizCheckResultDao bizCheckResultDao;
	
	//通过Id 查最新的 报销单审核
	@Override
	public BizCheckResult getCrbyid(BizClaimVoucher cv) {
		
		return bizCheckResultDao.findCRById(cv);
	}

	
	
	public IBizCheckResultDao getBizCheckResultDao() {
		return bizCheckResultDao;
	}

	public void setBizCheckResultDao(IBizCheckResultDao bizCheckResultDao) {
		this.bizCheckResultDao = bizCheckResultDao;
	}

	
	
}
