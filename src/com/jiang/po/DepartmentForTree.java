package com.jiang.po;



import java.util.ArrayList;
import java.util.List;

public class DepartmentForTree {
	
	private int id;
	private String text;
	private int pid;
	private List<DepartmentForTree> children 
		= new ArrayList<DepartmentForTree>();
	
	public DepartmentForTree() {
		super();
	}
	public DepartmentForTree(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public DepartmentForTree(int id, String text, int pid) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
	}
	public DepartmentForTree(int id, String text,
			List<DepartmentForTree> children) {
		super();
		this.id = id;
		this.text = text;
		this.children = children;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<DepartmentForTree> getChildren() {
		return children;
	}
	public void setChildren(List<DepartmentForTree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "DepartmentForTree [id=" + id + ", text=" + text + ", children="
				+ children + "]";
	}
}
