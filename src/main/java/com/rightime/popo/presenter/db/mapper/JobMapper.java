package com.rightime.popo.presenter.db.mapper;

import com.rightime.popo.presenter.db.dto.JobData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface JobMapper {
    //    @Select("select id, job_type_id, created_at, modified_at from job")
    public ArrayList<JobData> findJobByAvailability(@Param("availability") boolean availability);
}
