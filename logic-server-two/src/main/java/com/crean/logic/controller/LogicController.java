package com.crean.logic.controller;

import com.crean.logic.entities.LogicEntity;
import com.crean.logic.service.LogicOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 逻辑控制
 */
@RestController
@RequestMapping(value = "/logic-two")
public class LogicController {

    @Autowired
    private LogicOneService logicOneService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public LogicEntity test() {
        LogicEntity entity = new LogicEntity();
        entity.setBody("logic-two, logic one body=" + logicOneService.test().getBody());
        return entity;
    }
}
