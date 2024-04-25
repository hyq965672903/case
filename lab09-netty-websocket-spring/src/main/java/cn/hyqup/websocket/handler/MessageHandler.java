package cn.hyqup.websocket.handler;

import cn.hyqup.websocket.manager.UserChannelManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/18
 * @description:
 */
@Slf4j
@NoArgsConstructor
@ChannelHandler.Sharable
public class MessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception {
        log.info("ctx的ID:{}", ctx.channel());
        String text = textWebSocketFrame.text();
        log.info("收到客户端消息:{}", text);
        ctx.channel().writeAndFlush(new TextWebSocketFrame("收到客户端消息：" + text));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("+++++++++++有连接请求：{}==>{}+++++++++++", ctx.channel().id(), ctx.channel().remoteAddress());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        closeChannel(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("netty服务发生异常：{}", cause.getMessage());
        closeChannel(ctx.channel());
    }


    /**
     * 移除在线信息以及关闭channel
     *
     * @param channel
     */
    private void closeChannel(Channel channel) {
        UserChannelManager.removeOnlineUser(channel);
        channel.close();
    }

}
