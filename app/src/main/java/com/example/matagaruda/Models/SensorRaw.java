package com.example.matagaruda.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SensorRaw {

    @SerializedName("device_name")
    @Expose
    private String deviceName;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("protected_subnet")
    @Expose
    private String protectedSubnet;

    public SensorRaw(String deviceName, String hostname, String ipAddress, String location, String protectedSubnet) {
        this.deviceName = deviceName;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.location = location;
        this.protectedSubnet = protectedSubnet;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public String getProtectedSubnet() {
        return protectedSubnet;
    }

    public void setProtectedSubnet(String protectedSubnet) {
        this.protectedSubnet = protectedSubnet;
    }

}
