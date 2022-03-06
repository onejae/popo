package com.rightime.popo.presenter.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.rightime.popo.presenter.db.mapper")
public class DBConfig {

    @Autowired
    private DataSource dataSource;

    // mybatis-springboot-starter will configure db automatically
//    @Value("${mybatis.config-location}")
//    private String configLocation;

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));

}
