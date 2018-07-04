package org.wuliu.entity;

import java.util.Date;
public class CarMessage {
    private int code;
    private String tradeMark;
    private String brand;
    private String style;
    private String carload;
    private String userTime;
    private String driverName;
    private String driverTime;
    private String licenceNumber;
    private String licenceStyle;
    private String transpotStyle;



    private String linkMan;
    private String linkPhone;
    private String remark;
    private Date issueDate;
    private String userName;
    public String getTranspotStyle() {
        return transpotStyle;
    }

    public void setTranspotStyle(String transpotStyle) {
        this.transpotStyle = transpotStyle;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCarload() {
        return carload;
    }

    public void setCarload(String carload) {
        this.carload = carload;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverTime() {
        return driverTime;
    }

    public void setDriverTime(String driverTime) {
        this.driverTime = driverTime;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceStyle() {
        return licenceStyle;
    }

    public void setLicenceStyle(String licenceStyle) {
        this.licenceStyle = licenceStyle;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CarMessage{" +
                "code=" + code +
                ", tradeMark='" + tradeMark + '\'' +
                ", brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                ", carload='" + carload + '\'' +
                ", userTime='" + userTime + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverTime='" + driverTime + '\'' +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", licenceStyle='" + licenceStyle + '\'' +
                ", transpotStyle='" + transpotStyle + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", remark='" + remark + '\'' +
                ", issueDate=" + issueDate +
                ", userName='" + userName + '\'' +
                '}';
    }
}
