package com.accumulate.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tjwang on 2016/8/10.
 */
@Component
public class ObjectMapperUtil implements InitializingBean {

    private static ObjectMapper mapper = null;


    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new ObjectMapper();
        mapper.registerModule(new DateTimeModule());
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);

    public String write(Object o)  {
        Assert.notNull(o);
        String value = "{}";
        try {
            value = mapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            logger.error("序化失败", ex);
        }
        return value;
    }

    public <T> T read(String value, Class<T> clazz) {
        try {
            return mapper.readValue(value, clazz);
        } catch (IOException ex) {
            logger.error("反序化失败", ex);

        }
        return null;
    }

    private class DateTimeModule extends SimpleModule {
        public DateTimeModule() {
            super();
            addSerializer(DateTime.class, new DateTimeSerializer());
        }
    }


    private class DateTimeSerializer extends StdScalarSerializer<DateTime> {

        protected DateTimeSerializer() {
            super(DateTime.class);
        }

        @Override
        public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = format.format(new Date(value.getMillis()));
            jgen.writeString(dateString);
        }
    }

}
