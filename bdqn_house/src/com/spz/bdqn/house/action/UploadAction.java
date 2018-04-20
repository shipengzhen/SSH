package com.spz.bdqn.house.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @���� ���ļ��ϴ�
 * @���� ʩ����
 * @�������� 2017��12��21��
 * @����ʱ�� ����11:10:35
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	//��װ�ļ���������
	private String title;
	//��װ�ϴ��ļ�����
	private File upload;
	//��ȡ�ύ���ļ�����
	private String uploadContentType;
	//��װ�ϴ��ļ�����
	private String uploadFileName;
	//��ȡ�ļ��ϴ���·��
	private String savePath;
	
	

	
	@Override
	public String execute() throws Exception {
		byte[] buffer=new byte[1024];
		FileInputStream fis=new FileInputStream(this.getUpload());
		FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+this.getUploadFileName());
		int length=fis.read(buffer);
		while (length>0) {
			//ÿ��д��length���ȵ�����
			fos.write(buffer,0, length);
			length=fis.read(buffer);
		}	
		fis.close();
		fos.flush();
		fos.close();
		return SUCCESS;
	}
	
	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
