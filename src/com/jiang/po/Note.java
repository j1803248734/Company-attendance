package com.jiang.po;

import java.util.Date;

public class Note {	
	private int noteID;
	private int departmentID;
	private int employeeID;
	private int noteTypeID;
	private String cause;
	private Date fillInTime;
	private String directorSign;
	private String administrationSign;
	private String presidentSign;
	private Date startDate;
	private String startTime;
	private Date endDate;
	private String endTime;
	private int adminID;
	private String noteMemo;
	private int operatorID;
	private String isVerify;
	
	private String cardNumber;   //员工卡号
	private String employeeName; //员工名称
	private int oneDID;		 //一级编号
	private String oneDName;	//一级部门名称
	private int twoDID;			//二级编号
	private String twoName;			//二级部门名称
	private String TypeName;		//请假类型名称
	private String operatorName;	//代理人姓名
	
	private String startTimeAM;
	private String endTimeAM;
	private String startTimePM;
	private String endTimePM;
	public String getStartTimeAM() {
		return startTimeAM;
	}

	public void setStartTimeAM(String startTimeAM) {
		this.startTimeAM = startTimeAM;
	}

	public String getEndTimeAM() {
		return endTimeAM;
	}

	public void setEndTimeAM(String endTimeAM) {
		this.endTimeAM = endTimeAM;
	}

	public String getStartTimePM() {
		return startTimePM;
	}

	public void setStartTimePM(String startTimePM) {
		this.startTimePM = startTimePM;
	}

	public String getEndTimePM() {
		return endTimePM;
	}

	public void setEndTimePM(String endTimePM) {
		this.endTimePM = endTimePM;
	}

	public Note() {
		super();
	}
	
	public Note(int departmentID, int employeeID, int noteTypeID, String cause, Date fillInTime, String directorSign,
			String administrationSign, String presidentSign, Date startDate, String startTime, Date endDate,
			String endTime, int adminID, String noteMemo, int operatorID, String isVerify, String cardNumber,
			String employeeName, int oneDID, String oneDName, int twoDID, String twoName, String typeName,
			String operatorName) {
		super();
		this.departmentID = departmentID;
		this.employeeID = employeeID;
		this.noteTypeID = noteTypeID;
		this.cause = cause;
		this.fillInTime = fillInTime;
		this.directorSign = directorSign;
		this.administrationSign = administrationSign;
		this.presidentSign = presidentSign;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.adminID = adminID;
		this.noteMemo = noteMemo;
		this.operatorID = operatorID;
		this.isVerify = isVerify;
		this.cardNumber = cardNumber;
		this.employeeName = employeeName;
		this.oneDID = oneDID;
		this.oneDName = oneDName;
		this.twoDID = twoDID;
		this.twoName = twoName;
		TypeName = typeName;
		this.operatorName = operatorName;
	}

	public Note(int noteID, int departmentID, int employeeID, int noteTypeID, String cause, Date fillInTime,
			String directorSign, String administrationSign, String presidentSign, Date startDate, String startTime,
			Date endDate, String endTime, int adminID, String noteMemo, int operatorID, String isVerify,
			String cardNumber, String employeeName, int oneDID, String oneDName, int twoDID, String twoName,
			String typeName, String operatorName) {
		super();
		this.noteID = noteID;
		this.departmentID = departmentID;
		this.employeeID = employeeID;
		this.noteTypeID = noteTypeID;
		this.cause = cause;
		this.fillInTime = fillInTime;
		this.directorSign = directorSign;
		this.administrationSign = administrationSign;
		this.presidentSign = presidentSign;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.adminID = adminID;
		this.noteMemo = noteMemo;
		this.operatorID = operatorID;
		this.isVerify = isVerify;
		this.cardNumber = cardNumber;
		this.employeeName = employeeName;
		this.oneDID = oneDID;
		this.oneDName = oneDName;
		this.twoDID = twoDID;
		this.twoName = twoName;
		TypeName = typeName;
		this.operatorName = operatorName;
		
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getNoteTypeID() {
		return noteTypeID;
	}

	public void setNoteTypeID(int noteTypeID) {
		this.noteTypeID = noteTypeID;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getFillInTime() {
		return fillInTime;
	}

	public void setFillInTime(Date fillInTime) {
		this.fillInTime = fillInTime;
	}

	public String getDirectorSign() {
		return directorSign;
	}

	public void setDirectorSign(String directorSign) {
		this.directorSign = directorSign;
	}

	public String getAdministrationSign() {
		return administrationSign;
	}

	public void setAdministrationSign(String administrationSign) {
		this.administrationSign = administrationSign;
	}

	public String getPresidentSign() {
		return presidentSign;
	}

	public void setPresidentSign(String presidentSign) {
		this.presidentSign = presidentSign;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getNoteMemo() {
		return noteMemo;
	}

	public void setNoteMemo(String noteMemo) {
		this.noteMemo = noteMemo;
	}

	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}

	public String getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Override
	public String toString() {
		return "Note [noteID=" + noteID + ", departmentID=" + departmentID + ", employeeID=" + employeeID
				+ ", noteTypeID=" + noteTypeID + ", cause=" + cause + ", fillInTime=" + fillInTime + ", directorSign="
				+ directorSign + ", administrationSign=" + administrationSign + ", presidentSign=" + presidentSign
				+ ", startDate=" + startDate + ", startTime=" + startTime + ", endDate=" + endDate + ", endTime="
				+ endTime + ", adminID=" + adminID + ", noteMemo=" + noteMemo + ", operatorID=" + operatorID
				+ ", isVerify=" + isVerify + ", cardNumber=" + cardNumber + ", employeeName=" + employeeName
				+ ", oneDID=" + oneDID + ", oneDName=" + oneDName + ", twoDID=" + twoDID + ", twoName=" + twoName
				+ ", TypeName=" + TypeName + ", operatorName=" + operatorName + "]";
	}
	
	
}
