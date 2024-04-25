package cn.hyqup.websocket.handler;

import cn.hyqup.websocket.manager.UserChannelManager;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description: 本Handler 只是在HTTP协议升级为websocket协议之前做鉴权验证，鉴权成功后从pipeline中移除
 */
@Slf4j
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            HttpHeaders headers = request.headers();
            String wsToken = headers.get("ws-token");
            if (!authenticateUser(wsToken)) {
                log.info("用户未登录，关闭连接");
                ctx.close();
            } else {
                UserChannelManager.addOnlineUser(ctx.channel(),wsToken);
                //移除本处理器,后续直接走下一个处理器
                ctx.pipeline().remove(this);
                ctx.fireChannelRead(msg);
            }
        }
    }

    private boolean authenticateUser(String wsToken) {
        return null != wsToken;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("发生异常，程序终止");
        cause.printStackTrace();
        ctx.channel().close();
    }
}
