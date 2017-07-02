package com.hzlwyykj.model;

import java.util.List;

public class Role {
    private Integer rid;

    private String rolename;

    private String description;

    private Integer isdel;
    
    private List<Integer> mids;

    public Integer getRid() {
        return rid;
    }

    public List<Integer> getMids() {
		return mids;
	}

	public void setMids(List<Integer> mids) {
		this.mids = mids;
	}

	public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}