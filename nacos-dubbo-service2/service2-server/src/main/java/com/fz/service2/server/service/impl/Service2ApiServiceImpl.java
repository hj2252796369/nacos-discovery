package com.fz.service2.server.service.impl;

import com.fz.service2.api.service.api.IService2ApiService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author by        hujie
 * @project_name IntelliJ IDEA
 * @class_name Service2ApiServiceImpl
 * @description
 * @create_date 22:03 2020-04-15
 */
@Service
public class Service2ApiServiceImpl implements IService2ApiService {

    public String dubboService2() {
        return "Service2ApiServiceImpl";
    }
}
