package com.rightime.popo.presenter.huv;

import com.rightime.popo.domain.entity.Board;
import com.rightime.popo.domain.entity.PostItem;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class HuvUtza extends Board {

    @Override
    public ArrayList<PostItem> crawl() {
        // every time crawling, it starts from the last page finished
        // utza does not have permanent pagination, so crawl recent 5 pages
        final int pages = 5;


        for (int i = 0; i < pages; i++) {
            System.out.println("do sth");
//            Step step1 = step(writer);
//            JobBuilder jobBuilder = jobBuilderFactory.get("Batch job for crawling " + this.name);
//            jobBuilder.preventRestart().flow(step1).end().build();

        }

        return null;
    }

    public HuvUtza() {
        super();
    }

    public HuvUtza(String name, String url) {
        super(name, url);
    }

    public HuvUtza(String name, String url, String pageParamName, int startPage) {
        super(name, url, pageParamName, startPage);
    }
}

@Configuration
@EnableBatchProcessing
class BatchConfig {
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private HuvUtzaItemWriter writer;

    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        super();
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    public Step step(HuvUtzaItemWriter writer) {
        StepBuilder stepBuilder = stepBuilderFactory.get("step1");
        return stepBuilder.<Integer, ArrayList<PostItem>>chunk(1).reader(reader()).processor(processor()).writer(writer).build();
    }

    @Bean
    public HuvUtzaItemProcessor processor() {
        return new HuvUtzaItemProcessor();
    }

    @Bean
    public MyBatisCursorItemReader<Integer> reader() {
//        return new MyBatisCursorItemReaderBuilder<Integer>().sqlSessionFactory().queryId()
        return null;
    }
}

@Component
class HuvUtzaItemWriter implements ItemWriter<ArrayList<PostItem>> {

    public HuvUtzaItemWriter() {
        System.out.println("...");
    }

    @Override
    public void write(List<? extends ArrayList<PostItem>> list) throws Exception {
        System.out.println("writing results...'");
    }
}


class HuvUtzaItemProcessor implements ItemProcessor<Integer, ArrayList<PostItem>> {

    @Override
    public ArrayList<PostItem> process(Integer page) throws Exception {
        System.out.println("processing...");
        return null;
    }
}