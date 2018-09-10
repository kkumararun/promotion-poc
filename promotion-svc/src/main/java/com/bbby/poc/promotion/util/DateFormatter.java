package com.bbby.poc.promotion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Adi
 *
 */
public class DateFormatter {

	/**
	 * @param dateAsString
	 * @param ipFormat
	 * @param opFormat
	 * @return
	 * @throws ParseException
	 */
	public static String getFormattedDate(String dateAsString, String ipFormat, String opFormat) throws ParseException {
		String formattedDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(ipFormat);// ("dd/MM/yyyy hh:mm:ss a");
		Date date = sdf.parse(dateAsString);
		sdf = new SimpleDateFormat(opFormat);// ("dd-MMM-yy hh.mm.ss a");
		formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	/**
	 * @param date
	 * @param opFormat
	 * @return
	 * @throws ParseException
	 */
	public static String getFormattedDate(Date date, String opFormat) throws ParseException {
		String formattedDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(opFormat);// ("dd/MM/yyyy hh:mm:ss a");
		formattedDate = sdf.format(date);
		return formattedDate;
	}
}