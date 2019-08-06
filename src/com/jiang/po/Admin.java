package com.jiang.po;

public class Admin {
	private int adminID;
	private String adminAccount;
	private String adminPwd;
	private String adminState;
	private String adminRight;
	private String adminName;
	private int oneDID;		 //一级编号
	private String oneDName;	//一级部门名称
	private int twoDID;			//二级编号
	private String twoName;	
	private int departmentID;
	
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public Admin() {
		super();
	}
	public Admin(String adminAccount, String adminPwd, String adminState,
			String adminRight, String adminName) {
		super();
		this.adminAccount = adminAccount;
		this.adminPwd = adminPwd;
		this.adminState = adminState;
		this.adminRight = adminRight;
		this.adminName = adminName;
	}
	public Admin(int adminID, String adminAccount, String adminPwd,
			String adminState, String adminRight, String adminName) {
		super();
		this.adminID = adminID;
		this.adminAccount = adminAccount;
		this.adminPwd = adminPwd;
		this.adminState = adminState;
		this.adminRight = adminRight;
		this.adminName = adminName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminState() {
		return adminState;
	}
	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}
	public String getAdminRight() {
		return adminRight;
	}
	public void setAdminRight(String adminRight) {
		this.adminRight = adminRight;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public int getOneDID() {
		return oneDID;
	}
	public void setOneDID(int oneDID) {
		this.oneDID = oneDID;
	}
	public String getOneDName() {
		return oneDName;
	}
	public void setOneDName(String oneDName) {
		this.oneDName = oneDName;
	}
	public int getTwoDID() {
		return twoDID;
	}
	public void setTwoDID(int twoDID) {
		this.twoDID = twoDID;
	}
	public String getTwoName() {
		return twoName;
	}
	public void setTwoName(String twoName) {
		this.twoName = twoName;
	}
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminAccount=" + adminAccount
				+ ", adminPwd=" + adminPwd + ", adminState=" + adminState
				+ ", adminRight=" + adminRight + ", adminName=" + adminName
				+ "]";
	}
	
}
