package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
// TODO: 2020/9/26  配合springcloud bus总线的引入，可以实现动态刷新，一次配置，处处生效（只需要向配置中心发一次post请求即可）
@RefreshScope
public class ConfigClientController {
    // 因为config仓库以rest形式暴露，所以所有客户端都可以通过config服务端访问到github上对应的文件信息
    @Value("${config.info}")
    private String configInfo;

    /**
     *  发送一次post请求，即可处处生效。
     *  curl -X POST "http://localhost:3344/actuator/bus-refresh"
     *
     *  http://localhost:3355/configInfo
     *  http://localhost:3366/configInfo
     * @return
     */
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
