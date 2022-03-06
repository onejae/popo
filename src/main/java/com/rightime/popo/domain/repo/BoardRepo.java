package com.rightime.popo.domain.repo;


import com.rightime.popo.domain.entity.Board;

public interface BoardRepo {
    public Board save(Board board);

    public Board getBoardBySiteId(int siteId);
}