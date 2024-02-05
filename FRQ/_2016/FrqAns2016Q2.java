package APCSA.FRQ._2016;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2016Q2 {
	public static void main(String[] args) {
		// Test for 2016 FRQ 2.(a)
		LogMessage log1 = new LogMessage("CLIENT3:security alert – repeated login failures");
		LogMessage log2 = new LogMessage("Webserver:disk offline");
		LogMessage log3 = new LogMessage("SERVER1:file offline not found");
		LogMessage log4 = new LogMessage("SERVER2:read error on disk DSK1");
		LogMessage log5 = new LogMessage("SERVER1:write error on disk DSK2");
		LogMessage log6 = new LogMessage("Webserver:error on /dev/disk");
		System.out.println(log1.toString());
		System.out.println(log2); // Same as toString()
		System.out.println(log3); // Same as toString()
		System.out.println(log4); // Same as toString()
		System.out.println(log5); // Same as toString()
		System.out.println(log6); // Same as toString()
		System.out.println("*********************");
		
		// Test for 2016 FRQ 2.(b)
		SystemLog sysLog = new SystemLog();
		sysLog.addMessages(log6);
		sysLog.addMessages(log5);
		sysLog.addMessages(log4);
		sysLog.addMessages(log3);
		sysLog.addMessages(log2);
		sysLog.addMessages(log1);
		sysLog.addMessages(new LogMessage("Esmond:null"));
		sysLog.addMessages(new LogMessage("Ethan:null values are all arround."));
		sysLog.display();
		
		// Test for 2016 FRQ 2.(b)
		sysLog.removeMessages("null");
		sysLog.display();
		sysLog.removeMessages("offline");
		sysLog.display();
		System.out.println("*********************");
	}
}

class LogMessage {
	private String machineId;
	private String description;

	/** Precondition: message is a valid log message. */
	// Answer for 2016 FRQ 2.(a)
	public LogMessage(String message) {
		int colon = message.indexOf(":");
		this.machineId = message.substring(0, colon);
		this.description = message.substring(colon + 1);
	}

	/**
	 * Returns true if the description in this log message properly contains
	 * keyword; false otherwise.
	 */
	// Answer for 2016 FRQ 2.(b)
	public boolean containsWord(String keyword) {
		if (this.description.equals(keyword)) {
			return true;
		}
		if (this.description.indexOf(keyword + " ") == 0) {
			return true;
		}
		if (this.description.indexOf(" " + keyword + " ") != -1) {
			return true;
		}
		if (this.description.length() > keyword.length()) {
			if ((this.description.substring(this.description.length() - keyword.length() - 1).equals(" " + keyword))) {
				return true;
			}
		}
		return false;
	}

	public String getMachineId() {
		return this.machineId;
	}

	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return String.format("%s-->\"%s\"", this.machineId, this.description );
	}
}

class SystemLog {
	/**
	 * Contains all the entries in this system log. Guaranteed not to be null and to
	 * contain only non-null entries.
	 */
	private ArrayList<LogMessage> messageList;
	
	public SystemLog() {
		messageList = new ArrayList<LogMessage>();
	}
	
	public void addMessages(LogMessage logMsg) {
		messageList.add(logMsg);
	}

	/**
	 * Removes from the system log all entries whose descriptions properly contain
	 * keyword, and returns a list (possibly empty) containing the removed entries.
	 * Postcondition: - Entries in the returned list properly contain keyword and
	 * are in the order in which they appeared in the system log. - The remaining
	 * entries in the system log do not properly contain keyword and are in their
	 * original order. - The returned list is empty if no messages properly contain
	 * keyword.
	 */
	public List<LogMessage> removeMessages(String keyword) {
		List<LogMessage> removals = new ArrayList<LogMessage>();
		for (int i = 0; i < messageList.size(); i++) {
			if (messageList.get(i).containsWord(keyword)) {
				removals.add(messageList.remove(i));
				i--;
			}
		}
		return removals;
	}
	
	public void display() {
		if (messageList.size() == 0)
			return;
		for (LogMessage element: messageList) {
			System.out.println(element);
		}
		System.out.println();
	}
}