/**
 * 
 */
package com.spz.bdqn.house.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.spz.bdqn.house.entity.User;
import com.spz.bdqn.house.service.IUserService;
import com.spz.bdqn.house.service.impl.UserServiceImpl;

/**
 * @描述 用户控制器
 * @作者 施鹏振
 * @创建日期 2017年12月18日
 * @创建时间 下午1:19:34
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	private IUserService userService = new UserServiceImpl();

	private static final String CURRENT_USER="user";

	private String isnext;

	public String getIsnext() {
		return isnext;
	}

	public void setIsnext(String isnext) {
		this.isnext = isnext;
	}
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
//	@Override
//	public void validate() {
//		System.out.println(user==null);
//		System.out.println("-------------------------------------------------------------");
//		if (user.getPassword().length() > 6) {
//			addFieldError("password", "密码不能大于6位");
//		}
//	}

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
				if (user1.getIsadmin().equals("是")) {
					isnext="admin";
				}else {
					isnext="user";
				}
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

	public String admin(){
		return Action.SUCCESS;
	}
	
	public String user(){
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("username"));
		return Action.SUCCESS;
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
