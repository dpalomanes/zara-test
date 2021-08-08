package com.zara.challenge.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class ResponseJsonSerializerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerialization() throws JsonProcessingException {
        ErrorResponse errorResponse = new ErrorResponse(404, "Resource not found.");
        String json = objectMapper.writeValueAsString(errorResponse);

        assertEquals("{\"status\":\"404\",\"message\":\"Resource not found.\"}", json);
    }
}