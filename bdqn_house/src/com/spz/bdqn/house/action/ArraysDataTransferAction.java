package com.spz.bdqn.house.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ArraysDataTransferAction extends ActionSupport {
	private String[] hobbies;
	private Double[] numbers=new Double[3];
	
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Double[] getNumbers() {
		return numbers;
	}
	public void setNumbers(Double[] numbers) {
		this.numbers = numbers;
	}
	
	public String execute(){
		System.out.println("hobbies�ĳ�����"+hobbies.length);
		for(int i=0;i<hobbies.length;i++){
			System.out.println("hobbies�����е�"+i+"��Ԫ���ǣ�"+hobbies[i]);
		}
		System.out.println("numbers�ĳ�����"+numbers.length);
		for(int i=0;i<numbers.length;i++){
			System.out.println("numbers�����е�"+i+"��Ԫ���ǣ�"+numbers[i]);
		}
		
		return SUCCESS;
	}
}
