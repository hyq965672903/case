package cn.hyqup.socketio.config;

import cn.hutool.json.JSONUtil;
import cn.hyqup.socketio.properties.SocketIOProperties;
import com.corundumstudio.socketio.AuthorizationResult;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Copyright © 2024. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2024/3/15
 * @description:
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(SocketIOProperties.class)
public class SocketIOConfig {

    private final SocketIOProperties socketIOProperties;

    @Bean
    public SocketIOServer socketIOServer() {
        log.info("初始化SocketIO配置");
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();

        // 设置端口号，默认为 9092
        config.setPort(socketIOProperties.getPort());
        // 设置 Boss 线程数，默认为 CPU 核心数的 2 倍
        config.setBossThreads(socketIOProperties.getBossThreads());
        // 设置 Worker 线程数，默认为 CPU 核心数的 2 倍
        config.setWorkerThreads(socketIOProperties.getWorkerThreads());
        // 是否允许自定义请求，默认为 false
        config.setAllowCustomRequests(socketIOProperties.isAllowCustomRequests());
        // 设置升级超时时间（毫秒），默认为 10000 毫秒
        config.setUpgradeTimeout(socketIOProperties.getUpgradeTimeout());
        // 设置 Ping 超时时间（毫秒），默认为 60000 毫秒
        config.setPingTimeout(socketIOProperties.getPingTimeout());
        // 设置 Ping 间隔时间（毫秒），默认为 25000 毫秒
        config.setPingInterval(socketIOProperties.getPingInterval());
//        config.setOrigin("*");

        SocketConfig socketConfig = new SocketConfig();
        // 是否启用 TCP 无延迟，默认为 true
        socketConfig.setTcpNoDelay(true);
        // 设置 SO 延迟时间（秒），默认为 0
        socketConfig.setSoLinger(0);
        // 设置 Socket 配置到配置对象
        config.setSocketConfig(socketConfig);


        config.setAuthorizationListener(handshakeData -> {
            log.info("握手数据：{}", JSONUtil.toJsonStr(handshakeData));
            HttpHeaders headers = handshakeData.getHttpHeaders();
            for (Map.Entry<String, String> header : headers) {
                System.out.println(header.getKey() + ":" + header.getValue());
            }
            String token = headers.get("token");
            if (null == token) {
                return AuthorizationResult.FAILED_AUTHORIZATION;
            }
            return AuthorizationResult.SUCCESSFUL_AUTHORIZATION;
        });

        // 创建 Socket.IO 服务器
        SocketIOServer socketIOServer = new SocketIOServer(config);
        return socketIOServer;
    }

    /**
     * 注册SpringAnnotationScanner
     *
     * @param socketIOServer
     * @return
     */
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
        return new SpringAnnotationScanner(socketIOServer);
    }


}
