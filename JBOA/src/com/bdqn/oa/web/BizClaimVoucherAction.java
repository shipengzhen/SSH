package com.bdqn.oa.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.IBizClaimVoucherService;
import com.bdqn.oa.service.IBizCvDetaillyService;
import com.bdqn.oa.util.Paging;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BizClaimVoucherAction extends ActionSupport {

	//报销单
	private IBizClaimVoucherService bizClaimVoucherService;	//报销单
	private IBizCvDetaillyService bizCvDetaillyService;		//明细
	
	private BizClaimVoucher bizClaimVoucher;			//报销单
	private List<BizCvDetailly> bizCvDetailly;			//报销单明细集合
	
	private Integer pageNo;								//当前页
	private Integer cvId;								//报销单id
	private Integer cdId;								//报销单明细id
	
	//通过ajax 删除报销单明细
	public String delCd(){
		System.out.println("ajax");
		try {
			bizCvDetaillyService.delCd(cdId);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	//员工修改报销单 明细
	public String updateCvd(){
		try {
			bizClaimVoucher.getBizCvDetaillies().addAll(bizCvDetailly);
			bizClaimVoucherService.updateCVD(bizClaimVoucher);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	//进入--查看报销单
	public String updateCv(){
		System.out.println("进入修改报销单");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			BizClaimVoucher bcv= bizClaimVoucherService.findbycv(cvId);		//报销单对象							
			request.setAttribute("cv",bcv);
			request.setAttribute("cd",bizCvDetaillyService.findscdByid(bcv));//返回 明细
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	
	//查看报销单
	public String selectCv(){
		System.out.println("进入查看报销单");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			BizClaimVoucher bcv= bizClaimVoucherService.findbycv(cvId);		//报销单对象							
			request.setAttribute("cv",bcv);
			request.setAttribute("cd",bizCvDetaillyService.findscdByid(bcv));//返回 明细
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	
	//新增报销单
	public String addcxd(){
		System.out.println("-----------进入新增报销单----------");

		Map<String,Object> session=ActionContext.getContext().getSession();
		bizClaimVoucher.setSysEmployeeByProposerEid((SysEmployee)session.get("User"));	//创建人

		try {
			bizClaimVoucherService.addCv(bizClaimVoucher);
			
			for (BizCvDetailly bizCvDetailly2 : bizCvDetailly) {
				bizCvDetailly2.setBizClaimVoucher(bizClaimVoucher);
			}
			
			bizCvDetaillyService.addCvd(bizCvDetailly);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	//查询报销单 分页
	public String findAllfy(){
		
		if(bizClaimVoucher==null){
			bizClaimVoucher=new BizClaimVoucher();
			this.pageNo=1;
		}
		
		Paging<BizClaimVoucher> pcv=new Paging<BizClaimVoucher>();
		Map<String,Object> session=ActionContext.getContext().getSession();
		
		System.out.println("-------------------进入查询 报销单---------------------");
		pcv.setT(bizClaimVoucher);
		
		pcv.setCurrentPageNo(pageNo);			//当前页
		pcv.setPageSize(5);						//页大小
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		pcv.setList(bizClaimVoucherService.findCvfy(pcv,(SysEmployee)session.get("User")));
		
		
		try {
			request.setAttribute("pcv",pcv);
			request.setAttribute("cv",bizClaimVoucher);
			
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
	
		return Action.SUCCESS;
	}

	
	
	
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public BizClaimVoucher getBizClaimVoucher() {
		return bizClaimVoucher;
	}
	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}
	public IBizClaimVoucherService getBizClaimVoucherService() {
		return bizClaimVoucherService;
	}
	public void setBizClaimVoucherService(IBizClaimVoucherService bizClaimVoucherService) {
		this.bizClaimVoucherService = bizClaimVoucherService;
	}
	public List<BizCvDetailly> getBizCvDetailly() {
		return bizCvDetailly;
	}
	public void setBizCvDetailly(List<BizCvDetailly> bizCvDetailly) {
		this.bizCvDetailly = bizCvDetailly;
	}
	public IBizCvDetaillyService getBizCvDetaillyService() {
		return bizCvDetaillyService;
	}
	public void setBizCvDetaillyService(IBizCvDetaillyService bizCvDetaillyService) {
		this.bizCvDetaillyService = bizCvDetaillyService;
	}
	public Integer getCvId() {
		return cvId;
	}
	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}


	public Integer getCdId() {
		return cdId;
	}


	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}	
	
	
}
