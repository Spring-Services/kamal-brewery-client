package com.kamaldwip.springframework.kamalbreweryclient.web.config;

import com.kamaldwip.springframework.kamalbreweryclient.web.helperBeans.ConnectionDataSource;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    @Autowired
    ConnectionDataSource dataSource;

    public ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(dataSource.getDefaultNumberOfConnections());
        connectionManager.setMaxTotal(dataSource.getMaxNumberOfConnections());

        System.out.println(connectionManager.getDefaultMaxPerRoute());
        System.out.println(connectionManager.getMaxTotal());

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(dataSource.getRequestTimeout())
                .setSocketTimeout(dataSource.getSocketTimeout())
                .build();

        System.out.println(requestConfig.getConnectionRequestTimeout());
        System.out.println(requestConfig.getSocketTimeout());

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);

    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(clientHttpRequestFactory());
    }
}
