package com.rightime.popo.controllers;

import com.rightime.popo.domain.entity.CrawlObject;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.PostItem;
import com.rightime.popo.domain.service.MessageHandler;
import com.rightime.popo.domain.service.MessageService;
import com.rightime.popo.domain.usecase.CrawlUsecase;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import com.rightime.popo.presenter.db.dto.PostItemData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JobWorker implements MessageHandler {

    private CrawlUsecase crawlUsecase;
    private MessageService messageService;
    private JobScheduleUsecase jobScheduleUsecase;

    public JobWorker(MessageService messageService, JobScheduleUsecase jobScheduleUsecase) {
        this.messageService = messageService;
        this.messageService.setHandler("jobs", this);
        this.jobScheduleUsecase = jobScheduleUsecase;
    }

    @Override
    public void OnMessage(String message) {

    }

    @Override
    public void OnMessage(CrawlJob job) {
        ArrayList<PostItem> postItemArrayList = crawlUsecase.crawlAndStore(jobScheduleUsecase.getCrawlObjectById(job.jobObjectId));
    }
}
