package com.bdqn.oa.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.ClaimVoucherService_w;
import com.bdqn.oa.service.IBizCheckResultService;
import com.bdqn.oa.util.Paging;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClaimVoucherAction_w extends ActionSupport {
	private ClaimVoucherService_w vouService;		//service
	private BizClaimVoucher bizClaimVoucher;		//报销单 对象	
	private IBizCheckResultService bizCheckResultService;
	
	private BizCheckResult bizCheckResult;			//审批	--
	private Integer pageNo;							//当前页
	private Integer cvId;							//报销单id
	

	//进入审批 报销单界面
	public String getVoucher(){
			System.out.println("进入进入审批 报销单界面--- ");
			System.out.println(cvId);
			try {
				BizClaimVoucher cv=vouService.getFindVouById(cvId);			//返回报销单
				List<BizCvDetailly> cdList=vouService.getFindAllByVouId(cvId);	//返回报销单明细
				
				BizCheckResult cr=bizCheckResultService.getCrbyid(cv);
				
				HttpServletRequest request=ServletActionContext.getRequest();
				request.setAttribute("cv", cv);
				request.setAttribute("cd", cdList);
				request.setAttribute("cr", cr);
				
			} catch (Exception e) {
			
				e.printStackTrace();
				return "505";
			}
	
			return Action.SUCCESS;
	}
	
	//查询报销单
	public String getVouList(){
		//不提交表单
		if(bizClaimVoucher==null){
			bizClaimVoucher=new BizClaimVoucher();
			this.pageNo=1;
		}
		System.out.println("----------------zwj-----------------");
		System.out.println(bizClaimVoucher.getBegindate());
		System.out.println(pageNo);
		
		
		//获取Session
		Map<String,Object> session=ActionContext.getContext().getSession();
		SysEmployee emp=(SysEmployee) session.get("User");
	
		Paging<BizClaimVoucher> voucher=new Paging<BizClaimVoucher>();	//分页 util
	
		voucher.setT(bizClaimVoucher);					//传对象
		voucher.setCurrentPageNo(pageNo);	//当前页
		voucher.setPageSize(5);				//页大小
		
		try {
			voucher.setTotalCount(vouService.getCount(emp, voucher));	//总数据
			voucher.setList(vouService.getFingVouByVou(emp, voucher));	//集合
			
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("pcv", voucher);
		
		return Action.SUCCESS;
	}
	
	
	
	//新增审核信息
	public String saveCheckResult(){
	
		try {
			//获取Session
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee emp=(SysEmployee) session.get("User");
		
			
			bizCheckResult.setCheckDate(new Date());			//获取当前时间
			bizCheckResult.setBizClaimVoucher(bizClaimVoucher);	//审核的报销单
			bizCheckResult.setSysEmployee(emp);					//审核人
			
			vouService.saveCheckResult(bizCheckResult);
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
		return Action.SUCCESS;
	}
	
	
	public ClaimVoucherService_w getVouService() {
		return vouService;
	}
	public void setVouService(ClaimVoucherService_w vouService) {
		this.vouService = vouService;
	}
	public BizClaimVoucher getBizClaimVoucher() {
		return bizClaimVoucher;
	}
	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getCvId() {
		return cvId;
	}

	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}

	public BizCheckResult getBizCheckResult() {
		return bizCheckResult;
	}

	public void setBizCheckResult(BizCheckResult bizCheckResult) {
		this.bizCheckResult = bizCheckResult;
	}

	public IBizCheckResultService getBizCheckResultService() {
		return bizCheckResultService;
	}

	public void setBizCheckResultService(IBizCheckResultService bizCheckResultService) {
		this.bizCheckResultService = bizCheckResultService;
	}
	
	
	

	
	
}
