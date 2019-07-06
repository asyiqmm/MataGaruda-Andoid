
package com.example.matagaruda.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Events {

    @SerializedName("alert_msg")
    @Expose
    private String alertMsg;
    @SerializedName("classification")
    @Expose
    private Integer classification;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("day")
    @Expose
    private Integer day;
    @SerializedName("dest_country")
    @Expose
    private String destCountry;
    @SerializedName("dest_ip")
    @Expose
    private String destIp;
    @SerializedName("dest_mac")
    @Expose
    private String destMac;
    @SerializedName("dest_port")
    @Expose
    private Integer destPort;
    @SerializedName("dest_region")
    @Expose
    private String destRegion;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("hour")
    @Expose
    private Integer hour;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ip_type")
    @Expose
    private String ipType;
    @SerializedName("minute")
    @Expose
    private Integer minute;
    @SerializedName("month")
    @Expose
    private Integer month;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("protocol")
    @Expose
    private String protocol;
    @SerializedName("second")
    @Expose
    private Integer second;
    @SerializedName("sig_gen")
    @Expose
    private Integer sigGen;
    @SerializedName("sig_id")
    @Expose
    private Integer sigId;
    @SerializedName("sig_rev")
    @Expose
    private Integer sigRev;
    @SerializedName("src_country")
    @Expose
    private String srcCountry;
    @SerializedName("src_ip")
    @Expose
    private String srcIp;
    @SerializedName("src_mac")
    @Expose
    private String srcMac;
    @SerializedName("src_port")
    @Expose
    private Integer srcPort;
    @SerializedName("src_region")
    @Expose
    private String srcRegion;
    @SerializedName("ts")
    @Expose
    private String ts;
    @SerializedName("year")
    @Expose
    private Integer year;

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp;
    }

    public String getDestMac() {
        return destMac;
    }

    public void setDestMac(String destMac) {
        this.destMac = destMac;
    }

    public Integer getDestPort() {
        return destPort;
    }

    public void setDestPort(Integer destPort) {
        this.destPort = destPort;
    }

    public String getDestRegion() {
        return destRegion;
    }

    public void setDestRegion(String destRegion) {
        this.destRegion = destRegion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getSigGen() {
        return sigGen;
    }

    public void setSigGen(Integer sigGen) {
        this.sigGen = sigGen;
    }

    public Integer getSigId() {
        return sigId;
    }

    public void setSigId(Integer sigId) {
        this.sigId = sigId;
    }

    public Integer getSigRev() {
        return sigRev;
    }

    public void setSigRev(Integer sigRev) {
        this.sigRev = sigRev;
    }

    public String getSrcCountry() {
        return srcCountry;
    }

    public void setSrcCountry(String srcCountry) {
        this.srcCountry = srcCountry;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public void setSrcMac(String srcMac) {
        this.srcMac = srcMac;
    }

    public Integer getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(Integer srcPort) {
        this.srcPort = srcPort;
    }

    public String getSrcRegion() {
        return srcRegion;
    }

    public void setSrcRegion(String srcRegion) {
        this.srcRegion = srcRegion;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
