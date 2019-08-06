package com.jiang.po;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private int departmentID;
	private String departmentName;
	private String startTimeAM;
	private String endTimeAM;
	private String startTimePM;
	private String endTimePM;
	private int parentID;
	
	
	public Department(int departmentID, String departmentName,
			String startTimeAM, String endTimeAM, String startTimePM,
			String endTimePM) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
	}

	public Department(String departmentName, String startTimeAM,
			String endTimeAM, String startTimePM, String endTimePM) {
		super();
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
	}

	public Department(int departmentID, String departmentName,
			String startTimeAM, String endTimeAM, String startTimePM,
			String endTimePM, int parentID) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
		this.parentID = parentID;
	}

	public Department(String departmentName, String startTimeAM,
			String endTimeAM, String startTimePM, String endTimePM, int parentID) {
		super();
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
		this.parentID = parentID;
	}

	private List<Department> childDepartments = new ArrayList<Department>(); //子集
	public Department() {
		super();
	}
	
	public Department(String departmentName, String startTimeAM,
			String endTimeAM, String startTimePM, String endTimePM,
			int parentID, List<Department> childDepartments) {
		super();
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
		this.parentID = parentID;
		this.childDepartments = childDepartments;
	}

	public Department(int departmentID, String departmentName,
			String startTimeAM, String endTimeAM, String startTimePM,
			String endTimePM, int parentID, List<Department> childDepartments) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.startTimeAM = startTimeAM;
		this.endTimeAM = endTimeAM;
		this.startTimePM = startTimePM;
		this.endTimePM = endTimePM;
		this.parentID = parentID;
		this.childDepartments = childDepartments;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public List<Department> getChildDepartments() {
		return childDepartments;
	}

	public void setChildDepartments(List<Department> childDepartments) {
		this.childDepartments = childDepartments;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName="
				+ departmentName + ", startTimeAM=" + startTimeAM
				+ ", endTimeAM=" + endTimeAM + ", startTimePM=" + startTimePM
				+ ", endTimePM=" + endTimePM + ", parentID=" + parentID
				+ ", childDepartments=" + childDepartments + "]";
	}
	
	
}
