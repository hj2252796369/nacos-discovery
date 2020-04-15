package com.fz.service1.server.service.impl;

import com.fz.service1.api.service.IService1ApiService;
import com.fz.service2.api.service.api.IService2ApiService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author by        hujie
 * @project_name IntelliJ IDEA
 * @class_name Service1ApiServiceImpl
 * @description
 * @create_date 22:43 2020-04-15
 */
@Service
public class Service1ApiServiceImpl implements IService1ApiService {

    @Reference
    private IService2ApiService service2ApiService;

    public String dubboService1() {
        return "Dubbo Service1Api || " + service2ApiService.dubboService2();
    }
}
