package com.struts2.action;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Login,Struts Action类。
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {// implements Action

	// 用户名，用户登录时输入
	private String username = "";
	// 密码，用户登录时输入
	private String password = "";

	/**
	 * 获取 用户名。
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置 用户名。
	 * 
	 * @param userName
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取 密码。
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置 密码。
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 数据校验 execute方法，当Struts 2处理用户请求时，在默认配置下调用的方法。
	 * 
	 * @return
	 */
	@Override
	public void validate() {
		if (this.getUsername().length() == 0) {
			addFieldError("name", "用户名不能为空");
		}
		if (this.getPassword().length() == 0) {
			addFieldError("password", "用户密码不能为空");
		}
	}

	/**
	 * execute方法，当Struts 2处理用户请求时，在默认配置下调用的方法。
	 * 
	 * @return
	 */
	// public String execute() {
	// // 用户名为“jason”密码为“2010”时，登录成功
	// if("spz".equals(username) && "1997".equals(password)) {
	// // 登录成功，返回“success”
	// return "success";
	// } else {
	// // 登录失败，返回“fail”
	// return "error";
	// }
	// }

	// session紧耦方式
	// public String execute() {
	// // 用户名为“jason”密码为“2010”时，登录成功
	// if("spz".equals(username) && "1997".equals(password)) {
	// // 获取session
	// HttpSession session = null;
	// session = ServletActionContext.getRequest().getSession();
	// // 判断session中是否已有用户对象
	// if(session.getAttribute("username")!=null) {
	// // 从session中移除已有的用户对象
	// session.setAttribute("username",null);
	// }
	// // 将用对象存入session
	// session.setAttribute("username",username);
	// // 登录成功，返回“success”
	// return Action.SUCCESS;
	// } else {
	// // 登录失败，返回“error”
	// return Action.ERROR;
	// }
	// }

	private static final String CURRENT_USER = "username";

	// session解耦方式
	public String execute() {
		// 用户名为“jason”密码为“2010”时，登录成功
		if ("spz".equals(username) && "1997".equals(password)) {
			// 获取session
			Map<String, Object> session = null;
			session = ActionContext.getContext().getSession();
			// 判断session中是否已有用户对象
			if (session.containsKey(CURRENT_USER)) {
				// 从session中移除已有的用户对象
				session.remove(CURRENT_USER);
			}
			// 将用对象存入session
			session.put(CURRENT_USER, username);
			// 登录成功，返回“success”
			return Action.SUCCESS;
		} else {
			// 登录失败，返回“error”
			return Action.ERROR;
		}
	}

	// session解耦方式
	public String login() {
		// 用户名为“jason”密码为“2010”时，登录成功
		if ("spz".equals(username) && "1997".equals(password)) {
			// 获取session
			Map<String, Object> session = null;
			session = ActionContext.getContext().getSession();
			// 判断session中是否已有用户对象
			if (session.containsKey(CURRENT_USER)) {
				// 从session中移除已有的用户对象
				session.remove(CURRENT_USER);
			}
			// 将用对象存入session
			session.put(CURRENT_USER, username);
			// 登录成功，返回“success”
			return Action.SUCCESS;
		} else {
			// 登录失败，返回“error”
			return Action.ERROR;
		}
	}
}