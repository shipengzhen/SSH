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
		System.out.println("hobbies的长度是"+hobbies.size());
		for(int i=0;i<hobbies.size();i++){
			System.out.println("hobbies数组中第"+i+"个元素是："+hobbies.get(i));
		}
		System.out.println("numbers的长度是"+numbers.size());
		for(int i=0;i<numbers.size();i++){
			System.out.println("numbers数组中第"+i+"个元素是："+numbers.get(i));
		}
		System.out.println("users的长度是"+users.size());
		for(int i=0;i<users.size();i++){
			System.out.println("users数组中第"+i+"个元素是："+users.get(i).getName());
		}
		return SUCCESS;
	}

}
