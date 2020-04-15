package com.fz.nacos.consumer;

import com.fz.service2.api.service.api.IService2ApiService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author by        hujie
 * @project_name IntelliJ IDEA
 * @class_name RestConsumerController
 * @description
 * @create_date 20:34 2020-04-14
 */
@RestController
@RequestMapping("/consumer")
public class RestConsumerController {

    /**
     *    指定服务名称
     */
    private String providerName = "nacos-restful-provider";

    /**
     *通过负载均衡发现地址，
     * @return
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(){
        RestTemplate restTemplate = new RestTemplate();

        ServiceInstance serviceInstance = loadBalancerClient.choose(providerName);
        URI uri = serviceInstance.getUri();
        String forObject = restTemplate.getForObject(uri + "/provider/hello", String.class);

        return "Consumer Nacos===========" + forObject;
    }

    @Reference
    private IService2ApiService service2ApiService;

    @GetMapping("/service2")
    public String service2(){
        String resultString = service2ApiService.dubboService2();
        return "Dubbo Nacos Consumer ||  " + resultString;

    }

}
