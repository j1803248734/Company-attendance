package com.jiang.util;



public class PageUtil {
	private int pageSize = 5; //ÿҳ���ٱ�
	private int currentPageIndex = 0; //��ǰ������ҳ
	private int total ; //�ܱ���
	private int pageTotal ; //��ҳ��
	private int startIndex = 0;   //��ʼ�ı���
	
	//���currentPageIndex �� pageSize����õ�
	public int getStartIndex() {
		return  currentPageIndex * pageSize ;
	}
	
	/*
	p0ublic void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	*/
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;		
		this.startIndex = this.currentPageIndex * this.pageSize;
	}
	
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
		
		//���total�������Щֵ�������˱仯
		this.pageTotal = (total  + pageSize -1)/ pageSize;
	}
	
	//pageTotal =	(total  + pageSize �C 1)/ pageSize;
	public int getPageTotal() {		
		return pageTotal =	(total  + pageSize -1)/ pageSize;
	}
	
	
	public PageUtil(int pageSize, int currentPageIndex, int total) {
		super();
		this.pageSize = pageSize;
		this.currentPageIndex = currentPageIndex; //������
		this.total = total;	//�ܱ���
		
		//���total����pageTotal
		this.pageTotal = (total  + pageSize - 1)/ pageSize; //����ҳ��
		//���������ʼ��
		this.startIndex = currentPageIndex * pageSize;
	}
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PageUtil(int total) {
		super();
		this.total = total;
		
		//���total����pageTotal
		this.pageTotal = (total  + pageSize - 1)/ pageSize;
		//���������ʼ��
		this.startIndex = currentPageIndex * pageSize;
	}
	
	
	
	@Override
	public String toString() {
		return "PageUtil [pageSize=" + pageSize + ", currentPageIndex="
				+ currentPageIndex + ", total=" + total + ", pageTotal="
				+ pageTotal + ", startIndex=" + startIndex + "]";
	}

	
}
