package com.rightime.popo.presenter.db.dto;

import com.rightime.popo.domain.entity.Board;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.presenter.huv.HuvUtza;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    JobData JobEntityToDto(CrawlJob crawlJob);

    CrawlJob JobDataToEntity(JobData jobData);

    default Board createBoard() {
        return new HuvUtza();
    }
}
