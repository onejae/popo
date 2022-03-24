package com.rightime.popo.presenter.repo;

import com.rightime.popo.domain.entity.CrawlObject;
import com.rightime.popo.domain.repo.CrawlObjectRepo;
import com.rightime.popo.presenter.db.dto.BoardData;
import com.rightime.popo.presenter.db.dto.CrawlObjectData;
import com.rightime.popo.presenter.db.mapper.BoardMapper;
import com.rightime.popo.presenter.db.mapper.CrawlObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrawlObjectRepoMysql implements CrawlObjectRepo {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private CrawlObjectMapper crawlObjectMapper;

    @Override
    public CrawlObject save(CrawlObject board) {
        return null;
    }

    @Override
    public CrawlObject getObjectById(int id) {
        // get object(board or site) by id, table join must be needed
        try {
            CrawlObjectData crawlObjectData = crawlObjectMapper.getCrawlObjectById(id);

            if (crawlObjectData.name.equals("Board")) {
                BoardData boardData = boardMapper.getBoardByObjectId(id);

                // let's boarddata to board(crawl) and return
            } else if (crawlObjectData.name.equals("Site")) {

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
