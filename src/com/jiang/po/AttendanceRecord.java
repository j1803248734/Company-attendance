package com.jiang.po;

import java.util.Date;

public class AttendanceRecord {
		private int attendanceID;
		private int employeeID;
		private String  cardNumber;
		private Date attendanceDate;
		private String attendanceTime;
		private String attendanceFlag;
		private int attendanceType;
		private String attendanceMemo;
		private int adminID;
		private int departmentID;
		private int noteID;
		private String employeeName;
		private String departmentName;
		private int oneDID;		 //一级编号
		private String oneName;	//一级部门名称
		private int twoDID;			//二级编号
		private String twoName;	
		private String typeName;
		private String MType; //上午出勤
		private String AType;	//下午出勤
		
		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}

		public String getOneName() {
			return oneName;
		}

		public void setOneName(String oneName) {
			this.oneName = oneName;
		}

		public String getMType() {
			return MType;
		}

		public void setMType(String mType) {
			MType = mType;
		}

		public String getAType() {
			return AType;
		}

		public void setAType(String aType) {
			AType = aType;
		}

		public int getOneDID() {
			return oneDID;
		}

		public void setOneDID(int oneDID) {
			this.oneDID = oneDID;
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

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public int getAttendanceID() {
			return attendanceID;
		}

		public void setAttendanceID(int attendanceID) {
			this.attendanceID = attendanceID;
		}

		public int getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public Date getAttendanceDate() {
			return attendanceDate;
		}

		public void setAttendanceDate(Date attendanceDate) {
			this.attendanceDate = attendanceDate;
		}

		public String getAttendanceTime() {
			return attendanceTime;
		}

		public void setAttendanceTime(String attendanceTime) {
			this.attendanceTime = attendanceTime;
		}

		public String getAttendanceFlag() {
			return attendanceFlag;
		}

		public void setAttendanceFlag(String attendanceFlag) {
			this.attendanceFlag = attendanceFlag;
		}

		public int getAttendanceType() {
			return attendanceType;
		}

		public void setAttendanceType(int attendanceType) {
			this.attendanceType = attendanceType;
		}

		public String getAttendanceMemo() {
			return attendanceMemo;
		}

		public void setAttendanceMemo(String attendanceMemo) {
			this.attendanceMemo = attendanceMemo;
		}

		public int getAdminID() {
			return adminID;
		}

		public void setAdminID(int adminID) {
			this.adminID = adminID;
		}

		public int getDepartmentID() {
			return departmentID;
		}

		public void setDepartmentID(int departmentID) {
			this.departmentID = departmentID;
		}

		public int getNoteID() {
			return noteID;
		}

		public void setNoteID(int noteID) {
			this.noteID = noteID;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		@Override
		public String toString() {
			return "AttendanceRecord [attendanceID=" + attendanceID
					+ ", employeeID=" + employeeID + ", cardNumber="
					+ cardNumber + ", attendanceDate=" + attendanceDate
					+ ", attendanceTime=" + attendanceTime
					+ ", attendanceFlag=" + attendanceFlag
					+ ", attendanceType=" + attendanceType
					+ ", attendanceMemo=" + attendanceMemo + ", adminID="
					+ adminID + ", departmentID=" + departmentID + ", noteID="
					+ noteID + ", departmentName=" + departmentName + "]";
		}
		
}
