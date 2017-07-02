package com.hzlwyykj.model;

import java.util.Date;

public class Handleworkhistory {
    private Integer id;

    private String workorderid;

    private Integer handleperson;

    private String handlepersonname;

    private Integer handlegroup;

    private String handlegroupname;

    private String actionstr;

    private Date createdate;

    private String descs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid == null ? null : workorderid.trim();
    }

    public Integer getHandleperson() {
        return handleperson;
    }

    public void setHandleperson(Integer handleperson) {
        this.handleperson = handleperson;
    }

    public String getHandlepersonname() {
        return handlepersonname;
    }

    public void setHandlepersonname(String handlepersonname) {
        this.handlepersonname = handlepersonname == null ? null : handlepersonname.trim();
    }

    public Integer getHandlegroup() {
        return handlegroup;
    }

    public void setHandlegroup(Integer handlegroup) {
        this.handlegroup = handlegroup;
    }

    public String getHandlegroupname() {
        return handlegroupname;
    }

    public void setHandlegroupname(String handlegroupname) {
        this.handlegroupname = handlegroupname == null ? null : handlegroupname.trim();
    }

    public String getActionstr() {
        return actionstr;
    }

    public void setActionstr(String actionstr) {
        this.actionstr = actionstr == null ? null : actionstr.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }
}