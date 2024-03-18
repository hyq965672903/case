package cn.hyqup.socketio.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/15
 * @description:
 */
@Data
@ConfigurationProperties(prefix = "socketio")
public class SocketIOProperties {
    private int port=9092;
    private int bossThreads=1;
    private int workerThreads=100;
    private boolean isAllowCustomRequests=true;
    private int upgradeTimeout=100000;
    private int pingTimeout=6000000;
    private int pingInterval=30000;
}
