package cn.hyqup.websocket.manager;

import cn.hutool.core.util.IdUtil;
import cn.hyqup.websocket.constant.AttributeKeyConstant;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/19
 * @description:
 */
@Slf4j
public class UserChannelManager {

    /**
     * 存储所有在线的客户端Channel
     */
    private static final ChannelGroup onlineChannelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 存储所有在线的userId与之对应的Channel
     */
    private static final ConcurrentMap<String, Channel> onlineUserChannelMap = new ConcurrentHashMap<>();

    private static AtomicInteger onlineUserCount = new AtomicInteger(0);

    private static <T> void setAttribute(Channel channel, String key, T value) {
        AttributeKey<T> attrKey = AttributeKey.valueOf(key);
        Attribute<T> attr = channel.attr(attrKey);
        attr.setIfAbsent(value);
    }

    private static <T> T getAttribute(Channel channel, String key) {
        AttributeKey<T> attrKey = AttributeKey.valueOf(key);
        return channel.attr(attrKey).get();
    }

    /**
     * 添加在线用户
     *
     * @param channel
     * @param wsToken
     */
    public static void addOnlineUser(Channel channel, String wsToken) {
        //TODO,正确的做法从token解析或者从缓存中获取userId
        String userId = IdUtil.simpleUUID();
        onlineUserChannelMap.put(userId, channel);
        onlineChannelGroup.add(channel);
        setAttribute(channel, AttributeKeyConstant.USER_ID, userId);
        setAttribute(channel, AttributeKeyConstant.WS_TOKEN_KEY, wsToken);
        int count = onlineUserCount.incrementAndGet();
        log.info("当前在线用户共{}个", count);

    }

    /**
     * 移除在线用户
     *
     * @param channel
     */
    public static void removeOnlineUser(Channel channel) {
        String userId = getAttribute(channel, AttributeKeyConstant.USER_ID);
        onlineUserChannelMap.remove(userId);
        onlineChannelGroup.remove(channel);
        log.info("客户端：{} 断开连接", userId);
        int count = onlineUserCount.decrementAndGet();
        log.info("客户端还有{}个连接中", count);
    }
    /**
     * 获取所有的在线用户
     */
    public static ChannelGroup getOnlineChannelGroup() {
        return onlineChannelGroup;
    }

    /**
     * 获取在线用户
     *
     * @param userId
     * @return
     */
    public static Channel getOnlineUserChannel(String userId) {
        return onlineUserChannelMap.get(userId);
    }

    /**
     * 获取在线用户人数
     */
    public static int getOnlineUserCount() {
        return onlineUserCount.get();
    }

}
