package com.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "adminlogin")
public class AdminLogin
{
	private int id;
	private String admin_name;
	private String admin_password;

	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLogin(int id, String admin_name, String admin_password) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}
	 @Id
	 @Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
}
