package com.rightime.popo.presenter.db.mapper;

import com.rightime.popo.presenter.db.dto.BoardData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    BoardData getBoardByObjectId(int objectId) throws Exception;
}
