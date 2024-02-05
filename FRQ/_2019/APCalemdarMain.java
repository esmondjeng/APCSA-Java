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

public class APCalemdarMain {

	public static void main(String[] args) {
		// Test sample for method numberOfLeapYears()
		System.out.printf("There are %d leap years between %d and %d.\n", APCalendar.numberOfLeapYears(1991, 2000), 1991, 2000);
		
		// Test sample for method listOfLeapYears()
		int[] listOfLeapYears = APCalendar.listOfLeapYears(1991, 2000);
		for (int element: listOfLeapYears) {
			System.out.println(element);
		}
		
		String[] DayofWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		// Test sample for method dayOfWeek()
		System.out.printf("1 Day of Week for 2021/8/11 is %d\n", APCalendar.dayOfWeek(2021, 8, 11));
		System.out.printf("2 Day of Week for 2021/8/11 is %d\n", APCalendar.dayOfWeek2(2021, 8, 11));
		System.out.printf("3 Day of Week for 2021/8/11 is %d\n", APCalendar.dayOfWeek3(2021, 8, 11));
		System.out.println("Day of Week for 2021/8/11 is " + DayofWeek[APCalendar.dayOfWeek(2021, 8, 11)-1]);

		// Test sample for method firstDayOfYear()
		System.out.println("1 Day of Week for 1st day of 2021 is " + APCalendar.firstDayOfYear(2021));
		System.out.println("2 Day of Week for 1st day of 2021 is " + APCalendar.firstDayOfYear2(2021));
		System.out.println("3 Day of Week for 1st day of 2021 is " + APCalendar.dayOfWeek(2021, 1, 1));
		System.out.println("4 Day of Week for 1st day of 2021 is " + APCalendar.dayOfWeek2(2021, 1, 1));
		System.out.println("5 Day of Week for 1st day of 2021 is " + APCalendar.dayOfWeek3(2021, 1, 1));
		System.out.println("Day of Week for 1st day of 2021 is " + APCalendar.getFirstDayOfWeek(2021, 1));
		System.out.printf("Day of Week for 1st day of 2021 is %d\n", APCalendar.firstDayOfYear(2021));
		System.out.println("Day of Week for 1st day of 2021 is " + DayofWeek[APCalendar.firstDayOfYear(2021)]);
		
		// Test sample for method getFirstDayOfWeek()
		System.out.println("Here " +APCalendar.getFirstDayOfWeek(2021, 32));
	}

}
