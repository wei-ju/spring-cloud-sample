package com.crean.logic.controller;

import com.crean.logic.entities.LogicEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 逻辑控制
 */
@RestController
@RequestMapping(value = "/logic-one")
public class LogicController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public LogicEntity test() {
        LogicEntity entity = new LogicEntity();
        entity.setBody("logic-one 15120");
        return entity;
    }
}
