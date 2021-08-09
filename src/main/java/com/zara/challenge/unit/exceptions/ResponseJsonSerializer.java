package com.zara.challenge.unit.exceptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ResponseJsonSerializer extends JsonSerializer<ErrorResponse> {

    @Override
    public void serialize(ErrorResponse response, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("status", String.valueOf(response.getStatus()));
        jsonGenerator.writeStringField("message", response.getMessage());
        jsonGenerator.writeEndObject();
    }
}
