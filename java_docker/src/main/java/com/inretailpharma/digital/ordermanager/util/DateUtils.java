package com.inretailpharma.digital.ordermanager.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final String TIME_TEMPLATE = "HH:mm:ss";
    private static final String TIME_TEMPLATE_HOUR_MINUTE = "HH:mm";
    private static final String DATE_TEMPLATE = "yyyy-MM-dd";
    private static final String FORMATE_DATE_CUSTOM = "EEEE, dd MMMM";
    private static final String DATETIME_TEMPLATE = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_TEMPLATE);


    public static String getLocalTimeWithFormat(LocalTime localtime) {
        return localtime.format(DateTimeFormatter.ofPattern(TIME_TEMPLATE));
    }


    public static String getLocalDateTimeWithFormat(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DATETIME_TEMPLATE));
    }

    public static LocalTime getLocalTimeFromStringWithFormatHourandMinute(String localtime) {
        return LocalTime.parse(localtime, DateTimeFormatter.ofPattern(TIME_TEMPLATE_HOUR_MINUTE));
    }

    public static LocalDateTime getLocalDateTimeFromStringWithFormat(String localDateTime) {
        return LocalDateTime.parse(localDateTime, DateTimeFormatter.ofPattern(DATETIME_TEMPLATE));
    }

    public static LocalTime getLocalTimeFromStringWithFormat(String localtime) {
        return LocalTime.parse(localtime, DateTimeFormatter.ofPattern(TIME_TEMPLATE));
    }

    public static LocalTime getLocalTimeFromDate(Date startHour) {
        return LocalTime
                .parse(
                        dateFormat.format(startHour), DateTimeFormatter.ofPattern(TIME_TEMPLATE)
                );
    }

    public static LocalTime getLocalTimeNow() {
        return LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern(TIME_TEMPLATE)));
    }

    public static LocalDate getLocalDateNow() {
        return LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_TEMPLATE)));
    }

    public static String getFormattedLocalDate(LocalDate localDate) {
        Locale spanishLocale = new Locale("es", "ES");

        return localDate.format(DateTimeFormatter.ofPattern(FORMATE_DATE_CUSTOM,spanishLocale));
    }



    public static LocalDate getLocalDateFromStringDate(String localDate) {
        return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DATE_TEMPLATE));
    }

    public static Integer transformHourToMinutesFromHourLocalDate(Integer hour) {
        return hour*60;
    }

}
