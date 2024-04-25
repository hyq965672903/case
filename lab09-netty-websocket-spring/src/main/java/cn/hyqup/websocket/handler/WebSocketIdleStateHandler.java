package cn.hyqup.websocket.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description: WebSocket服务端的心跳检测
 * 两种实现方式：（我这里选择方式一,因为代码可读性高）
 * 1、自定义IdleStateHandler，可在其中处理IdleStateEvent事件
 * 2、不自定义IdleStateHandler，直接使用IdleStateHandler，
 *  但此时需要在WebSocketHandler(ChannelInboundHandler 的子类)中处理IdleStateEvent事件，
 *  并且需要在WebSocketHandler中重写userEventTriggered方法向下传递，不传递的话后续的事件将不会被处理
 */
@Slf4j
public class WebSocketIdleStateHandler  extends IdleStateHandler {
    /**
     * 默认的读空闲时间
     */
    private static final int DEFAULT_READER_IDLE_TIME = 5;
    public WebSocketIdleStateHandler() {
        this(DEFAULT_READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    public WebSocketIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
        super(readerIdleTime, writerIdleTime, allIdleTime, unit);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        //如果是读空闲
        if (evt.state().equals(IdleState.READER_IDLE)) {
            Channel channel = ctx.channel();
            log.info("服务端未检测到客户端【{}】的心跳包，强制关闭客户端！", channel.id());
            channel.close();
        }
        super.channelIdle(ctx, evt);
    }
}
