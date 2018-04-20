package com.spz.bdqn.house.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @描述 单文件上传
 * @作者 施鹏振
 * @创建日期 2017年12月21日
 * @创建时间 上午11:10:35
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	//封装文件标题属性
	private String title;
	//封装上传文件属性
	private File upload;
	//获取提交的文件类型
	private String uploadContentType;
	//封装上传文件名称
	private String uploadFileName;
	//获取文件上传的路径
	private String savePath;
	
	

	
	@Override
	public String execute() throws Exception {
		byte[] buffer=new byte[1024];
		FileInputStream fis=new FileInputStream(this.getUpload());
		FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+this.getUploadFileName());
		int length=fis.read(buffer);
		while (length>0) {
			//每次写入length长度的内容
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
