package cn.hyqup.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/18
 * @description:
 */
public class NettyWebSocketServer {


    public NettyWebSocketServer() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup(1, new DefaultThreadFactory("BOSS-GROUP", true));
        EventLoopGroup workerGroup = new NioEventLoopGroup(2, new DefaultThreadFactory("WORKER-GROUP", true));
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_RCVBUF, 1024 * 1024)// 设置读取缓冲区大小
                .option(ChannelOption.SO_BACKLOG, 128) //设置队列大小
                .option(ChannelOption.SO_TIMEOUT, 10 * 1000) //设置读取超时时间
                .option(ChannelOption.SO_SNDBUF, 1024 * 1024) //设置发送缓冲区大小
                .childOption(ChannelOption.SO_KEEPALIVE, true) //是否保持长连接
                .childOption(ChannelOption.SO_REUSEADDR, true)  //是否开启复用端口
                .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5 * 1000) //设置链接超时时间
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.TCP_NODELAY, true)//子处理器处理客户端连接的请求和数据
                .childHandler(new ServerChannelInitializer());//添加自定义初始化处理器集合
        ;
    }



}
