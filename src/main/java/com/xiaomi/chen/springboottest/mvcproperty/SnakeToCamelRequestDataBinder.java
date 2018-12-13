package com.xiaomi.chen.springboottest.mvcproperty;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Chen on 15:46 2018/7/11.
 * 下划线到驼峰的转换
 */
public class SnakeToCamelRequestDataBinder extends ExtendedServletRequestDataBinder {


    public SnakeToCamelRequestDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    @Override
    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);

        List<PropertyValue> covertValues = new ArrayList<PropertyValue>();
        for (PropertyValue propertyValue : mpvs.getPropertyValueList()) {
            if (propertyValue.getName().contains("_")) {
                String camelName = snakeToCamel(propertyValue.getName());
                if (!mpvs.contains(camelName)) {
                    covertValues.add(new PropertyValue(camelName, propertyValue.getValue()));
                }
            }
        }
        mpvs.getPropertyValueList().addAll(covertValues);

    }

    private String snakeToCamel(String snake) {
        if (snake == null) {
            return null;
        }

        if (snake.indexOf("_") < 0) {
            return snake;
        }

        String result = "";

        String[] split = StringUtils.split(snake, "_");
        int index = 0;
        for (String s : split) {
            if (index == 0) {
                result += s.toLowerCase();
            } else {
                result += capitalize(s);
            }
            index++;
        }

        return result;
    }

    private static String capitalize(String s) {

        if (s == null) {
            return null;
        }

        if (s.length() == 1) {
            return s.toUpperCase();
        }

        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
