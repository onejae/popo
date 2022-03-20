package com.rightime.popo.presenter.db.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class JobData {
    public int id;
    public int jobObjectId;
    public Date createdAt;
    public Date modifiedAt;
}
