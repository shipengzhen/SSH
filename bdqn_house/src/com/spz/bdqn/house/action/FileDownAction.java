package com.spz.bdqn.house.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FileDownAction extends ActionSupport {
	private String inputPath;
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	//�����ļ����ļ���
	private String fileName;
	//��ȡ�����ļ���������
	//	private InputStream inputStream;
	//�����ļ�������
	private String conetntType;
	
	public  InputStream getInputStream() throws FileNotFoundException{
		/*return ServletActionContext
				.getServletContext()
				.getResourceAsStream(inputPath + "\\" + fileName);*/
		String path=ServletActionContext.getServletContext().getRealPath(inputPath);
	return new BufferedInputStream(new FileInputStream(path+"\\"+fileName));

		
	}
	
	
	@Override
	public String execute() throws Exception {
/*		//����һ��File����
		File file=new File(fileName);
		//ͨ����ȡFile���󴴽�������
		inoutStream=new FileInputStream(file) ;
		//�õ�ʵ�ʵ��ļ�����
		fileName=file.getName();
		//
		conetntType=this.getConetntType();*/
		
		return SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
/*	public InputStream getInputStream() {
		return inputStream;
	}*/
	public String getConetntType() {
		return conetntType;
	}
//	public void setInputStream(InputStream inputStream) {
//		this.inputStream = inputStream;
//	}


	public void setConetntType(String conetntType) {
		this.conetntType = conetntType;
	}
}
