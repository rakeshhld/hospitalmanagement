package com.hospital.hospitalmanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public static SimpleDateFormat datewithTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	public static Date parseToDate(String date) throws ParseException{
		return sdf.parse(date);
	}
	public static String formatDate(Date date){
		return sdf.format(date);
	}
	
	public static Date parseToDatetime(String date) throws ParseException{
		return sdf.parse(date);
	}
	public static String formatDatetime(Date date){
		return sdf.format(date);
	}
}
