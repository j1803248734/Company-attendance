package com.jiang.po;

import java.util.Date;

public class Employee {
	private int employeeID;
	private String employeeName;
	private String employeeGender; //0女 1男
	private int positionID;
	private int departmentID;
	private String  cardNumber;
	private String employeeState;
	private String employeeMemo;
	private String positionName;
	private String departmentName;
	private int oneDID;		 //一级编号
	private String oneDName;	//一级部门名称
	private int twoDID;			//二级编号
	private String twoName;	
	private String startTimeAM;
	private String endTimeAM;
	private String startTimePM;
	private String endTimePM;
	private int parentID;
	private Date attendanceDate;
	private Date startDate;
	private Date endDate;
	private int typeID;
	private String mType;
	private String aType;
	private String attendanceType;
	private String attendance;
	private String illness;
	private String yield;
	private String matter;
	private String late;
	private String absenteeism;
	private String marry;
	private String lose;
	private int sel1;
	private int sel2;
	
	public int getSel1() {
		return sel1;
	}

	public void setSel1(int sel1) {
		this.sel1 = sel1;
	}

	public int getSel2() {
		return sel2;
	}

	public void setSel2(int sel2) {
		this.sel2 = sel2;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	

	public String getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(String absenteeism) {
		this.absenteeism = absenteeism;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getLose() {
		return lose;
	}

	public void setLose(String lose) {
		this.lose = lose;
	}

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

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

	public Employee() {
		super();
	}

	public Employee(String employeeName, String employeeGender, int positionID,
			int departmentID, String cardNumber, String employeeState,
			String employeeMemo, String positionName, String departmentName) {
		super();
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.positionID = positionID;
		this.departmentID = departmentID;
		this.cardNumber = cardNumber;
		this.employeeState = employeeState;
		this.employeeMemo = employeeMemo;
		this.positionName = positionName;
		this.departmentName = departmentName;
	}

	public Employee(int employeeID, String employeeName, String employeeGender,
			int positionID, int departmentID, String cardNumber,
			String employeeState, String employeeMemo, String positionName,
			String departmentName) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.positionID = positionID;
		this.departmentID = departmentID;
		this.cardNumber = cardNumber;
		this.employeeState = employeeState;
		this.employeeMemo = employeeMemo;
		this.positionName = positionName;
		this.departmentName = departmentName;
	}

	

	public Employee(String employeeName, String employeeGender, int positionID,
			int departmentID, String cardNumber, String employeeState,
			String employeeMemo) {
		super();
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.positionID = positionID;
		this.departmentID = departmentID;
		this.cardNumber = cardNumber;
		this.employeeState = employeeState;
		this.employeeMemo = employeeMemo;
	}

	public Employee(int employeeID, String employeeName, String employeeGender,
			int positionID, int departmentID, String cardNumber,
			String employeeState, String employeeMemo) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.positionID = positionID;
		this.departmentID = departmentID;
		this.cardNumber = cardNumber;
		this.employeeState = employeeState;
		this.employeeMemo = employeeMemo;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeeMemo() {
		return employeeMemo;
	}

	public void setEmployeeMemo(String employeeMemo) {
		this.employeeMemo = employeeMemo;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName="
				+ employeeName + ", employeeGender=" + employeeGender
				+ ", positionID=" + positionID + ", departmentID="
				+ departmentID + ", cardNumber=" + cardNumber
				+ ", employeeState=" + employeeState + ", employeeMemo="
				+ employeeMemo + ", positionName=" + positionName
				+ ", departmentName=" + departmentName + "]";
	}
	
}
