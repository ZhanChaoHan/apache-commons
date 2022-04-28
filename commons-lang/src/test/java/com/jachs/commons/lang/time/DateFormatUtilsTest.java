package com.jachs.commons.lang.time;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DateFormatUtilsTest {
	DateFormatUtils dfu=new DateFormatUtils();
	
	@Test
	public void test() {
		System.out.println(dfu.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(dfu.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
}
