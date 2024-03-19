package cn.hyqup.websocket.server;

import cn.hyqup.websocket.handler.AuthHandler;
import cn.hyqup.websocket.handler.MessageHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/18
 * @description: handlerAdded() –> channelRegistered() –> channelActive() –> channelRead() –> channelReadComplete()
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 因为是基于http协议的，使用http的编解码器
        pipeline.addLast(new HttpServerCodec());
        // 以块的方式写，添加ChunkedWriteHandler
        pipeline.addLast(new ChunkedWriteHandler());
        /**
         * http数据再传输的过程中是分段的，HttpObjectAggregator就是将多个段聚合
         * 这就是为什么，当浏览器发送大量数据时，会发出多次http请求
         */
        pipeline.addLast(new HttpObjectAggregator(1024 * 1024 * 1024));

        // 自定义的handler，处理身份验证
        pipeline.addLast(new AuthHandler());

        // 心跳检测handler,重写IdleStateHandler
//        pipeline.addLast(new WebSocketIdleStateHandler());

        /**
         * 对于websocket他的数据是以frame的形式传递的
         * 可以看到websocketFrame下面有六个子类
         * 浏览器请求时，ws://localhost:9092/ws 标识请求的URI
         * WebSocketServerProtocolHandler核心功能是将http协议升级，保持长链接
         * 还是通过一个状态码101
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws", null, true, 65536 * 10));

        //自定义消息message handler处理器
        pipeline.addLast(new MessageHandler());


    }
}
