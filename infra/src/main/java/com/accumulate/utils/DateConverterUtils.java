package com.accumulate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.accumulate.exception.CommonErrorCode;
import com.accumulate.exception.SystemException;

/**
 * 处理日期格式转换的工具类
 * 
 */
public class DateConverterUtils {

	public static final String DATETIME_PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String DATETIME_PATTERN_TIMESTAMP = "yyyyMMddHHmmssSSS";

	public static final String DATETIME_PATTERN_NO_SECOND = "yyyy-MM-dd HH:mm";

	public static final String DATE_PATTERN = "yyyy-MM-dd";

	public static final String MONTH_PATTERN = "yyyy-MM";

	public static final String MONTH_DAY_PATTERN = "yyMM";
	
	public static final String TIME_PATTERN = "HHmmss";

	public static final SimpleDateFormat standardDateFormat = new SimpleDateFormat(
			DATETIME_PATTERN_STANDARD);

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

	public static String doConvertDateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern);
		String result = simpleDateFormat.format(date);
		return result;
	}

	public static String convertToStandardString(Date date) {
		return doConvertDateToString(date, DATETIME_PATTERN_STANDARD);
	}

	public static String convertToTimeStamp(Date date) {
		return doConvertDateToString(date, DATETIME_PATTERN_TIMESTAMP);
	}

	public static String convertToStringNoSecond(Date date) {
		return doConvertDateToString(date, DATETIME_PATTERN_NO_SECOND);
	}

	public static String convertDateToMonthDay(Date date) {
		return doConvertDateToString(date, MONTH_DAY_PATTERN);
	}

	public static Date doConvertStringToDate(String stringDate, String pattern) {
		Date date = null;
		SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(stringDate);
		} catch (ParseException e) {
			throw new SystemException(CommonErrorCode.DATE_FORMAT_ERROR, e, stringDate, pattern);
		}
		return date;
	}

	public static Date convertToStandardDate(String dateString) {
		return doConvertStringToDate(dateString, DATETIME_PATTERN_STANDARD);
	}

	private static SimpleDateFormat getSimpleDateFormat(String pattern) {
		if (DATETIME_PATTERN_STANDARD.equals(pattern)) {
			return standardDateFormat;
		} else if (DATE_PATTERN.equals(pattern)) {
			return dateFormat;
		} else {
			return new SimpleDateFormat(pattern);
		}
	}

	/**
	 * 获取{hours}个小时之前的时间
	 * 
	 * @param hours
	 * @return
	 */
	public static Date getDateBefore(int hours, Date date) {
		Calendar now = Calendar.getInstance();
		if (date == null) {
			date = new Date();
		}
		now.setTime(date);
		now.set(Calendar.HOUR, now.get(Calendar.HOUR) - hours);
		return now.getTime();
	}

	/**
	 * 获取{hours}个小时之后的时间
	 * 
	 * @param hours
	 * @return
	 */
	public static Date getDateAfter(int hours, Date date) {
		Calendar now = Calendar.getInstance();
		if (date == null) {
			date = new Date();
		}
		now.setTime(date);
		now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hours);
		return now.getTime();
	}
	
	/**
	 * 将格式为”20150520“的数字，转化为日期
	 * @param dayTime
	 * @return
	 */
	public static Date getDateFromInteger(Integer dayTime) {
		String dayTimeStr = String.valueOf(dayTime);
		Integer year = Integer.valueOf(dayTimeStr.substring(0, 4));
		Integer month = Integer.valueOf(dayTimeStr.substring(4, 6));
		Integer day = Integer.valueOf(dayTimeStr.substring(6, 8));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, day);
		
		return c.getTime();
	}
	
	public static Date getDateFromInteger(Integer dayTime, Integer hour) {
		String dayTimeStr = String.valueOf(dayTime);
		Integer year = Integer.valueOf(dayTimeStr.substring(0, 4));
		Integer month = Integer.valueOf(dayTimeStr.substring(4, 6));
		Integer day = Integer.valueOf(dayTimeStr.substring(6, 8));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	public static Date getDateFromInteger(Integer dayTime, Integer hour, Integer minute) {
		String dayTimeStr = String.valueOf(dayTime);
		Integer year = Integer.valueOf(dayTimeStr.substring(0, 4));
		Integer month = Integer.valueOf(dayTimeStr.substring(4, 6));
		Integer day = Integer.valueOf(dayTimeStr.substring(6, 8));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	public static Integer getIntegerFromDate(Date dayTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(dayTime);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		StringBuilder sb = new StringBuilder("");
		sb.append(year);
		if (month < 10) {
			sb.append("0");
		}
		sb.append(month);
		if (day < 10) {
			sb.append("0");
		}
		sb.append(day);
		
		return Integer.valueOf(sb.toString());
	}
	
	public static long getDiffDayNum(Date start, Date end) {
		long dayMills = 24 * 60 * 60 * 1000;
		
		long startTime = start.getTime() / dayMills;
		long endTime = end.getTime() / dayMills;
		
		long diff = endTime - startTime;
		
		return diff + 1;
	}

	public static void main(String[] args) {
		//System.out.println(DateConverterUtils.convertToTimeStamp(new Date()));
		
		Date date = getDateFromInteger(20150525, 17);
		System.out.println(date);
	}
}
