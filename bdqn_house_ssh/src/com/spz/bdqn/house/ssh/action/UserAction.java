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
 * @���� �û�������
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����1:19:34
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
			addFieldError("password", "���벻�ܴ���6λ");
		}
	}*/
	
	
	//��֤�û��Ƿ����
	//��ʽһ
	
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
			if("΢Ц��".equals(user.getUsername())){
				result = "<font color='red'>�û����Ѵ���</font>";
			}else{
				result = "<font color='green'>�û���������</font>";
			}
			inputStream = new ByteArrayInputStream(result.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	
	//��ʽ��
	private Map<String,Object> list;
	
	public Map<String, Object> getList() {
		return list;
	}
	public void setList(Map<String, Object> list) {
		this.list = list;
	}
	public String checkName(){
		list = new HashMap<String,Object>();
		if("΢Ц��".equals(user.getUsername())){
			list.put("isok",true);
		}else{
			list.put("isok",false);
		}
		return SUCCESS;
	}
	
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
