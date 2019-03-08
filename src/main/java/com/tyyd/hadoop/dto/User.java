package com.tyyd.hadoop.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String userPassword;
	private String userMobilephone;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userRegTime;
	private String userAreaCode;
	private String userUaInfo;
	private String userLastLoginway;
	private String userLastLogintime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobilephone() {
		return userMobilephone;
	}
	public void setUserMobilephone(String userMobilephone) {
		this.userMobilephone = userMobilephone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAreaCode() {
		return userAreaCode;
	}
	public void setUserAreaCode(String userAreaCode) {
		this.userAreaCode = userAreaCode;
	}
	public String getUserUaInfo() {
		return userUaInfo;
	}
	public void setUserUaInfo(String userUaInfo) {
		this.userUaInfo = userUaInfo;
	}
	public String getUserLastLoginway() {
		return userLastLoginway;
	}
	public void setUserLastLoginway(String userLastLoginway) {
		this.userLastLoginway = userLastLoginway;
	}
	public String getUserRegTime() {
		return userRegTime;
	}
	public void setUserRegTime(String userRegTime) {
		this.userRegTime = userRegTime;
	}
	public String getUserLastLogintime() {
		return userLastLogintime;
	}
	public void setUserLastLogintime(String userLastLogintime) {
		this.userLastLogintime = userLastLogintime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append(", userMobilephone=");
		builder.append(userMobilephone);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userNickname=");
		builder.append(userNickname);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userRegTime=");
		builder.append(userRegTime);
		builder.append(", userAreaCode=");
		builder.append(userAreaCode);
		builder.append(", userUaInfo=");
		builder.append(userUaInfo);
		builder.append(", userLastLoginway=");
		builder.append(userLastLoginway);
		builder.append(", userLastLogintime=");
		builder.append(userLastLogintime);
		builder.append("]");
		return builder.toString();
	}
	public static void main(String[] args) {
		System.out.println(Timestamp.valueOf(LocalDateTime.now()));
	}
}
