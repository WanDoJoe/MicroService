package com.seventythree.model;

public class UserModel {
	
	int id;
	String u_name;
	String u_password;
	String othername;
	String date;
	String selfintroduction;
	String icon;
	String birthday;
	String gender;
	String phone;
	String address;
	
	@Override
	public String toString() {
		return "UserModel [id="+id+"u_name=" + u_name + ", u_password=" + u_password + ", othername=" + othername + ", date="
				+ date + ", selfintroduction=" + selfintroduction + ", icon=" + icon + ", birthday=" + birthday
				+ ", gender=" + gender + ", phone=" + phone + ", address=" + address + "]";
	}
	
	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public String getU_name() {
		return u_name;
	}
	public String getU_password() {
		return u_password;
	}
	
	public String getSelfintroduction() {
		return selfintroduction;
	}
	public String getIcon() {
		return icon;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	public void setSelfintroduction(String selfintroduction) {
		this.selfintroduction = selfintroduction;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
