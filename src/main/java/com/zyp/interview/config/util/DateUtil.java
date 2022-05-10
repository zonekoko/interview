package com.zyp.interview.config.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public final static String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String YMD_PATTERN = "yyyy-MM-dd";
    public final static String YM_PATTERN = "yyyy-MM";
    public final static String YM_PATTERN_2 = "yyyyMM";

    public static final String HH_MM_FORMAT = "HH:mm";
    public static final String DATETIME_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDD_FORMAT = "yyyyMMdd";
    public static final String YYYYMMDDHHMM_FORMAT = "yyyyMMddHHmm";
    public static final String YYYYMMDDHHMMSS_FORMAT = "yyyyMMddHHmmss";
    public static final String YYYYMMDD_OL_HHMMSS_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String MM_DD_FORMAT = "MM月dd日";

    public static String getYmdHms(Date date) {
        if (ObjUtil.isEmpty(date)) {
            return null;
        }

        return DateFormatUtils.format(date, YMDHMS_PATTERN);
    }

    public static String getStringDate(Date date,String format) {
        if (ObjUtil.isEmpty(date)) {
            return null;
        }

        return DateFormatUtils.format(date, format);
    }

    public static String getYmdHmsV2(Date date) {
        if (ObjUtil.isEmpty(date)) {
            return null;
        }

        return DateFormatUtils.format(date, YYYYMMDDHHMMSS_FORMAT);
    }

    public static String getYmd(Date date) {
        if (ObjUtil.isEmpty(date)) {
            return null;
        }

        return DateFormatUtils.format(date, YMD_PATTERN);
    }

    public static String getYm(Date date) {
        if (ObjUtil.isEmpty(date)) {
            return null;
        }

        return DateFormatUtils.format(date, YM_PATTERN);
    }

    public static String getYmdHms(Long timestamp) {
        if (ObjUtil.isEmpty(timestamp)) {
            return null;
        }

        return DateFormatUtils.format(timestamp, YMDHMS_PATTERN);
    }

    public static Date getAfterNumDate(Date date, int num) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }

    public static Date getAfterNumDate(Date date, int num, int field) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, num);
        return calendar.getTime();
    }

    public static Date StringToDate(String strDate, String strDateFormat) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        } else {
            if ("".equals(strDateFormat) || strDateFormat == null) {
                strDateFormat = YMDHMS_PATTERN;
            }
            Date rDate;
            SimpleDateFormat format = new SimpleDateFormat(strDateFormat);
            try {
                rDate = format.parse(strDate);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return rDate;
        }
    }

    public static Integer getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}