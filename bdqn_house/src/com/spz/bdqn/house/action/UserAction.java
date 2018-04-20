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
 * @���� �û�������
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����1:19:34
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
//			addFieldError("password", "���벻�ܴ���6λ");
//		}
//	}

	//��¼
	public String dologin() {
		try {
			User user1=userService.findUser(user.getUsername(),user.getPassword());
			if ( user1!= null) {
				// ��ȡsession
				Map<String, Object> session = null;
				session = ActionContext.getContext().getSession();
				// �ж�session���Ƿ������û�����
				if (session.containsKey(CURRENT_USER)) {
					// ��session���Ƴ����е��û�����
					session.remove(CURRENT_USER);
				}
				// ���ö������session
				session.put(CURRENT_USER, user1);
				// ��¼�ɹ������ء�success��
				if (user1.getIsadmin().equals("��")) {
					isnext="admin";
				}else {
					isnext="user";
				}
				return Action.SUCCESS;
			} else {
				// ��¼ʧ�ܣ����ء�error��
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("error", "�û������������");
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
	
	//ע��
	public String register() {
		user.setIsadmin("��");
		if (userService.addUser(user)) {
			return Action.SUCCESS;
		}else {
			return Action.ERROR;
		}
	}
}
