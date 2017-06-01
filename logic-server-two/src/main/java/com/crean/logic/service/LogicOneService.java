package com.crean.logic.service;

import com.crean.logic.entities.LogicEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用外部服务
 */
@Component
public class LogicOneService {

    /**
     * 利用 feign 调用外部服务接口
     *
     */
    @FeignClient(value = "logic-server-one")
    public interface LogicOneRest {

        @RequestMapping(value = "/logic-one/test", method = RequestMethod.GET)
        LogicEntity test();
    }

    @Autowired
    private LogicOneRest logicOneRest;

    /**
     * 如果调用外部服务失败，使用hystrix熔断，服务降级，返回默认数据
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "testHystrix")
    public LogicEntity test() {
        return logicOneRest.test();
    }

    /**
     * 熔断后调用的函数，可以降级调用备用服务
     *
     * @return
     */
    public LogicEntity testHystrix() {
        LogicEntity entity = new LogicEntity();
        entity.setBody("testHystrix");
        return entity;
    }

}
