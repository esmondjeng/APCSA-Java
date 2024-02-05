package APCSA.FRQ._2003;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;

public class FrqAns2003Q2 {
	public static void main(String[] args) {
		Employee p1 = new Employee(50, 30, 35453.5);
		Employee p2 = new Employee(20, 10, 12000.4);
		Employee p3 = new Employee(33, 20, 35453.3);
		Employee p4 = new Employee(45, 25, 56000.2);
		Employee p5 = new Employee(52, 26, 35000.6);
		Employee p6 = new Employee(50, 22, 38400.7);
		Employee p7 = new Employee(48, 17, 59400.5);
		
		// Test for 2003 FRQ 2.(a)
		// Test for 2003 FRQ 2.(b)
		Company c1 = new Company(50, 25, 50000.0);
		Company c2 = new Company(40, 30, 40000.0);
		c1.addEmployee(p1); c2.addEmployee(p1);
		c1.addEmployee(p2); c2.addEmployee(p2);
		c1.addEmployee(p3); c2.addEmployee(p3);
		c1.addEmployee(p4); c2.addEmployee(p4);
		c1.addEmployee(p5); c2.addEmployee(p5);
		c1.addEmployee(p6); c2.addEmployee(p6);
		c1.addEmployee(p7); c2.addEmployee(p7);
		c1.display();
		System.out.println("**********");
		c1.ProcessRetirements();
		c1.display();
		System.out.println("**********");
		
		// Test for 2003 FRQ 2.(a)
		// Test for 2003 FRQ 2.(b)
		c2.display();
		System.out.println("+++++++++++");
		c2.ProcessRetirements();
		c2.display();
		System.out.println("+++++++++++");
	}
}

class Employee {
	private int age;
	private int yearOnJob;
	private double salary;
	private int ID;
	static private int seqID;
	
	public Employee(int eligibleAge, int eligibleYear, double eligibleSalary) {
		this.age = eligibleAge;
		this.yearOnJob = eligibleYear;
		this.salary = eligibleSalary;
		this.ID = getNextID();
	}
	
	// returns the age (in years) of this employee	
	public int getAge() {
		return this.age;
	}
	// returns the number of years this employee has worked
	public int getYearsOnJob() {
		return this.yearOnJob;
	}
	// returns the salary of this employee in dollars
	public double getSalary() {
		return this.salary;
	}
	// returns unique employee ID number
	public int getID() {
		return this.ID;
	}
	public static int getNextID() {
		return seqID++;
	}
	
	/*
	 * An employee is eligible for retirement if (s)he meets at least two of the following requirements:
	 * 1. The employee is at least retireAge years old.
	 * 2. The employee has worked for at least retireYears.
	 * 3. The employee’s salary is at least retireSalary.
	 * Precondition:
	 * 		int retireAge;			// minimum age to retire
	 *		int retireYears;		// minimum years on job to retire
	 *		double retireSalary;	// minimum salary to retire
	 * Postcondition: returns true if emp is eligible to retire; otherwise, returns false
	 */
	private boolean EmployeeIsEligible(int retireAge, int retireYears, double retireSalary) {
		if(this.getAge() >= retireAge && this.getYearsOnJob() >= retireYears)
			return true;
		if(this.getAge() >= retireAge && this.getSalary() >= retireSalary)
			return true;
		if(this.getYearsOnJob() >= retireYears && this.getSalary() >= retireSalary)
			return true;
		return false;
	};
	
	public String toString() {
		String str = String.format("%2d, age %2d, %2d years, $%8.2f", 
				getID(), getAge(), getYearsOnJob(), getSalary());
		// DEBUG: str = str + " --> " + EmployeeIsEligible(50, 25, 50000.0);
		// DEBUG: str = str + " --> " + EmployeeIsEligible(40, 30, 40000.0);
		return str;
	}
}

class Company
{
	ArrayList<Employee> empList;	// empList.length() is the number of employees in this company
	int retireAge;			// minimum age to retire
	int retireYears;		// minimum years on job to retire
	double retireSalary;	// minimum salary to retire
	double salaryBudget;	// total salary of all employees

	public Company(	int retireAge, int retireYears, double retireSalary) {
		empList = new ArrayList<Employee>();
		this.retireAge = retireAge;
		this.retireYears = retireYears;
		this.retireSalary = retireSalary;
		this.salaryBudget = salaryBudget;
	}
	
	public void addEmployee(Employee emp) {
		empList.add(emp);
		salaryBudget = salaryBudget + emp.getSalary();
	}
	
	/*
	 * An employee is eligible for retirement if (s)he meets at least two of the following requirements:
	 * 1. The employee is at least retireAge years old.
	 * 2. The employee has worked for at least retireYears.
	 * 3. The employee’s salary is at least retireSalary.
	 * 
	 * Postcondition: returns true if emp is eligible to retire; otherwise, returns false
	 */
	/* Answer for 2003 FRQ 2.(a) */
	private boolean EmployeeIsEligible(Employee emp) {
		if(emp.getAge() >= this.retireAge && emp.getYearsOnJob() >= this.retireYears)
			return true;
		if(emp.getAge() >= this.retireAge && emp.getSalary() >= this.retireSalary)
			return true;
		if(emp.getYearsOnJob() >= this.retireYears && emp.getSalary() >= this.retireSalary)
			return true;
		
		return false;
	};
	
	/*
	 * Postcondition: all retirement-eligible employees have been
	 * removed from empList; empList has been resized to reflect retirements;
	 * empList remains sorted by employee ID;
	 * salaryBudget has been updated to reflect remaining employees
	 */
	/* Answer for 2003 FRQ 2.(b) */
	public void ProcessRetirements() {
		ArrayList<Integer> removeList = new ArrayList<Integer>();
		
		// Create remove ArrayList to store all index to be removed reversely
		for (int i=0; i < empList.size(); i++) {
			if(EmployeeIsEligible(empList.get(i))) {
				removeList.add(0, i); // add to the beginning, so reverse order.
			}
		}
		
		// Star remove from employee ArrayList backwards
		for(int removeIndex: removeList) {
			salaryBudget = salaryBudget - empList.get(removeIndex).getSalary();
			empList.remove(removeIndex);
		}
	}
	
	public void display() {
		for (Employee element: empList)
			System.out.println(element);
		System.out.println("Total Budget: " + salaryBudget);
	}
};