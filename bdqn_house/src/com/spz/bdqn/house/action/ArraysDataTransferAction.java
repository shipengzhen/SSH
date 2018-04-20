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
		System.out.println("hobbies的长度是"+hobbies.length);
		for(int i=0;i<hobbies.length;i++){
			System.out.println("hobbies数组中第"+i+"个元素是："+hobbies[i]);
		}
		System.out.println("numbers的长度是"+numbers.length);
		for(int i=0;i<numbers.length;i++){
			System.out.println("numbers数组中第"+i+"个元素是："+numbers[i]);
		}
		
		return SUCCESS;
	}
}
