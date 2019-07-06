package com.example.matagaruda.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsRaw {
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
