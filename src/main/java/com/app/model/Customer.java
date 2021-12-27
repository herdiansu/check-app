package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "customer_users")
public class Customer {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Username Harus Di Isi !")
	@Column(name = "username_old")
	private String usernameOld;
	
	@Column(name = "customer_key")
	private String usernameKey;
	
	@NotEmpty(message = "Company Harus Di Pilih!")
	@Column(name = "customer_company")
	private String customerCompany;
	
	@NotEmpty(message = "Password Harus Di Isi !")
	@Column(name = "password_old")
	private String passwordOld;
	
	@Column(name = "password_new")
	private String passwordNew;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsernameOld() {
		return usernameOld;
	}

	public void setUsernameOld(String usernameOld) {
		this.usernameOld = usernameOld;
	}

	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public String getCustomerCompany() {
		return customerCompany;
	}

	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
}
