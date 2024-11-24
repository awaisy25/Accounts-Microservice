package com.project.Accounts.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue
	private Long ID;
	private String Username;
	private String password;
	private Date Creation_Date;
	private boolean Active;
	private Date DeActivate_Date;
	private String Email;
	
	public Account() {}
	
	public Account(String username, String password, boolean active, String email) {
		this.Username = username;
		this.password = password;
		this.Active = active;
		this.Email = email;
		// getting current date when creating new account object
		long millis = System.currentTimeMillis();
		this.Creation_Date = new java.sql.Date(millis);
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreation_Date() {
		return Creation_Date;
	}
	public void setCreation_Date(Date creation_Date) {
		Creation_Date = creation_Date;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public Date getDeActivate_Date() {
		return DeActivate_Date;
	}
	public void setDeActivate_Date(Date deActivate_Date) {
		DeActivate_Date = deActivate_Date;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
