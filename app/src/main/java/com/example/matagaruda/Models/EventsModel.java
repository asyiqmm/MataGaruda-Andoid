
package com.example.matagaruda.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsModel {

    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private List<Events> data = null;

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

    public List<Events> getData() {
        return data;
    }

    public void setData(List<Events> data) {
        this.data = data;
    }

}
