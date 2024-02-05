package APCSA.FRQ._2013;
/**
 * https://apstudents.collegeboard.org/courses/ap-computer-science-a/free-response-questions-by-year
 */
import java.util.ArrayList;
import java.util.List;

public class FrqAns2013Q1 {
	public static void main(String[] args) {
		ArrayList<String> titles = new ArrayList<String>();
		for (int i=0; i<5;i++)
			titles.add("Hey Jude");
		for (int i=0; i<3;i++)
			titles.add("Soul Sister");
		for (int i=0; i<10;i++)
			titles.add("Aqualung");
		System.out.println(titles);
		
		MusicDownloads m = new MusicDownloads();
		m.updateDownloads(titles);
		// m.display();
		// System.out.println(m);
		
		// Test for 2013 FRQ 1.(a) enhanced for loop
		System.out.println(m.getDownloadInfo("Aqualung"));
		System.out.println(m.getDownloadInfo("Soul Sister"));
		System.out.println(m.getDownloadInfo("Hey Jude"));
		System.out.println(m.getDownloadInfo("John"));
		System.out.println(m.getDownloadInfo("Mary"));
		System.out.println("**********");
		
		// Test for 2013 FRQ 1.(b) enhanced for loop
		ArrayList<String> songTitles = new ArrayList<String>();
		songTitles.add("Lights");songTitles.add("Aqualung");songTitles.add("Soul Sister");
		songTitles.add("Go Now");songTitles.add("Lights");songTitles.add("Soul Sister");
		System.out.println(m);
		m.updateDownloads(songTitles);
		// m.display();
		System.out.println(m);
	}
}

class DownloadInfo {
	private String title;
	private int times;
	
	/**
	 * Creates a new instance with the given unique title and sets the number of
	 * times downloaded to 1.
	 * 
	 * @param title the unique title of the downloaded song
	 */
	public DownloadInfo(String title) {
		this.title = title;
		this.times = 1;
	}

	/** @return the title */
	public String getTitle() {
		return this.title;
	}

	/** Increment the number times downloaded by 1 */
	public void incrementTimesDownloaded() {
		this.times++;
	}
	
	@Override
	public String toString() {
		return ("Title: " + this.getTitle() + "(" + this.times + "); ");
	}
}

class MusicDownloads {
	/**
	 * The list of downloaded information. Guaranteed NOT to be NULL and NOT to
	 * contain DUPLICATE titles.
	 */
	private ArrayList<DownloadInfo> downloadList;

	/** Creates the list of downloaded information. */
	public MusicDownloads() {
		this.downloadList = new ArrayList<DownloadInfo>();
	}

	/**
	 * Returns a reference to the DownloadInfo object with the requested title if it
	 * exists.
	 * 
	 * @param title the requested title
	 * @return a reference to the DownloadInfo object with the title that matches
	 *         the parameter title if it exists in the list; null otherwise.
	 *         Postcondition: - no changes were made to downloadList.
	 */
	// Answer for 2013 FRQ 1.(a) enhanced for loop
	public DownloadInfo getDownloadInfo(String title) {
		for (DownloadInfo info: downloadList) {
			if(info.getTitle().equals(title))
				return info;
		}
		return null;
	} // End of getDownloadInfo() Method
	
	// Wrong Answer (Not Perfect) for 2013 FRQ 1.(a) thru for loop
	public DownloadInfo getDownloadInfo2(String title) {
		DownloadInfo found = null; // No initialization
		for (int i=0; i < downloadList.size() ; i++) {
			if(downloadList.get(i).getTitle().equals(title)) {
				found = downloadList.get(i);
				break;
			}
		}
		// found shall be null here
		return found;
	} // End of getDownloadInfo2() Method

	/**
	 * Updates downloadList with information from titles.
	 * 
	 * @param titles a list of song titles Postcondition: - there are no duplicate
	 *        titles in downloadList. - no entries were removed from
	 *        downloadList. - all songs in titles are represented in
	 *        downloadList. - for each existing entry in downloadList, the
	 *        download count is increased by the number of times its title
	 *        appeared in titles. - the order of the existing entries in
	 *        downloadList is not changed. - the first time an object with a
	 *        title from titles is added to downloadList, it is added to the
	 *        end of the list. - new entries in downloadList appear in the
	 *        same order in which they first appear in titles. - for each new
	 *        entry in downloadList, the download count is equal to the
	 *        number of times its title appeared in titles.
	 */
	// Answer for 2013 FRQ 1.(b) enhanced for loop
	public void updateDownloads(List<String> titles) {
		boolean found = false;
		for(String t: titles) {
			found = false;
			for(DownloadInfo dl: this.downloadList) {
				if(dl.getTitle().equals(t)) {
					dl.incrementTimesDownloaded();
					found = true;
					// DEBUG: System.out.println(t+" is increased.");
					break;
				}
			}
			if(!found) {
				downloadList.add(new DownloadInfo(t));
				// DEBUG: System.out.println(t+" is added.");
			}
		}
	} // End of updateDownloads() method
	
	public void display() {
		for(DownloadInfo dl: this.downloadList) {
			System.out.println(dl);
		}
	}
	
	@Override
	public String toString() {
		String str="";
		for(DownloadInfo dl: this.downloadList) {
			str = str + dl.toString() + "\n";
		}
		return str;
	}
} // End of MusicDownloads class