package com.unique.app.util;

import android.text.format.DateFormat;

import java.util.Date;

/**
 * Project: MysteryGank <br/>
 * Package: com.crainax.mysterygank.util <br/>
 * Description: Handling the Date associating data.<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/6/11 <br/>
 */
public class DateUtils {

    /**
     * Format example: 2016/06/11
     */
    public static final String FORMAT_YMD_1 = "yyyy/MM/dd";
    /**
     * Format example: 2016年06月11日
     */
    public static final String FORMAT_YMD_2 = "yyyy年MM月dd日";

    public static String formatDate(Date date, String format) {

        return (String) DateFormat.format(format, date);

    }
}
