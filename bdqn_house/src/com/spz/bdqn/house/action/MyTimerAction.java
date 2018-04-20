package com.spz.bdqn.house.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MyTimerAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("Ö´ÐÐActionÒµÎñ");
		return SUCCESS;
	}

}
