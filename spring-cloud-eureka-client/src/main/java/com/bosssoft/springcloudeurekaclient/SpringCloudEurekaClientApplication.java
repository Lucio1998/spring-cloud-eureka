package com.bosssoft.springcloudeurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注意这里也可使用@EnableEurekaClient
 *但由于springcloud是灵活的，注册中心支持eureka、consul、zookeeper等
 * 若写了具体的注册中心注解，则当替换成其他注册中心时，又需要替换成对应的注解了。
 * 所以 直接使用@EnableDiscoveryClient 启动发现。
 * 这样在替换注册中心时，只需要替换相关依赖即可
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
    }

    /**
     * 从配置文件获得属性
     */
    @Value("${server.port}")
    String port;

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
