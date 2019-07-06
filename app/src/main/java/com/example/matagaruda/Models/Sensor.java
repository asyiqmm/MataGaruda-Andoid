
package com.example.matagaruda.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sensor {

    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("device_name")
    @Expose
    private String deviceName;
    @SerializedName("external_subnet")
    @Expose
    private String externalSubnet;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("oinkcode")
    @Expose
    private String oinkcode;
    @SerializedName("protected_subnet")
    @Expose
    private String protectedSubnet;
    @SerializedName("sensor_key")
    @Expose
    private String sensorKey;
    @SerializedName("time_created")
    @Expose
    private String timeCreated;
    @SerializedName("topic_cmd")
    @Expose
    private String topicCmd;
    @SerializedName("topic_global")
    @Expose
    private String topicGlobal;
    @SerializedName("topic_resp")
    @Expose
    private String topicResp;

    public Sensor(String deviceName, String hostname, String ipAddress, String location, String protectedSubnet) {
        this.deviceName = deviceName;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.location = location;
        this.protectedSubnet = protectedSubnet;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getExternalSubnet() {
        return externalSubnet;
    }

    public void setExternalSubnet(String externalSubnet) {
        this.externalSubnet = externalSubnet;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOinkcode() {
        return oinkcode;
    }

    public void setOinkcode(String oinkcode) {
        this.oinkcode = oinkcode;
    }

    public String getProtectedSubnet() {
        return protectedSubnet;
    }

    public void setProtectedSubnet(String protectedSubnet) {
        this.protectedSubnet = protectedSubnet;
    }

    public String getSensorKey() {
        return sensorKey;
    }

    public void setSensorKey(String sensorKey) {
        this.sensorKey = sensorKey;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTopicCmd() {
        return topicCmd;
    }

    public void setTopicCmd(String topicCmd) {
        this.topicCmd = topicCmd;
    }

    public String getTopicGlobal() {
        return topicGlobal;
    }

    public void setTopicGlobal(String topicGlobal) {
        this.topicGlobal = topicGlobal;
    }

    public String getTopicResp() {
        return topicResp;
    }

    public void setTopicResp(String topicResp) {
        this.topicResp = topicResp;
    }

}
