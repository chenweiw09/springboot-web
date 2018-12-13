package com.xiaomi.chen.springboottest.utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
public class JSONUtil {
    private static ObjectMapper mapper = null;

    public JSONUtil() {
    }

    public static String toJSONString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException var2) {
            throw new RuntimeException("toJSONString|object to json string exception:" + var2);
        }
    }

    public static <T> T parseObject(String str, Class<T> clazz) {
        if (str != null && !str.isEmpty()) {
            try {
                return mapper.readValue(str, clazz);
            } catch (IOException var3) {
                throw new RuntimeException("parseObject|to object exception:" + var3);
            }
        } else {
            return null;
        }
    }

    static {
        mapper = new ObjectMapper();
        mapper.configure(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, true);
    }
}
