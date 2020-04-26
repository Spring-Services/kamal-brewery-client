package com.kamaldwip.springframework.kamalbreweryclient.web.config;

import com.kamaldwip.springframework.kamalbreweryclient.web.helperBeans.ConnectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${kamal.httpClient.defaultConnections}")
    int defaultNumberOfConnections;

    @Value("${kamal.httpClient.maxConnections}")
    int maxNumberOfConnections;

    @Value("${kamal.httpClient.requestTimeout}")
    int requestTimeout;

    @Value("${kamal.httpClient.socketTimeout}")
    int socketTimeout;

    @Bean
    public ConnectionDataSource dataSource(){
        ConnectionDataSource connectionDataSource = new ConnectionDataSource();
        connectionDataSource.setDefaultNumberOfConnections(defaultNumberOfConnections);
        connectionDataSource.setMaxNumberOfConnections(maxNumberOfConnections);
        connectionDataSource.setSocketTimeout(socketTimeout);
        connectionDataSource.setRequestTimeout(requestTimeout);
        return connectionDataSource;
    }



}
