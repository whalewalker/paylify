package com.paylify.web.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaylifyException extends RuntimeException{
    final String code;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public PaylifyException(Object err){
        super(OBJECT_MAPPER.convertValue(err, JsonNode.class).toPrettyString());
        this.code = "99";
    }

    public PaylifyException(String err, String code) {
        super(err);
        this.code = code;
    }

    public PaylifyException(Object err, String code){
        super(OBJECT_MAPPER.convertValue(err, JsonNode.class).toPrettyString());
        this.code = code;
    }

}
