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
	private BizClaimVoucher bizClaimVoucher;		//������ ����	
	private IBizCheckResultService bizCheckResultService;
	
	private BizCheckResult bizCheckResult;			//����	--
	private Integer pageNo;							//��ǰҳ
	private Integer cvId;							//������id
	

	//�������� ����������
	public String getVoucher(){
			System.out.println("����������� ����������--- ");
			System.out.println(cvId);
			try {
				BizClaimVoucher cv=vouService.getFindVouById(cvId);			//���ر�����
				List<BizCvDetailly> cdList=vouService.getFindAllByVouId(cvId);	//���ر�������ϸ
				
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
	
	//��ѯ������
	public String getVouList(){
		//���ύ��
		if(bizClaimVoucher==null){
			bizClaimVoucher=new BizClaimVoucher();
			this.pageNo=1;
		}
		System.out.println("----------------zwj-----------------");
		System.out.println(bizClaimVoucher.getBegindate());
		System.out.println(pageNo);
		
		
		//��ȡSession
		Map<String,Object> session=ActionContext.getContext().getSession();
		SysEmployee emp=(SysEmployee) session.get("User");
	
		Paging<BizClaimVoucher> voucher=new Paging<BizClaimVoucher>();	//��ҳ util
	
		voucher.setT(bizClaimVoucher);					//������
		voucher.setCurrentPageNo(pageNo);	//��ǰҳ
		voucher.setPageSize(5);				//ҳ��С
		
		try {
			voucher.setTotalCount(vouService.getCount(emp, voucher));	//������
			voucher.setList(vouService.getFingVouByVou(emp, voucher));	//����
			
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("pcv", voucher);
		
		return Action.SUCCESS;
	}
	
	
	
	//���������Ϣ
	public String saveCheckResult(){
	
		try {
			//��ȡSession
			Map<String,Object> session=ActionContext.getContext().getSession();
			SysEmployee emp=(SysEmployee) session.get("User");
		
			
			bizCheckResult.setCheckDate(new Date());			//��ȡ��ǰʱ��
			bizCheckResult.setBizClaimVoucher(bizClaimVoucher);	//��˵ı�����
			bizCheckResult.setSysEmployee(emp);					//�����
			
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
