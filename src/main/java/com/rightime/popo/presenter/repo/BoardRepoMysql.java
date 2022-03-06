package com.rightime.popo.presenter.repo;

import com.rightime.popo.domain.entity.Board;
import com.rightime.popo.domain.repo.BoardRepo;
import com.rightime.popo.presenter.db.dto.BoardData;
import com.rightime.popo.presenter.db.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardRepoMysql implements BoardRepo {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public Board save(Board board) {
        return null;
    }

    @Override
    public Board getBoardBySiteId(int siteId) {
        try {
            BoardData boardData = boardMapper.getBoardById(siteId);

            System.out.println(boardData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
