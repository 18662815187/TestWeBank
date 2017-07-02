package com.hzlwyykj.model;

public class Workattach {
    private Integer id;

    private String newfilename;

    private String oldfilename;

    private String workid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewfilename() {
        return newfilename;
    }

    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename == null ? null : newfilename.trim();
    }

    public String getOldfilename() {
        return oldfilename;
    }

    public void setOldfilename(String oldfilename) {
        this.oldfilename = oldfilename == null ? null : oldfilename.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }
}