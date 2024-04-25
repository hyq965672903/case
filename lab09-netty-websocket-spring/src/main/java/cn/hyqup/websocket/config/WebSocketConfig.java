package cn.hyqup.websocket.config;

import cn.hyqup.websocket.server.NettyWebSocketServer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description:
 */
@Slf4j
@Component
public class WebSocketConfig {
    @PostConstruct
    public static void init(){
        NettyWebSocketServer server = new NettyWebSocketServer();
        server.init();
        //这里要新开一个线程，否则会阻塞原本的controller等业务
        new Thread(() -> server.start(), "netty-websocket-server").start();

        /**
         * jvm 退出时关闭
         */
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                log.info("钩子函数执行,优雅停止netty server");
                server.shutdown();
            }
        });

    }

}
