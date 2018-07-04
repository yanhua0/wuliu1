package org.wuliu.entity;


import java.util.Date;


public class GoodsMeg {

    private int id;
    private String goodsStyle;
    private String goodsName;
    private String goodsNumber;
    private String goodsUnit;
    private String startProvince;
    private String startCity;
    private String endProvince;
    private String endCity;
    private String style;
    private String transportTime;
    private String phone;
    private String link;
    private Date issueDate;
    private String remark;
    private String request;
    private String  userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsStyle() {
        return goodsStyle;
    }

    public void setGoodsStyle(String goodsStyle) {
        this.goodsStyle = goodsStyle;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndProvince() {
        return endProvince;
    }

    public void setEndProvince(String endProvince) {
        this.endProvince = endProvince;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTransportTime() {
        return transportTime;
    }

    public void setTransportTime(String transportTime) {
        this.transportTime = transportTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "GoodsMeg{" +
                "id=" + id +
                ", goodsStyle='" + goodsStyle + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", startProvince='" + startProvince + '\'' +
                ", startCity='" + startCity + '\'' +
                ", endProvince='" + endProvince + '\'' +
                ", endCity='" + endCity + '\'' +
                ", style='" + style + '\'' +
                ", transportTime='" + transportTime + '\'' +
                ", phone='" + phone + '\'' +
                ", link='" + link + '\'' +
                ", issueDate=" + issueDate +
                ", remark='" + remark + '\'' +
                ", request='" + request + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
