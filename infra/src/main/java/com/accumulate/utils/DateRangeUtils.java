package com.accumulate.utils;

import java.util.Date;

import com.accumulate.base.constant.CommonConstants;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.CommonErrorCode;

/**
 * 处理日期范围相关逻辑的工具类
 * 
 * @author jintao
 * @date 2015年12月19日
 *
 */
public class DateRangeUtils {

	/**
	 * 获取两个日期相差的天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getDiffDayNum(Date start, Date end) {
		long dayMills = 24 * 60 * 60 * 1000;
		long startTime = start.getTime() / dayMills;
		long endTime = end.getTime() / dayMills;
		long diff = endTime - startTime;
		return diff + 1;
	}

	/**
	 * 检查开始时间是否早于结束时间
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ApplicationException
	 */
	public static boolean checkStartAndEndTime(Date startDate, Date endDate) throws ApplicationException {
		if (startDate == null) {
			throw new ApplicationException(CommonErrorCode.DATE_START_NULL);
		}
		if (endDate == null) {
			throw new ApplicationException(CommonErrorCode.DATE_END_NULL);
		}
		int retult = startDate.compareTo(endDate);
		if (retult > 0) {
			throw new ApplicationException(CommonErrorCode.DATE_END_BEFORE_START, startDate, endDate);
		}
		return true;
	}

	/**
	 * 检查开始时间是否早于结束时间，并且时间差是否超过指定天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ApplicationException
	 */
	public static boolean checkStartAndEndRangeDays(Date startDate, Date endDate, int days) throws ApplicationException {
		checkStartAndEndTime(startDate, endDate);
		Date temStartDate2 = DateUtils.addDays(startDate, days);// 开始日期往后推{}天，然后应该大于endDate
		int retult2 = temStartDate2.compareTo(endDate);
		if (retult2 < 0) {
			throw new ApplicationException(CommonErrorCode.DATE_RANGE_OVERSTEP_DAYS,
					DateConverterUtils.convertToStandardString(startDate),
					DateConverterUtils.convertToStandardString(endDate), days);
		}

		return true;
	}

	public static boolean checkStartAndEndRangeDays(Date startDate, Date endDate, Integer maxDays, Integer minDays)
			throws ApplicationException {
		checkStartAndEndTime(startDate, endDate);
		if (maxDays != null) {
			Date temStartDate2 = DateUtils.addDays(startDate, maxDays);// 开始日期往后推{maxDays}天
			int retult2 = endDate.compareTo(temStartDate2);
			if (retult2 > 0) {
				throw new ApplicationException(CommonErrorCode.DATE_RANGE_OVERSTEP_DAYS,
						DateConverterUtils.convertToStandardString(startDate),
						DateConverterUtils.convertToStandardString(endDate), maxDays);
			}
		}
		if (minDays != null) {
			Date temStartDate2 = DateUtils.addDays(startDate, minDays);// 开始日期往后推{minDays}天
			int retult2 = endDate.compareTo(temStartDate2);
			if (retult2 < 0) {
				throw new ApplicationException(CommonErrorCode.DATE_RANGE_LESSTHAN_DAYS,
						DateConverterUtils.convertToStandardString(startDate),
						DateConverterUtils.convertToStandardString(endDate), minDays);
			}
		}

		return true;
	}

	/**
	 * 根据开始日期和结束日期获取当前状态（future-未开始；inprogress-进行中；finished-已结束）
	 * 
	 * @param startTime
	 * @param endTime
	 * @return future: <startTime; inprogress: startTime<endTime; finished:
	 *         >endTime
	 */
	public static String getStatusBetweenTimes(Date startTime, Date endTime) {

		Date now = new Date();
		if (startTime != null && now.compareTo(startTime) < 0) {
			return CommonConstants.TIME_STATUS_FUTURE;
		} else if (endTime != null && now.compareTo(endTime) > 0) {
			return CommonConstants.TIME_STATUS_FINISHED;
		} else {
			return CommonConstants.TIME_STATUS_INPROGRESS;
		}
	}

	/**
	 * Return date before appointed time. For example, appointedTime is 2013-3-1
	 * 11:00:00, interval is 2 hours(2*60*60*1000), then this method return
	 * 2013-3-1 9:00:00.
	 * 
	 * @param appointedTime
	 * @param interval
	 * @return
	 */
	public static Date getDateBeforeTime(Date appointedTime, long interval) {
		long returnTimeMillisecond = getMillisecondBeforeTime(appointedTime, interval);
		return new Date(returnTimeMillisecond);
	}

	/**
	 * Return date of millisecond before appointed time. For example,
	 * appointedTime is 2013-3-1 11:00:00, interval is 2 hours(2*60*60*1000),
	 * then this method return millisecond of time 2013-3-1 9:00:00.
	 * 
	 * @param appointedTime
	 * @param interval
	 * @return
	 */
	public static long getMillisecondBeforeTime(Date appointedTime, long interval) {
		if (appointedTime == null) {
			throw new IllegalArgumentException(
					"Parameter appointedTime in DateTimeUtils.getMillisecondBeforeTime can not be null ");
		}
		long appointedTimeMillisecond = appointedTime.getTime();
		long returnTimeMillisecond = appointedTimeMillisecond - interval;
		return returnTimeMillisecond;
	}

	/**
	 * Return date before appointed time. For example, appointedTime is 2013-3-1
	 * 11:00:00, interval is 2 hours(2*60*60*1000), then this method return
	 * 2013-3-1 9:00:00.
	 * 
	 * @param appointedTime
	 * @param interval
	 * @return
	 */
	public static Date getDateAfterTime(Date appointedTime, long interval) {
		long returnTimeMillisecond = getMillisecondAfterTime(appointedTime, interval);
		return new Date(returnTimeMillisecond);
	}

	/**
	 * Return date of millisecond before appointed time. For example,
	 * appointedTime is 2013-3-1 11:00:00, interval is 2 hours(2*60*60*1000),
	 * then this method return millisecond of time 2013-3-1 9:00:00.
	 * 
	 * @param appointedTime
	 * @param interval
	 * @return
	 */
	public static long getMillisecondAfterTime(Date appointedTime, long interval) {
		if (appointedTime == null) {
			throw new IllegalArgumentException(
					"Parameter appointedTime in DateTimeUtils.getMillisecondAfterTime can not be null ");
		}
		long appointedTimeMillisecond = appointedTime.getTime();
		long returnTimeMillisecond = appointedTimeMillisecond + interval;
		return returnTimeMillisecond;
	}
}
