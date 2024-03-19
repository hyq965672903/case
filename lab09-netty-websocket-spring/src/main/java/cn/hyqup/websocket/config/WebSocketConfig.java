package cn.hyqup.websocket.config;

import cn.hyqup.websocket.server.NettyWebSocketServer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description:
 */
@Component
public class WebSocketConfig {
    @PostConstruct
    public static void init(){
        NettyWebSocketServer server = new NettyWebSocketServer();
        server.init();
        server.start();
        /**
         * jvm 退出时关闭
         */
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                server.shutdown();
                System.exit(0);
            }
        });

    }

}
