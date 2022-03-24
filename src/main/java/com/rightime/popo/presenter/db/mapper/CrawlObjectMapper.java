package com.rightime.popo.presenter.db.mapper;


import com.rightime.popo.presenter.db.dto.CrawlObjectData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrawlObjectMapper {
    CrawlObjectData getCrawlObjectById(int id);
}