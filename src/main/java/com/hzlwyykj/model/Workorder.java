package com.hzlwyykj.model;

import java.util.Date;
import java.util.List;

public class Workorder {
	private String workorderid;

	private Integer customerid;

	private String customername;

	private String centificatenumber;

	private Integer aging;

	private String problemtype;
	// 添加临时字段，数据库中没有
	private String problemtypename;

	private Integer handlegroup;
	private String handlegroupname;
	// 临时字段
	private String handlepersonname;
	private Integer handleperson;

	private String urgencylevel;
	private String urgencylevelname;

	private Integer status;

	private Date creatdate;
	private String descs;

	/**
	 * 一个客户对应一个工单
	 */
	private Customer customer;
	/**
	 * 一个工单有多个附件
	 */
	private List<Workattach> attaches;

	public String getHandlepersonname() {
		return handlepersonname;
	}

	public void setHandlepersonname(String handlepersonname) {
		this.handlepersonname = handlepersonname;
	}

	public String getUrgencylevelname() {
		return urgencylevelname;
	}

	public void setUrgencylevelname(String urgencylevelname) {
		this.urgencylevelname = urgencylevelname;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getProblemtypename() {
		return problemtypename;
	}

	public void setProblemtypename(String problemtypename) {
		this.problemtypename = problemtypename;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Workattach> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<Workattach> attaches) {
		this.attaches = attaches;
	}

	public String getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid == null ? null : workorderid.trim();
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername == null ? null : customername.trim();
	}

	public String getCentificatenumber() {
		return centificatenumber;
	}

	public void setCentificatenumber(String centificatenumber) {
		this.centificatenumber = centificatenumber == null ? null : centificatenumber.trim();
	}

	public Integer getAging() {
		return aging;
	}

	public void setAging(Integer aging) {
		this.aging = aging;
	}

	public String getProblemtype() {
		return problemtype;
	}

	public void setProblemtype(String problemtype) {
		this.problemtype = problemtype == null ? null : problemtype.trim();
	}

	public Integer getHandlegroup() {
		return handlegroup;
	}

	public void setHandlegroup(Integer handlegroup) {
		this.handlegroup = handlegroup;
	}

	public Integer getHandleperson() {
		return handleperson;
	}

	public void setHandleperson(Integer handleperson) {
		this.handleperson = handleperson;
	}

	public String getUrgencylevel() {
		return urgencylevel;
	}

	public void setUrgencylevel(String urgencylevel) {
		this.urgencylevel = urgencylevel == null ? null : urgencylevel.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}

	public String getHandlegroupname() {
		return handlegroupname;
	}

	public void setHandlegroupname(String handlegroupname) {
		this.handlegroupname = handlegroupname;
	}
}