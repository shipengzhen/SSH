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

	//������
	private IBizClaimVoucherService bizClaimVoucherService;	//������
	private IBizCvDetaillyService bizCvDetaillyService;		//��ϸ
	
	private BizClaimVoucher bizClaimVoucher;			//������
	private List<BizCvDetailly> bizCvDetailly;			//��������ϸ����
	
	private Integer pageNo;								//��ǰҳ
	private Integer cvId;								//������id
	private Integer cdId;								//��������ϸid
	
	//ͨ��ajax ɾ����������ϸ
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
	
	
	//Ա���޸ı����� ��ϸ
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
	
	
	//����--�鿴������
	public String updateCv(){
		System.out.println("�����޸ı�����");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			BizClaimVoucher bcv= bizClaimVoucherService.findbycv(cvId);		//����������							
			request.setAttribute("cv",bcv);
			request.setAttribute("cd",bizCvDetaillyService.findscdByid(bcv));//���� ��ϸ
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	
	//�鿴������
	public String selectCv(){
		System.out.println("����鿴������");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			BizClaimVoucher bcv= bizClaimVoucherService.findbycv(cvId);		//����������							
			request.setAttribute("cv",bcv);
			request.setAttribute("cd",bizCvDetaillyService.findscdByid(bcv));//���� ��ϸ
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}
	
	//����������
	public String addcxd(){
		System.out.println("-----------��������������----------");

		Map<String,Object> session=ActionContext.getContext().getSession();
		bizClaimVoucher.setSysEmployeeByProposerEid((SysEmployee)session.get("User"));	//������

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
	//��ѯ������ ��ҳ
	public String findAllfy(){
		
		if(bizClaimVoucher==null){
			bizClaimVoucher=new BizClaimVoucher();
			this.pageNo=1;
		}
		
		Paging<BizClaimVoucher> pcv=new Paging<BizClaimVoucher>();
		Map<String,Object> session=ActionContext.getContext().getSession();
		
		System.out.println("-------------------�����ѯ ������---------------------");
		pcv.setT(bizClaimVoucher);
		
		pcv.setCurrentPageNo(pageNo);			//��ǰҳ
		pcv.setPageSize(5);						//ҳ��С
		
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
