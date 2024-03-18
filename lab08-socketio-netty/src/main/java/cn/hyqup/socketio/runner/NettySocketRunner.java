package cn.hyqup.socketio.runner;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/15
 * @description:
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class NettySocketRunner implements CommandLineRunner {
    private final SocketIOServer socketIOServer;
    @Override
    public void run(String... args) throws Exception {
        log.info("--------------------SocketIOServer socket.io通信启动成功!---------------------");
        socketIOServer.start();
    }
}
