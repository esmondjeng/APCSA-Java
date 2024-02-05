package APCSA.FRQ._2019;
/**
 * https://blog.csdn.net/weixin_33371440/article/details/114622385
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class CalendarExample {

	public static void main(String[] args) {
		// Instantiate Calendar object
		Calendar calendar = Calendar.getInstance();

		// Set Monday is the first day of a week with Calendar object
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		// Set Monday is minimal days in a week across month with Calendar object
		calendar.setMinimalDaysInFirstWeek(4);

		// Get current year from Calendar object
		int weekYear = calendar.get(Calendar.YEAR);

		// Get nth week from Calendar object
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		
		System.out.println("This Year is: " + weekYear);
		System.out.println("Today is at the week of this year: " + weekOfYear);

		// Instantiate a Date Format object from SimpleDateFormat Class
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date trialTime = null;
		try {
			trialTime = simpleDateFormat.parse("2019-12-31");
			System.out.println("2019-12-31 的 simpleDateFormat 后的结果" + trialTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Set specific day over calendar object
		calendar.setTime(trialTime);
		// Get nth week from Calendar object
		int weekOfYear1 = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println("2019-12-31是在当年的第几" + weekOfYear1 + "周");
		
		// Instantiate a GregorianCalendar object
		Calendar c = new GregorianCalendar();

		// Set time to 2019-12-31 23:59:59 over GregorianCalendar object
		c.set(2019, Calendar.DECEMBER, 31, 23, 59, 59);

		//获得当前日期属于今年的第几周
		Integer weekOfYearLastWeek1 = c.get(Calendar.WEEK_OF_YEAR);
		System.out.println("当前日期属于第" + weekOfYearLastWeek1 + "周");

		//获得指定年的第几周的开始日期(dayOfWeek是从周日开始排序的)
		calendar.setWeekDate(2019, 51, 2);

		//获得Calendar的时间
		Date starttime = calendar.getTime();

		//获得指定年的第几周的结束日期
		calendar.setWeekDate(2019, 51, 1);
		Date endtime = calendar.getTime();

		//将时间戳格式化为指定格式
		String dateStart = simpleDateFormat.format(starttime);
		String dateEnd = simpleDateFormat.format(endtime);
		System.out.println("2019年第52周的开始日期为：" + dateStart);
		System.out.println("2019年第52周的结束日期为：" + dateEnd);
	}
}