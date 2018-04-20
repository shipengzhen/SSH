package com.spz.bdqn.house.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spz.bdqn.house.entity.User;
import java.util.*;

@SuppressWarnings("serial")
public class ListDataTransferAction extends ActionSupport {
	private List<String> hobbies;
	private List<Double> numbers;
	private List<User> users;
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Double> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String execute(){
		System.out.println("hobbies�ĳ�����"+hobbies.size());
		for(int i=0;i<hobbies.size();i++){
			System.out.println("hobbies�����е�"+i+"��Ԫ���ǣ�"+hobbies.get(i));
		}
		System.out.println("numbers�ĳ�����"+numbers.size());
		for(int i=0;i<numbers.size();i++){
			System.out.println("numbers�����е�"+i+"��Ԫ���ǣ�"+numbers.get(i));
		}
		System.out.println("users�ĳ�����"+users.size());
		for(int i=0;i<users.size();i++){
			System.out.println("users�����е�"+i+"��Ԫ���ǣ�"+users.get(i).getName());
		}
		return SUCCESS;
	}

}
