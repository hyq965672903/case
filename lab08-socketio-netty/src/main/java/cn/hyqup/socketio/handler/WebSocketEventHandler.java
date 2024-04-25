package cn.hyqup.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/15
 * @description:
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class WebSocketEventHandler {
    private final SocketIOServer server;

    /**
     * 建立链接
     *
     */
    @OnConnect
    public void onConnect(SocketIOClient ioClient) {
        log.info("onConnect:{}", ioClient);
    }

    /**
     * 断开链接
     * SocketIOClient
     */
    @OnDisconnect
    public void onDisconnect(SocketIOClient ioClient) {
        System.err.println(ioClient.getRemoteAddress() + " web客户端接入");
        String s = ioClient.getSessionId().toString();
        log.info("onDisconnect会话id:{}", s);
    }

    @OnEvent(value = "send")
    public void onSendEvent(SocketIOClient client, AckRequest request, Object data) {
        log.info("接收消息:{}", data);
    }

    @OnEvent(value = "chatevent")
    public void onChatEvent(SocketIOClient client, AckRequest request, Object data) {
        log.info("接收消息:{}", data);
        server.getBroadcastOperations().sendEvent("chatevent", data);
    }
}
