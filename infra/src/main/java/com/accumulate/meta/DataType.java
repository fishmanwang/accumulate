package com.accumulate.meta;


import com.accumulate.dto.KeyValue;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.CommonErrorCode;
import com.accumulate.meta.handler.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjwang on 2016/10/9.
 */
public enum DataType {
    String("String", "字符串", String.class, "", null),
    Boolean("Boolean", "布尔类型", Boolean.class, "取值可以为true/false, 1/0, 是/否", new BooleanHandler()),
    DateTime("DateTime", "日期类型", org.joda.time.DateTime.class, "日期格式 yyyy-MM-dd'T'HH:mm:ss.SSSZ", new DateTimeHandler()),
    Number("Number", "数值", Double.class, "数值类型，支持小数", new DoubleHandler()),
    Email("Email", "电子邮件类型", String.class, "电子邮件", new EmailHandler()),
    Mobile("Mobile", "移动号码", String.class, "11位数字", new MobileHandler()),
    Password("Password", "密码", String.class, "密码，HASH后的值", null),;

    DataType(String code, String name, Class clazz, String description, DataTypeHandler handler) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.clazz = clazz;
        this.handler = handler;
    }

    // 编码
    private String code;
    // 名称
    private String name;
    // 描述
    private String description;
    // 内部处理类型
    private Class clazz;

    private DataTypeHandler handler;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Class getClazz() {
        return clazz;
    }

    public String validate(String value) {
        if (handler == null) {
            return null;
        }

        if (handler.validate(value) || (handler instanceof BooleanHandler)) {
            return null;
        } else {
            return "数据类型必须是" + name;
        }
    }

    public Object transform(String value) {
        if (handler == null) {
            return value;
        }

        return handler.transform(value);
    }

    public static DataType parseByCode(String code) {
        if (DataType.String.name().equalsIgnoreCase(code)) {
            return DataType.String;
        }
        if (DataType.Boolean.name().equalsIgnoreCase(code)) {
            return DataType.Boolean;
        }
        if (DataType.DateTime.name().equalsIgnoreCase(code)) {
            return DataType.DateTime;
        }
        if (DataType.Number.name().equalsIgnoreCase(code)) {
            return DataType.Number;
        }
        if (DataType.Email.name().equalsIgnoreCase(code)) {
            return DataType.Email;
        }
        if (DataType.Mobile.name().equalsIgnoreCase(code)) {
            return DataType.Mobile;
        }
        if (DataType.Password.name().equalsIgnoreCase(code)) {
            return DataType.Password;
        }

        throw new ApplicationException(CommonErrorCode.APP_ATTR_TYPE_NOT_EXISTS);
    }

    public static List<KeyValue<String, String>> toList() {
        List<KeyValue<String, String>> dataTypes = new ArrayList<>();
        for (DataType dataType : DataType.values()) {
            KeyValue<String, String> keyValue = new KeyValue<>();
            // 使用枚举变量的名字
            keyValue.setK(dataType.name());
            keyValue.setV(dataType.getName());
            dataTypes.add(keyValue);
        }
        return dataTypes;
    }
}
