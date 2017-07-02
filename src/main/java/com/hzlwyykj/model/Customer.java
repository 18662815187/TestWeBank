package com.hzlwyykj.model;

public class Customer {
    private Integer id;

    private String customername;

    private String sex;

    private String certificatetype;

    private String centificatenumber;

    private String telephone;

    private String wechatwhite;

    private String openchannel;

    private String qqwhile;

    private String customertype;

    private String comeinchannel;

    private String callphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype == null ? null : certificatetype.trim();
    }

    public String getCentificatenumber() {
        return centificatenumber;
    }

    public void setCentificatenumber(String centificatenumber) {
        this.centificatenumber = centificatenumber == null ? null : centificatenumber.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getWechatwhite() {
        return wechatwhite;
    }

    public void setWechatwhite(String wechatwhite) {
        this.wechatwhite = wechatwhite == null ? null : wechatwhite.trim();
    }

    public String getOpenchannel() {
        return openchannel;
    }

    public void setOpenchannel(String openchannel) {
        this.openchannel = openchannel == null ? null : openchannel.trim();
    }

    public String getQqwhile() {
        return qqwhile;
    }

    public void setQqwhile(String qqwhile) {
        this.qqwhile = qqwhile == null ? null : qqwhile.trim();
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype == null ? null : customertype.trim();
    }

    public String getComeinchannel() {
        return comeinchannel;
    }

    public void setComeinchannel(String comeinchannel) {
        this.comeinchannel = comeinchannel == null ? null : comeinchannel.trim();
    }

    public String getCallphone() {
        return callphone;
    }

    public void setCallphone(String callphone) {
        this.callphone = callphone == null ? null : callphone.trim();
    }
}