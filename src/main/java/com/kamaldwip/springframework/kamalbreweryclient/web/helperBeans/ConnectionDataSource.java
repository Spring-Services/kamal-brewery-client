package com.kamaldwip.springframework.kamalbreweryclient.web.helperBeans;


public class ConnectionDataSource {

    private  int defaultNumberOfConnections;

    private int maxNumberOfConnections;

    private int requestTimeout;

    private int socketTimeout;

    public int getDefaultNumberOfConnections() {
        return defaultNumberOfConnections;
    }

    public void setDefaultNumberOfConnections(int defaultNumberOfConnections) {
        this.defaultNumberOfConnections = defaultNumberOfConnections;
    }

    public int getMaxNumberOfConnections() {
        return maxNumberOfConnections;
    }

    public void setMaxNumberOfConnections(int maxNumberOfConnections) {
        this.maxNumberOfConnections = maxNumberOfConnections;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
