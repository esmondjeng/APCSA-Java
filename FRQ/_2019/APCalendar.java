package APCSA.FRQ._2019;
/**
 * https://runestone.academy/runestone/books/published/csjava/Unit8-ArrayList/2019delimitersQ3a.html
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 * 
 * public class APCalendar
 * private static boolean isLeapYear(int year)
 * public static int numberOfLeapYears(int year1, int year2)
 * private static int firstDayOfYear(int year)
 * private static int dayOfYear(int month, int day, int year)
 * public static int dayOfWeek(int month, int day, int year)
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class APCalendar {
	/** Returns true if year is a leap year and false otherwise. */
	public static boolean isLeapYear(int year) {
		/*
		 * 1. 普通年能被4整除且不能被100整除的为闰年 (year % 100 != 0) 
		 * 2. 世纪年能被400整除的是闰年 (year % 100 == 0)
		 */
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number of leap years between year1 and year2, inclusive.
	 * Precondition: 0 <= year1 <= year2
	 */
	public static int numberOfLeapYears(int year1, int year2) {
		int count = 0;
		for (int i = year1; i <= year2; i++) {
			if (isLeapYear(i)) {
				count++;
			}
		}

		return count;
	}
	
	/**
	 * Returns the number of leap years between year1 and year2, inclusive.
	 * Precondition: 0 <= year1 <= year2
	 */
	public static int[] listOfLeapYears(int year1, int year2) {
		int[] LeapYearCount = new int[year2-year1+1];
		int count = 0;
		for (int i = year1; i <= year2; i++) {
			if (isLeapYear(i)) {
				LeapYearCount[count] = i;
				count++;
			}
		}
		int[] LeapYearCount2 = new int[count];

		for (int i = 0; i < count; i++) {
			LeapYearCount2[i] = LeapYearCount[i];
			// DEBUG: System.out.println(LeapYearCount2[i]);
		}
		
		return LeapYearCount2;
	}
	
	/**
	 * Returns n, where month, day, and year specify the nth day of the year.
	 * Returns 1 for January 1 (month = 1, day = 1) of any year. Precondition: The
	 * date represented by month, day, year is a valid date.
	 */
	public static int dayOfYear(int year, int month, int day) {
		int sumDays = 0;
		switch (month) {
		case 12:
			sumDays += 30; // Total days before 12/1
		case 11:
			sumDays += 31; // Total days before 11/1
		case 10:
			sumDays += 30; // Total days before 10/1
		case 9:
			sumDays += 31; // Total days before 9/1
		case 8:
			sumDays += 31; // Total days before 8/1
		case 7:
			sumDays += 30; // Total days before 7/1
		case 6:
			sumDays += 31; // Total days before 6/1
		case 5:
			sumDays += 30; // Total days before 5/1
		case 4:
			sumDays += 31; // Total days before 4/1
		case 3:
			if (isLeapYear(year)) {
				sumDays += 29; // Total days before 3/1
			} else {
				sumDays += 28;
			}
		case 2:
			sumDays += 31; // Total days before 2/1
		case 1:
			sumDays += day; // Total days in January
		}

		return sumDays;
	}
	
	/**
	 * Returns n, where month, day, and year specify the nth day of the year.
	 * Returns 1 for January 1 (month = 1, day = 1) of any year. Precondition: The
	 * date represented by month, day, year is a valid date.
	 */
	public static int dayOfYear2(int year, int month, int day) {
		final int[] DAYS_OF_MONTH_LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		final int[] DAYS_OF_MONTH_NONLEAP = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sumDays = day;
		boolean leapYear = isLeapYear(year);
		for (int i=0; i < month-1; i++) {
			if (leapYear) {
				sumDays = sumDays + DAYS_OF_MONTH_LEAP[i];
			} else {
				sumDays = sumDays + DAYS_OF_MONTH_NONLEAP[i];
			}
		}
		
		return sumDays;
	}

	/**
	 * Returns the value representing the day of the week for the first day of year,
	 * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
	 */
	public static int firstDayOfYear(int year) {
		return dayOfWeek(year, 1, 1);
	}
	
	/**
	 * Returns the value representing the day of the week for the first day of year,
	 * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
	 */
	public static int firstDayOfYear2(int year) {
		GregorianCalendar gcal = new GregorianCalendar(year, 1-1, 1); // Specific day
		return (gcal.get(GregorianCalendar.DAY_OF_WEEK)-1);
	}
	
	/**
	 * Returns the value representing the day of the week for the given date (month,
	 * day, year), where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes
	 * Saturday. 
	 * 
	 * Precondition: The date represented by month, day, year is a valid
	 * date.
	 */
	public static int dayOfWeek(int year, int month, int day) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		Date d = null;
		try {
			d = fmt.parse(year + "/" + month + "/" + day);
		} catch (ParseException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDay;
	}
	
	/**
	 * Returns the value representing the day of the week for the given date (month,
	 * day, year), where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes
	 * Saturday. 
	 * 
	 * Precondition: The date represented by month, day, year is a valid
	 * date.
	 */
	public static int dayOfWeek2(int year, int month, int day) {
		GregorianCalendar gcal = new GregorianCalendar(year, month-1, day); // Specific day
		return (gcal.get(GregorianCalendar.DAY_OF_WEEK)-1);
	}
	
	/**
	 * Returns the value representing the day of the week for the given date (month,
	 * day, year), where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes
	 * Saturday. 
	 * 
	 * Precondition: The date represented by month, day, year is a valid
	 * date.
	 */
	public static int dayOfWeek3(int year, int month, int day) {
		int date = firstDayOfYear(year);
		int countedDays = dayOfYear(year, month, day);
		int x = countedDays % 7 + date - 1;
		if (x > 7)
			x = x-7; // You may forget this!!
		return x;
	}
	
	/**
	 * Returns the value representing the day of the week for the given date (month,
	 * day, year), where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes
	 * Saturday. 
	 * 
	 * Precondition: The date represented by month, day, year is a valid
	 * date.
	 */
	public static int dayOfWeek4(int year, int month, int day) {
		int[] xArray = {0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6};
		int date = firstDayOfYear(year);
		int countedDays = dayOfYear(year, month, day);
		int x = countedDays % 7 + date - 1;
		return xArray[x];
	}

	/**
	 * Return the first day's DATE Type of a specific nth week in a year
	 *
	 * @param year
	 * @param week
	 * @return Date type
	 * 
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * Return the first day's DATE of a specific nth month in a year
	 *
	 * @param year
	 * @param month
	 * @return Date type
	 */
	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * Return the first day's DATE of a specific nth quarter in a year
	 *
	 * @param year
	 * @param quarter
	 * @return Date type
	 */
	public static Date getFirstDayOfQuarter(int year, int quarter) {
		int month = 0;
		if (quarter > 4) {
			return null;
		} else {
			month = (quarter - 1) * 3 + 1;
		}

		return getFirstDayOfMonth(year, month);
	}

	/**
	 * Return the first day's DATE of a specific year
	 *
	 * @param year
	 * @return Date type
	 */
	public static Date getFirstDayOfYear(int year) {
		return getFirstDayOfQuarter(year, 1);
	}
}