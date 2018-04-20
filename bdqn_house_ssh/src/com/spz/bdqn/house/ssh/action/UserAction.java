/**
 * 
 */
package com.spz.bdqn.house.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.spz.bdqn.house.ssh.entity.User;
import com.spz.bdqn.house.ssh.service.IUserService;

/**
 * @描述 用户控制器
 * @作者 施鹏振
 * @创建日期 2017年12月18日
 * @创建时间 下午1:19:34
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	private static final String CURRENT_USER="user";

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/*@Override
	public void validate() {
		if (user.getPassword().length() > 6) {
			addFieldError("password", "密码不能大于6位");
		}
	}*/
	
	
	//验证用户是否存在
	//方式一
	
	/*private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String checkName(){
		String result = null;
		try {
			if("微笑吧".equals(user.getUsername())){
				result = "<font color='red'>用户名已存在</font>";
			}else{
				result = "<font color='green'>用户名不存在</font>";
			}
			inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	
	//方式二
	private Map<String,Object> list;
	
	public Map<String, Object> getList() {
		return list;
	}
	public void setList(Map<String, Object> list) {
		this.list = list;
	}
	public String checkName(){
		list = new HashMap<String,Object>();
		if("微笑吧".equals(user.getUsername())){
			list.put("isok",true);
		}else{
			list.put("isok",false);
		}
		return SUCCESS;
	}
	
	//登录
	public String dologin() {
		try {
			User user1=userService.findUser(user.getUsername(),user.getPassword());
			if ( user1!= null) {
				// 获取session
				Map<String, Object> session = null;
				session = ActionContext.getContext().getSession();
				// 判断session中是否已有用户对象
				if (session.containsKey(CURRENT_USER)) {
					// 从session中移除已有的用户对象
					session.remove(CURRENT_USER);
				}
				// 将用对象存入session
				session.put(CURRENT_USER, user1);
				// 登录成功，返回“success”
				return Action.SUCCESS;
			} else {
				// 登录失败，返回“error”
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("error", "用户名或密码错误");
				return Action.ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
	}

	
	//注册
	public String register() {
		user.setIsadmin("否");
		if (userService.addUser(user)) {
			return Action.SUCCESS;
		}else {
			return Action.ERROR;
		}
	}
}
