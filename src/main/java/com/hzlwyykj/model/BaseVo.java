package com.hzlwyykj.model;

public class BaseVo {
	/**
	 * 封装的参数属性；
	 * pageNum，pageSize为分页查询参数；
	 * keywords为关键字查询参数；
	 */
    private int pageNum=1;
    private int pageSize=5;
    private String keywords;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
    
    

}
