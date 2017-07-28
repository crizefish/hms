package com.hj.pers.classes.usual;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.Assert;

public class DateUtils {
	public static String  s1 = "yyyy_MM_dd";
	public static String  s2 = "yyyyMMdd";
	public static String  s3 = "yyyyMMddHHmmss";
	public static String  s4 = "yyyy_MM_dd:HHmmss";
	public static String  s5 = "yyyyMMdd:HHmmss";
	public static String  s6 = "yyyyMMddHHmmss";
	
	private static Calendar calendar = Calendar.getInstance();
	
	public static String formatDate(Date date ,String form){
		Assert.notNull(date, "formart error : date is null");
		Assert.notNull(form, "formart error : form is null");
		return new SimpleDateFormat(form).format(date);
	}
	
	public static Date addOrReduceDate(Date date,int count){
		Assert.notNull(date, "calculate date error : date is null");
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+count);
		return calendar.getTime();
	}
	
	
	
	public static void main(String[] args) {
		Date a = DateUtils.addOrReduceDate(null, 1);
		System.out.println(DateUtils.formatDate(new Date(), DateUtils.s1));
		System.out.println(DateUtils.formatDate(a, DateUtils.s1));
	}
	
	
}
