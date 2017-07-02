package com.hzlwyykj.model;

import java.util.Date;

public class Workorder {
    private String workorderid;

    private Integer customerid;

    private String customername;

    private String centificatenumber;

    private Integer aging;

    private String problemtype;

    private Integer handlegroup;

    private Integer handleperson;

    private String urgencylevel;

    private Integer status;

    private Date creatdate;

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
}