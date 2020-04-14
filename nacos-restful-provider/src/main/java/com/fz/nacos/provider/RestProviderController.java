package com.fz.nacos.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by        hujie
 * @project_name IntelliJ IDEA
 * @class_name RestProviderController
 * @description
 * @create_date 20:31 2020-04-14
 */
@RestController
@RequestMapping("/provider")
public class RestProviderController {

    @GetMapping("/hello")
    public String hello(String text){
        return "Nacos-Provider======hello" + text;
    }

}
