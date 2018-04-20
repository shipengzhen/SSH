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
	//下载文件的文件名
	private String fileName;
	//读取下载文件的输入流
	//	private InputStream inputStream;
	//下载文件的类型
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
/*		//创建一个File对象
		File file=new File(fileName);
		//通过读取File对象创建输入流
		inoutStream=new FileInputStream(file) ;
		//得到实际的文件名称
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
