package com.crean.logic.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 逻辑返回的实例
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogicEntity {

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
