
package com.example.matagaruda.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SensorModel {

    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("sensors")
    @Expose
    private List<Sensor> sensors = null;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}
