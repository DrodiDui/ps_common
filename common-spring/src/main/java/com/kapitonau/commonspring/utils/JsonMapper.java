/*
package com.kapitonau.commonspring.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class JsonMapper {
    private final ObjectMapper objectMapper;

    @Nullable
    public <T> T toObject(String json, Class<T> valueType) {
        if (json == null)
            return null;
        try {
            return objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new MapperException(e, json);
        }
    }

    @Nullable
    public <T> T toObject(byte[] bytes, Class<T> valueType) {
        if (bytes == null)
            return null;
        try {
            return objectMapper.readValue(bytes, valueType);
        } catch (IOException e) {
            throw new MapperException(e, bytes.toString());
        }
    }

    @Nullable
    public <T> HashMap<String, T> toMap(String json, Class<T> valueType) {
        if (json == null)
            return null;
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, valueType));
        } catch (IOException e) {
            throw new MapperException(e, json);
        }
    }

    @Nullable
    public <T> HashMap<String, T> toMap(byte[] bytes, Class<T> valueType) {
        if (bytes == null)
            return null;
        try {
            return objectMapper.readValue(bytes, objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, valueType));
        } catch (IOException e) {
            throw new MapperException(e, bytes.toString());
        }
    }

    @Nullable
    public HashMap<String, Object> toObjectMap(String json) {
        return toMap(json, Object.class);
    }

    @Nullable
    public HashMap<String, Object> toObjectMap(byte[] bytes) {
        return toMap(bytes, Object.class);
    }


    public <T> List<T> toObjectList(String json, Class<T> valueType) {
        if (json == null)
            return Collections.emptyList();
        try {

            return objectMapper.readValue(json, new ObjectMapper().getTypeFactory().constructCollectionType(List.class, valueType));
        } catch (IOException e) {
            throw new MapperException(e, json);
        }
    }

    public <T> List<T> toObjectList(byte[] bytes, Class<T> valueType) {
        if (bytes == null)
            return Collections.emptyList();
        try {

            return objectMapper.readValue(bytes, new ObjectMapper().getTypeFactory().constructCollectionType(List.class, valueType));
        } catch (IOException e) {
            throw new MapperException(e, bytes.toString());
        }
    }

    @Nullable
    public String toString(Object object) {
        if (object == null)
            return null;
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new MapperException(e, object.toString());
        }
    }
}
*/
