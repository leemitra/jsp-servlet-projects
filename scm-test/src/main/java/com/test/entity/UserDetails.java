package com.test.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="user_login")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name", length=150)
	private String fullName;
	@Column(name="user_name", length=100)
	private String username;
	@Column(name="user_pass", length=200)
	private String password;
	@Column(name="email", length=50)
	private String email;
	@Column(name="phone", length=15)
	private String phone ;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private UserRoles role;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserRoles getRole() {
		return role;
	}
	public void setRole(UserRoles role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", role=" + role + "]";
	}
	
	
	
}
