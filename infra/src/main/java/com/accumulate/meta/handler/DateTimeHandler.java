package com.accumulate.meta.handler;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DateTimeHandler implements DataTypeHandler {
    private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>();
    
    static {
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
        dateFormats.add(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS"));
        dateFormats.add(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"));
        dateFormats.add(new SimpleDateFormat("yyyy.MM.dd HH:mm"));
        dateFormats.add(new SimpleDateFormat("yyyy.MM.dd"));
        dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS"));
        dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
        dateFormats.add(new SimpleDateFormat("yyyy/MM/dd HH:mm"));
        dateFormats.add(new SimpleDateFormat("yyyy/MM/dd"));
    }
    
    @Override
    public boolean validate(String v) {
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.parse(v);
                return true;
            } catch(Exception e) {
            }
        }
        return false;
    }
    
    @Override
    public Object transform(String v) {
        for (SimpleDateFormat format : dateFormats) {
            try {
                DateTime date = new DateTime(format.parse(v));
                return date.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
            } catch(Exception e) {
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        DateTimeHandler v = new DateTimeHandler();
        System.out.println(v.transform("1985-07-06"));
        System.out.println(v.transform("1985-7-6T23:41:32.544Z"));
        System.out.println(v.transform("1985-7-6T23:41:32.544"));
        System.out.println(v.transform("1985-7-6 23:41:32.444"));
        System.out.println(v.transform("1985-7-6 23:41:32"));
        System.out.println(v.transform("1985-7-6 23:41"));
        System.out.println(v.transform("2015.4.5 23:12"));
    }
    
}
