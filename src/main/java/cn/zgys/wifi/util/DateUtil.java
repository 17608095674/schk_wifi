package cn.zgys.wifi.util;

import sun.util.calendar.CalendarSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    //半年前的时间
    public static Date getHalfYearAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -6);
        return calendar.getTime();
    }

    //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    //获取当天的结束时间
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    //获取过去n天的开始时间
    public static Date getBeginByDay(int day) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 0 - day);
        return cal.getTime();
    }

    //获取过去n天的结束时间
    public static Date getEndByDay(int day) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 0 - day);
        return cal.getTime();
    }

    //获取n天后时间
    public static Date getDayOn(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    //imc时间转换
    public static String dayFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd%20HH:mm");
        String str = format.format(date);
        return str;
    }

    public static void main(String[] args) {
        System.err.println(dayFormat(getDayOn(5)));
    }


}
