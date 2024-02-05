package APCSA.FRQ._2019;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.GregorianCalendar;

/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
public class FrqAns2019Q1 {
	public static void main(String[] args) {
		// Test for 2019 FRQ 1.(a)
		System.out.println("Year 2021 is Leap Year?= " + APCalendar.isLeapYear(2021));
		System.out.println("Counted Leap Year between 2000~2021= " + numberOfLeapYears(2000, 2021));
		
		// Test for 2019 FRQ 1.(b)	
		final String[] DateInaWeek = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		int date = firstDayOfYear(2021);
		System.out.println("First Day of this Year = " + DateInaWeek[date]);
		int countedDays = dayOfYear(2021, 9, 3);
		System.out.println("Counted Days of this Year = " + countedDays);
		System.out.println("Remainder of Counted Days = " + (countedDays % 7));
		int rtnDay = dayOfWeek(2021, 9, 3);
		System.out.println("Specified Day = " + DateInaWeek[rtnDay]);
	}
	
	/**
	 * @return boolean of true for leap year
	 * @return boolean of false for nonleap year
	 */
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
	 * Input specific day format below
	 * @param year, 0 < year < 9999
	 * @param month, 1 <= month <= 12
	 * @param day, 1 <= day <= 31
	 * @return day of week of specific day (year, month, day)
	 */
	public static int firstDayOfYear(int year) {
		GregorianCalendar gcal = new GregorianCalendar(year, 1-1, 1); // Specific day
		return (gcal.get(GregorianCalendar.DAY_OF_WEEK)-1);
	}
	
	
	/**
	 * Knowing isLeapYear(int year) method
	 * @param year1~year2
	 * @param year2
	 * @return number of leap years between year 1 and year 2
	 */
	// Answer for 2019 FRQ 1.(a)
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
	 * Knowing isLeapYear(int year) method
	 * Input specific day format below
	 * @param year, 0 < year < 9999
	 * @param month, 1 <= month <= 12
	 * @param day, 1 <= day <= 31
	 * @return nth days in that year within 365/366
	 */
	public static int dayOfYear(int year, int month, int day) {
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
	 * Knowing firstDayOfYear(int year) method & isLeapYear(int year) method
	 * Knowing dayOfYear(int year, int month, int day) method
	 * Input specific day format below
	 * @param year, 0 < year < 9999
	 * @param month, 1 <= month <= 12
	 * @param day, 1 <= day <= 31
	 * @return Date or Day of Week
	 */
	// Answer for 2019 FRQ 1.(b)
	public static int dayOfWeek(int year, int month, int day) {
		// You may forget Class Reference "APCalendar."
		int date = firstDayOfYear(year);
		int countedDays = dayOfYear(year, month, day);
		int x = countedDays % 7 + date - 1;
		if (x > 7)
			x = x-7; // You may forget this!!
		return x;
	}


}