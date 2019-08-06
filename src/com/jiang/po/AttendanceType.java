package com.jiang.po;

public class AttendanceType {
	private int typeID;
	private String typeName;
	private String typeCategory;
	
	public AttendanceType() {
		super();
	}

	public AttendanceType(String typeName, String typeCategory) {
		super();
		this.typeName = typeName;
		this.typeCategory = typeCategory;
	}

	public AttendanceType(int typeID, String typeName, String typeCategory) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
		this.typeCategory = typeCategory;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	@Override
	public String toString() {
		return "AttendanceType [typeID=" + typeID + ", typeName=" + typeName
				+ ", typeCategory=" + typeCategory + "]";
	}
	
}
