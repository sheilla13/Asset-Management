package com.project.AssetManagement.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanDTO {
    private int id;
    private Integer asset_id;
    private String status;
    private String submit_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Integer asset_id) {
        this.asset_id = asset_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmit_date() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }
}
