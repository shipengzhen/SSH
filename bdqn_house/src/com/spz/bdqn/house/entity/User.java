package com.spz.bdqn.house.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String name;
	private String telephone;
	private String isadmin;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id, String username, String password, String name, String isadmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.isadmin = isadmin;
	}

	/** full constructor */
	public User(Integer id, String username, String password, String name, String telephone, String isadmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.isadmin = isadmin;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

}