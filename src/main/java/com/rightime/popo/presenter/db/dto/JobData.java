package com.rightime.popo.presenter.db.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class JobData {
    public int id;
    public int jobTypeId;
    public String jobType;
    public Date createdAt;
    public Date modifiedAt;
}
