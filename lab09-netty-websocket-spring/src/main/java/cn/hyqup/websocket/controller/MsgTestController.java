package cn.hyqup.websocket.controller;

import cn.hyqup.websocket.manager.UserChannelManager;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/message")
public class MsgTestController {


    @GetMapping(value = "/send")
    public void sendMessageByUserId(){
        ChannelGroup onlineChannelGroup = UserChannelManager.getOnlineChannelGroup();
        onlineChannelGroup.writeAndFlush(new TextWebSocketFrame("你好 hello"));
        log.info("发送消息成功");
    }
}
